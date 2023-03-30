package swag.rest.nis_risk_app.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Model_Mapper {

    @Bean
    public ModelMapper modelMapper() {
        return new org.modelmapper.ModelMapper();
    }

}
