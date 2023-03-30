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
public class RedSocMedRiskFactorDto implements Serializable {
    private Boolean withoutCareRisk;
    private Boolean childLabour;
    private Boolean domesticViolence;
    private Boolean exploitation;
}
