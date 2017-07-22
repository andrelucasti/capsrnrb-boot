package br.com.api.capsrnrb.controller;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.oltu.oauth2.as.response.OAuthASResponse;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.apache.oltu.oauth2.common.message.types.ParameterStyle;
import org.apache.oltu.oauth2.rs.request.OAuthAccessResourceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;

import br.com.api.capsrnrb.exceptions.AdminNotFindException;
import br.com.api.capsrnrb.exceptions.SessionInvalidateException;
import br.com.api.capsrnrb.models.User;
import br.com.api.capsrnrb.service.ServiceOAuth2;
import br.com.api.capsrnrb.service.ServiceUser;

@CrossOrigin
@RestController
@RequestMapping("/user")
@SessionScope
public class UserRestController implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private ServiceUser serviceUser;

	@Autowired
	private ServiceOAuth2 serviceOAuth2;



	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = {MediaType.APPLICATION_JSON_VALUE})
	//@Cacheable(value="appHome")
	public @ResponseBody Iterable<User>listar(HttpServletRequest request, HttpServletResponse response) throws OAuthSystemException, OAuthProblemException, AdminNotFindException{
		OAuthAccessResourceRequest oauthRequest = new OAuthAccessResourceRequest(request, ParameterStyle.HEADER);

		String tokenRequest = oauthRequest.getAccessToken();
		serviceOAuth2.updateToken(tokenRequest);

		Iterable<User> lista = serviceUser.findAllUser();


		/*
		return OAuthASResponse.tokenResponse(HttpServletResponse.SC_OK).setAccessToken(updateToken)
				.setParam("data", lbApi.convertCollectionInJson(lista))
				.buildJSONMessage();*/


		
		return lista;
	}

	@RequestMapping(method = RequestMethod.GET, value="/{id}", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = {MediaType.APPLICATION_JSON_VALUE})
	public User usuario(@PathVariable("id") Long id) throws SessionInvalidateException{
		User user = serviceUser.findUser(id);

		return user;
	}


	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = {MediaType.APPLICATION_JSON_VALUE})
	//@CacheEvict(allEntries = true, value ="appHome")
	public @ResponseBody OAuthResponse salvar(@RequestBody User usuarios, HttpServletRequest request, HttpServletResponse response) throws OAuthSystemException, OAuthProblemException, AdminNotFindException{

		OAuthAccessResourceRequest oauthRequest = new OAuthAccessResourceRequest(request, ParameterStyle.HEADER);

		String tokenRequest = oauthRequest.getAccessToken();
		String updateToken = serviceOAuth2.updateToken(tokenRequest);

		serviceUser.saveUser(usuarios);


		return OAuthASResponse.tokenResponse(HttpServletResponse.SC_OK).setRefreshToken(updateToken).setParam("", "").buildJSONMessage();

	}


	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = {MediaType.APPLICATION_JSON_VALUE})
	//@CacheEvict(allEntries = true, value ="appHome")
	public @ResponseBody OAuthResponse alterar(@RequestBody User usuarios, HttpServletRequest request, HttpServletResponse response) throws SessionInvalidateException, OAuthSystemException, OAuthProblemException, AdminNotFindException{
		OAuthAccessResourceRequest oauthRequest = new OAuthAccessResourceRequest(request, ParameterStyle.HEADER);

		String tokenRequest = oauthRequest.getAccessToken();
		String updateToken = serviceOAuth2.updateToken(tokenRequest);

		serviceUser.editUser(usuarios); 

		return OAuthASResponse.tokenResponse(HttpServletResponse.SC_OK).setRefreshToken(updateToken).setParam("", "").buildJSONMessage();
	}


	@RequestMapping(method = RequestMethod.DELETE, value="/{id}", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = {MediaType.APPLICATION_JSON_VALUE})
	//@CacheEvict(allEntries = true, value ="appHome")
	public @ResponseBody OAuthResponse remover(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) throws SessionInvalidateException, OAuthSystemException, OAuthProblemException, AdminNotFindException{
		OAuthAccessResourceRequest oauthRequest = new OAuthAccessResourceRequest(request, ParameterStyle.HEADER);
		String tokenRequest = oauthRequest.getAccessToken();
		String updateToken = serviceOAuth2.updateToken(tokenRequest);

		serviceUser.delete(id);

		return OAuthASResponse.tokenResponse(HttpServletResponse.SC_OK).setRefreshToken(updateToken).setParam("", "").buildJSONMessage();
	}

}
