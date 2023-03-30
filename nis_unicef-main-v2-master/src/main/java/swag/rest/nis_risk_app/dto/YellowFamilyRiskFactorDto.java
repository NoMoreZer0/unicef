package swag.rest.nis_risk_app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@ToString
@Setter
public class YellowFamilyRiskFactorDto implements Serializable {
    private Boolean alcoNarco;
    private Boolean homelessParents;
    private Boolean warRefugee;
    private Boolean imprisonedParents;
    private Boolean lowIncome;
    private Boolean religiousParent;
    private Boolean failedBonding;
    private Boolean divorcedParents;
    private Boolean familyConflicts;
    private Boolean badHousing;
    private Boolean badMedicals;
    private Boolean socialIsolation;
    private Boolean discriminated;
    private Boolean culturalNorms;
    private Boolean psychoParents;
    private Boolean hivParents;
}
