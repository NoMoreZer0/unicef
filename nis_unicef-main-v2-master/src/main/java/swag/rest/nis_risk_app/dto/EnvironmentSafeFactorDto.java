package swag.rest.nis_risk_app.dto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@ToString
@Setter
public class EnvironmentSafeFactorDto implements Serializable {
    private Boolean economicStability;
    private Boolean employedParent;
    private Boolean educatedParent;
    private Boolean normalLivingCondition;
    private Boolean socialHelp;
    private Boolean medicalAccess;
    private Boolean resourceCoordination;
}