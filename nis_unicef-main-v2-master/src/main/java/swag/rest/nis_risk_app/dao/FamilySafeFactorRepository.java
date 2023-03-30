package swag.rest.nis_risk_app.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import swag.rest.nis_risk_app.entity.FamilySafeFactor;
import swag.rest.nis_risk_app.entity.IndividualSafeFactor;

@Repository
public interface FamilySafeFactorRepository  extends JpaRepository<FamilySafeFactor, Long> {
}