package swag.rest.nis_risk_app.dto;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * A DTO for the {@link swag.rest.nis_risk_app.entity.GreenSelfIndependence} entity
 */
@Data
public class GreenSelfIndependenceDto implements Serializable {
    private Boolean noPoowrenie;
    private Boolean noPracticalSkill;
    private Boolean noMoneySkill;
}
