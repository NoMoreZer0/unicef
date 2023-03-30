package swag.rest.nis_risk_app.exception;

public class CaseNotFound extends RuntimeException{
    public CaseNotFound(Long id) {
        super(String.format("Case with id %s not found", id));
    }
}
