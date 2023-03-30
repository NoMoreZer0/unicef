package swag.rest.nis_risk_app.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link swag.rest.nis_risk_app.entity.YellowSelfIndependence} entity
 */
@Data
public class YellowSelfIndependenceDto implements Serializable {
    private Boolean notAbleToCareHimself;
}
