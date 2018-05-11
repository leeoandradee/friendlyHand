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

import com.friendlyHand.model.Prestador;
import com.friendlyHand.model.MensagemRetorno;
import com.friendlyHand.service.PrestadorService;

@RestController
public class PrestadorController {
	
	@Autowired
	PrestadorService prestadorService;
	
	@RequestMapping(method=RequestMethod.GET, value="/prestadores")
	public List<Prestador> getAllPrestadors() throws FileNotFoundException, ClassNotFoundException, IOException{
		return prestadorService.getAllPrestadors();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="prestador/{id}")
	public Prestador getPrestador(@PathVariable("id") int id) throws FileNotFoundException, ClassNotFoundException, IOException{
		return prestadorService.getPrestador(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/prestador")
	public Prestador createPrestador(@RequestBody Prestador Prestador) throws FileNotFoundException, ClassNotFoundException, IOException{
		return prestadorService.createPrestador(Prestador);	
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/prestador/{id}")
	public Prestador atualizarPrestador(@RequestBody Prestador Prestador, @PathVariable("id") int id) throws FileNotFoundException, ClassNotFoundException, IOException{
		return prestadorService.updatePrestador(Prestador, id);	
	}

	@RequestMapping(method=RequestMethod.DELETE, value="prestador/{id}")
	public MensagemRetorno deletePrestador(@PathVariable("id") int id) throws FileNotFoundException, ClassNotFoundException, IOException{
		return prestadorService.deletePrestador(id);
	}

}
