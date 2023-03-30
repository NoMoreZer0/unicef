package swag.rest.nis_risk_app.dto;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UpdateNewsDto {

    private Long id;
    private String label;

    private LocalDateTime timestamp;

    private String topic;
}
