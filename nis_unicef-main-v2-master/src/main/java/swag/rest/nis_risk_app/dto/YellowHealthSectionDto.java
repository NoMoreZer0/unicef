package swag.rest.nis_risk_app.dto;

import lombok.*;
import swag.rest.nis_risk_app.util.HealthIssues;
import swag.rest.nis_risk_app.util.IsInvalid;

import java.io.Serializable;

/**
 * A DTO for the {@link swag.rest.nis_risk_app.entity.YellowHealthSection} entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class YellowHealthSectionDto implements Serializable {
    private HealthIssues healthIssues;
    private Boolean haveHealthIssues;
    private Boolean noChronicAttachment;
    private Boolean noPedSocMed;
    private Boolean noPolyclinicAttachment;
    private Boolean noRegularHealthCheck;
    private Boolean noHeightWeightRatio;
    private Boolean phobia;
    private Boolean noSleep;
    private Boolean trauma;
}
