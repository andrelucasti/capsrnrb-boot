package br.com.api.capsrnrb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.capsrnrb.models.City;
import br.com.api.capsrnrb.models.State;
import br.com.api.capsrnrb.service.ServiceOther;

@RestController
public class StateRestController {
	
	@Autowired
	private ServiceOther serviceOther;
	
	
	
	@RequestMapping(method = RequestMethod.GET, value="/estados")
	public @ResponseBody Iterable<State> listarEstados(){
		
		return serviceOther.findAllState();
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value="/cidades/{idEstado}")
	public Iterable<City> listarCidades(@PathVariable("idEstado") Integer pIdEstado){
			
			State state = serviceOther.findState(pIdEstado);
			Iterable<City> citys = serviceOther.findeAllCity(state);
			
		return citys;
	}

}
