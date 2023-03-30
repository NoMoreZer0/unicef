package swag.rest.nis_risk_app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@ToString
@Setter
public class RedIndividualRiskFactorDto implements Serializable {
    private Boolean riskyBehaviour;
    private Boolean suicideRisk;
}
