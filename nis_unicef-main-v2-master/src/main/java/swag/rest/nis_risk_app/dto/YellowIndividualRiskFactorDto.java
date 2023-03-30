package swag.rest.nis_risk_app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@ToString
@Setter
public class YellowIndividualRiskFactorDto {
    private Boolean selfHarm;
    private Boolean grief;
    private Boolean stressTrauma;
    private Boolean physMentalDisorder;
    private Boolean weakSelfService;
    private Boolean psychoemotional;
    private Boolean bullied;
}
