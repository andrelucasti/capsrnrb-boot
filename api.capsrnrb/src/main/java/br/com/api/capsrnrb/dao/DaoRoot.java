package br.com.api.capsrnrb.dao;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.api.capsrnrb.models.Root;

public interface DaoRoot extends CrudRepository<Root, Integer>{
	
	@Query("select r from Root r where r.username=:pName")
	public Root findByRootName(@Param("pName") String pName);
	
	@Query("select r from Root r where r.username=:pName and r.password=:pPassword")
	public Root findByRootLogin(@Param("pName") String pName, @Param("pPassword")  String pPassword );
}
