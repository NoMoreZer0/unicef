package swag.rest.nis_risk_app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

/**
 * A DTO for the {@link swag.rest.nis_risk_app.entity.AbuseSuspicion} entity
 */
@AllArgsConstructor
@Getter
@ToString
public class AbuseSuspicionDto implements Serializable {
    private Boolean domesticViolence;
    private Boolean sexualAbuse;
    private Boolean parentMakeDangerousEnv;
    private Boolean locationUnknown;
}
