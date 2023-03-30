package swag.rest.nis_risk_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {
    private String FIO;

    private String username;

    private String phoneNumber;

    private String email;

    private String position;

    private String school;
}
