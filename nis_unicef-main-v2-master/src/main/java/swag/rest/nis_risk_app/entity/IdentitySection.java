package swag.rest.nis_risk_app.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(fluent = true)
@Table(name = "identity_section_v2")
public class IdentitySection {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RedIdentitySection getRedIdentitySection() {
        return redIdentitySection;
    }

    public void setRedIdentitySection(RedIdentitySection redIdentitySection) {
        this.redIdentitySection = redIdentitySection;
    }

    public YellowIdentitySection getYellowIdentitySection() {
        return yellowIdentitySection;
    }

    public void setYellowIdentitySection(YellowIdentitySection yellowIdentitySection) {
        this.yellowIdentitySection = yellowIdentitySection;
    }

    public GreenIdentitySection getGreenIdentitySection() {
        return greenIdentitySection;
    }

    public void setGreenIdentitySection(GreenIdentitySection greenIdentitySection) {
        this.greenIdentitySection = greenIdentitySection;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "red_identity_section_id")
    private RedIdentitySection redIdentitySection;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "yellow_identity_section_id")
    private YellowIdentitySection yellowIdentitySection;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "green_identity_section_id")
    private GreenIdentitySection greenIdentitySection;

}
