package swag.rest.nis_risk_app.dto;

import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link swag.rest.nis_risk_app.entity.ParentSkills} entity
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class ParentSkillsDto implements Serializable {
    private BasicCareForm4Dto basicCareForm4;
    private SecurityForm4Dto securityForm4;
    private EmotionalHeatForm4Dto emotionalHeatForm4;
    private StabilityForm4Dto stabilityForm4;
    private DirectionBordersForm4Dto directionBordersForm4;
    private StimulationForm4Dto stimulationForm4;
    private ParentProblemsForm4Dto parentProblemsForm4;
    private HousingWorkIncomeForm4Dto housingWorkIncomeForm4;
    private FamilyHistoryForm4Dto familyHistoryForm4;
    private ExtendedFamilyForm4Dto extendedFamilyForm4;
    private ResourcesForm4Dto resourcesForm4;
    private SocialIntegrationForm4Dto socialIntegrationForm4;
}