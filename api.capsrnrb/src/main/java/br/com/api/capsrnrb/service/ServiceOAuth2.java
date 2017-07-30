package br.com.api.capsrnrb.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.oltu.oauth2.as.issuer.MD5Generator;
import org.apache.oltu.oauth2.as.issuer.OAuthIssuerImpl;
import org.apache.oltu.oauth2.as.request.OAuthTokenRequest;
import org.apache.oltu.oauth2.as.response.OAuthASResponse;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.api.capsrnrb.exceptions.AdminNotFindException;
import br.com.api.capsrnrb.exceptions.OAuthCredencialExeption;
import br.com.api.capsrnrb.models.Root;
import br.com.api.capsrnrb.models.Token;
import br.com.api.capsrnrb.util.LibraryDateHour;
import br.com.api.capsrnrb.util.LibraryFunctions;


@Service
public class ServiceOAuth2 {
	private String clientId = "capsrnrbid";
	private String clientSecret = "s3cr3t_rnrb";
	
	
	@Autowired
	private ServiceRoot serviceRoot;
	@Autowired
	private ServiceToken serviceToken;
	@Autowired
	private LibraryDateHour libDateHour;
	@Autowired
	private LibraryFunctions lbFunctions;
	
	@Transactional
	public OAuthResponse doLogin(HttpServletRequest request) throws OAuthSystemException, OAuthProblemException, OAuthCredencialExeption, AdminNotFindException, NoSuchAlgorithmException, UnsupportedEncodingException {
		
		if (isValidAccess(request)) {
			
			Root root = this.getValidateRoot(request);
			
			String tokenOAuth2 = this.getToken();
			
			Token token = new Token();
			token.setToken(tokenOAuth2);
			token.setDateCreated(libDateHour.getCurrentDate());
			token.setDateToExpire(libDateHour.nextTimeInMinutes(10));
			token.setEnable(true);
			root.setToken(token);
			
			serviceRoot.update(root);
			
			return OAuthASResponse.tokenResponse(HttpServletResponse.SC_OK).setAccessToken(tokenOAuth2)
					.setParam("login", root.getUsername())
					.setParam("email", root.getEmail()).buildJSONMessage();
		}
		
		
		return null;
		
	}
	
	
	public boolean isValidAccess(HttpServletRequest request) throws OAuthSystemException, OAuthProblemException, OAuthCredencialExeption{
		OAuthTokenRequest oauthRequest = new OAuthTokenRequest(request);	
		String clientId = oauthRequest.getClientId();
		String clientSecret = oauthRequest.getClientSecret();
		
		
		if (!clientId.equals(this.clientId)) {
			throw new OAuthCredencialExeption();
		}
		
		if (!clientSecret.equals(this.clientSecret)) {
			throw new OAuthCredencialExeption();
		}

		
		return true;
		
	}
	
	
	public String getToken() throws OAuthSystemException, OAuthProblemException, AdminNotFindException{
	
		return new OAuthIssuerImpl(new MD5Generator()).accessToken();
		
	}
	
	
	public Root getValidateRoot(HttpServletRequest request) throws AdminNotFindException, OAuthSystemException, OAuthProblemException, NoSuchAlgorithmException, UnsupportedEncodingException{
		
		OAuthTokenRequest oauthRequest = new OAuthTokenRequest(request);
		String username = oauthRequest.getUsername();
		String password = oauthRequest.getPassword();
		
		Root root = new Root();
		root.setUsername(username);
		root.setPassword(lbFunctions.convertStringToSHA256(password));
		
		return serviceRoot.doLogin(root);
		
	}
	
	

	public boolean tokenIsValid(String pToken, Token pTokenRoot){
		if(pTokenRoot != null && !pToken.equals(pTokenRoot.getToken())){
			return false;
		} else {
			Token token = new Token();
			token.setToken(pToken);
			Root root = serviceRoot.findRootByToken(token);
			
			if (root == null) {
				return false;
			}
			
			
			return true;
		}
	}
	
	
	public String updateToken(String pToken) throws OAuthSystemException, OAuthProblemException, AdminNotFindException{
		
		Token token = this.serviceToken.findOne(pToken);
		
		if (token.getDateToExpire().before(new Date())) {
			token.setEnable(false);
			this.serviceToken.update(token);
			
			return getTokenUpdated(token);
			
		} else {
			return pToken;
		}
		
		
	}
	
	public Token getTokenRootAccess(HttpServletRequest request) throws AdminNotFindException, OAuthSystemException, OAuthProblemException, NoSuchAlgorithmException, UnsupportedEncodingException{
		Root root = this.getValidateRoot(request);
		
		
		return root.getToken();
		
	}
	
	public String getTokenUpdated(Token pToken) throws OAuthSystemException, OAuthProblemException, AdminNotFindException{
		String tokenOAuth2 = this.getToken();
		
		Token token = new Token();
		token.setToken(tokenOAuth2);
		token.setDateCreated(libDateHour.getCurrentDate());
		token.setDateToExpire(libDateHour.nextTimeInMinutes(10));
		
		Root root = serviceRoot.findRootByToken(pToken);
		root.setToken(token);
		
		serviceRoot.update(root);
		
		return tokenOAuth2;
		
	
	}

}
