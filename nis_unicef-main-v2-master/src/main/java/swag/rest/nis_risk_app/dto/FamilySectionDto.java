package swag.rest.nis_risk_app.dto;

import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link swag.rest.nis_risk_app.entity.FamilySection} entity
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
public class FamilySectionDto implements Serializable {
    private RedFamilySectionDto redFamilySection;
    private YellowFamilySectionDto yellowFamilySection;
    private GreenFamilySectionDto greenFamilySection;
    private BloodyRedFamilySectionDto bloodyRedFamilySection;
}
