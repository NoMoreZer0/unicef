package swag.rest.nis_risk_app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import swag.rest.nis_risk_app.entity.Parent;
import swag.rest.nis_risk_app.util.Gender;
import swag.rest.nis_risk_app.util.StudentStatus;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link swag.rest.nis_risk_app.entity.Student} entity
 */
@AllArgsConstructor
@Getter
@ToString
public class StudentDto implements Serializable {
    private String nameOfStudent;
    private Gender gender;
    private String grade;
    private String dateOfBirth;
    private String educationalNeeds;
    private String address;
    private String language;
    private String phoneNumber;
    private String school;
    private StudentStatus studentStatus;
    private List<Parent> parents;
    private List<ParentDto> parentsDto;
}
