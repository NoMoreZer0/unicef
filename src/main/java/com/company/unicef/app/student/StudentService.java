package com.company.unicef.app.student;

import com.company.unicef.entity.Address;
import com.company.unicef.entity.Student;
import com.company.unicef.entity.StudentStatusField;
import com.company.unicef.entity.User;
import io.jmix.core.DataManager;
import io.jmix.notifications.NotificationManager;
import io.jmix.notifications.entity.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("studentService")
public class StudentService {

    private static final Logger log = LoggerFactory.getLogger(
            StudentService.class
    );

    private final DataManager dataManager;

    @Autowired
    NotificationManager notificationManager;

    public StudentService(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public ResponseEntity<String> save(List<StudentDao> students) {
        try {
            students.forEach(s -> {
                Student student = dataManager.create(Student.class);
                Address address = dataManager.create(Address.class);
                address.setCity(s.getCity());
                student.setStudentId(getNewStudentId());
                student.setSchool(s.getSchool());
                student.setFio(s.getName());
                student.setStudyingYear(s.getCourse());
                student.setAddress(address);
                student.setStatus(StudentStatusField.GRAY);
                dataManager.save(address);
                dataManager.save(student);

                List<User> userNotifications = loadByRole();
                List<String> usernamesNotific = new ArrayList<>();
                userNotifications.forEach(u -> usernamesNotific.add(u.getUsername()));
                log.info("Created student \n {}", student);
                notificationManager.createNotification()
                        .withSubject("Добавлен новый студент")
                        .withRecipientUsernames(usernamesNotific)
                        .toChannelsByNames("in-app")
                        .withContentType(ContentType.PLAIN)
                        .withBody("Проведите проверку нового студента")
                        .send();
            });
            return ResponseEntity.ok("Students saved successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    private String getNewStudentId() {
        int lastStudentId = dataManager.loadValue("select max(cast(e.studentId integer)) from Student e", Integer.class)
                .optional()
                .orElse(0);
        return String.format("%06d", lastStudentId + 1);
    }

    private List<User> loadByRole() {
        return dataManager.load(User.class)
                .query("select u from User u join sec_RoleAssignmentEntity s on s.username = u.username where s.roleCode = :role1 or s.roleCode = :role2")
                .parameter("role1", "system-full-access")
                .parameter("role2", "manager-role")
                .list();
    }

}