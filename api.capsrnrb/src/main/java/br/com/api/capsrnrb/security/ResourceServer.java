package br.com.api.capsrnrb.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;


@Configuration
@EnableResourceServer
public class ResourceServer  extends ResourceServerConfigurerAdapter{
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenServices(tokenServices());
	}	
	
	@Bean
	public JwtAccessTokenConverter tokenConverter(){
		return new JwtAccessTokenConverter();
	}
	
	@Bean
	public TokenStore tokenStore(){
		return new JwtTokenStore(tokenConverter());
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

}
