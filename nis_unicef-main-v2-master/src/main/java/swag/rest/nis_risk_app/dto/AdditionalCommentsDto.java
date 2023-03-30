package swag.rest.nis_risk_app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * A DTO for the {@link swag.rest.nis_risk_app.entity.AdditionalComments} entity
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class AdditionalCommentsDto implements Serializable {
    private String comment;
}
