package swag.rest.nis_risk_app.service;

import swag.rest.nis_risk_app.dto.ParentDto;
import swag.rest.nis_risk_app.entity.Parent;

import java.util.List;
import java.util.Optional;

public interface ParentService {
    Parent saveParent(ParentDto parentDto);

    List<Parent> getAll();

    Optional<Parent> findById(Long id);
}
