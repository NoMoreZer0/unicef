package swag.rest.nis_risk_app.controller;

import static swag.rest.nis_risk_app.constant.Constant.FIRST_PHASE_DOWNLOAD_LINK;
import static swag.rest.nis_risk_app.constant.Constant.FOURTH_PHASE_DOWNLOAD_LINK;
import static swag.rest.nis_risk_app.constant.Constant.SECOND_PHASE_DOWNLOAD_LINK;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.docx4j.openpackaging.exceptions.Docx4JException;
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
import swag.rest.nis_risk_app.dto.FirstPhaseDto;
import swag.rest.nis_risk_app.dto.FormDto;
import swag.rest.nis_risk_app.dto.FourthPhaseDto;
import swag.rest.nis_risk_app.dto.SecondPhaseDto;
import swag.rest.nis_risk_app.entity.FirstPhase;
import swag.rest.nis_risk_app.entity.FourthPhase;
import swag.rest.nis_risk_app.entity.SecondPhase;
import swag.rest.nis_risk_app.entity.Student;
import swag.rest.nis_risk_app.exception.StudentNotFound;
import swag.rest.nis_risk_app.service.FormService;
import swag.rest.nis_risk_app.service.StudentService;

@RestController
@RequestMapping("/form")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin("*")
public class FormController {

    private final StudentService studentService;
    private final FormService formService;


