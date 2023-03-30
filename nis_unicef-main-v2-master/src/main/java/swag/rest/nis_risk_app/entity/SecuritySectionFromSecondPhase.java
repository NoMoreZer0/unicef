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
@Table(name = "security_section_from_second_phase")
public class SecuritySectionFromSecondPhase {
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

    @Column(name = "current_home_bad")
    private Boolean currentHomeBad;

    @Column(name = "parent_unemployed")
    private Boolean parentUnemployed;

    @Column(name = "family_no_take_needed_allowance")
    private Boolean familyNoTakeNeededAllowance;

    @Column(name = "have_material_issue")
    private Boolean haveMaterialIssue;


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null ||
            Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        SecuritySectionFromSecondPhase that = (SecuritySectionFromSecondPhase) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}