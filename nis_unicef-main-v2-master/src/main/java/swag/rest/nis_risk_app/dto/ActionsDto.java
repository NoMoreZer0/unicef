package swag.rest.nis_risk_app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import javax.mail.Multipart;
import java.io.Serializable;

/**
 * A DTO for the {@link swag.rest.nis_risk_app.entity.Actions} entity
 */
@AllArgsConstructor
@Getter
@ToString
public class ActionsDto implements Serializable {
    private  Boolean supportNotNeeded;
    private  Boolean signContract;
    private  Boolean liveInDanger;
    private  Boolean needSupport;
    private  String caseManager;
    private  String sign;
    private  String date;
}
