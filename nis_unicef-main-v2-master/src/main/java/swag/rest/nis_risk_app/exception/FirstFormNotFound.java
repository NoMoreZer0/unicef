package swag.rest.nis_risk_app.exception;

public class FirstFormNotFound extends RuntimeException{
    public FirstFormNotFound(Long formId) {
        super(String.format("First form with id %s not found", formId));
    }
}
