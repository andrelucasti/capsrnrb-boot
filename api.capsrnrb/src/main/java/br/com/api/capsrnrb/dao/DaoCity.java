package br.com.api.capsrnrb.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.api.capsrnrb.models.City;
import br.com.api.capsrnrb.models.State;

public interface DaoCity extends CrudRepository<City, Integer> {
	
	
	@Query("select c from City c where c.state=:pState ")
	public Iterable<City> findAllCity(@Param("pState") State pState);
		

}
