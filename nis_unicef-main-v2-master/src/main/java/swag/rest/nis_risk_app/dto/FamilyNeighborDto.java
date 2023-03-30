package swag.rest.nis_risk_app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

/**
 * A DTO for the {@link swag.rest.nis_risk_app.entity.FamilyNeighbor} entity
 */
@AllArgsConstructor
@Getter
@ToString
public class FamilyNeighborDto implements Serializable {
    private  String nameOfParent;
    private  String phoneNumber;
    private  String dateOfBirth;
    private  String age;
    private  String familyStatus;
    private  String address;
}
