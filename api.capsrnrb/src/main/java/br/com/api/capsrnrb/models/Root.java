package br.com.api.capsrnrb.models;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;


@Entity
public class Root implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Integer id;
	private String username;
	private String email;
	private String password;
	

	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE, })
	private Token token;
	
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
			name = "ROOTS_ROLES",
			joinColumns={@JoinColumn(name = "ROOT_ID", referencedColumnName = "ID")},
			inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName = "ID")}
			)
	private List<Role> roles = new ArrayList<>();
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	public Token getToken() {
		return token;
	}
	public void setToken(Token token) {
		this.token = token;
	}
	
}
