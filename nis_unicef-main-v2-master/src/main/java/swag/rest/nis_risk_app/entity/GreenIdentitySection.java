package swag.rest.nis_risk_app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "green_identity_section_v2")
public class GreenIdentitySection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "no_confident")
    private Boolean noConfident;
    @Column(name = "no_happy_look")
    private Boolean noHappyLook;
    @Column(name = "no_culture")
    private Boolean noCulture;
    @Column(name = "no_independent")
    private Boolean noIndependent;

}
