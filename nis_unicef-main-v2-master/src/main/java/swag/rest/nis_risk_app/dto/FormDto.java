package swag.rest.nis_risk_app.dto;

import lombok.Builder;
import lombok.Data;
import swag.rest.nis_risk_app.entity.FormType;

@Data
@Builder
public class FormDto {
    private Long id;
    private String downloadLink;
    private String grade;
    private String studentName;
    private FormType formType;
}
