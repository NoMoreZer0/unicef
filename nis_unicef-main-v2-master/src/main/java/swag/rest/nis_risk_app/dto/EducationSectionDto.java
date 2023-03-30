package swag.rest.nis_risk_app.dto;

import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link swag.rest.nis_risk_app.entity.EducationSection} entity
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EducationSectionDto implements Serializable {
    private RedEducationSectionDto redEducationSection;
    private YellowEducationSectionDto yellowEducationSection;
    private GreenEducationSectionDto greenEducationSection;
}
