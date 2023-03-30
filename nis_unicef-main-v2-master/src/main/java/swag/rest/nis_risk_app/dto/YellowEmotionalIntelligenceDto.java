package swag.rest.nis_risk_app.dto;

import lombok.*;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * A DTO for the {@link swag.rest.nis_risk_app.entity.YellowEmotionalIntelligence} entity
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
public class YellowEmotionalIntelligenceDto implements Serializable {
    private Boolean easilyUpset;
    private Boolean noSchoolFriends;
    private Boolean outsideHome;
    private Boolean emotionalAlone;
    private Boolean selfHarm;
    private Boolean leftHome;
    private Boolean zadira;
    private Boolean riskyBehaviour;
    private Boolean witnessConflict;
    private Boolean noControlEmotion;
    private Boolean robbery;
    private Boolean uchet;
    private Boolean noGoodBad;
    private Boolean noSocietyNorms;
}