    //TODO create 1 form
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CASE_MANAGER')")
    @CrossOrigin(origins = "*")
    @PostMapping("/first_phase/{studentId}")
    public FirstPhase createNewFirstForm(@RequestBody FirstPhaseDto firstPhaseDto,
                                         @PathVariable(name = "studentId") Long studentId,
                                         @RequestParam Long caseId) throws IllegalAccessException {
        Student student = studentService.findStudentById(studentId)
                .orElseThrow(() ->
                        new StudentNotFound(studentId));
        return formService.createFirstForm(firstPhaseDto, student, caseId);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CASE_MANAGER','ROLE_THERAPIST')")
    @CrossOrigin(origins = "*")
    @PutMapping("/first_phase/{formId}")
    public FirstPhase fulfillFirstForm(@RequestBody FirstPhaseDto firstPhaseDto, @PathVariable(name = "formId") Long formId) {
        return formService.updateFirstForm(firstPhaseDto, formId);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_HEADTEACHER','ROLE_THERAPIST','ROLE_MED', 'ROLE_CURATOR','ROLE_POLICE')")
    @CrossOrigin(origins = "*")
    @PutMapping("/first_phase/add-part/{formId}")
    public FirstPhase fulfillPartOfFirstForm(@RequestBody FirstPhaseDto firstPhaseDto, @PathVariable(name = "formId") Long formId) {
        return formService.updatePartOfFirstForm(firstPhaseDto, formId);
    }


    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CASE_MANAGER','ROLE_THERAPIST')")
    @CrossOrigin(origins = "*")
    @GetMapping("/first_phase/is-done/{formId}")
    public Boolean isFirstFormFilled(@PathVariable(name = "formId") Long formId) {
        return formService.isFirstFormFullyFilled(formId);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CASE_MANAGER','ROLE_THERAPIST')")
    @CrossOrigin(origins = "*")
    @GetMapping("/second_phase/is-done/{formId}")
    public Boolean isSecondFormFilled(@PathVariable(name = "formId") Long formId) {
        return formService.isSecondFormFullyFilled(formId);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CASE_MANAGER','ROLE_THERAPIST')")
    @CrossOrigin(origins = "*")
    @GetMapping(path = "/first_phase/download-link/{formId}")
    public ResponseEntity<?> generateFirstFormLink(@PathVariable(name = "formId") Long formId) {
        return formService.isFirstFormFullyFilled(formId)
            ? ResponseEntity.ok(Map.of("Link",FIRST_PHASE_DOWNLOAD_LINK + formId))
            : ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CASE_MANAGER','ROLE_THERAPIST')")
    @CrossOrigin(origins = "*")
    @GetMapping(path = "/second_phase/download-link/{formId}")
    public ResponseEntity<?> generateSecondFormLink(@PathVariable(name = "formId") Long formId) {
        return formService.isSecondFormFullyFilled(formId) ?
                        ResponseEntity.ok(Map.of("Link",SECOND_PHASE_DOWNLOAD_LINK + formId)) : ResponseEntity.noContent().build();
    }


//    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_TEACHER','ROLE_THERAPIST')")
    @CrossOrigin(origins = "*")
    @GetMapping(path = "/first_phase/download/{formId}", produces = "application/vnd.openxmlformats-officedocument.wordprocessingml.document")
    public ResponseEntity<?> generateFirstForm(@PathVariable(name = "formId") Long formId) throws Exception {
        byte[] firstFormDoc = formService.generateFirstForm(formId);
        return new ResponseEntity<>(firstFormDoc, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CASE_MANAGER','ROLE_THERAPIST')")
    @CrossOrigin(origins = "*")
    @GetMapping("/first_phase/{formId}")
    public FirstPhase fulfillFirstForm( @PathVariable(name = "formId") Long formId) {
        return formService.getFirstFormById(formId);
    }


    @CrossOrigin(origins = "*")
    @GetMapping("/first_phase")
    public List<FirstPhase> getFirstForm() {
        return formService.getAllFirstForms();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CASE_MANAGER','ROLE_THERAPIST')")
    @CrossOrigin(origins = "*")
    @PostMapping("/second_phase/{studentId}")
    public SecondPhase createNewSecondForm(@RequestBody SecondPhaseDto secondPhaseDto,
                                           @PathVariable(name = "studentId") Long studentId,
                                           @RequestParam Long caseId) throws IllegalAccessException {
        Student student = studentService.findStudentById(studentId)
                .orElseThrow(() ->
                        new StudentNotFound(studentId));
        return formService.createSecondForm(secondPhaseDto, caseId, student);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CASE_MANAGER','ROLE_THERAPIST')")
    @CrossOrigin(origins = "*")
    @PutMapping("/second_phase/{formId}")
    public SecondPhase fulfillSecondForm(@RequestBody SecondPhaseDto secondPhaseDto, @PathVariable(name = "formId") Long formId) {
        return formService.updateSecondForm(secondPhaseDto, formId);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CASE_MANAGER','ROLE_THERAPIST')")
    @CrossOrigin(origins = "*")
    @GetMapping("/second_phase/all")
    public List<SecondPhase> getSecondForm() {
        return formService.getAllSecondForms();
    }

    @PreAuthorize("hasAnyRole('ROLE_CASE_MANAGER','ROLE_ADMIN')")
    @CrossOrigin(origins = "*")
    @GetMapping(path = "/second_phase/download/{formId}", produces = "application/vnd.openxmlformats-officedocument.wordprocessingml.document")
    public ResponseEntity<?> generateSecondForm(@PathVariable(name = "formId") Long formId) throws IOException, Docx4JException {
        byte[] secondFormDoc = formService.generateSecondForm(formId);
        return new ResponseEntity<>(secondFormDoc, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/fourth_phase/{student_id}", produces = "application/json")
    public FourthPhase createNewFourthForm (@RequestBody FourthPhaseDto fourthPhaseDto,
                                            @PathVariable(name = "student_id") Long studentId,
                                            @RequestParam Long caseId) {
        Student student = studentService.findStudentById(studentId)
                .orElseThrow(() ->
                        new StudentNotFound(studentId));
        return formService.createFourthForm(fourthPhaseDto, caseId, student);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/fourth_phase")
    public List<FourthPhase> getFourthForm() {
        return formService.getAllFourthForms();
    }

    @CrossOrigin(origins = "*")
    @PutMapping(path = "/fourth_phase/update/{form_id}")
    public FourthPhase updateFourthForm(@RequestBody FourthPhaseDto fourthPhaseDto, @PathVariable(name = "form_id") Long formId) {
        return formService.updateFourthForm(fourthPhaseDto, formId);
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/fourth_phase/download-link/{formId}")
    public ResponseEntity<?> generateFourthFormLink(@PathVariable(name = "formId") Long formId) {
//        return formService.isFourthFormFullyFilled(formId) ?
//                ResponseEntity.ok(Map.of("Link",
//                        String.format("http://pdpcm.kz/api/form/fourth_phase/download/%s", formId))) : ResponseEntity.noContent().build();
        return ResponseEntity.ok(Map.of("Link", FOURTH_PHASE_DOWNLOAD_LINK +  formId));
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/fourth_phase/download/{formId}", produces = "application/vnd.openxmlformats-officedocument.wordprocessingml.document")
    public ResponseEntity<?> generateFourthForm(@PathVariable(name = "formId") Long formId) throws IOException, Docx4JException {
        byte[] fourthFormDoc = formService.generateFourthForm(formId);
        return new ResponseEntity<>(fourthFormDoc, HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @CrossOrigin(origins = "*")
    @GetMapping("/forms/all")
    public List<FormDto> getAllForms() {
        return formService.getAllForms();
    }



}
