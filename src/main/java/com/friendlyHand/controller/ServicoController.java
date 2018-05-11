package com.friendlyHand.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.friendlyHand.model.MensagemRetorno;
import com.friendlyHand.model.Servico;
import com.friendlyHand.service.ServicoService;

@RestController
public class ServicoController {
	
	@Autowired
	ServicoService servicoService;
	
	@RequestMapping(method=RequestMethod.GET, value="/servicos")
	public List<Servico> getAllServicos() throws FileNotFoundException, ClassNotFoundException, IOException{
		return servicoService.getAllServicos();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/servico/{id_servico}")
	public Servico getAllServicos(@PathVariable("id_servico") int idServico) throws FileNotFoundException, ClassNotFoundException, IOException{
		return servicoService.getServico(idServico);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/prestador/{id_prestador}/servico")
	public Servico createServico(@PathVariable("id_prestador") int idPrestador,@RequestBody Servico servico) throws FileNotFoundException, ClassNotFoundException, IOException{
		return servicoService.createServico(idPrestador, servico);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/prestador/{id_prestador}/servico/{id_servico}")
	public Servico updateServico(@PathVariable("id_prestador") int idPrestador,@PathVariable("id_servico") int idServico,@RequestBody Servico servico) throws FileNotFoundException, ClassNotFoundException, IOException{
		return servicoService.updateServico(idPrestador, idServico, servico);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/servico/{id_servico}")
	public MensagemRetorno updateServico(@PathVariable("id_servico") int idServico) throws FileNotFoundException, ClassNotFoundException, IOException{
		return servicoService.deleteServico(idServico);
	}

}
