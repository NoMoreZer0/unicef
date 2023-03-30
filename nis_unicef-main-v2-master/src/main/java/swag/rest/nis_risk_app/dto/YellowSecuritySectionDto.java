package swag.rest.nis_risk_app.dto;

import lombok.*;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * A DTO for the {@link swag.rest.nis_risk_app.entity.YellowSecuritySection} entity
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
public class YellowSecuritySectionDto implements Serializable {
    private Boolean haveEducationEnv;
    private Boolean frequentSchoolChange;
    private Boolean parentNoInterestWhere;
    private Boolean noLawFamily;
}
