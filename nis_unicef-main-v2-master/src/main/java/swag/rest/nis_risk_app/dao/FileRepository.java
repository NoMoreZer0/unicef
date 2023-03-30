package swag.rest.nis_risk_app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import swag.rest.nis_risk_app.entity.Emergency;
import swag.rest.nis_risk_app.entity.File;

import java.util.List;

@Repository
public interface FileRepository extends JpaRepository<File, String> {
    List<File> findAllByFileEmergency(Emergency emergency);
}
