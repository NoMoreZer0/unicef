package swag.rest.nis_risk_app.service.internal;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import swag.rest.nis_risk_app.dao.UserRepository;
import swag.rest.nis_risk_app.dto.UserAuthDto;
import swag.rest.nis_risk_app.exception.UserAlreadyExistException;
import swag.rest.nis_risk_app.util.Role;
import swag.rest.nis_risk_app.entity.Users;
import swag.rest.nis_risk_app.service.UserService;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public Users save(UserAuthDto userDto) {
        Users user = new Users();
        user.setUsername(userDto.getUsername());
        log.info("Saving user {} to the database", user.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRole(Role.ROLE_THERAPIST);
        user.setEnabled(true);
        userRepository.findByUsername(userDto.getUsername())
                .ifPresent((newUser) -> {
                    throw new UserAlreadyExistException(newUser.getUsername());
                });
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public Optional<Users> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }



    @Override
    @Transactional
    public Optional<Users> findById(Long id) {
        return userRepository.findById(id);
    }


    @Override
    @Transactional
    public List<Users> findAll() {
        return userRepository.findAll();
    }


}
