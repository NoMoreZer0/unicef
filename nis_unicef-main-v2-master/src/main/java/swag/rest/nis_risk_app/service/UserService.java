package swag.rest.nis_risk_app.service;

import org.springframework.stereotype.Service;
import swag.rest.nis_risk_app.dto.UserAuthDto;
import swag.rest.nis_risk_app.entity.Users;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
     Users save(UserAuthDto user);
     Optional<Users> findByUsername(String username);
     Optional<Users> findById(Long id);
     List<Users> findAll();

}
