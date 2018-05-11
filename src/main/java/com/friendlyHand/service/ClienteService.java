package com.friendlyHand.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friendlyHand.model.Cliente;
import com.friendlyHand.model.Dados;
import com.friendlyHand.model.MensagemRetorno;
import com.friendlyHand.repository.Repository;

@Service
public class ClienteService {
	
	@Autowired
	Repository repo;
	
	/*------------MOSTRAR UM CLIENTE-----------*/
	public Cliente getCliente(int id) throws FileNotFoundException, ClassNotFoundException, IOException {

		Dados dados = repo.lerArquivo();
		
		for (int i = 0; i < dados.getClientes().size(); i++) {
			
			if(dados.getClientes().get(i).getId()==id) {
				return dados.getClientes().get(i);
			}
		}	
		return null;
	}
	
	/*------------MOSTRAR TODOS OS CLIENTE-----------*/
	public List<Cliente> getAllClientes() throws FileNotFoundException, ClassNotFoundException, IOException{
		
		Dados dados = repo.lerArquivo();
		return dados.getClientes();

	}
	
	/*------------CRIAR UM CLIENTE-----------*/
	public Cliente createCliente(Cliente cliente) throws FileNotFoundException, ClassNotFoundException, IOException {
		
		Dados dados = repo.lerArquivo();
		if(dados.getClientes().size()==0) {
			cliente.setId(1);
			dados.getClientes().add(cliente);
		}else {
			int ultimoId = dados.getClientes().get(dados.getClientes().size()-1).getId();
			cliente.setId(ultimoId+1);
			dados.getClientes().add(cliente);
		}
		repo.gravarArquivo(dados);
		return cliente;
	}


	/*------------ATUALIZAR UM CLIENTE-----------*/
	public Cliente updateCliente(Cliente cliente, int id) throws FileNotFoundException, ClassNotFoundException, IOException {
		
		Dados dados = repo.lerArquivo();
		for (int i = 0; i < dados.getClientes().size(); i++) {
			if(dados.getClientes().get(i).getId()==id) {
				
				dados.getClientes().get(i).setNome(cliente.getNome());
				dados.getClientes().get(i).setEmail(cliente.getEmail());
				dados.getClientes().get(i).setCpf(cliente.getCpf());
				dados.getClientes().get(i).setDataNascimento(cliente.getDataNascimento());
				dados.getClientes().get(i).setSenha(cliente.getSenha());
				dados.getClientes().get(i).setEndereco(cliente.getEndereco());
				
				repo.gravarArquivo(dados);
				
				return dados.getClientes().get(i);
			}
		}

		return null;
	}
	
	/*------------DELETAR UM CLIENTE-----------*/
	public MensagemRetorno deleteCliente(int id) throws FileNotFoundException, ClassNotFoundException, IOException {
		
		MensagemRetorno retorno = new MensagemRetorno();
		
		Dados dados = repo.lerArquivo();
		for (int i = 0; i < dados.getClientes().size(); i++) {
			if(dados.getClientes().get(i)!=null) {
				if(dados.getClientes().get(i).getId()==id) {
					dados.getClientes().set(i, null);
					repo.gravarArquivo(dados);
					retorno.setStatus("OK");
					retorno.setMensagem("Cliente deletado com sucesso");
					return retorno;
				}
			}
		}
		
		retorno.setStatus("ERRO");
		retorno.setMensagem("Cliente não encontrado");
		
		return retorno;
	}
	
}
