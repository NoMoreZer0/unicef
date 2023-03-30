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
public class FamilySafeFactorDto implements Serializable {
    private Boolean familyRuleSet;
    private Boolean roleModel;
    private Boolean supportingEnvironment;
    private Boolean safeBonding;
    private Boolean caringParent;
    private Boolean stability;
    private Boolean goodParentSkills;
    private Boolean positivePractice;
    private Boolean basicNeed;
    private Boolean sustainableRelation;
}
