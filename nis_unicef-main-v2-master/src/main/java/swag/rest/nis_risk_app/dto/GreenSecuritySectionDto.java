package swag.rest.nis_risk_app.dto;

import lombok.*;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * A DTO for the {@link swag.rest.nis_risk_app.entity.GreenSecuritySection} entity
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
public class GreenSecuritySectionDto implements Serializable {
    private Boolean noSchedule;
    private Boolean noPraise;
    private Boolean noKnowProblem;
}
