package br.com.api.capsrnrb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.capsrnrb.dao.DaoEstado;
import br.com.api.capsrnrb.dao.DaoUsuario;
import br.com.api.capsrnrb.models.Cidade;
import br.com.api.capsrnrb.models.Estado;
import br.com.api.capsrnrb.models.Usuarios;


@RestController
@RequestMapping("/service/user")
public class UserRestController {
	
	
	@Autowired
	private DaoUsuario daoUsuario;
	
	@Autowired
	private DaoEstado daoEstado;
	
	
	@RequestMapping(method = RequestMethod.GET, value="/estados")
	
	public @ResponseBody Iterable<Estado> listarEstados(){
		
		System.err.println("chamou estados");


		return daoEstado.findAll();
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value="/cidades/{idEstado}")
	public List<Cidade> listarCidades(@PathVariable("idEstado") Integer pIdEstado){
		
		//return servico.listarCidades(pIdEstado);
		
		return null;
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	@Cacheable(value="appHome")
	public Iterable<Usuarios> listar(){
		Iterable<Usuarios> lista = daoUsuario.findAll();
		
		System.err.println("chamou user");
		
		return lista;
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public Usuarios usuario(@PathVariable("id") Integer id){
		//Usuarios  usuario = servico.buscarUsuario(id);
		
		return null;
	}
	
	
	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	@CacheEvict(allEntries = true, value ="appHome")
	public @ResponseBody String salvar(@RequestBody Usuarios usuarios, HttpServletRequest request, HttpServletResponse response){
		String status = String.valueOf(response.getStatus());
		
		
		//servico.salvarUsuario(usuarios);
		
		return status;
	}
	
	//FIXME TESTAR
	@RequestMapping(method = RequestMethod.PUT, produces = "application/json", value="/{id}")
	@CacheEvict(allEntries = true, value ="appHome")
	public @ResponseBody String alterar(@PathVariable("id") Long id, @RequestBody Usuarios usuarios, HttpServletRequest request, HttpServletResponse response){
		String status = String.valueOf(response.getStatus());
		
		usuarios.setId(id);
		//servico.alterarUsuario(usuarios);
		
		return status;
	}
	

	//FIXME TESTAR
	@RequestMapping(method = RequestMethod.DELETE, produces = "application/json", value="/{id}")
	@CacheEvict(allEntries = true, value ="appHome")
	public @ResponseBody String remover(@PathVariable("id") Integer id, @RequestBody Usuarios usuarios, HttpServletRequest request, HttpServletResponse response){
		String status = String.valueOf(response.getStatus());
		
		//servico.removerUsuario(id);
		
		return status;
	}

}
