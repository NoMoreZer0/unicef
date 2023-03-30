package swag.rest.nis_risk_app.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.lang.reflect.Field;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "yellow_soc_med_risk_factor")
public class YellowSocMedRiskFactor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "law_conflict")
    private Boolean lawConflict;

    @Column(name = "invalid")
    private Boolean invalid;

    @Column(name = "early_pregnancy")
    private Boolean earlyPregnancy;

    @Column(name = "has_hiv")
    private Boolean hasHiv;

    @Column(name = "violent_approach")
    private Boolean violentApproach;

    @Column(name = "psychical_issue")
    private Boolean psychicalIssue;

    @Column(name = "religious")
    private Boolean religious;

    @Column(name = "war_refugee")
    private Boolean warRefugee;

    @Column(name = "foster_care_experience")
    private Boolean fosterCareExperience;

    @Column(name = "bad_eating")
    private Boolean badEating;

    @Column(name = "score")
    private Long score;

    public Long countScore(Long userScore) throws IllegalAccessException {
        long multiplier = 40L;
        if(userScore != null) multiplier = userScore;
        long counter = 0L;
        Field[] fields = this.getClass().getDeclaredFields();
        for(Field f : fields){
            Class<?> t = f.getType();
            Object v = f.get(this);
            if(t == Boolean.class && Boolean.TRUE.equals(v))
                counter += multiplier;

        }
        this.setScore(counter);
        return score;
    }

}
