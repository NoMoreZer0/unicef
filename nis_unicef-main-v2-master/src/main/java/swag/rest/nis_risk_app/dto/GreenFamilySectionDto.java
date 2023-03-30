package swag.rest.nis_risk_app.dto;

import lombok.*;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * A DTO for the {@link swag.rest.nis_risk_app.entity.GreenFamilySection} entity
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
public class GreenFamilySectionDto implements Serializable {
    private Boolean parentsChanged;
    private Boolean noSpareTime;
}
