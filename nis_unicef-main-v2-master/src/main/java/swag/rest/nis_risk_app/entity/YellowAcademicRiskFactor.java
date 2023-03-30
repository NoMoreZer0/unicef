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
@Table(name = "yellow_academic_risk_factor")
public class YellowAcademicRiskFactor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "absence_without_excuse")
    private Boolean absenceWithoutExcuse;

    @Column(name = "unsatisfactory_grades")
    private Boolean unsatisfactoryGrades;

    @Column(name = "low_motivation")
    private Boolean lowMotivation;

    @Column(name = "no_parental_control")
    private Boolean noParentalControl;

    @Column(name = "s2s_conflict")
    private Boolean s2sConflict;

    @Column(name = "s2t_conflict")
    private Boolean s2tConflict;

    @Column(name = "t2p_conflict")
    private Boolean t2pConflict;

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
