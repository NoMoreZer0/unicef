package swag.rest.nis_risk_app.dto;

import lombok.*;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * A DTO for the {@link swag.rest.nis_risk_app.entity.GreenEducationSection} entity
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
public class GreenEducationSectionDto implements Serializable {
    private Boolean noBelovedSubject;
    private Boolean haveSchoolFriend;
    private Boolean noParticipatedInClub;
}
