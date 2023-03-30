package swag.rest.nis_risk_app.entity;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import swag.rest.nis_risk_app.util.HealthIssues;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "health_section_from_second_phase")
public class HealthSectionFromSecondPhase {
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

    @Column(name = "health_issues")
    @Enumerated(EnumType.STRING)
    private HealthIssues healthIssues;

    @Column(name = "no_ped_soc_med")
    private Boolean noPedSocMed;

    @Column(name = "not_eat_well")
    private Boolean notEatWell;

    @Column(name = "bad_habits")
    private Boolean badHabits;

    @Column(name = "incontinence")
    private Boolean incontinence;

    @Column(name = "speech_issues")
    private Boolean speechIssues;

    @Column(name = "no_glasses")
    private Boolean noGlasses;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null ||
            Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        HealthSectionFromSecondPhase that = (HealthSectionFromSecondPhase) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}