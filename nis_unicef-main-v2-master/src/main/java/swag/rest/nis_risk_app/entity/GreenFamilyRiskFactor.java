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
@Table(name = "green_family_risk_factor")
public class GreenFamilyRiskFactor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "many_kids")
    private Boolean manyKids;

    @Column(name = "partial_family")
    private Boolean partialFamily;

    @Column(name = "migrant_parents")
    private Boolean migrantParents;

    @Column(name = "pregnant_with_kids")
    private Boolean pregnantWithKids;

    @Column(name = "invalid_parent")
    private Boolean invalidParent;

    @Column(name = "old_parent")
    private Boolean oldParent;

    @Column(name = "uneducated_parents")
    private Boolean uneducatedParents;

    @Column(name = "weak_parents")
    private Boolean weakParents;

    @Column(name = "institute_parent")
    private Boolean instituteParent;

    @Column(name = "no_transport")
    private Boolean noTransport;

    @Column(name = "financial_problem")
    private Boolean financialProblem;

    @Column(name = "no_social_help")
    private Boolean noSocialHelp;

    @Column(name = "little_access_service")
    private Boolean littleAccessService;

    @Column(name = "unemployed_member")
    private Boolean unemployedMember;

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