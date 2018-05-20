package com.friendlyHand.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"id_servico_contratado",
	"id_prestador",
	"id_cliente",
	"data",
	"confirmado",
	"concluido"
})

@Entity
@Table(name = "servicocontratado")
public class ServicoContratado{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonProperty("id_servico_contratado")
	private int id;
	@JsonProperty("id_prestador")
	private int id_prestador;
	@JsonProperty("id_cliente")
	private int id_cliente;
	@JsonProperty("id_servico")
	private int id_servico;
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
	
	@JsonProperty("id_prestador")
	public int getId_prestador() {
		return id_prestador;
	}

	@JsonProperty("id_prestador")
	public void setId_prestador(int id_prestador) {
		this.id_prestador = id_prestador;
	}

	@JsonProperty("id_cliente")
	public int getId_cliente() {
		return id_cliente;
	}

	@JsonProperty("id_cliente")
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	@JsonProperty("id_servico")
	public int getId_servico() {
		return id_servico;
	}

	@JsonProperty("id_servico")
	public void setId_servico(int id_servico) {
		this.id_servico = id_servico;
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
