package swag.rest.nis_risk_app.service;

import org.springframework.stereotype.Service;
import swag.rest.nis_risk_app.dto.EmergencyDto;
import swag.rest.nis_risk_app.entity.Emergency;

import java.util.List;

@Service
public interface EmergencyService {
    Emergency save(EmergencyDto emergencyDto);

    List<Emergency> getAllEmergency();

    Emergency getEmergencyById(Long id);
}
