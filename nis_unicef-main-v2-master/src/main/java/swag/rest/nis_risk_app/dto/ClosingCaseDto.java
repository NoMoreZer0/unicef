package swag.rest.nis_risk_app.dto;

import lombok.Data;

@Data
public class ClosingCaseDto {
    private Long caseId;
    private String closingReason;
}
