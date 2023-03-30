package swag.rest.nis_risk_app.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.lang.reflect.Field;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bloody_red_family_section")
public class BloodyRedFamilySection {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getNotSecuredFromSexualAffection() {
        return notSecuredFromSexualAffection;
    }

    public void setNotSecuredFromSexualAffection(Boolean notSecuredFromSexualAffection) {
        this.notSecuredFromSexualAffection = notSecuredFromSexualAffection;
    }

    public Boolean getAbusiveBehaviorOfParents() {
        return abusiveBehaviorOfParents;
    }

    public void setAbusiveBehaviorOfParents(Boolean abusiveBehaviorOfParents) {
        this.abusiveBehaviorOfParents = abusiveBehaviorOfParents;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "not_secured_from_sexual_affection")
    private Boolean notSecuredFromSexualAffection;

    @Column(name = "abusive_behavior_of_parents")
    private Boolean abusiveBehaviorOfParents;

    public boolean inDanger() throws IllegalAccessException {
        Field[] fields = this.getClass().getDeclaredFields();
        for(Field f : fields){
            Class<?> t = f.getType();
            Object v = f.get(this);
            if(t == Boolean.class && Boolean.TRUE.equals(v))
                return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

}
