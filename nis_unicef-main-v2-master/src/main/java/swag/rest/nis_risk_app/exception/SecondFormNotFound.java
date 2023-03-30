package swag.rest.nis_risk_app.exception;

public class SecondFormNotFound extends  RuntimeException{
    public SecondFormNotFound(Long formId) {
        super(String.format("Second form with id %s not found", formId));
    }
}
