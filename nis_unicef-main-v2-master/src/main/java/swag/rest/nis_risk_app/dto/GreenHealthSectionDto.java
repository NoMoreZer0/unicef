package swag.rest.nis_risk_app.dto;

import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link swag.rest.nis_risk_app.entity.GreenHealthSection} entity
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class GreenHealthSectionDto implements Serializable {
    private Boolean notVaccinated;
    private Boolean notActive;
}
