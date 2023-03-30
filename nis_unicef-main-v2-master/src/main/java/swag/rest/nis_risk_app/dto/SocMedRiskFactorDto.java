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
public class SocMedRiskFactorDto implements Serializable {
    private RedSocMedRiskFactorDto redSocMedRiskFactor;
    private YellowSocMedRiskFactorDto yellowSocMedRiskFactor;
    private GreenSocMedRiskFactorDto greenSocMedRiskFactor;
}
