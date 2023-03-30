package swag.rest.nis_risk_app.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "school_safe_factor")
public class SchoolSafeFactor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "safe_school")
    private Boolean safeSchool;

    @Column(name = "additional_class")
    private Boolean additionalClass;

    @Column(name = "has_npa")
    private Boolean hasNpa;

    @Column(name = "mentorship")
    private Boolean mentorship;

    @Column(name = "parent_program")
    private Boolean parentProgram;

    @Column(name = "inclusive")
    private Boolean inclusive;

    @Column(name = "additional_creative_class")
    private Boolean additionalCreativeClass;

    @Column(name = "prophylactic")
    private Boolean prophylactic;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SchoolSafeFactor that = (SchoolSafeFactor) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}