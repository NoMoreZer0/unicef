package swag.rest.nis_risk_app.dto;

import lombok.*;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * A DTO for the {@link swag.rest.nis_risk_app.entity.RedHealthSection} entity
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RedHealthSectionDto implements Serializable {
    private Boolean notEatWell;
    private Boolean noGlasses;
    private Boolean badCoordination;
    private Boolean badHabits;
    private Boolean incontinence;
    private Boolean speechIssues;
}
