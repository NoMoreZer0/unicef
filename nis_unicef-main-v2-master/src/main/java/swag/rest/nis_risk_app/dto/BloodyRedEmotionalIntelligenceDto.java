package swag.rest.nis_risk_app.dto;

import lombok.*;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * A DTO for the {@link swag.rest.nis_risk_app.entity.BloodyRedEmotionalIntelligence} entity
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BloodyRedEmotionalIntelligenceDto implements Serializable {
    private Boolean anxiety;
    private Boolean depression;
    private Boolean bullied;
    private Boolean suicidalDream;
    private Boolean suicidalAction;
    private Boolean aggressor;
}
