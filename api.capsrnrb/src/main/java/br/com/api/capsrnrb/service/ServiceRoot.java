package br.com.api.capsrnrb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.capsrnrb.dao.DaoRoot;
import br.com.api.capsrnrb.exceptions.AdminNotFindException;
import br.com.api.capsrnrb.models.Root;

@Service
public class ServiceRoot {
	
	@Autowired
	private DaoRoot daoRoot;
	
	public Root doLogin (Root root) throws AdminNotFindException{
		Root rootDoLogin = this.rootValidate(root);
		if(rootDoLogin==null){
			throw new AdminNotFindException();
		}
		
		return rootDoLogin;
	}
	
	
	public Root rootValidate(Root root){
		Root rootLogin = this.daoRoot.findByRootLogin(root.getUsername(), root.getPassword());
		if (rootLogin != null) {
			return rootLogin;
		}
		
		return null;
	}
	
	
	public void update(Root root){
		daoRoot.save(root);
	}
}
