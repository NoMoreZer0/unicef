package swag.rest.nis_risk_app.service.internal;

import static swag.rest.nis_risk_app.constant.Constant.DEEP_FROM;
import static swag.rest.nis_risk_app.constant.Constant.PLAN_FORM;
import static swag.rest.nis_risk_app.entity.Users.getCurrentUserRole;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import swag.rest.nis_risk_app.dao.CaseRepository;
import swag.rest.nis_risk_app.dao.FirstPhaseRepository;
import swag.rest.nis_risk_app.dao.FourthPhaseRepository;
import swag.rest.nis_risk_app.dao.NotifyRepository;
import swag.rest.nis_risk_app.dao.SecondPhaseRepository;
import swag.rest.nis_risk_app.dto.CaseDto;
import swag.rest.nis_risk_app.entity.Case;
import swag.rest.nis_risk_app.entity.FirstPhase;
import swag.rest.nis_risk_app.entity.Notification;
import swag.rest.nis_risk_app.entity.Student;
import swag.rest.nis_risk_app.entity.Users;
import swag.rest.nis_risk_app.exception.CaseManagerNotFound;
import swag.rest.nis_risk_app.exception.CaseNotFound;
import swag.rest.nis_risk_app.exception.FirstFormNotCreated;
import swag.rest.nis_risk_app.exception.StudentNotFound;
import swag.rest.nis_risk_app.exception.UserNotFound;
import swag.rest.nis_risk_app.service.CaseService;
import swag.rest.nis_risk_app.service.StudentService;
import swag.rest.nis_risk_app.service.UserService;
import swag.rest.nis_risk_app.util.CaseStatus;
import swag.rest.nis_risk_app.util.Role;

@Slf4j
@Service
@RequiredArgsConstructor
public class CaseServiceImpl implements CaseService {

    private final CaseRepository caseRepository;
    private final StudentService studentService;
    private final UserService userService;
    private final NotifyRepository notifyRepository;

    private final SecondPhaseRepository secondPhaseRepository;

    private final FourthPhaseRepository fourthPhaseRepository;


    private final FirstPhaseRepository firstPhaseRepository;


    @Transactional
    public Case save(CaseDto studentCase){
        Student student = studentService.findStudentById(studentCase.getStudentId())
                .orElseThrow(() ->
                        new StudentNotFound(studentCase.getStudentId()));
        List<Users> users = new ArrayList<>();
        for (Integer userId : studentCase.getUsersIds()) {
            users.add(userService.findById(Long.parseLong(userId.toString()))
                    .orElseThrow(() ->
                            new UserNotFound(Long.parseLong(userId.toString()))));
        }
        Case caseToSave = Case.builder().openingDate(studentCase.getOpeningDate())
                .caseStatus(studentCase.getCaseStatus())
                .whoStated(studentCase.getWhoStated())
                .users(users)
                .openingReason(studentCase.getReason())
                .build();
        caseToSave.setStudent(student);
        caseToSave.setCaseManager(
                userService.findById(studentCase.getCaseManagerId())
                        .orElseThrow(() ->
                                new CaseManagerNotFound(studentCase.getCaseManagerId())));
        Case resultCase = caseRepository.save(caseToSave);
        Notification notify = new Notification("Case created");
        log.info(Arrays.toString(users.toArray()) + " - users");
        notify.setUsers(users);
        notifyRepository.save(notify);
        return resultCase;
    }

    @Override
    public Case save(Case studentCase) {
        return caseRepository.save(studentCase);
    }

    @Override
    @Transactional
    public Case findById(Long caseId) {
        Case studentCase = caseRepository.findById(caseId).orElseThrow(() -> new CaseNotFound(caseId));
        if (getCurrentUserRole().equals(Role.ROLE_ADMIN.name())
        || getCurrentUserRole().equals(Role.ROLE_CASE_MANAGER.name())) {
            return studentCase;
        }
        return studentCase.getUsers()
                .stream()
                .anyMatch(s -> s.getRole().name().equals(getCurrentUserRole()))
                ? studentCase : null;
    }

    @Override
    @Transactional
    public void closeCase(Long caseId, String closingReason) {
        Case caseToClose = caseRepository.findById(caseId).orElse(new Case());
        caseToClose.setCaseStatus(CaseStatus.CLOSED);
        caseToClose.setClosingReason(closingReason);
        Notification notify = new Notification("Case closed");
        notify.setUsers(caseToClose.getUsers());
        notifyRepository.save(notify);
    }

    @Override
    @Transactional
    public List<Case> findAll() {
        if(Role.ROLE_CASE_MANAGER.name().equals(getCurrentUserRole()))
            return caseRepository.findAll();
        else
            return caseRepository.findAll()
                    .stream()
                    .filter(s ->
                            s.getUsers().stream()
                            .anyMatch(q ->
                                    q.getRole().name().equals(getCurrentUserRole())))
                    .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<Case> findByUserId(Long userId) {
        Users user = userService.findById(userId).orElse(null);
        return caseRepository.findByUsers(user);
    }

    @Override
    public Map<String, Long> getCaseCountByStatus() {
        Map<String, Long> map = new HashMap<>();
        List<Case> caseList = caseRepository.findAll();
        for (CaseStatus status : CaseStatus.values()) {
            map.put(status.name(), caseList.stream().filter(s -> s.getCaseStatus().equals(status)).count());
        }
        map.put(DEEP_FROM, secondPhaseRepository.count());
        map.put(PLAN_FORM, fourthPhaseRepository.count());
        return map;
    }

}
