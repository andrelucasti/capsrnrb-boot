package br.com.api.capsrnrb.main;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication

public class Application {
	
	@Bean	
	public DataSource dataSource(){
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/capsad");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		
		System.err.println("iniciou jpa");

		return dataSource;
		
	}
	
	
	public static void main(String[] args) {
		
		SpringApplication.run(Application.class, args);
		
	}

}
