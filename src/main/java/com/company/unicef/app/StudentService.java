package com.company.unicef.app;

import com.company.unicef.entity.Address;
import com.company.unicef.entity.Student;
import com.company.unicef.entity.User;
import io.jmix.core.DataManager;
import io.jmix.core.event.EntitySavingEvent;
import io.jmix.notifications.NotificationManager;
import io.jmix.notifications.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("studentService")
public class StudentService {

    private final DataManager dataManager;

    @Autowired
    NotificationManager notificationManager;

    public StudentService(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    private boolean justCreated;

    public ResponseEntity<String> save(String city, String school, String course, String name) {
        try {
            Student student = dataManager.create(Student.class);
            Address address = dataManager.create(Address.class);
            address.setCity(city);
            student.setSchool(school);
            student.setFio(name);
            student.setStudyingYear(course);
            student.setAddress(address);
            student.setStudentId(getNewStudentId());
            dataManager.save(address);
            dataManager.save(student);

            List<User> userNotifications = loadByRole();
            List<String> usernamesNotific = new ArrayList<>();
            for (User user : userNotifications) {
                usernamesNotific.add(user.getUsername());
            }
            notificationManager.createNotification()
                    .withSubject("Добавлен новый студент")
                    .withRecipientUsernames(usernamesNotific)
                    .toChannelsByNames("in-app")
                    .withContentType(ContentType.PLAIN)
                    .withBody("Проведите проверку нового студента")
                    .send();
            return ResponseEntity.ok("Student saved successfully!");
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
                .query("select u from User u where u.role = :role1 or u.role = :role2")
                .parameter("role1", "психолог")
                .parameter("role2", "ADMIN")
                .list();
    }

}