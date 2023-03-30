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
@Table(name = "emotional_intelligence_from_second_phase")
public class EmotionalIntelligenceFromSecondPhase {
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

    @Column(name = "anxiety")
    private Boolean anxiety;

    @Column(name = "depression")
    private Boolean depression;

    @Column(name = "bullied")
    private Boolean bullied;

    @Column(name = "no_school_friends")
    private Boolean noSchoolFriends;

    @Column(name = "emotional_alone")
    private Boolean emotionalAlone;

    @Column(name = "risky_behaviour")
    private Boolean riskyBehaviour;

    @Column(name = "witness_conflict")
    private Boolean witnessConflict;

    @Column(name = "uchet")
    private Boolean uchet;


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null ||
            Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        EmotionalIntelligenceFromSecondPhase that = (EmotionalIntelligenceFromSecondPhase) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}