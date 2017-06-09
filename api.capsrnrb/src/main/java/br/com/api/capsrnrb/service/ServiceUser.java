package br.com.api.capsrnrb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.capsrnrb.dao.DaoUser;
import br.com.api.capsrnrb.models.User;

@Service
public class ServiceUser {
	
	
	@Autowired
	private DaoUser daoUser;
	

	//TODO test the findAllUserJoinAdressJoinDate
	public Iterable<User> findAllUser() {
		
		Iterable<User> users = daoUser.findAll();
		
		return users;
	}

	public User findUser(Long id) {
		return daoUser.findOne(id);
	}

	public void saveUser(User user) {
		daoUser.save(user);
		
	}

	public void editUser(User user) {
		this.saveUser(user);
	}

	public void delete(Long id) {
		daoUser.delete(id);
		
	}
	
	

	
	

}
