package swag.rest.nis_risk_app.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import swag.rest.nis_risk_app.dto.CaseDto;
import swag.rest.nis_risk_app.entity.Case;

public interface CaseService {
    Case save(CaseDto studentCase);

    Case save(Case studentCase);

    Case findById(Long caseId);

    void closeCase(Long caseId, String closingReason);

    List<Case> findAll();

    List<Case> findByUserId(Long userId);

    Map<String, Long> getCaseCountByStatus();

}
