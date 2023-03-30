package swag.rest.nis_risk_app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import swag.rest.nis_risk_app.entity.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByStudentStatus(String status);

    List<Student> findByNameOfStudentContainingIgnoreCase(String nameOfStudent);
}
