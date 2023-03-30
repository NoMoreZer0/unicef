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
@Accessors(fluent = true)
@Table(name = "health_section_2")
public class HealthSection {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RedHealthSection getRedHealthSection() {
        return redHealthSection;
    }

    public void setRedHealthSection(RedHealthSection redHealthSection) {
        this.redHealthSection = redHealthSection;
    }

    public YellowHealthSection getYellowHealthSection() {
        return yellowHealthSection;
    }

    public void setYellowHealthSection(YellowHealthSection yellowHealthSection) {
        this.yellowHealthSection = yellowHealthSection;
    }

    public GreenHealthSection getGreenHealthSection() {
        return greenHealthSection;
    }

    public void setGreenHealthSection(GreenHealthSection greenHealthSection) {
        this.greenHealthSection = greenHealthSection;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "red_health_section_id")
    private RedHealthSection redHealthSection;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "yellow_health_section_id")
    private YellowHealthSection yellowHealthSection;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "green_health_section_id")
    private GreenHealthSection greenHealthSection;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HealthSection that = (HealthSection) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
