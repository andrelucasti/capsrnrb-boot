package br.com.api.capsrnrb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.api.capsrnrb.dao.DaoRoot;
import br.com.api.capsrnrb.models.CustomUserDetailsService;

@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
	}
	
	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, DaoRoot rep) throws Exception{
		builder.userDetailsService(name -> new CustomUserDetailsService(rep.findByRootName(name))).passwordEncoder(new BCryptPasswordEncoder());
		
	}

}
