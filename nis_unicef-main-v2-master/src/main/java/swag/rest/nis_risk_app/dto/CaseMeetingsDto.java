package swag.rest.nis_risk_app.dto;

import lombok.Data;
import swag.rest.nis_risk_app.entity.Case;
import swag.rest.nis_risk_app.entity.Users;

import java.util.Date;

@Data
public class CaseMeetingsDto {
    private String date;

    private Long caseId;

    private String post;

    private String rating;

}
