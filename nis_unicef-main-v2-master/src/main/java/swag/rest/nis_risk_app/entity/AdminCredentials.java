package swag.rest.nis_risk_app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AdminCredentials  {
    String username;
    Boolean isMaster;


}
