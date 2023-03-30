package swag.rest.nis_risk_app.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import swag.rest.nis_risk_app.dto.UserAuthDto;
import swag.rest.nis_risk_app.dto.UserFullDto;
import swag.rest.nis_risk_app.entity.Users;
import swag.rest.nis_risk_app.jwt.JwtUtil;
import swag.rest.nis_risk_app.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    private final AuthenticationManager authenticationManager;

    private final ModelMapper modelMapper;


    @PostMapping("/register")
    @CrossOrigin(origins = "http://localhost:3000")
    public Map<String, String> save(@RequestBody UserAuthDto user) {
        userService.save(user);
        Map<String, String> response = new HashMap<>();
        response.put("result","Account " + user.getUsername() + " created");
        return response;
    }



    //return login
    @PostMapping("/authenticate")
    @CrossOrigin(origins = "http://localhost:3000")
    public Map<String, String> authenticateUser(@Valid @RequestBody UserAuthDto userAuthDto, HttpServletRequest request, HttpServletResponse response) {
        Users user = new Users();
        user.setUsername(userAuthDto.getUsername());
        user.setPassword(userAuthDto.getPassword());
        Users userFromDb = userService.findByUsername(userAuthDto.getUsername()).orElseThrow(() -> new UsernameNotFoundException("Wrong username"));
        user.setRole(userFromDb.getRole());
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(),user.getAuthorities()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = JwtUtil.createAccessToken(user.getUsername(), request.getRequestURL().toString(), user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()));
        ResponseCookie cookie = ResponseCookie.from("token", jwt) // key & value
                .httpOnly(true)
                .secure(true)
                .maxAge(Duration.ofHours(100))
                .sameSite("None")  // sameSite
                .build();
        response.setHeader(HttpHeaders.AUTHORIZATION, cookie.toString());
        Map<String, String> responseJson = new HashMap<>();
        responseJson.put("token", jwt);
        responseJson.put("role", userFromDb.getRole().toString());
        responseJson.put("username", userFromDb.getUsername());
        return responseJson;
    }



    @Operation(description = "Logout")
    @CrossOrigin("http://localhost:3000")
    @PostMapping("/logout")
    public void fakeLogout() {
        throw new IllegalStateException("This method shouldn't be called. It's implemented by Spring Security filters.");
    }


    @Operation(description = "Rated student list")
    @GetMapping("/currentUser")
    @CrossOrigin(origins = "http://localhost:3000")
    public UserFullDto aboutUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Users user = userService.findByUsername(auth.getName()).orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return convertToDto(user);
    }

    private UserFullDto convertToDto(Users user) {
        return modelMapper.map(user, UserFullDto.class);
    }


}
