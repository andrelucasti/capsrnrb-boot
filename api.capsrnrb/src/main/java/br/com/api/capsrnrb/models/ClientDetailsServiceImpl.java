/*package br.com.api.capsrnrb.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.api.capsrnrb.models.Root;

public class ClientDetailsServiceImpl implements UserDetails , Serializable{
	
	*//**
	 * 
	 *//*
	private static final long serialVersionUID = 1L;
	private Root root;

	public ClientDetailsServiceImpl(Root root) {
		this.root = root;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.roles();
	}

	@Override
	public String getPassword() {
		return this.root.getPassword();
	}

	@Override
	public String getUsername() {
		return this.root.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	private List<GrantedAuthority> roles(){
		List<GrantedAuthority> roles = new ArrayList<>();
		for (Role role : this.root.getRoles()) {
			roles.add(new SimpleGrantedAuthority(role.getName().name().toUpperCase()));
		}
		
		return roles;
	}

}
*/