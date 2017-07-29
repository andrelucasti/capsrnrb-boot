package br.com.api.capsrnrb.service;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.capsrnrb.dao.DaoUser;
import br.com.api.capsrnrb.models.ScreeningDate;
import br.com.api.capsrnrb.models.User;
import br.com.api.capsrnrb.util.LibraryDateHour;

@Service
public class ServiceUser implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private DaoUser daoUser;
	
	
	@Autowired
	private LibraryDateHour libDateHour;
	

	public Iterable<User> findAllUser() {
		
		Iterable<User> users = daoUser.findAll();
		
		return users;
	}

	public User findUser(Long id) {
		return daoUser.findOne(id);
	}

	public void saveUser(User user) throws ParseException {
		
		ScreeningDate screeningDate = user.getScreeningDate().get(0);
		screeningDate.setDate(libDateHour.converteStringInCalendar(screeningDate.getDateText()));
		
		List<ScreeningDate> collectionScreeningDate = new ArrayList<>();
		collectionScreeningDate.add(screeningDate);
		
		user.setScreeningDate(collectionScreeningDate);
		user.setdateOfBirth(libDateHour.converteStringInCalendar(user.getDateOfBirthText()));

		daoUser.save(user);
		
	}

	public void editUser(User user) throws ParseException {
		
		List<ScreeningDate> collectionScDate = new ArrayList<>();
		user.getScreeningDate().forEach(date->{
			if (date.getDateText() != null && !date.getDateText().equals("")) {
				try {
					date.setDate(libDateHour.converteStringInCalendar(date.getDateText()));
					collectionScDate.add(date);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			} else {
				collectionScDate.add(date);
			}
		});
		
		

		
		user.setScreeningDate(collectionScDate);
		
		
		if (user.getDateOfBirthText()!=null) {			
			user.setdateOfBirth( libDateHour.converteStringInCalendar(user.getDateOfBirthText()));
		}
				
		daoUser.save(user);
	}

	public void delete(Long id) {
		daoUser.delete(id);
		
	}


	

}
