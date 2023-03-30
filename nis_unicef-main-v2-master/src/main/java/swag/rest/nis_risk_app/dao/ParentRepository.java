package swag.rest.nis_risk_app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import swag.rest.nis_risk_app.entity.Parent;
@Repository
public interface ParentRepository extends JpaRepository<Parent, Long> {
}
