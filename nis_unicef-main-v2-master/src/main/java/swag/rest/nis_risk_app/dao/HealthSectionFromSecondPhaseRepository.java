package swag.rest.nis_risk_app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import swag.rest.nis_risk_app.entity.HealthSectionFromSecondPhase;

public interface HealthSectionFromSecondPhaseRepository
    extends JpaRepository<HealthSectionFromSecondPhase, Long> {
}
