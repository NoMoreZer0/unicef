package swag.rest.nis_risk_app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import swag.rest.nis_risk_app.entity.Father;
import swag.rest.nis_risk_app.entity.Mother;

@Repository
public interface MotherRepository  extends JpaRepository<Mother, Long> {
}
