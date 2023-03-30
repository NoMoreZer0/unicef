package swag.rest.nis_risk_app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("swag.rest.nis_risk_app")
public class NisApplication  {

    public static void main(String[] args) {
       SpringApplication.run(NisApplication.class);
    }


}

