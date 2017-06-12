package br.com.api.capsrnrb.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter{
	
	private final String LOGIN_URL = "http://localhost:4200/login";
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().
			
			antMatchers("/states/**").permitAll().
			antMatchers("/citys/*").permitAll().
			antMatchers("/user").authenticated().and().
			
			formLogin().loginProcessingUrl(LOGIN_URL).defaultSuccessUrl("http://localhost:4200/").
			failureUrl(LOGIN_URL).permitAll();
			
			
	}

}
