package com.friendlyHand.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"id_avaliacao",
	"id_servico_contratado",
	"id_cliente",
	"id_prestador",
	"nota",
	"comentario"
})

@Entity
public class AvaliacaoPrestador {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonProperty("id_avaliacao")
	private int id;
	@JsonProperty("id_servico_contratado")
	private int idServicoContratado;
	@JsonProperty("id_prestador")
	private int avaliador;
	@JsonProperty("id_cliente")
	private int avaliado;
	@JsonProperty("nota")
	private double nota;
	@JsonProperty("comentario")
	private String comentario;
	
	@JsonProperty("id_avaliacao")
	public int getId() {
		return id;
	}
	
	@JsonProperty("id_avaliacao")
	public void setId(int id) {
		this.id = id;
	}
	
	@JsonProperty("id_servico_contratado")
	public int getIdServicoContratado() {
		return idServicoContratado;
	}
	
	@JsonProperty("id_servico_contratado")
	public void setIdServicoContratado(int idServicoContratado) {
		this.idServicoContratado = idServicoContratado;
	}
	
	@JsonProperty("id_prestador")
	public int getAvaliador() {
		return avaliador;
	}
	
	@JsonProperty("id_prestador")
	public void setAvaliador(int avaliador) {
		this.avaliador = avaliador;
	}
	
	@JsonProperty("id_cliente")
	public int getAvaliado() {
		return avaliado;
	}
	
	@JsonProperty("id_cliente")
	public void setAvaliado(int avaliado) {
		this.avaliado = avaliado;
	}
	
	@JsonProperty("nota")
	public double getNota() {
		return nota;
	}
	
	@JsonProperty("nota")
	public void setNota(double nota) {
		this.nota = nota;
	}
	
	@JsonProperty("comentario")
	public String getComentario() {
		return comentario;
	}
	
	@JsonProperty("comentario")
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

}
