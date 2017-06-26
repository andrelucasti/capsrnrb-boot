package br.com.api.capsrnrb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.capsrnrb.models.User;

@RestController(value="/doLogin")
public class LoginController {
	
	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody String doLogin(@RequestBody User user, HttpServletRequest request, HttpServletResponse response){
		
		String status = String.valueOf(response.getStatus());
		
		return status;
		
	}

}
