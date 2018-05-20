package com.friendlyHand.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.friendlyHand.model.Cliente;
import com.friendlyHand.model.Prestador;
import com.friendlyHand.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	LoginService service;
	
	@RequestMapping(method=RequestMethod.GET, value="/login/prestador")
	public Prestador loginPrestador(@RequestParam("email") String email, @RequestParam("senha") String senha){
		return service.loginPrestador(email, senha);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/login/cliente")
	public Cliente loginCliente(@RequestParam("email") String email, @RequestParam("senha") String senha){
		return service.loginCliente(email, senha);
	}
	
}
