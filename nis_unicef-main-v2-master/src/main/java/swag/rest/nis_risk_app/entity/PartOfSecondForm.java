package swag.rest.nis_risk_app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "part_of_second_form")
public class PartOfSecondForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "health_section_from_second_phase_id")
    private HealthSectionFromSecondPhase healthSectionFromSecondPhase;
    @ManyToOne
    @JoinColumn(name = "education_section_from_second_phase_id")
    private EducationSectionFromSecondPhase educationSectionFromSecondPhase;
    @OneToOne
    @JoinColumn(name = "emotional_intelligence_from_second_phase_id")
    private EmotionalIntelligenceFromSecondPhase emotionalIntelligenceFromSecondPhase;
    @OneToOne
    @JoinColumn(name = "identity_section_from_second_phase_id")
    private IdentitySectionFromSecondPhase identitySectionFromSecondPhase;
    @OneToOne
    @JoinColumn(name = "family_section_from_second_phase_id")
    private FamilySectionFromSecondPhase familySectionFromSecondPhase;
    @OneToOne
    @JoinColumn(name = "security_section_from_second_phase_id")
    private SecuritySectionFromSecondPhase securitySectionFromSecondPhase;
}
