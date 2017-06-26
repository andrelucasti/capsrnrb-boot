package br.com.api.capsrnrb.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

public class ClienteDetailsImpl implements ClientDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Root root;
	
	public ClienteDetailsImpl(Root pRoot) {
		this.root = pRoot;
	}

	@Override
	public String getClientId() {
		return this.root.getEmail();
	}

	@Override
	public Set<String> getResourceIds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isSecretRequired() {
		return true;
	}

	@Override
	public String getClientSecret() {
		return this.root.getPassword();
	}

	@Override
	public boolean isScoped() {
		return true;
	}

	@Override
	public Set<String> getScope() {
		//"read", "write", "trust"
		Set<String> scopes = new TreeSet<>();
		scopes.add("read");
		scopes.add("write");
		scopes.add("trust");
		
		return scopes;
	}

	@Override
	public Set<String> getAuthorizedGrantTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> getRegisteredRedirectUri() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return this.authorities();
	}

	@Override
	public Integer getAccessTokenValiditySeconds() {
		return 5000;
	}

	@Override
	public Integer getRefreshTokenValiditySeconds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAutoApprove(String scope) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<String, Object> getAdditionalInformation() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	private List<GrantedAuthority> authorities(){
		
		List<GrantedAuthority> auths = new ArrayList<>();
		
		this.root.getRoles().forEach(role -> auths.add(new SimpleGrantedAuthority(role.getName().name())));
		
		return auths;
		
	}

}
