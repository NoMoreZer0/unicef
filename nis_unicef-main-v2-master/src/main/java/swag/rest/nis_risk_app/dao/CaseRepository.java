package swag.rest.nis_risk_app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import swag.rest.nis_risk_app.entity.Case;
import swag.rest.nis_risk_app.entity.Users;

import java.util.List;

@Repository
public interface CaseRepository extends JpaRepository<Case, Long> {
    List<Case> findByUsers(Users user);

}
