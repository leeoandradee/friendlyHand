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
	"id_endereco",
	"cep",
	"rua",
	"numero",
	"bairro",
	"cidade",
	"uf"
	})

@Entity
public class Endereco{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonProperty("id_endereco")
	private int id;
	@JsonProperty("cep")
	private int cep;
	@JsonProperty("rua")
	private String rua;
	@JsonProperty("numero")
	private int numero;
	@JsonProperty("bairro")
	private String bairro;
	@JsonProperty("cidade")
	private String cidade;
	@JsonProperty("uf")
	private String uf;
	
	@JsonProperty("id_endereco")
	public int getId() {
		return id;
	}

	@JsonProperty("id_endereco")
	public void setId(int id) {
		this.id = id;
	}

	@JsonProperty("cep")
	public int getCep() {
	return cep;
	}
	
	@JsonProperty("cep")
	public void setCep(int cep) {
	this.cep = cep;
	}
	
	@JsonProperty("rua")
	public String getRua() {
	return rua;
	}
	
	@JsonProperty("rua")
	public void setRua(String rua) {
	this.rua = rua;
	}
	
	@JsonProperty("numero")
	public int getNumero() {
	return numero;
	}
	
	@JsonProperty("numero")
	public void setNumero(int numero) {
	this.numero = numero;
	}
	
	@JsonProperty("bairro")
	public String getBairro() {
	return bairro;
	}
	
	@JsonProperty("bairro")
	public void setBairro(String bairro) {
	this.bairro = bairro;
	}
	
	@JsonProperty("cidade")
	public String getCidade() {
	return cidade;
	}
	
	@JsonProperty("cidade")
	public void setCidade(String cidade) {
	this.cidade = cidade;
	}
	
	@JsonProperty("uf")
	public String getUf() {
	return uf;
	}
	
	@JsonProperty("uf")
	public void setUf(String uf) {
	this.uf = uf;
	}
	
	
}

