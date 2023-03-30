package swag.rest.nis_risk_app.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class EmergencyDto {

    private String informedAdministrationFIO;

    private String informedParentFIO;

    private String isStudentIsolated;

    private String isStudentTransferred;

    private Long studentId;
}
