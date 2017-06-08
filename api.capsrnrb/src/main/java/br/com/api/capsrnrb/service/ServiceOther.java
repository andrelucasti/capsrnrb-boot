package br.com.api.capsrnrb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.capsrnrb.dao.DaoCity;
import br.com.api.capsrnrb.dao.DaoState;
import br.com.api.capsrnrb.models.City;
import br.com.api.capsrnrb.models.State;

@Service
public class ServiceOther {

	@Autowired
	private DaoState daoState;

	@Autowired
	private DaoCity daoCity;



	public Iterable<State> findAllState() {

		Iterable<State> states = daoState.findAll();

		return states;
	}
	
	//TODO execute test
	public Iterable<City> findeAllCity(State pEstado) {
		
		Iterable<City> citys = daoCity.findAllCity(pEstado);
		
		return citys;
		
	}

	public State findState(Integer pIdEstado) {
		
		return daoState.findOne(pIdEstado);
	}

}
