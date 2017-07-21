package br.com.api.capsrnrb.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.api.capsrnrb.exceptions.AdminNotFindException;
import br.com.api.capsrnrb.exceptions.OAuthCredencialExeption;
import br.com.api.capsrnrb.exceptions.SessionInvalidateException;

@CrossOrigin
@RestControllerAdvice
public class ExceptionHandlerController {
	
	@ExceptionHandler(SessionInvalidateException.class)
	public @ResponseBody String errorCaptureSessionInvalidate(){
		
		return String.valueOf(401); 
	}

	@ExceptionHandler(AdminNotFindException.class)
	public @ResponseBody String errorAdminNotFind(){
		return String.valueOf(403); 
	}
	
	@ExceptionHandler(OAuthCredencialExeption.class)
	public @ResponseBody String credencialInvalidate(){
		return String.valueOf(404); 
	}
	
	@ExceptionHandler(Exception.class)
	public @ResponseBody String errorCaptureAny(){
		return String.valueOf(404); 
	}
	
	
	
	
}
