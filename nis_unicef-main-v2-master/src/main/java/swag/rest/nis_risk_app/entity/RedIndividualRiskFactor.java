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
@Table(name = "red_individual_risk_factor")
public class RedIndividualRiskFactor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "risky_behaviour")
    private Boolean riskyBehaviour;

    @Column(name = "suicide_risk")
    private Boolean suicideRisk;

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
