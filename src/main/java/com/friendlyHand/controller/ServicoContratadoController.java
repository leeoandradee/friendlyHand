package com.friendlyHand.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.friendlyHand.model.MensagemRetorno;
import com.friendlyHand.model.ServicoContratado;
import com.friendlyHand.service.ServicoContratadoService;

@RestController
public class ServicoContratadoController {
	
	@Autowired
	ServicoContratadoService service;
	
	@RequestMapping(method=RequestMethod.GET, value="/servicoscontratados")
	public List<ServicoContratado> getAllServicosContratados(){
		return service.getAllServicosContratados();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="servicocontratado/{id}")
	public ServicoContratado getServicoContratado(@PathVariable("id") int id){
		return service.getServicoContratado(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/servicocontratado")
	public ServicoContratado createServicoContratado(@RequestBody ServicoContratado servicoContratado){
		return service.createServicoContratado(servicoContratado);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/servicocontratado")
	public ServicoContratado atualizarServicoContratado(@RequestBody ServicoContratado servicoContratado){
		return service.updateServicoContratado(servicoContratado);	
	}

	@RequestMapping(method=RequestMethod.DELETE, value="servicoContratado/{id}")
	public MensagemRetorno deletecreateServicoContratado(@PathVariable("id") int id){
		return service.deleteServico(id);
	}

}
