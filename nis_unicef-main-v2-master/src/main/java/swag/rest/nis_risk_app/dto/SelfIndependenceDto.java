package swag.rest.nis_risk_app.dto;

import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link swag.rest.nis_risk_app.entity.SelfIndependence} entity
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
public class SelfIndependenceDto implements Serializable {
    private YellowSelfIndependenceDto yellowSelfIndependence;
    private GreenSelfIndependenceDto greenSelfIndependence;
}
