package swag.rest.nis_risk_app.dto;

import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link swag.rest.nis_risk_app.entity.ChildDevelopmentNeeds} entity
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class ChildDevelopmentNeedsDto implements Serializable {
    private HealthForm4Dto healthForm4;
    private EducationForm4Dto educationForm4;
    private EmotionalDevelopmentForm4Dto emotionalDevelopmentForm4;
    private IdentityForm4Dto identityForm4;
    private SocialPresentationForm4Dto socialPresentationForm4;
    private FamilyForm4Dto familyForm4;
    private SelfIndependenceForm4Dto selfIndependenceForm4;
}