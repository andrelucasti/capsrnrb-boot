package br.com.api.capsrnrb.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Token {
	
	@Id
	private String token;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
	
	
	
	

}
