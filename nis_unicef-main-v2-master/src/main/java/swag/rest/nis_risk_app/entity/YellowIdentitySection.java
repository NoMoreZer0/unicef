package swag.rest.nis_risk_app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "yellow_identity_section_v2")
public class YellowIdentitySection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "no_family_belong")
    private Boolean noFamilyBelong;
    @Column(name = "certain_gender_problem")
    private Boolean certainGenderProblem;
    @Column(name = "no_positive_individual")
    private Boolean noPositiveIndividual;
    @Column(name = "no_decision_maker")
    private Boolean noDecisionMaker;
    @Column(name = "no_hygiene")
    private Boolean noHygiene;

}
