package swag.rest.nis_risk_app.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import swag.rest.nis_risk_app.entity.FourthPhase;

public interface FourthPhaseRepository extends JpaRepository<FourthPhase, Long> {


    @Query(" SELECT f FROM FourthPhase f WHERE f.partOfSecondForm is not null "
         + " and f.studentCase.id = ?1")
    Optional<FourthPhase> findByStudentCaseId(Long id);

}
