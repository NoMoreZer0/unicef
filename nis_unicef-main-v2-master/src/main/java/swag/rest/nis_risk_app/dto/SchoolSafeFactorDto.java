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
public class SchoolSafeFactorDto implements Serializable {
    private Boolean safeSchool;
    private Boolean additionalClass;
    private Boolean hasNpa;
    private Boolean mentorship;
    private Boolean parentProgram;
    private Boolean inclusive;
    private Boolean additionalCreativeClass;
    private Boolean prophylactic;
}