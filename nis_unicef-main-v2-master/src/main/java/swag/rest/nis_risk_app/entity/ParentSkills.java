package swag.rest.nis_risk_app.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "parent_skills")
@AllArgsConstructor
@NoArgsConstructor
public class ParentSkills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "basic_care_id")
    private BasicCareForm4 basicCareForm4;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "security_id")
    private SecurityForm4 securityForm4;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "emotional_heat_id")
    private EmotionalHeatForm4 emotionalHeatForm4;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "stability_id")
    private StabilityForm4 stabilityForm4;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "direction_borders_id")
    private DirectionBordersForm4 directionBordersForm4;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "stimulation_id")
    private StimulationForm4 stimulationForm4;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "parent_problems_id")
    private ParentProblemsForm4 parentProblemsForm4;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "housing_work_income_id")
    private HousingWorkIncomeForm4 housingWorkIncomeForm4;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "family_history_id")
    private FamilyHistoryForm4 familyHistoryForm4;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "extended_family_id")
    private ExtendedFamilyForm4 extendedFamilyForm4;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "resources_id")
    private ResourcesForm4 resourcesForm4;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "social_integration_id")
    private SocialIntegrationForm4 socialIntegrationForm4;
}
