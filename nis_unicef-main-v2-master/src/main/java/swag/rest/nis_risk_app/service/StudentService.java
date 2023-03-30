package swag.rest.nis_risk_app.service;

import java.util.Map;
import org.springframework.http.ResponseEntity;
import swag.rest.nis_risk_app.dto.StudentDto;
import swag.rest.nis_risk_app.entity.Student;

import java.util.List;
import java.util.Optional;
import swag.rest.nis_risk_app.util.CaseStatus;
import swag.rest.nis_risk_app.util.StudentStatus;

public interface StudentService {
    Optional<Student> findStudentById(Long studentId);
    void changeStudentStatus(Long studentId, String studentStatus);

    Student getStudentsByStatus(String status);
    List<Student> findAll();

    ResponseEntity<Object> saveStudent(StudentDto studentDto);

    Student updateStudent(StudentDto studentDto, Long studentId);

    List<Student> getStudentsByName(String name);

    Map<StudentStatus, Long> getStudentCountByStatus();

}
