package br.com.nfx;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public LocaleResolver localeResolver() {
		return new FixedLocaleResolver(new Locale("pt", "BR"));
	}
	
//	@Bean
//	public ResourceBundleMessageSource messageSource() {
//		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
//		source.setBasenames("validation/messages"); // name of the resource bundle
//		source.setUseCodeAsDefaultMessage(true);
//		return source;
//	}
}
