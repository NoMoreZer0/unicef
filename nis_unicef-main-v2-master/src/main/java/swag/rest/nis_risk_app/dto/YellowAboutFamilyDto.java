package swag.rest.nis_risk_app.dto;

import lombok.*;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * A DTO for the {@link swag.rest.nis_risk_app.entity.YellowAboutFamily} entity
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
public class YellowAboutFamilyDto implements Serializable {
    private Boolean avaryHome;
    private Boolean currentHomeBad;
    private Boolean parentUnemployed;
    private Boolean familyNoTakeNeededAllowance;
    private Boolean haveMaterialIssue;
}
