package br.com.api.capsrnrb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.capsrnrb.exceptions.AdminNotFindException;
import br.com.api.capsrnrb.exceptions.OAuthCredencialExeption;
import br.com.api.capsrnrb.service.ServiceOAuth2;

@CrossOrigin
@RestController(value="/doLogin")
public class LoginController {
	
	@Autowired
	private ServiceOAuth2 service;
	
	
	@RequestMapping(method = RequestMethod.POST,  produces = "application/json")
	public @ResponseBody OAuthResponse doLogin (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, AdminNotFindException, OAuthSystemException, OAuthProblemException, OAuthCredencialExeption{
		
		OAuthResponse responseOauth = service.doLogin(request);
		
		
		return responseOauth;
		
	}

}
