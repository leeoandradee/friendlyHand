package com.friendlyHand.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.friendlyHand.model.Cliente;
import com.friendlyHand.model.MensagemRetorno;
import com.friendlyHand.service.ClienteService;

@RestController
public class ClienteController {
	
	@Autowired
	private ClienteService clientService;
	
	@RequestMapping(method=RequestMethod.GET, value="/clientes")
	public List<Cliente> getAllClientes() {
		return clientService.getAllClientes();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="cliente/{id}")
	public Cliente getCliente(@PathVariable("id") int id) {
		return clientService.getCliente(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/cliente")
	public Cliente createCliente(@RequestBody Cliente cliente) {
		return clientService.createCliente(cliente);	
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/cliente/{id}")
	public Cliente atualizarCliente(@RequestBody Cliente cliente, @PathVariable("id") int id) {
		return clientService.updateCliente(cliente, id);	
	}

	@RequestMapping(method=RequestMethod.DELETE, value="cliente/{id}")
	public MensagemRetorno deleteCliente(@PathVariable("id") int id) {
		return clientService.deleteCliente(id);
	}
	
	
	
	

}
