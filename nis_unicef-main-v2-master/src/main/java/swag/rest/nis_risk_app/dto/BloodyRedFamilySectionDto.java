package swag.rest.nis_risk_app.dto;

import lombok.*;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * A DTO for the {@link swag.rest.nis_risk_app.entity.BloodyRedFamilySection} entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BloodyRedFamilySectionDto implements Serializable {
    public Boolean getNotSecuredFromSexualAffection() {
        return notSecuredFromSexualAffection;
    }

    public void setNotSecuredFromSexualAffection(Boolean notSecuredFromSexualAffection) {
        this.notSecuredFromSexualAffection = notSecuredFromSexualAffection;
    }

    public Boolean getAbusiveBehaviorOfParents() {
        return abusiveBehaviorOfParents;
    }

    public void setAbusiveBehaviorOfParents(Boolean abusiveBehaviorOfParents) {
        this.abusiveBehaviorOfParents = abusiveBehaviorOfParents;
    }

    private Boolean notSecuredFromSexualAffection;
    private Boolean abusiveBehaviorOfParents;
}
