package swag.rest.nis_risk_app.dto;

import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link swag.rest.nis_risk_app.entity.OpinionOfInvolvedParties} entity
 */
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class OpinionOfInvolvedPartiesDto implements Serializable {
    private String childComment;
    private String parentComment;
    private String organizationComment;
}