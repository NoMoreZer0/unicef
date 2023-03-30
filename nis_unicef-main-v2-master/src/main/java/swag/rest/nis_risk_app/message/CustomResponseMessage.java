package swag.rest.nis_risk_app.message;

import lombok.Data;

@Data
public class CustomResponseMessage {
    private String message;

    public CustomResponseMessage(String message) {
        this.message = message;
    }
}
