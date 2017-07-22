package br.com.api.capsrnrb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import br.com.api.capsrnrb.oauth2.OAuth2Interceptor;

@Configuration
public class ApplicationWebConfig extends WebMvcConfigurerAdapter{
	
	
	@Bean
	public OAuth2Interceptor interceptor(){
		return new OAuth2Interceptor();
	}
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(interceptor()).excludePathPatterns("/doLogin");
	
	}
}
