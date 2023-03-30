package swag.rest.nis_risk_app.dto;

import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link swag.rest.nis_risk_app.entity.IdentitySection} entity
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
public class IdentitySectionDto implements Serializable {
    private RedIdentitySectionDto redIdentitySection;
    private YellowIdentitySectionDto yellowIdentitySection;
    private GreenIdentitySectionDto greenIdentitySection;
}
