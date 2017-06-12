package br.com.api.capsrnrb.models;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class Root {

	@Id
	private Integer id;
	private String username;
	private String email;
	private String password;
	private Boolean enabled;
	private Date lastPasswordResetDate;
	
	
	
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

	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public Date getLastPasswordResetDate() {
		return lastPasswordResetDate;
	}
	public void setLastPasswordResetDate(Date lastPasswordResetDate) {
		this.lastPasswordResetDate = lastPasswordResetDate;
	}


	
	
}
