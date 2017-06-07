package br.com.api.capsrnrb.main;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
public class Application {
	
		
	public DataSource dataSource(){
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/capsad");
		dataSource.setUsername("root");
		dataSource.setPassword("");

		return dataSource;
		
	}
	
	
	public static void main(String[] args) {
		
		SpringApplication.run(Application.class, args);
		
	}

}
