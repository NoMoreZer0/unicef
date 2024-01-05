package com.company.unicef.app;

import com.company.unicef.entity.Address;
import com.company.unicef.entity.Student;
import io.jmix.core.DataManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("studentService")
public class StudentService {

    private final DataManager dataManager;

    public StudentService(DataManager dataManager) {
        this.dataManager = dataManager;
    }

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
}