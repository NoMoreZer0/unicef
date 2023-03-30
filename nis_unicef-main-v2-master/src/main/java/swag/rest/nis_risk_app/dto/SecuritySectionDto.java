package swag.rest.nis_risk_app.dto;

import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link swag.rest.nis_risk_app.entity.SecuritySection} entity
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SecuritySectionDto implements Serializable {
    private RedSecuritySectionDto redSecuritySection;
    private YellowSecuritySectionDto yellowSecuritySection;
    private GreenSecuritySectionDto greenSecuritySection;
}
