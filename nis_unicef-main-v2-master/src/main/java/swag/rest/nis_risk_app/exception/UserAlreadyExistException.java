package swag.rest.nis_risk_app.exception;

public class UserAlreadyExistException extends RuntimeException{
    public UserAlreadyExistException(String user) {
        super(user + " already exist");
    }
}
