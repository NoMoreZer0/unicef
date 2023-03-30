package swag.rest.nis_risk_app.dto;

import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link swag.rest.nis_risk_app.entity.RedFamilySection} entity
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RedFamilySectionDto implements Serializable {
    private Boolean constantlySeeingConflicts;
}
