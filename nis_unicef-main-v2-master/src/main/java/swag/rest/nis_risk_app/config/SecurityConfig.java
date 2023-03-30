package swag.rest.nis_risk_app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import swag.rest.nis_risk_app.jwt.CustomAuthenticationFilter;
import swag.rest.nis_risk_app.jwt.CustomAuthorizationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private final UserDetailsService userDetailsService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .cors()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .logout().logoutUrl("/logout").deleteCookies("token")
                .and()
                .authorizeRequests().antMatchers(HttpMethod.POST,  "/register").hasRole("ADMIN")
                .and()
                .authorizeRequests().antMatchers(HttpMethod.POST,  "/authenticate").permitAll()
                .and()
                .authorizeRequests().antMatchers(HttpMethod.GET,  "/news", "/news/*").permitAll()
                .and()
                .authorizeRequests().antMatchers(HttpMethod.GET,  "/form/first_phase/download/*").permitAll()
                .and()
                .authorizeRequests().antMatchers(HttpMethod.GET,  "/media/files/**").permitAll()
                .and()
                .authorizeRequests().antMatchers(HttpMethod.GET,  "/form/second_phase/download/*").permitAll()
                .and()
                .authorizeRequests().antMatchers(HttpMethod.GET,  "/media/picture/*").permitAll()
                .and()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .addFilter(new CustomAuthenticationFilter(super.authenticationManagerBean()))
                .addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

    }




    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers( "/swagger-ui/**", "/v3/api-docs/**","/swagger-resources/**","/v2/api-docs/**", "/h2-console/**", "/register");
    }
}
