package com.stopcozi;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.MultipartAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {MultipartAutoConfiguration.class})	
public class StopCoziApplication {

	public static void main(String[] args) {
		SpringApplication.run(StopCoziApplication.class, args);
	}
	
	@Bean
    public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf) {
		return hemf.getSessionFactory();
		}
	
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver getCommonsMultipartResolver() {
	    CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
	    multipartResolver.setMaxUploadSize(20971520);   // 20MB
	    multipartResolver.setMaxInMemorySize(1048576);  // 1MB
	    return multipartResolver;
	}
	
//	@Bean
//	 public JavaMailSender javaMailService() {
//	        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
//
//	        javaMailSender.setHost("smtp.gmail.com");
//	        javaMailSender.setPort(465);
//
//	        javaMailSender.setJavaMailProperties(getMailProperties());
//	        javaMailSender.setUsername("petcov.alexandra@gmail.com");
//	        javaMailSender.setPassword("Sprite06");
//
//	        return javaMailSender;
//	    }
//
//	    private Properties getMailProperties() {
//	        Properties properties = new Properties();
//	        properties.setProperty("mail.transport.protocol", "smtp");
//	        properties.setProperty("mail.smtp.auth", "true");
//	        properties.setProperty("mail.smtp.starttls.enable", "true");
//	        properties.setProperty("mail.debug", "true");
//	        properties.setProperty("mail.smtp.ssl.enable","true");
//	        properties.setProperty("mail.test-connection","true");
//	        return properties;
//	    }
	
//	
//	@Bean
//	public MultipartResolver multipartResolver() {
//	    return new CommonsMultipartResolver();
//	}
	
//	@Bean
//	public CommonsMultipartResolver multipartResolver() {
//	    CommonsMultipartResolver multipart = new CommonsMultipartResolver();
//	    multipart.setMaxUploadSize(3 * 1024 * 1024);
//	    return multipart;
//	}

//	@Bean
//	@Order(0)
//	public MultipartFilter multipartFilter() {
//	    MultipartFilter multipartFilter = new MultipartFilter();
//	    multipartFilter.setMultipartResolverBeanName("multipartResolver");
//	    return multipartFilter;
//	}
//	
}
