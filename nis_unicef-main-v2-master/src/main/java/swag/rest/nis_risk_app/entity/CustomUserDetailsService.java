package swag.rest.nis_risk_app.entity;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import swag.rest.nis_risk_app.dao.UserRepository;

import java.util.Optional;

@Service
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;


    private static final String USER_NOT_FOUND_MESSAGE = "User with username %s not found";



    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> user = userRepository.findByUsername(username);
        if(!user.isPresent()) {
            String message = String.format(USER_NOT_FOUND_MESSAGE, username);
            log.error(message);
            throw new UsernameNotFoundException(message);
        } else {
            log.debug("User found in the database: {}", username);
            return user.get();
        }

    }
}