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
public class GreenFamilyRiskFactorDto implements Serializable {
    private Boolean manyKids;
    private Boolean partialFamily;
    private Boolean migrantParents;
    private Boolean pregnantWithKids;
    private Boolean invalidParent;
    private Boolean oldParent;
    private Boolean uneducatedParents;
    private Boolean weakParents;
    private Boolean instituteParent;
    private Boolean noTransport;
    private Boolean financialProblem;
    private Boolean noSocialHelp;
    private Boolean littleAccessService;
    private Boolean unemployedMember;

}
