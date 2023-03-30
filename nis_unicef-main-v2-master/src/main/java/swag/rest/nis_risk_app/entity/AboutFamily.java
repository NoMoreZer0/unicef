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
@Table(name = "about_family_v2")
public class AboutFamily {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public YellowAboutFamily getYellowAboutFamily() {
        return yellowAboutFamily;
    }

    public void setYellowAboutFamily(YellowAboutFamily yellowAboutFamily) {
        this.yellowAboutFamily = yellowAboutFamily;
    }

    public GreenAboutFamily getGreenAboutFamily() {
        return greenAboutFamily;
    }

    public void setGreenAboutFamily(GreenAboutFamily greenAboutFamily) {
        this.greenAboutFamily = greenAboutFamily;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "yellow_about_family_id")
    private YellowAboutFamily yellowAboutFamily;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "green_about_family_id")
    private GreenAboutFamily greenAboutFamily;


}
