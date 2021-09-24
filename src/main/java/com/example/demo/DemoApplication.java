package com.example.demo;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 * The Class DemoApplication.
 */
@SpringBootApplication
public class DemoApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	
	@Bean
	public LocaleResolver localResolver() {
		
		//SessionLocaleResolver localeResolver= new SessionLocaleResolver();
		AcceptHeaderLocaleResolver localeResolver= new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		
		return localeResolver;
	}
	
	/*//once you define spring.messages.basename=messages in application.properties file we can delete the below method
	 * @Bean public ResourceBundleMessageSource bundleMessageSource() {
	 * 
	 * ResourceBundleMessageSource messageSource= new ResourceBundleMessageSource();
	 * messageSource.setBasename("messages");
	 * 
	 * return messageSource;
	 * 
	 * 
	 * 
	 * }
	 */
}
