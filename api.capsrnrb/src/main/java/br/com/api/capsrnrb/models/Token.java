package br.com.api.capsrnrb.models;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Token {
	
	@Id
	private String token;
	@DateTimeFormat
	private Calendar dateToExpire;
	@DateTimeFormat
	private Calendar dateCreated;
	
	@Column(nullable = false)
	private Boolean enable;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Calendar getDateToExpire() {
		return dateToExpire;
	}
	public void setDateToExpire(Calendar dateToExpire) {
		this.dateToExpire = dateToExpire;
	}
	public Calendar getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Calendar dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Boolean getEnable() {
		return enable;
	}
	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
	
	
	
	
	
	

}
