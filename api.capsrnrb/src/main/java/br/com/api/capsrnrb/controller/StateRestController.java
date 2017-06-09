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
	
	
	
	@RequestMapping(method = RequestMethod.GET, value="/states")
	public @ResponseBody Iterable<State> listarEstados(){
		
		return serviceOther.findAllState();
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value="/citys/{idState}")
	public @ResponseBody Iterable<City> listarCidades(@PathVariable("idState") Integer pIdState){
			State state = serviceOther.findState(pIdState);
			Iterable<City> citys = serviceOther.findeAllCity(state);
			
		return citys;
	}

}
