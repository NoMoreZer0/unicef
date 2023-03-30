package swag.rest.nis_risk_app.controller;

import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import swag.rest.nis_risk_app.service.CaseService;
import swag.rest.nis_risk_app.service.StudentService;
import swag.rest.nis_risk_app.util.StudentStatus;

@RestController
@RequiredArgsConstructor
public class AnaliticsController {

    private final StudentService studentService;

    private final CaseService caseService;


    @GetMapping("/analytics/students")
    @CrossOrigin(origins = "*")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Map<StudentStatus, Long> getAllStudentsByStatus() {
        return studentService.getStudentCountByStatus();
    }

    @GetMapping("/analytics/cases")
    @CrossOrigin(origins = "*")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Map<String, Long> getAllCaseByStatus() {
        return caseService.getCaseCountByStatus();
    }


}
