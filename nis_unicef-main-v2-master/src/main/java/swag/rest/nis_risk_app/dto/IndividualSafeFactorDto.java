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
public class IndividualSafeFactorDto implements Serializable {
    private Boolean academicSuccess;
    private Boolean goodLifeSkills;
    private Boolean active;
    private Boolean selfConfident;

}