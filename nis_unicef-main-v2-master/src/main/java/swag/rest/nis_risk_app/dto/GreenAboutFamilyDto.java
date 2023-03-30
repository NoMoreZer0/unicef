package swag.rest.nis_risk_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * A DTO for the {@link swag.rest.nis_risk_app.entity.GreenAboutFamily} entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class GreenAboutFamilyDto implements Serializable {
    private Boolean noHaveOwnHouse;

}
