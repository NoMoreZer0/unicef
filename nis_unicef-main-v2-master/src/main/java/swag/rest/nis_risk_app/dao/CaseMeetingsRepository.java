package swag.rest.nis_risk_app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import swag.rest.nis_risk_app.entity.Case;
import swag.rest.nis_risk_app.entity.CaseMeetings;
import swag.rest.nis_risk_app.entity.Users;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface CaseMeetingsRepository extends JpaRepository<CaseMeetings, Long> {
    Optional<CaseMeetings> findByDateAndStudentCaseAndMeetingHolder(String date, Case studentCase, Users meetingHolder);

    List<CaseMeetings> findAllByMeetingHolder(Users user);

    List<CaseMeetings> findAllByStudentCase(Case cases);

}
