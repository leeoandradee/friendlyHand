package com.friendlyHand.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Dados implements Serializable{
	
	@JsonProperty("clientes")
	private List<Cliente> clientes;
	@JsonProperty("prestadores")
	private List<Prestador> prestadores;
	@JsonProperty("servicos")
	private List<Servico> servicos;
	
	
	@JsonProperty("clientes")
	public List<Cliente> getClientes() {
		if(clientes==null) {
			return clientes = new ArrayList<Cliente>();
		}
		return clientes;
	}
	
	@JsonProperty("clientes")
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	@JsonProperty("prestadores")
	public List<Prestador> getPrestadores() {
		if(prestadores==null) {
			return prestadores = new ArrayList<Prestador>();
		}
		return prestadores;
	}
	
	@JsonProperty("prestadores")
	public void setPrestadores(List<Prestador> prestadores) {
		this.prestadores = prestadores;
	}
	
	@JsonProperty("servicos")
	public List<Servico> getServicos() {
		if(servicos==null) {
			return servicos= new ArrayList<Servico>();
		}
		return servicos;
	}
	
	@JsonProperty("servicos")
	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}
	
	

}
