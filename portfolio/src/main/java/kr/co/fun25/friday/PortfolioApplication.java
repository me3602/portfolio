package kr.co.fun25.friday;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class PortfolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioApplication.class, args);
	}	
	
	/*@Bean
    ServletRegistrationBean h2ServletRegistrationBean(){
    	ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
    	registrationBean.addUrlMappings("/console/*");
    	return registrationBean;
    }*/
}
