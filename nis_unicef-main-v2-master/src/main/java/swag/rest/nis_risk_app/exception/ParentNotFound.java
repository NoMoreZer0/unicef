package swag.rest.nis_risk_app.exception;

public class ParentNotFound extends RuntimeException{
    public ParentNotFound(Long id) {
        super(String.format("Parent with id %s not found", id));
    }
}
