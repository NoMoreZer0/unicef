package swag.rest.nis_risk_app.exception;

public class InternalServerError extends RuntimeException {
    public InternalServerError(String message, Throwable cause) {
        super(message, cause);
    }
}
