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
public class YellowAcademicRiskFactorDto implements Serializable {
    private Boolean absenceWithoutExcuse;
    private Boolean unsatisfactoryGrades;
    private Boolean lowMotivation;
    private Boolean noParentalControl;
    private Boolean s2sConflict;
    private Boolean s2tConflict;
    private Boolean t2pConflict;
}
