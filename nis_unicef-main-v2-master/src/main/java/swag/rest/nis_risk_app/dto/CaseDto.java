package swag.rest.nis_risk_app.dto;

import java.sql.Date;
import java.util.List;
import lombok.Data;
import swag.rest.nis_risk_app.util.CaseStatus;

@Data
public class CaseDto {

    public List<Integer> getUsersIds() {
        return usersIds;
    }

    private Date openingDate;

    private String reason;

    private String whoStated;

    private Long studentId;

    private CaseStatus caseStatus;

    private Long caseManagerId;

    private List<Integer> usersIds;
}
