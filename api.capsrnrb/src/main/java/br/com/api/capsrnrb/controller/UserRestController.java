package br.com.api.capsrnrb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.capsrnrb.models.User;
import br.com.api.capsrnrb.service.ServiceUser;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserRestController {
	
	
	@Autowired
	private ServiceUser serviceUser;
	
	
	@RequestMapping(method = RequestMethod.GET)
	//@Cacheable(value="appHome")
	public Iterable<User> listar(){
		Iterable<User> lista = serviceUser.findAllUser();
		
		return lista;
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public User usuario(@PathVariable("id") Long id){
		User user = serviceUser.findUser(id);
		
		return user;
	}
	
	
	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	//@CacheEvict(allEntries = true, value ="appHome")
	public @ResponseBody String salvar(@RequestBody User usuarios, HttpServletRequest request, HttpServletResponse response){
		
		String status = String.valueOf(response.getStatus());
				
		serviceUser.saveUser(usuarios);
		
		return status;
	}

	
	@RequestMapping(method = RequestMethod.PUT, produces = "application/json")
	//@CacheEvict(allEntries = true, value ="appHome")
	public @ResponseBody String alterar(@RequestBody User usuarios, HttpServletRequest request, HttpServletResponse response){
		String status = String.valueOf(response.getStatus());

		serviceUser.editUser(usuarios);
		
		return status;
	}
	
	
	@RequestMapping(method = RequestMethod.DELETE, produces = "application/json", value="/{id}")
	//@CacheEvict(allEntries = true, value ="appHome")
	public @ResponseBody String remover(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response){
		String status = String.valueOf(response.getStatus());
		
		serviceUser.delete(id);
		
		return status;
	}

}
