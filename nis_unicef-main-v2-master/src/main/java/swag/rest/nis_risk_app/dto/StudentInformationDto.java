package swag.rest.nis_risk_app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import swag.rest.nis_risk_app.util.Gender;

import java.io.Serializable;

/**
 * A DTO for the {@link swag.rest.nis_risk_app.entity.StudentInformation} entity
 */
@AllArgsConstructor
@Getter
@ToString
public class StudentInformationDto implements Serializable {
    private String nameOfStudent;
    private Gender gender;
    private String grade;
    private String dateOfBirth;
    private String educationalNeeds;
    private String address;
    private String phoneNumber;
}
