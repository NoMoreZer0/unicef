package swag.rest.nis_risk_app.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "environment_safe_factor")
public class EnvironmentSafeFactor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "economic_stability")
    private Boolean economicStability;

    @Column(name = "employed_parent")
    private Boolean employedParent;

    @Column(name = "educated_parent")
    private Boolean educatedParent;

    @Column(name = "normal_living_condition")
    private Boolean normalLivingCondition;

    @Column(name = "social_help")
    private Boolean socialHelp;

    @Column(name = "medical_access")
    private Boolean medicalAccess;

    @Column(name = "resource_coordination")
    private Boolean resourceCoordination;
}