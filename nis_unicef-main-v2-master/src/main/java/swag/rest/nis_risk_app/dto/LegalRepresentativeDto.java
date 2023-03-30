package swag.rest.nis_risk_app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

/**
 * A DTO for the {@link swag.rest.nis_risk_app.entity.LegalRepresentative} entity
 */
@AllArgsConstructor
@Getter
@ToString
public class LegalRepresentativeDto implements Serializable {
    private FatherDto father;
    private OtherPersonDto otherPerson;
    private MotherDto mother;
}
