package swag.rest.nis_risk_app.exception;

public class FourthFormNotFound extends  RuntimeException{
    public FourthFormNotFound(Long formId) {
        super(String.format("Fourth form with id %s not found", formId));
    }
}
