package swag.rest.nis_risk_app.dto;

import lombok.*;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * A DTO for the {@link swag.rest.nis_risk_app.entity.YellowFamilySection} entity
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
public class YellowFamilySectionDto implements Serializable {
    private  Boolean noPositiveWithParent;
    private  Boolean noAdultDepend;
    private  Boolean noBondingParentKid;

    private  Boolean noLikeFamilyMember;

    private  Boolean noFriend;

    private Boolean noParentSkill;

    private Boolean takeParentRole;

    private Boolean farAway;
    private Boolean problemParentKid;
    private Boolean chronic;
    private Boolean sudimost;
    private Boolean traumaPast;
}
