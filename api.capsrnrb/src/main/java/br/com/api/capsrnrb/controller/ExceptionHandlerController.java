package br.com.api.capsrnrb.controller;

import javax.servlet.http.HttpServletResponse;

import org.apache.oltu.oauth2.as.response.OAuthASResponse;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.api.capsrnrb.exceptions.AdminNotFindException;
import br.com.api.capsrnrb.exceptions.OAuthCredencialExeption;
import br.com.api.capsrnrb.exceptions.TokenInvalidException;

@CrossOrigin
@RestControllerAdvice
public class ExceptionHandlerController {
	

	@ExceptionHandler(AdminNotFindException.class)
	public @ResponseBody OAuthResponse errorAdminNotFind() throws OAuthSystemException{
		return OAuthASResponse.errorResponse(HttpServletResponse.SC_UNAUTHORIZED).buildJSONMessage();
	}
	
	@ExceptionHandler(OAuthCredencialExeption.class)
	public @ResponseBody OAuthResponse credencialInvalidate() throws OAuthSystemException{
		return OAuthASResponse.errorResponse(HttpServletResponse.SC_UNAUTHORIZED).buildJSONMessage();
	}
	
	@ExceptionHandler(TokenInvalidException.class)
	public @ResponseBody OAuthResponse errorTokenInvalid()throws OAuthSystemException{
		return OAuthASResponse.errorResponse(HttpServletResponse.SC_UNAUTHORIZED).buildJSONMessage();
	
	}
	
	@ExceptionHandler(Exception.class)
	public @ResponseBody OAuthResponse errorCaptureAny()throws OAuthSystemException{
		return OAuthASResponse.errorResponse(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).buildJSONMessage();
	
	}
	
	
}
