package br.com.api.capsrnrb.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.api.capsrnrb.models.User;

public interface DaoUser extends CrudRepository<User, Long> {
	
	
	@Query("SELECT u FROM User u join fetch u.screeningDate join fetch u.address")
	public Iterable<User> findAllUserJoinAdressJoinDate();

}
