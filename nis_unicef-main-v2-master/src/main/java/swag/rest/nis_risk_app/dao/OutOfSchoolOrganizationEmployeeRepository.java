package swag.rest.nis_risk_app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import swag.rest.nis_risk_app.entity.OutOfSchoolOrganizationEmployee;

public interface OutOfSchoolOrganizationEmployeeRepository extends JpaRepository<OutOfSchoolOrganizationEmployee, Long> {
}
