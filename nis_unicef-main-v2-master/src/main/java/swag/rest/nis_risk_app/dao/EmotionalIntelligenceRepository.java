package swag.rest.nis_risk_app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import swag.rest.nis_risk_app.entity.EmotionalIntelligence;

public interface EmotionalIntelligenceRepository extends JpaRepository<EmotionalIntelligence, Long> {
}
