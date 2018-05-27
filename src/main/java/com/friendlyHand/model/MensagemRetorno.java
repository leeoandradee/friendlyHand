package com.friendlyHand.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"status",
"mensagem"
})

public class MensagemRetorno {
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("mensagem")
	private String mensagem;
	
	@JsonProperty("status")
	public String getStatus() {
		return status;
	}
	
	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}
	
	@JsonProperty("mensagem")
	public String getMensagem() {
		return mensagem;
	}
	
	@JsonProperty("mensagem")
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	

}
