package swag.rest.nis_risk_app.dto;

import lombok.*;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * A DTO for the {@link swag.rest.nis_risk_app.entity.RedEducationSection} entity
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RedEducationSectionDto implements Serializable {
    private Boolean noLikeAttend;
    private Boolean specialNeed;
    private Boolean studyingTrouble;
    private Boolean oftenMiss;
}
