package swag.rest.nis_risk_app.dto;

import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link swag.rest.nis_risk_app.entity.HealthSection} entity
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
public class HealthSectionDto implements Serializable {
    private RedHealthSectionDto redHealthSection;
    private YellowHealthSectionDto yellowHealthSection;
    private GreenHealthSectionDto greenHealthSection;
}
