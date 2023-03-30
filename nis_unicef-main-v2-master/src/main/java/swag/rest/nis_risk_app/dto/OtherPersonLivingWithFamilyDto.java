package swag.rest.nis_risk_app.dto;

import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link swag.rest.nis_risk_app.entity.OtherPersonLivingWithFamily} entity
 */
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class OtherPersonLivingWithFamilyDto implements Serializable {
    private String fio;
    private String birthDate;
    private String relationLevel;
    private String workplace;
}