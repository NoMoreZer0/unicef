package swag.rest.nis_risk_app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import swag.rest.nis_risk_app.util.Role;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A DTO for the {@link swag.rest.nis_risk_app.entity.Users} entity
 */
@AllArgsConstructor
@Getter
@ToString
public class UsersDto implements Serializable {
    private String FIO;
    @NotNull
    private String username;
    @NotNull
    private String password;
    private String phoneNumber;
    @Email
    private String email;
    private String position;
    private String school;
    private boolean enabled;
    private Role role;
    private Boolean isCurator;
}
