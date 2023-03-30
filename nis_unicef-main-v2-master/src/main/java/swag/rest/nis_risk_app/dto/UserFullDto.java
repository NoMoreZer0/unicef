package swag.rest.nis_risk_app.dto;

import lombok.Data;
import swag.rest.nis_risk_app.util.Role;

@Data
public class UserFullDto {

    private Long id;

    private String fio;

    private String username;

    private String phoneNumber;

    private String email;

    private String position;

    private String school;

    private boolean enabled;

    private Role role;

    private String pictureLink;

}
