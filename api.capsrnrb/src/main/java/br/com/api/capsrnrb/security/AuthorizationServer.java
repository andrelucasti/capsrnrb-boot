package br.com.api.capsrnrb.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import br.com.api.capsrnrb.dao.DaoRoot;
import br.com.api.capsrnrb.models.ClienteDetailsImpl;


@Configuration
@EnableAuthorizationServer
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter{
	
	@Autowired
	private DaoRoot daoRoot;
	
	@Autowired
	private AuthenticationManager manager;

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.passwordEncoder(new BCryptPasswordEncoder());
		
		security
		.tokenKeyAccess("permitAll()")
		.checkTokenAccess("isAuthenticated()");
		
		
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.withClientDetails(pClienteId -> new ClienteDetailsImpl(this.daoRoot.findByRootName(pClienteId)));
		
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(tokenStore()).accessTokenConverter(tokenConverter()).setClientDetailsService(pClienteId -> new ClienteDetailsImpl(this.daoRoot.findByRootName(pClienteId)));
		
	}
	
	
	@Bean
	public TokenStore tokenStore(){
		return new JwtTokenStore(tokenConverter());
	}
	
	
	@Bean
	public JwtAccessTokenConverter tokenConverter(){
		return new JwtAccessTokenConverter();
	}
	
	
	@Bean
	@Primary
	public DefaultTokenServices tokenServices(){
		
		DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
		
		
		defaultTokenServices.setAccessTokenValiditySeconds(60); // in seconds
		defaultTokenServices.setTokenStore(tokenStore());
		defaultTokenServices.setReuseRefreshToken(false);
		
		return defaultTokenServices;
	}
	
	
	//http://www.baeldung.com/spring-security-oauth-jwt
	//http://www.baeldung.com/rest-api-spring-oauth2-angularjs
	

}
