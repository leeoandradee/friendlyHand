package com.friendlyHand.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.friendlyHand.model.MensagemRetorno;
import com.friendlyHand.model.Servicocontratado;
import com.friendlyHand.service.ServicoContratadoService;

@RestController
public class ServicoContratadoController {
	
	@Autowired
	ServicoContratadoService service;
	
	@RequestMapping(method=RequestMethod.GET, value="/servicoscontratados/{usuario}/{id_usuario}")
	public List<Servicocontratado> getAllServicosContratadosUsuario(@PathVariable("usuario") String usuario, @PathVariable("id_usuario") int id_usuario,
			@RequestParam("referencia")String referencia) throws ClassNotFoundException{
		return service.getAllServicosContratadosUsuario(usuario,id_usuario, referencia);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="servicocontratado/{id}")
	public Servicocontratado getServicoContratado(@PathVariable("id") int id){
		return service.getServicoContratado(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/servicocontratado")
	public Servicocontratado createServicoContratado(@RequestBody Servicocontratado servicoContratado){
		return service.createServicoContratado(servicoContratado);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/servicocontratado")
	public Servicocontratado atualizarServicoContratado(@RequestBody Servicocontratado servicoContratado){
		return service.updateServicoContratado(servicoContratado);	
	}

	@RequestMapping(method=RequestMethod.DELETE, value="servicoContratado/{id}")
	public MensagemRetorno deletecreateServicoContratado(@PathVariable("id") int id){
		return service.deleteServico(id);
	}

}
