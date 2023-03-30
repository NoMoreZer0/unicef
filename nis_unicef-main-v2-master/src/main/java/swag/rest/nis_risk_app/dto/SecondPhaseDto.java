package swag.rest.nis_risk_app.dto;

import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link swag.rest.nis_risk_app.entity.SecondPhase} entity
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SecondPhaseDto implements Serializable {
    private HealthSectionDto healthSection;
    private EducationSectionDto educationSection;
    private EmotionalIntelligenceDto emotionalIntelligence;
    private IdentitySectionDto identitySection;
    private FamilySectionDto familySection;
    private SelfIndependenceDto selfIndependence;
    private SecuritySectionDto securitySection;
    private AboutFamilyDto aboutFamily;
}
