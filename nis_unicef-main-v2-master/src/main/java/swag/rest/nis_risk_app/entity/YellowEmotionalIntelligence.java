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
@Table(name = "yellow_emotional_intelligence")
public class YellowEmotionalIntelligence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "easily_upset")
    private Boolean easilyUpset;
    @Column(name = "no_school_friends")
    private Boolean noSchoolFriends;
    @Column(name = "outside_home")
    private Boolean outsideHome;
    @Column(name = "emotional_alone")
    private Boolean emotionalAlone;
    @Column(name = "self_harm")
    private Boolean selfHarm;
    @Column(name = "left_home")
    private Boolean leftHome;
    @Column(name = "zadira")
    private Boolean zadira;
    @Column(name = "risky_behaviour")
    private Boolean riskyBehaviour;
    @Column(name = "witness_conflict")
    private Boolean witnessConflict;
    @Column(name = "no_control_emotion")
    private Boolean noControlEmotion;
    @Column(name = "robbery")
    private Boolean robbery;
    @Column(name = "uchet")
    private Boolean uchet;
    @Column(name = "noGoodBad")
    private Boolean noGoodBad;
    @Column(name = "no_society_norms")
    private Boolean noSocietyNorms;

}
