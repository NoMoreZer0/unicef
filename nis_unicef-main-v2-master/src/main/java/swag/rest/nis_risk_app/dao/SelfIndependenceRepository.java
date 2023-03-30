package swag.rest.nis_risk_app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import swag.rest.nis_risk_app.entity.SelfIndependence;

public interface SelfIndependenceRepository extends JpaRepository<SelfIndependence, Long> {
}
