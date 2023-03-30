package swag.rest.nis_risk_app.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import swag.rest.nis_risk_app.entity.IndividualSafeFactor;
import swag.rest.nis_risk_app.entity.SchoolSafeFactor;

@Repository
public interface SchoolSafeFactorRepository  extends JpaRepository<SchoolSafeFactor, Long> {
}