package swag.rest.nis_risk_app.exception;

public class UserNotFound extends RuntimeException{
    public UserNotFound(Long userId) {
        super(String.format("User with id %s not found", userId));
    }

    public UserNotFound(String username) {
        super(String.format("User %s not found", username));
    }
}
