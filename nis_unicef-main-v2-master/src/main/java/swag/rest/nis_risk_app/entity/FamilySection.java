package swag.rest.nis_risk_app.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Accessors(fluent = true)
@Table(name = "family_section")
public class FamilySection {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RedFamilySection getRedFamilySection() {
        return redFamilySection;
    }

    public void setRedFamilySection(RedFamilySection redFamilySection) {
        this.redFamilySection = redFamilySection;
    }

    public YellowFamilySection getYellowFamilySection() {
        return yellowFamilySection;
    }

    public void setYellowFamilySection(YellowFamilySection yellowFamilySection) {
        this.yellowFamilySection = yellowFamilySection;
    }

    public GreenFamilySection getGreenFamilySection() {
        return greenFamilySection;
    }

    public void setGreenFamilySection(GreenFamilySection greenFamilySection) {
        this.greenFamilySection = greenFamilySection;
    }

    public BloodyRedFamilySection getBloodyRedFamilySection() {
        return bloodyRedFamilySection;
    }

    public void setBloodyRedFamilySection(BloodyRedFamilySection bloodyRedFamilySection) {
        this.bloodyRedFamilySection = bloodyRedFamilySection;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "red_family_section_id")
    private RedFamilySection redFamilySection;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "yellow_family_section_id")
    private YellowFamilySection yellowFamilySection;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "green_family_section_id")
    private GreenFamilySection greenFamilySection;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "bloody_red_family_section_id")
    private BloodyRedFamilySection bloodyRedFamilySection;

}
