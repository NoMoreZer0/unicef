package swag.rest.nis_risk_app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@ToString
@Setter
public class YellowSocMedRiskFactorDto implements Serializable {
    private Boolean lawConflict;
    private Boolean invalid;
    private Boolean earlyPregnancy;
    private Boolean hasHiv;
    private Boolean violentApproach;
    private Boolean psychicalIssue;
    private Boolean religious;
    private Boolean warRefugee;
    private Boolean fosterCareExperience;
    private Boolean badEating;
}
