package swag.rest.nis_risk_app.jwt;

import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomAuthorizationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain)
        throws ServletException, IOException {

        String token = null;
        if(request.getServletPath().equals("/login") || request.getServletPath().equals("/refreshToken") || request.getServletPath().equals("/authenticate")) {
            filterChain.doFilter(request, response);
        } else {
                try {
                    if (request.getHeader(HttpHeaders.AUTHORIZATION) != null) {
                                token = request.getHeader(HttpHeaders.AUTHORIZATION);
                                UsernamePasswordAuthenticationToken authenticationToken = JwtUtil.parseToken(token);
                                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                                log.info(String.valueOf(
                                    SecurityContextHolder.getContext().getAuthentication()));
                                filterChain.doFilter(request, response);
                        }
                       else  {
                        filterChain.doFilter(request, response);
                    }

                }
                catch (Exception e) {
                    log.error(String.format("Error auth token: %s", token), e);
                    response.setStatus(FORBIDDEN.value());
                    Map<String, String> error = new HashMap<>();
                    error.put("errorMessage", e.getMessage());
                    response.setContentType(APPLICATION_JSON_VALUE);
                    new ObjectMapper().writeValue(response.getOutputStream(), error);
                }
            }
        }
    }

