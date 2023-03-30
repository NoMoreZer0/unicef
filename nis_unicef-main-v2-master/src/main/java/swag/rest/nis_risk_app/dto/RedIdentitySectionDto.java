package swag.rest.nis_risk_app.dto;

import lombok.*;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * A DTO for the {@link swag.rest.nis_risk_app.entity.RedIdentitySection} entity
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RedIdentitySectionDto implements Serializable {
    private Boolean discrimination;
    private Boolean genderAcceptanceProblem;
}
