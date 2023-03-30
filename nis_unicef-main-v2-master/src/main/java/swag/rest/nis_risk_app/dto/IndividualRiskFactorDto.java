package swag.rest.nis_risk_app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class IndividualRiskFactorDto implements Serializable {
    private RedIndividualRiskFactorDto redIndividualRiskFactor;
    private YellowIndividualRiskFactorDto yellowIndividualRiskFactor;
}
