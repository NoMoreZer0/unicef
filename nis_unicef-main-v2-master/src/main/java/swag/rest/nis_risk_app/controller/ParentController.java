package swag.rest.nis_risk_app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import swag.rest.nis_risk_app.dto.ParentDto;
import swag.rest.nis_risk_app.entity.Parent;
import swag.rest.nis_risk_app.exception.ParentNotFound;
import swag.rest.nis_risk_app.service.ParentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/parent")
public class ParentController {

    private final ParentService parentService;

    @PostMapping
    @CrossOrigin(origins = "*")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_THERAPIST','ROLE_CASE_MANAGER')")
    public Parent addParent(@RequestBody ParentDto parentDto) {
        return parentService.saveParent(parentDto);
    }

    @GetMapping
    @CrossOrigin(origins = "*")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_THERAPIST','ROLE_CASE_MANAGER')")
    public List<Parent> getAllParents() {
        return parentService.getAll();
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "*")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_THERAPIST','ROLE_CASE_MANAGER')")
    public Parent getStudent(@PathVariable Long id) {
        return parentService
                .findById(id)
                .orElseThrow(() -> new ParentNotFound(id));
    }


}
