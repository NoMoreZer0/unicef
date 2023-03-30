package swag.rest.nis_risk_app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import swag.rest.nis_risk_app.entity.SecuritySectionFromSecondPhase;

public interface SecuritySectionFromSecondPhaseRepository extends
    JpaRepository<SecuritySectionFromSecondPhase, Long> {
}
