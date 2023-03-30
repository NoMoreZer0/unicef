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
@Table(name = "bloody_red_stability_section")
public class BloodyRedStabilitySection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "discriminated")
    private Boolean discriminated;

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
