package swag.rest.nis_risk_app.controller;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import swag.rest.nis_risk_app.dto.CaseDto;
import swag.rest.nis_risk_app.dto.CaseMeetingsDto;
import swag.rest.nis_risk_app.dto.ClosingCaseDto;
import swag.rest.nis_risk_app.dto.EmergencyDto;
import swag.rest.nis_risk_app.dto.FileDto;
import swag.rest.nis_risk_app.entity.Case;
import swag.rest.nis_risk_app.entity.CaseMeetings;
import swag.rest.nis_risk_app.entity.Emergency;
import swag.rest.nis_risk_app.entity.File;
import swag.rest.nis_risk_app.entity.Users;
import swag.rest.nis_risk_app.message.CustomResponseMessage;
import swag.rest.nis_risk_app.message.ResponseFile;
import swag.rest.nis_risk_app.service.CaseMeetingsService;
import swag.rest.nis_risk_app.service.CaseService;
import swag.rest.nis_risk_app.service.EmergencyService;
import swag.rest.nis_risk_app.service.FileStorageService;
import swag.rest.nis_risk_app.service.UserService;

@RequiredArgsConstructor
@RestController
@Slf4j
@CrossOrigin("*")
public class CaseController {

    private final CaseService caseService;
    private final CaseMeetingsService caseMeetingsService;
    private final UserService userService;
    private final EmergencyService emergencyService;
    private final FileStorageService fileStorageService;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CASE_MANAGER','ROLE_THERAPIST')")
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/create_new_case")
    public ResponseEntity<Case> createNewCase(@RequestBody CaseDto studentCase) {
        return new ResponseEntity<>(caseService.save(studentCase), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CASE_MANAGER','ROLE_THERAPIST')")
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/close_case")
    public void closeCase(@RequestBody ClosingCaseDto closingCaseDto) {
        caseService.closeCase(closingCaseDto.getCaseId(), closingCaseDto.getClosingReason());
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CASE_MANAGER','ROLE_THERAPIST')")
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/get_all_users")
    public List<Users> getAllUsers() {
        return userService.findAll();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CASE_MANAGER','ROLE_THERAPIST')")
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/get_user/{id}")
    public Users getUser(@PathVariable Long id) {
        return userService.findById(id).orElse(null);
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/get_all_cases")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CASE_MANAGER')")
    public List<Case> getAllCases() {
        return caseService.findAll();
    }


    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CASE_MANAGER','ROLE_THERAPIST')")
    @GetMapping("/get_all_cases_by_id/{userId}")
    public List<Case> getAllCasesById(@PathVariable("userId") Long userId) {
        return caseService.findByUserId(userId);
    }


    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CASE_MANAGER','ROLE_THERAPIST')")
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/get_all_case_users/{caseId}")
    public List<Users> getAllCaseUsers(@PathVariable Long caseId) {
        Case cases = caseService.findById(caseId);
        return cases.getUsers();
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/get_case/{caseId}")
    public Case getCase(@PathVariable Long caseId) {
        return caseService.findById(caseId);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_THERAPIST','ROLE_TEACHER', 'ROLE_HEADTEACHER', 'ROLE_POLICE', 'ROLE_CASE_MANAGER', 'ROLE_CURATOR')")
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/create_new_post")
    public ResponseEntity<CaseMeetings> createNewPost(@RequestBody CaseMeetingsDto caseMeetingsDto) {
        return new ResponseEntity<>(caseMeetingsService.save(caseMeetingsDto), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_THERAPIST','ROLE_TEACHER', 'ROLE_HEADTEACHER', 'ROLE_POLICE', 'ROLE_CASE_MANAGER', 'ROLE_CURATOR')")
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/update_post")
    public ResponseEntity<CaseMeetings> updatePost(@RequestBody CaseMeetingsDto caseMeetingsDto) {
        return new ResponseEntity<>(
                caseMeetingsService.update(
                        caseMeetingsDto,
                        caseMeetingsDto.getPost(),
                        caseMeetingsDto.getRating()),
                HttpStatus.OK);
    }


    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_THERAPIST','ROLE_TEACHER', 'ROLE_HEADTEACHER', 'ROLE_POLICE', 'ROLE_CASE_MANAGER', 'ROLE_CURATOR')")
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/get_posts_by_specialist/{userId}")
    public List<CaseMeetings> getPostsBySpecialist(@PathVariable Long userId) {
        return caseMeetingsService.getAllCaseMeetingsBySpecialist(userId);
    }


    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_THERAPIST','ROLE_TEACHER', 'ROLE_HEADTEACHER', 'ROLE_POLICE', 'ROLE_CASE_MANAGER', 'ROLE_CURATOR')")
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/get_all_posts")
    public List<CaseMeetings> getAllPosts() {
        return caseMeetingsService.getAllCaseMeetings();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CASE_MANAGER','ROLE_THERAPIST')")
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/get_all_relevant_posts/{userId}")
    public List<CaseMeetings> getAllRelevantPosts(@PathVariable Long userId) {
        return caseMeetingsService.getAllRelevantCaseMeetings(userId);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CASE_MANAGER','ROLE_THERAPIST')")
    @GetMapping("/get_posts_by_case/{caseId}")
    public List<CaseMeetings> getPostsByCase(@PathVariable Long caseId) {
        return caseMeetingsService.getAllCaseMeetingsByCaseId(caseId);
    }


    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_THERAPIST','ROLE_TEACHER', 'ROLE_HEADTEACHER', 'ROLE_POLICE', 'ROLE_CASE_MANAGER', 'ROLE_CURATOR')")
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/get_post/{id}")
    public CaseMeetings getPost(@PathVariable("id") String id) {
        return caseMeetingsService.getById(Long.parseLong(id));
    }


    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_THERAPIST','ROLE_TEACHER', 'ROLE_HEADTEACHER', 'ROLE_POLICE', 'ROLE_CASE_MANAGER', 'ROLE_CURATOR')")
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/emergency")
    public ResponseEntity<Emergency> emergency(@RequestBody EmergencyDto emergencyDto) {
        return new ResponseEntity<>(emergencyService.save(emergencyDto), HttpStatus.OK);
    }


    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CASE_MANAGER','ROLE_THERAPIST')")
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/get_all_emergency")
    public List<Emergency> getAllEmergency() {
        return emergencyService.getAllEmergency();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CASE_MANAGER','ROLE_THERAPIST')")
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(path = "/emergency_upload_file/{emergencyId}",
                    method = RequestMethod.POST,
                    consumes = {"multipart/form-data"})
    public ResponseEntity<CustomResponseMessage> emergencyUploadFormAlgorithm(@PathVariable Long emergencyId, @ModelAttribute FileDto fileDto) {
        String message;
        Emergency emergency = emergencyService.getEmergencyById(emergencyId);
        try {
            fileStorageService.store(fileDto.getFile(), emergency);
            message = "Uploaded the file successfully: " + fileDto.getFile().getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new CustomResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + fileDto.getFile().getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body(new CustomResponseMessage(message));
        }
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CASE_MANAGER','ROLE_THERAPIST')")
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/emergency_get_files/{emergencyId}")
    public ResponseEntity<List<ResponseFile>> getListFiles(@PathVariable Long emergencyId) {
        Emergency emergency = emergencyService.getEmergencyById(emergencyId);
        List<File> files = fileStorageService.getAllFilesByEmergency(emergency);
        List<ResponseFile> responseFiles = files.stream()
                .map(dbFile -> {
                    String fileDownloadUri = ServletUriComponentsBuilder
                            .fromCurrentContextPath()
                            .path("/emergency_download_file/")
                            .path(dbFile.getId())
                            .toUriString();
                    System.out.println(fileDownloadUri);
                    return new ResponseFile(
                            dbFile.getName(),
                            fileDownloadUri,
                            dbFile.getType(),
                            dbFile.getData().length);
                }).collect(Collectors.toList());


        return ResponseEntity.status(HttpStatus.OK).body(responseFiles);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_CASE_MANAGER','ROLE_THERAPIST')")
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/emergency_download_file/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable String id) {
        File fileDB = fileStorageService.getFile(id);
        System.out.println(fileDB.getName() + " - " + fileDB.getId());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
                .body(fileDB.getData());
    }
}
