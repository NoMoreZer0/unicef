package swag.rest.nis_risk_app.dto;

import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link swag.rest.nis_risk_app.entity.OutOfSchoolOrganizationEmployee} entity
 */
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class OutOfSchoolOrganizationEmployeeDto implements Serializable {
    private String fio;
    private String organization;
    private String contact;
}