package swag.rest.nis_risk_app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

/**
 * A DTO for the {@link swag.rest.nis_risk_app.entity.Source} entity
 */
@AllArgsConstructor
@Getter
@ToString
public class SourceDto implements Serializable {
    private String dateOfMeeting;
    private String nameOfPerson;
    private String organization;
    private String connectionWithStudent;
    private String contact;
}