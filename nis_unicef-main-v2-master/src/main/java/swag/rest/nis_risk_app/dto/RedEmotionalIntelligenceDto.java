package swag.rest.nis_risk_app.dto;

import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link swag.rest.nis_risk_app.entity.RedEmotionalIntelligence} entity
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
public class RedEmotionalIntelligenceDto implements Serializable {
    private Boolean seenConflict;
    private Boolean defiantBehavior;
    private Boolean isBully;
    private Boolean leavedHome;
    private Boolean selfHarm;
    private Boolean goingHomeLate;
    private Boolean cantShareThoughtsWithAdult;
}
