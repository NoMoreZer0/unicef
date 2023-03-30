package swag.rest.nis_risk_app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import swag.rest.nis_risk_app.entity.FirstPhase;

import java.util.Optional;

public interface FirstPhaseRepository extends JpaRepository<FirstPhase, Long> {

    Optional<FirstPhase> findById(Long id);

}
