package swag.rest.nis_risk_app.service;

import swag.rest.nis_risk_app.dto.CaseMeetingsDto;
import swag.rest.nis_risk_app.entity.CaseMeetings;

import java.util.List;

public interface CaseMeetingsService {
    CaseMeetings save(CaseMeetingsDto caseMeetingsDto);
    CaseMeetings update(CaseMeetingsDto caseMeetingsDto, String post, String rating);
    List<CaseMeetings> getAllCaseMeetings();
    List<CaseMeetings> getAllRelevantCaseMeetings(Long userId);
    List<CaseMeetings> getAllCaseMeetingsBySpecialist(Long userId);
    List<CaseMeetings> getAllCaseMeetingsByUserId(Long userId);
    List<CaseMeetings> getAllCaseMeetingsByCaseId(Long caseId);
    CaseMeetings getById(Long id);


}
