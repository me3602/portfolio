package kr.co.fun25.friday;

import java.util.Properties;

import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;


@SpringBootApplication
@Configuration
public class PortfolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioApplication.class, args);
	}	
	
	@Value("${tomcat.ajp.port}")
	int ajpPort;

	@Value("${tomcat.ajp.remoteauthentication}")
	String remoteAuthentication;

	@Value("${tomcat.ajp.enabled}")
	boolean tomcatAjpEnabled;
	
	@Bean
	public EmbeddedServletContainerFactory servletContainer() {

	    TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
	    if (tomcatAjpEnabled)
	    {
	        Connector ajpConnector = new Connector("AJP/1.3");
	        ajpConnector.setProtocol("AJP/1.3");
	        ajpConnector.setPort(ajpPort);
	        ajpConnector.setSecure(false);
	        ajpConnector.setAllowTrace(false);
	        ajpConnector.setScheme("http");
	        tomcat.addAdditionalTomcatConnectors(ajpConnector);
	    }

	    return tomcat;
	}
	
	/*@Bean
    ServletRegistrationBean h2ServletRegistrationBean(){
    	ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
    	registrationBean.addUrlMappings("/console/*");
    	return registrationBean;
    }*/
	
	
	@Bean
	public JavaMailSender getMailSender(){
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
		javaMailSender.setHost("smtp.gmail.com");
		javaMailSender.setPort(587);
		javaMailSender.setDefaultEncoding("utf-8");
		javaMailSender.setUsername("stark9838@gmail.com");
		javaMailSender.setPassword("googledudwls33!");
		
		Properties p = new Properties();
		p.put("mail.smtp.starttls.enable", true);
		p.put("mail.smtp.auth", true);
		
		javaMailSender.setJavaMailProperties(p);
		
		return javaMailSender;		
	}
}
