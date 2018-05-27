package com.friendlyHand.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({
	"id_cliente",
	"nome",
	"email",
	"cpf",
	"dataNascimento",
	"celular",
	"foto",
	"senha",
	"endereco",
	"servico_contratados"
	})
	
	@Entity
	public class Cliente{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonProperty("id_cliente")
	private int id;
	@JsonProperty("nome")
	private String nome;
	@Column(unique=true)
	@JsonProperty("email")
	private String email;
	@JsonProperty("cpf")
	private String cpf;
	@JsonProperty("dataNascimento")
	private String dataNascimento;
	@JsonProperty("celular")
	private String celular;
	@JsonProperty("foto")
	@Lob
	private String foto;
	@JsonProperty("senha")
	private String senha;
	@GeneratedValue
	@OneToOne(cascade=CascadeType.ALL)
	@JsonProperty("endereco")
	private Endereco endereco;
	@OneToMany(cascade=CascadeType.ALL)
	@ElementCollection(targetClass=Servicocontratado.class)
	@JsonProperty("servico_contratados")
	private List<Servicocontratado> servicosContratados;
	@OneToMany(cascade=CascadeType.ALL)
	@ElementCollection(targetClass=AvaliacaoPrestador.class)
	@JsonProperty("avaliações")
	private List<AvaliacaoPrestador> avaliações;
	

	@JsonProperty("id_cliente")
	public int getId() {
	return id;
	}

	@JsonProperty("id_cliente")
	public void setId(int id) {
	this.id = id;
	}

	@JsonProperty("nome")
	public String getNome() {
	return nome;
	}

	@JsonProperty("nome")
	public void setNome(String nome) {
	this.nome = nome;
	}

	@JsonProperty("email")
	public String getEmail() {
	return email;
	}

	@JsonProperty("email")
	public void setEmail(String email) {
	this.email = email;
	}

	@JsonProperty("senha")
	public String getSenha() {
	return senha;
	}

	@JsonProperty("senha")
	public void setSenha(String senha) {
	this.senha = senha;
	}

	@JsonProperty("cpf")
	public String getCpf() {
		return cpf;
	}

	@JsonProperty("cpf")
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@JsonProperty("dataNascimento")
	public String getDataNascimento() {
		return dataNascimento;
	}

	@JsonProperty("dataNascimento")
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
	@JsonProperty("celular")
	public String getCelular() {
		return celular;
	}

	@JsonProperty("celular")
	public void setCelular(String celular) {
		this.celular = celular;
	}

	@JsonProperty("foto")
	public String getFoto() {
		return foto;
	}

	@JsonProperty("foto")
	public void setFoto(String foto) {
		this.foto = foto;
	}

	@JsonProperty("endereco")
	public Endereco getEndereco() {
		return endereco;
	}

	@JsonProperty("endereco")
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	@JsonProperty("servico_contratados")
	public List<Servicocontratado> getServicosContratados() {
		return servicosContratados;
	}

	@JsonProperty("servico_contratados")
	public void setServicosContratados(List<Servicocontratado> servicosContratados) {
		this.servicosContratados = servicosContratados;
	}

	public List<AvaliacaoPrestador> getAvaliações() {
		return avaliações;
	}

	public void setAvaliações(List<AvaliacaoPrestador> avaliações) {
		this.avaliações = avaliações;
	}
	
	
}