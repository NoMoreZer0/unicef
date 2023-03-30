package swag.rest.nis_risk_app.service.internal;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import swag.rest.nis_risk_app.dao.CaseMeetingsRepository;
import swag.rest.nis_risk_app.dto.CaseMeetingsDto;
import swag.rest.nis_risk_app.entity.Case;
import swag.rest.nis_risk_app.entity.CaseMeetings;
import swag.rest.nis_risk_app.entity.Users;
import swag.rest.nis_risk_app.service.CaseMeetingsService;
import swag.rest.nis_risk_app.service.CaseService;
import swag.rest.nis_risk_app.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CaseMeetingsServiceImpl implements CaseMeetingsService {

    private final CaseMeetingsRepository caseMeetingsRepository;

    private final UserService userService;
    private final CaseService caseService;



    @Override
    @Transactional
    public CaseMeetings save(CaseMeetingsDto caseMeetingsDto) {
        Case caseToMeeting = caseService.findById(caseMeetingsDto.getCaseId());
        Users userToMeeting = userService.findByUsername(
                SecurityContextHolder.getContext().getAuthentication().getName()
        ).orElse(null);
        CaseMeetings caseMeetingsToSave =
                new CaseMeetings(caseMeetingsDto.getDate(), caseToMeeting, userToMeeting);
        caseMeetingsToSave.setPost(caseMeetingsDto.getPost());
        caseMeetingsToSave.setRating(caseMeetingsDto.getRating());
        assert caseToMeeting != null;
        CaseMeetings persistedMeeting = caseMeetingsRepository.save(caseMeetingsToSave);
        caseToMeeting.getCaseMeetings().add(persistedMeeting);
        caseService.save(caseToMeeting);
        return persistedMeeting;
    }

    @Override
    @Transactional
    public CaseMeetings update(CaseMeetingsDto caseMeetingsDto, String post, String rating) {
        Case caseToMeeting = caseService.findById(caseMeetingsDto.getCaseId());
        Users userToMeeting = userService.findByUsername(
                SecurityContextHolder.getContext().getAuthentication().getName()
        ).orElse(null);
        CaseMeetings caseMeetingsToUpdate = caseMeetingsRepository.findByDateAndStudentCaseAndMeetingHolder(
                caseMeetingsDto.getDate(),
                caseToMeeting,
                userToMeeting).orElse(null);
        assert caseMeetingsToUpdate != null;
        caseMeetingsToUpdate.setPost(post);
        caseMeetingsToUpdate.setRating(rating);
        CaseMeetings persistedMeeting = caseMeetingsRepository.save(caseMeetingsToUpdate);
        assert caseToMeeting != null;
        caseToMeeting.getCaseMeetings().add(persistedMeeting);
        caseService.save(caseToMeeting);
        return persistedMeeting;
    }
    @Override
    @Transactional
    public List<CaseMeetings> getAllCaseMeetingsBySpecialist(Long userId){
        Users user = userService.findById(userId).orElse(null);
        return caseMeetingsRepository.findAllByMeetingHolder(user);
    }

    @Override
    @Transactional
    public List<CaseMeetings> getAllCaseMeetingsByUserId(Long userId) {
        Users user = userService.findById(userId).orElse(null);
        return caseMeetingsRepository.findAllByMeetingHolder(user);
    }

    @Override
    @Transactional
    public CaseMeetings getById(Long id) {
        return caseMeetingsRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public List<CaseMeetings> getAllCaseMeetings() {
        return caseMeetingsRepository.findAll();
    }

    @Override
    @Transactional
    public List<CaseMeetings> getAllRelevantCaseMeetings(Long userId) {
        List<Case> cases = caseService.findByUserId(userId);
        List<CaseMeetings> caseMeetings = new ArrayList<>();
        for(Case c : cases){
            for(CaseMeetings cm : c.getCaseMeetings()){
                caseMeetings.add(cm);
            }
        }
        return caseMeetings;
    }

    @Override
    @Transactional
    public List<CaseMeetings> getAllCaseMeetingsByCaseId(Long caseId) {
        Case cases = caseService.findById(caseId);
        return caseMeetingsRepository.findAllByStudentCase(cases);
    }
}
