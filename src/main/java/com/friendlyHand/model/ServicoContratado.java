package com.friendlyHand.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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

@Entity
public class ServicoContratado{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonProperty("id_servico_contratado")
	private int id;
	@OneToOne
	@JsonProperty("prestador")
	private Prestador prestador;
	@OneToOne
	@JsonProperty("cliente")
	private Cliente cliente;
	@OneToOne
	@JsonProperty("servico")
	private Servico servico;
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
	
	@JsonProperty("servico")
	public Servico getServico() {
		return servico;
	}

	@JsonProperty("servico")
	public void setServico(Servico servico) {
		this.servico = servico;
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
