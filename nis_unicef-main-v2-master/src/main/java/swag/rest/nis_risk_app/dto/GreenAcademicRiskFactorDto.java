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
public class GreenAcademicRiskFactorDto implements Serializable {
    private Boolean absenceHealth;
    private Boolean notProvided;
    private Boolean noSchoolSessions;
    private Boolean refuseSchoolSession;
    private Boolean lowQualitySchoolSession;
}
