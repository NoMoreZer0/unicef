package swag.rest.nis_risk_app.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "child_development_needs")
@AllArgsConstructor
@NoArgsConstructor
public class ChildDevelopmentNeeds {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "health_id")
    private HealthForm4 healthForm4;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "education_id")
    private EducationForm4 educationForm4;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "emotional_development_id")
    private EmotionalDevelopmentForm4 emotionalDevelopmentForm4;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "identity_id")
    private IdentityForm4 identityForm4;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "social_presentation_id")
    private SocialPresentationForm4 socialPresentationForm4;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "family_id")
    private FamilyForm4 familyForm4;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "self_independence_id")
    private SelfIndependenceForm4 selfIndependenceForm4;
}
