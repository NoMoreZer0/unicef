package swag.rest.nis_risk_app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import swag.rest.nis_risk_app.entity.PartOfSecondForm;
import swag.rest.nis_risk_app.entity.SecondPhase;

public interface PartOfSecondFormRepository extends JpaRepository<PartOfSecondForm, Long> {
}
