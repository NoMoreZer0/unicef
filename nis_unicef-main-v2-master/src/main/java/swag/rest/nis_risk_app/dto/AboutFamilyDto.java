package swag.rest.nis_risk_app.dto;

import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link swag.rest.nis_risk_app.entity.AboutFamily} entity
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AboutFamilyDto implements Serializable {
    private YellowAboutFamilyDto yellowAboutFamily;
    private GreenAboutFamilyDto greenAboutFamily;
}
