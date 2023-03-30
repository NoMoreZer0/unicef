package swag.rest.nis_risk_app.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "education_section")
@Accessors(fluent = true)
public class EducationSection {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RedEducationSection getRedEducationSection() {
        return redEducationSection;
    }

    public void setRedEducationSection(RedEducationSection redEducationSection) {
        this.redEducationSection = redEducationSection;
    }

    public YellowEducationSection getYellowEducationSection() {
        return yellowEducationSection;
    }

    public void setYellowEducationSection(YellowEducationSection yellowEducationSection) {
        this.yellowEducationSection = yellowEducationSection;
    }

    public GreenEducationSection getGreenEducationSection() {
        return greenEducationSection;
    }

    public void setGreenEducationSection(GreenEducationSection greenEducationSection) {
        this.greenEducationSection = greenEducationSection;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "red_education_section_id")
    private RedEducationSection redEducationSection;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "yellow_education_section_id")
    private YellowEducationSection yellowEducationSection;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "green_education_section_id")
    private GreenEducationSection greenEducationSection;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EducationSection that = (EducationSection) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
