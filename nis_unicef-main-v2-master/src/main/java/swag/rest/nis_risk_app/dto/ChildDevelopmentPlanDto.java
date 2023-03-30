package swag.rest.nis_risk_app.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import swag.rest.nis_risk_app.entity.RatingScale;

@JsonSubTypes({
        @JsonSubTypes.Type(value = BasicCareForm4Dto.class, name = "basicCare"),
        @JsonSubTypes.Type(value = SecurityForm4Dto.class, name = "security"),
        @JsonSubTypes.Type(value = EmotionalHeatForm4Dto.class, name = "emotionalHeat"),
        @JsonSubTypes.Type(value = StabilityForm4Dto.class, name = "stability"),
        @JsonSubTypes.Type(value = DirectionBordersForm4Dto.class, name = "directionBorders"),
        @JsonSubTypes.Type(value = StimulationForm4Dto.class, name = "stimulation"),
        @JsonSubTypes.Type(value = ParentProblemsForm4Dto.class, name = "parentProblems"),
        @JsonSubTypes.Type(value = HousingWorkIncomeForm4Dto.class, name = "housingWorkIncome"),
        @JsonSubTypes.Type(value = ExtendedFamilyForm4Dto.class, name = "extendedFamily"),
        @JsonSubTypes.Type(value = ResourcesForm4Dto.class, name = "resources"),
        @JsonSubTypes.Type(value = SocialIntegrationForm4Dto.class, name = "socialIntegration"),
        @JsonSubTypes.Type(value = HealthForm4Dto.class, name = "health"),
        @JsonSubTypes.Type(value = EducationForm4Dto.class, name = "education"),
        @JsonSubTypes.Type(value = EmotionalDevelopmentForm4Dto.class, name = "emotionalDevelopment"),
        @JsonSubTypes.Type(value = IdentityForm4Dto.class, name = "identity"),
        @JsonSubTypes.Type(value = SocialPresentationForm4Dto.class, name = "socialPresentation"),
        @JsonSubTypes.Type(value = FamilyForm4Dto.class, name = "family"),
        @JsonSubTypes.Type(value = SelfIndependenceForm4Dto.class, name = "selfIndependence")
})
public class ChildDevelopmentPlanDto {
    public Integer criteria;
    public String discoveredRiskFactors;
    public String measures;
    public String measurePeriod;
    public String employee;
    public RatingScale ratingScale;
    public Integer indicator;
}
