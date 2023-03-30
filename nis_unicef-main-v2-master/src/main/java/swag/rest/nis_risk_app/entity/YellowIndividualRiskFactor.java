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
@Table(name = "yellow_individual_risk_factor")
public class YellowIndividualRiskFactor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "self_harm")
    private Boolean selfHarm;

    @Column(name = "grief")
    private Boolean grief;

    @Column(name = "stress_trauma")
    private Boolean stressTrauma;

    @Column(name = "phys_mental_disorder")
    private Boolean physMentalDisorder;

    @Column(name = "weak_self_service")
    private Boolean weakSelfService;

    @Column(name = "psychoemotional")
    private Boolean psychoemotional;

    @Column(name = "bullied")
    private Boolean bullied;

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
