package swag.rest.nis_risk_app.dto;

import lombok.*;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * A DTO for the {@link swag.rest.nis_risk_app.entity.GreenIdentitySection} entity
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
public class GreenIdentitySectionDto implements Serializable {
    private Boolean noConfident;
    private Boolean noHappyLook;
    private Boolean noCulture;
    private Boolean noIndependent;
}
