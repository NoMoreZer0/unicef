package swag.rest.nis_risk_app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

/**
 * A DTO for the {@link swag.rest.nis_risk_app.entity.OtherPerson} entity
 */
@AllArgsConstructor
@Getter
@ToString
public class OtherPersonDto implements Serializable {
    private String nameOfParent;
    private String phoneNumber;
    private String dateOfBirth;
    private String familyStatus;
    private String address;
    private String whoExactly;
    private String workplace;
}
