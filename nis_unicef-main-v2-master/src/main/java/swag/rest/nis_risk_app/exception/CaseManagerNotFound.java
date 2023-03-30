package swag.rest.nis_risk_app.exception;

public class CaseManagerNotFound extends RuntimeException {
    public CaseManagerNotFound(Long id) {
        super(String.format("Case manager with id %s not found", id));
    }
}
