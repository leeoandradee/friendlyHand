package com.friendlyHand.model;

import javax.persistence.CascadeType;
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
	"id_servico",
	"prestador",
	"nome",
	"descricao",
	"preco"
})

@Entity
public class Servico{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonProperty("id_servico")
	private int id;
	@OneToOne(cascade=CascadeType.ALL)
	@JsonProperty("prestador")
	private Prestador prestador;
	@JsonProperty("nome")
	private String nomeServico;
	@JsonProperty("descricao")
	private String descricao;
	@JsonProperty("preco")
	private int preco;

	
	@JsonProperty("id_servico")
	public int getId() {
		return id;
	}
	
	@JsonProperty("id_servico")
	public void setId(int id) {
		this.id = id;
	}
	
	@JsonProperty("nome")
	public String getNomeServico() {
		return nomeServico;
	}
	
	@JsonProperty("nome")
	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}
	
	@JsonProperty("prestador")
	public Prestador getPrestador() {
		return prestador;
	}
	@JsonProperty("prestador")
	public void setPrestador(Prestador prestador) {
		this.prestador = prestador;
	}
	
	@JsonProperty("descricao")
	public String getDescricao() {
		return descricao;
	}
	
	@JsonProperty("descricao")
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	@JsonProperty("preco")
	public int getPreco() {
		return preco;
	}
	
	@JsonProperty("preco")
	public void setPreco(int preco) {
		this.preco = preco;
	}
}
