package swag.rest.nis_risk_app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * A DTO for the {@link swag.rest.nis_risk_app.entity.Parent} entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class ParentDto implements Serializable {
    private String nameOfParent;
    private String phoneNumber;
    private String dateOfBirth;
    private String age;
    private String familyStatus;
    private String address;
}
