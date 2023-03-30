package swag.rest.nis_risk_app.dto;

import lombok.*;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * A DTO for the {@link swag.rest.nis_risk_app.entity.RedSecuritySection} entity
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RedSecuritySectionDto implements Serializable {
    private Boolean parentNotAbleToProvideBasicThing;
    private Boolean parentsNotGoesToDoctorWhenNeeded;
}
