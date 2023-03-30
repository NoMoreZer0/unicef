package swag.rest.nis_risk_app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Admin {
    String username;
    Boolean isMaster;
}
