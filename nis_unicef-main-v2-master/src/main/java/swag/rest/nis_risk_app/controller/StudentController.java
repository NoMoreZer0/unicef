package swag.rest.nis_risk_app.controller;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import swag.rest.nis_risk_app.dto.StudentDto;
import swag.rest.nis_risk_app.entity.Student;
import swag.rest.nis_risk_app.exception.StudentNotFound;
import swag.rest.nis_risk_app.service.StudentService;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;


    @PostMapping
    @CrossOrigin(origins = "*")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CASE_MANAGER','ROLE_THERAPIST')")
    public ResponseEntity<Object> addStudent(@RequestBody StudentDto studentDto) {
        return studentService.saveStudent(studentDto);
    }

    @PutMapping
    @CrossOrigin(origins = "*")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CASE_MANAGER','ROLE_THERAPIST')")
    public Student changeStudentInf(@RequestBody StudentDto studentDto, @RequestParam(name = "studentId") Long studentId) {
        return studentService.updateStudent(studentDto, studentId);
    }

    @GetMapping
    @CrossOrigin(origins = "*")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CASE_MANAGER','ROLE_THERAPIST')")
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "*")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CASE_MANAGER','ROLE_THERAPIST')")
    public Student getStudent(@PathVariable Long id) {
        return studentService.findStudentById(id)
                .orElseThrow(() ->
                        new StudentNotFound(id));
    }


    @CrossOrigin(origins = "*")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CASE_MANAGER','ROLE_THERAPIST')")
    @PostMapping("/change_student_status/{studentId}")
    public ResponseEntity<String> changeStatus(@PathVariable("studentId") Long studentId, @RequestParam String status) {
        studentService.changeStudentStatus(studentId, status);
        return new ResponseEntity<>("Status is changed", HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CASE_MANAGER','ROLE_THERAPIST')")
    @GetMapping("/get_students_by_status/{status}")
    public Student getStudentsByStatus(@PathVariable String status) {
        return studentService.getStudentsByStatus(status);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/get_students_by_name")
    public List<Student> getStudentsByName(@RequestParam (name = "name") Optional<String> name){
        return studentService.getStudentsByName(name.orElse("_"));
    }




}
