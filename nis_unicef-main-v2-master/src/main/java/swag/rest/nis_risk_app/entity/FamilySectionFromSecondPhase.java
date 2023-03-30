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
@Table(name = "family_section_from_second_phase")
public class FamilySectionFromSecondPhase {
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

    @Column(name = "not_secured_from_sexual_affection")
    private Boolean notSecuredFromSexualAffection;

    @Column(name = "abusive_behavior_of_parents")
    private Boolean abusiveBehaviorOfParents;

    @Column(name = "no_positive_with_parent")
    private  Boolean noPositiveWithParent;

    @Column(name = "no_adult_depend")
    private  Boolean noAdultDepend;

    @Column(name = "no_like_family_member")
    private  Boolean noLikeFamilyMember;

    @Column(name = "no_friend")
    private  Boolean noFriend;

    @Column(name = "constantly_seeing_conflicts")
    private Boolean constantlySeeingConflicts;

    @Column(name = "chronic")
    private Boolean chronic;

    @Column(name = "trauma_past")
    private Boolean traumaPast;


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null ||
            Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        FamilySectionFromSecondPhase that = (FamilySectionFromSecondPhase) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}