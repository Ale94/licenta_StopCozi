package com.stopcozi;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.MultipartAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.MultipartFilter;

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
