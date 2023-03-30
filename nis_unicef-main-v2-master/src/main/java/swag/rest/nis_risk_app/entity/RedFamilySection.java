package swag.rest.nis_risk_app.entity;

import lombok.*;

import javax.persistence.*;
import java.lang.reflect.Field;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "red_family_section")
public class RedFamilySection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "constantly_seeing_conflicts")
    private Boolean constantlySeeingConflicts;

}
