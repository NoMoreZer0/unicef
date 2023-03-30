package swag.rest.nis_risk_app.dto;

import lombok.*;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * A DTO for the {@link swag.rest.nis_risk_app.entity.YellowEducationSection} entity
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
public class YellowEducationSectionDto implements Serializable {
    private Boolean partTime;
    private Boolean noDiscipline;
    private Boolean noConcentration;
    private Boolean noKancellary;
    private Boolean noComputer;
    private Boolean noUniform;
    private Boolean teacherConflict;
    private Boolean noHomeworkSpace;
    private Boolean noMotivation;
}
