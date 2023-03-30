package swag.rest.nis_risk_app.dto;

import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link swag.rest.nis_risk_app.entity.EmotionalIntelligence} entity
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EmotionalIntelligenceDto implements Serializable {
    private RedEmotionalIntelligenceDto redEmotionalIntelligence;
    private YellowEmotionalIntelligenceDto yellowEmotionalIntelligence;
    private BloodyRedEmotionalIntelligenceDto bloodyRedEmotionalIntelligence;
}
