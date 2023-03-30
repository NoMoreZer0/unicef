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
@Table(name = "yellow_family_risk_factor")
public class YellowFamilyRiskFactor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "alco_narco")
    private Boolean alcoNarco;

    @Column(name = "homeless_parents")
    private Boolean homelessParents;

    @Column(name = "war_refugee")
    private Boolean warRefugee;

    @Column(name = "imprisoned_parents")
    private Boolean imprisonedParents;

    @Column(name = "low_income")
    private Boolean lowIncome;

    @Column(name = "religious_parent")
    private Boolean religiousParent;

    @Column(name = "failed_bonding")
    private Boolean failedBonding;

    @Column(name = "divorced_parents")
    private Boolean divorcedParents;

    @Column(name = "family_conflicts")
    private Boolean familyConflicts;

    @Column(name = "bad_housing")
    private Boolean badHousing;

    @Column(name = "bad_medicals")
    private Boolean badMedicals;

    @Column(name = "social_isolation")
    private Boolean socialIsolation;

    @Column(name = "discriminated")
    private Boolean discriminated;

    @Column(name = "cultural_norms")
    private Boolean culturalNorms;

    @Column(name = "psycho_parents")
    private Boolean psychoParents;

    @Column(name = "hiv_parents")
    private Boolean hivParents;

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
