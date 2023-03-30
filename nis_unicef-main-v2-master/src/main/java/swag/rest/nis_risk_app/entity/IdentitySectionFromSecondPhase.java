package swag.rest.nis_risk_app.entity;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "identity_section_from_second_phase")
public class IdentitySectionFromSecondPhase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "discrimination")
    private Boolean discrimination;

    @Column(name = "gender_acceptance_problem")
    private Boolean genderAcceptanceProblem;

    @Column(name = "no_decision_maker")
    private Boolean noDecisionMaker;

//    @Column(name = "no_family_belong")
//    private Boolean noFamilyBelong;
//
//    @Column(name = "certain_gender_problem")
//    private Boolean certainGenderProblem;
//
//    @Column(name = "no_positive_individual")
//    private Boolean noPositiveIndividual;
//
//    @Column(name = "no_hygiene")
//    private Boolean noHygiene;


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null ||
            Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        IdentitySectionFromSecondPhase that = (IdentitySectionFromSecondPhase) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}