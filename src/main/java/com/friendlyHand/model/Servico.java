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
	"id_servico",
	"id_prestador",
	"nome",
	"categoria_servico",
	"descricao",
	"preco"
})

@Entity
public class Servico{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonProperty("id_servico")
	private int id;
	@JsonProperty("id_prestador")
	private int id_prestador;
	@JsonProperty("nome")
	private String nomeServico;
	@JsonProperty("categoria_servico")
	private CategoriaServico categoriaServico;
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
	
	@JsonProperty("categoria_servico")
	public CategoriaServico getCategoriaServico() {
		return categoriaServico;
	}

	@JsonProperty("categoria_servico")
	public void setCategoriaServico(CategoriaServico categoriaServico) {
		this.categoriaServico = categoriaServico;
	}

	@JsonProperty("nome")
	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}
	
	@JsonProperty("id_prestador")
	public int getId_prestador() {
		return id_prestador;
	}
	
	@JsonProperty("id_prestador")
	public void setPrestador(int id_prestador) {
		this.id_prestador = id_prestador;
	}

	public void setId_prestador(int id_prestador) {
		this.id_prestador = id_prestador;
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
