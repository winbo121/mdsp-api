package egovframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
//@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class EgovBootApplication extends SpringBootServletInitializer{

	protected SpringApplicationBuilder config(SpringApplicationBuilder builder) {
		return builder.sources(EgovBootApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(EgovBootApplication.class, args);
	}

}