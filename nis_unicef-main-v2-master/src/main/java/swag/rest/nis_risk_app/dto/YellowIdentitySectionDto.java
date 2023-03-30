package swag.rest.nis_risk_app.dto;

import lombok.*;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * A DTO for the {@link swag.rest.nis_risk_app.entity.YellowIdentitySection} entity
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
public class YellowIdentitySectionDto implements Serializable {
    private Boolean noFamilyBelong;
    private Boolean certainGenderProblem;
    private Boolean noPositiveIndividual;
    private Boolean noDecisionMaker;
    private Boolean noHygiene;
}
