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
public class GreenSocMedRiskFactorDto implements Serializable {
    private Boolean noOutfit;
    private Boolean legalIssues;
    private Boolean liveOutsideFamily;
}
