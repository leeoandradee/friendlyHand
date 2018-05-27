package com.friendlyHand.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.friendlyHand.model.AvaliacaoCliente;
import com.friendlyHand.model.AvaliacaoPrestador;
import com.friendlyHand.service.AvaliacaoService;

@RestController
public class AvaliacaoController {
	
	@Autowired
	private AvaliacaoService service;
	
	@RequestMapping(method=RequestMethod.POST, value="/avaliacaoCliente")
	public AvaliacaoCliente criarAvaliacaoCliente(@RequestBody AvaliacaoCliente avaliacao) {
		return service.criarAvaliacaoCliente(avaliacao);
	}

	@RequestMapping(method=RequestMethod.POST, value="/avaliacaoPrestador")
	public AvaliacaoPrestador criarAvaliacaoPrestador(@RequestBody AvaliacaoPrestador avaliacao) {
		return service.criarAvaliacaoPrestador(avaliacao);
	}
	
}
