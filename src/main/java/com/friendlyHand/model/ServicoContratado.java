package com.friendlyHand.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"id_servico_contratado",
	"prestador",
	"cliente",
	"data",
	"confirmado",
	"concluido"
})

public class ServicoContratado implements Serializable{
	
	@JsonProperty("id_servico_contratado")
	private int id;
	@JsonProperty("prestador")
	private Prestador prestador;
	@JsonProperty("cliente")
	private Cliente cliente;
	@JsonProperty("data")
	private String data;
	@JsonProperty("confirmado")
	private boolean confirmado;
	@JsonProperty("concluido")
	private boolean concluido;
	
	@JsonProperty("id_servico_contratado")
	public int getId() {
		return id;
	}
	
	@JsonProperty("id_servico_contratado")
	public void setId(int id) {
		this.id = id;
	}
	
	@JsonProperty("prestador")
	public Prestador getPrestador() {
		return prestador;
	}
	@JsonProperty("prestador")
	public void setPrestador(Prestador prestador) {
		this.prestador = prestador;
	}
	
	@JsonProperty("cliente")
	public Cliente getCliente() {
		return cliente;
	}
	
	@JsonProperty("cliente")
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	@JsonProperty("data")
	public String getData() {
		return data;
	}
	@JsonProperty("data")
	public void setData(String data) {
		this.data = data;
	}
	
	@JsonProperty("confirmado")
	public boolean isConfirmado() {
		return confirmado;
	}
	@JsonProperty("confirmado")
	public void setConfirmado(boolean confirmado) {
		this.confirmado = confirmado;
	}
	
	@JsonProperty("concluido")
	public boolean isConcluido() {
		return concluido;
	}
	
	@JsonProperty("concluido")
	public void setConcluido(boolean concluido) {
		this.concluido = concluido;
	}

}
