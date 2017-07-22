package br.com.api.capsrnrb.oauth2;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.oltu.oauth2.common.message.types.ParameterStyle;
import org.apache.oltu.oauth2.rs.request.OAuthAccessResourceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.com.api.capsrnrb.exceptions.AdminNotFindException;
import br.com.api.capsrnrb.exceptions.TokenInvalidException;
import br.com.api.capsrnrb.models.Token;
import br.com.api.capsrnrb.service.ServiceOAuth2;
import br.com.api.capsrnrb.service.ServiceToken;


public class OAuth2Interceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	private ServiceOAuth2 serviceOAuth2;
	@Autowired
	private ServiceToken serviceToken;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	
		System.out.println(request.getHeader("Content-Type"));
		System.out.println(request.getHeader("Authorization"));
		
		
		if (request.getHeader("Authorization") != null) {
			OAuthAccessResourceRequest oauthRequest = new OAuthAccessResourceRequest(request, ParameterStyle.HEADER);
			String tokenRequest = oauthRequest.getAccessToken();
			Token tokenRoot= this.serviceToken.findOne(tokenRequest);
			
			if(this.serviceOAuth2.tokenIsValid(tokenRequest, tokenRoot)){
				return super.preHandle(request, response, handler);
			} else {
				
				return this.notAuthorized(response);
			}
			
		} else {
			return super.preHandle(request, response, handler);
		}
		
		
		
		
	}
	
	
	private boolean notAuthorized(HttpServletResponse response) throws IOException, TokenInvalidException{
		throw new TokenInvalidException("Token invalidated");
		
	}

	
	
	

}
