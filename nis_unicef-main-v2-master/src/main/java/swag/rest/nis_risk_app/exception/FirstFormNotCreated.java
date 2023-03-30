package swag.rest.nis_risk_app.exception;

public class FirstFormNotCreated extends RuntimeException {
    public FirstFormNotCreated() {
        super("Need to create first form");
    }
}
