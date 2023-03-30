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
@Table(name = "education_section_from_second_phase")
public class EducationSectionFromSecondPhase {
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

    @Column(name = "no_like_attend")
    private Boolean noLikeAttend;

    @Column(name = "special_need")
    private Boolean specialNeed;

    @Column(name = "studying_trouble")
    private Boolean studyingTrouble;

    @Column(name = "often_miss")
    private Boolean oftenMiss;

    @Column(name = "no_concentration")
    private Boolean noConcentration;


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null ||
            Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        EducationSectionFromSecondPhase that = (EducationSectionFromSecondPhase) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}