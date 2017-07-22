package br.com.api.capsrnrb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.capsrnrb.dao.DaoToken;
import br.com.api.capsrnrb.models.Token;

@Service
public class ServiceToken {
	
	@Autowired
	private DaoToken daoToken;
	
	
	public Token findOne(String pId){
		return daoToken.findOne(pId);
	}


	public void update(Token token) {
		daoToken.save(token);		
	}
	
	

}
