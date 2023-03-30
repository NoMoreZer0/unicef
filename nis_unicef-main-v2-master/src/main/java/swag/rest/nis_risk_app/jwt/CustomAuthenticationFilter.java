package swag.rest.nis_risk_app.jwt;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static swag.rest.nis_risk_app.constant.Constant.ERROR_ATTEMPT;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import swag.rest.nis_risk_app.entity.Users;
import swag.rest.nis_risk_app.exception.InternalServerError;

@Slf4j
@RequiredArgsConstructor
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private static final String BAD_CREDENTIAL_MESSAGE = "Authentication failed for username: %s and password: %s";

    private final AuthenticationManager authenticationManager;

    @SneakyThrows
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {

        String username = null;
        String password = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, String> map = objectMapper.readValue(request.getInputStream(),
                new TypeReference<>() {});
            username = map.get("username");
            password = map.get("password");
            log.debug("Login with username: {}", username);
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }
        catch (AuthenticationException e) {
            log.error(String.format(BAD_CREDENTIAL_MESSAGE, username, password), e);
            throw e;
        }
        catch (Exception e) {
            response.setStatus(INTERNAL_SERVER_ERROR.value());
            Map<String, String> error = new HashMap<>();
            error.put("errorMessage", e.getMessage());
            response.setContentType(APPLICATION_JSON_VALUE);
            new ObjectMapper().writeValue(response.getOutputStream(), error);
            throw new InternalServerError(
                String.format(ERROR_ATTEMPT, username, password), e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authentication) {
        Users user = (Users)authentication.getPrincipal();
        String accessToken = JwtUtil
            .createAccessToken(user.getUsername(), request.getRequestURL().toString(),
                user.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList()));
        String refreshToken = JwtUtil.createRefreshToken(user.getUsername());
        response.setHeader(HttpHeaders.AUTHORIZATION, accessToken);
        response.addHeader("access_token", accessToken);
        response.addHeader("refresh_token", refreshToken);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                              AuthenticationException failed) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> error = new HashMap<>();
        error.put("errorMessage", "Bad credentials");
        response.setContentType(APPLICATION_JSON_VALUE);
        mapper.writeValue(response.getOutputStream(), error);
    }
}