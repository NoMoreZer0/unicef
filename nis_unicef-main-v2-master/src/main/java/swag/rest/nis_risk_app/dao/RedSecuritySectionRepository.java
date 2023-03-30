package swag.rest.nis_risk_app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import swag.rest.nis_risk_app.entity.RedSecuritySection;

public interface RedSecuritySectionRepository extends JpaRepository<RedSecuritySection, Long> {
}
