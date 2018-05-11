package com.friendlyHand.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friendlyHand.model.Dados;
import com.friendlyHand.model.MensagemRetorno;
import com.friendlyHand.model.Prestador;
import com.friendlyHand.repository.Repository;

@Service
public class PrestadorService {
	
	@Autowired
	Repository repo;
	
	/*------------MOSTRAR UM PRESTADOR-----------*/
	public Prestador getPrestador(int id) throws FileNotFoundException, ClassNotFoundException, IOException {

		Dados dados = repo.lerArquivo();
		
		for (int i = 0; i < dados.getPrestadores().size(); i++) {
			
			if(dados.getPrestadores().get(i).getId()==id) {
				return dados.getPrestadores().get(i);
			}
		}	
		return null;
	}
	
	/*------------MOSTRAR TODOS OS PRESTADOR-----------*/
	public List<Prestador> getAllPrestadors() throws FileNotFoundException, ClassNotFoundException, IOException{
		
		Dados dados = repo.lerArquivo();
		return dados.getPrestadores();

	}
	
	/*------------CRIAR UM PRESTADOR-----------*/
	public Prestador createPrestador(Prestador Prestador) throws FileNotFoundException, ClassNotFoundException, IOException {
		
		Dados dados = repo.lerArquivo();
		if(dados.getPrestadores().size()==0) {
			Prestador.setId(1);
			dados.getPrestadores().add(Prestador);
		}else {
			int ultimoId = dados.getPrestadores().get(dados.getPrestadores().size()-1).getId();
			Prestador.setId(ultimoId+1);
			dados.getPrestadores().add(Prestador);
		}
		repo.gravarArquivo(dados);
		return Prestador;
	}


	/*------------ATUALIZAR UM PRESTADOR-----------*/
	public Prestador updatePrestador(Prestador Prestador, int id) throws FileNotFoundException, ClassNotFoundException, IOException {
		
		Dados dados = repo.lerArquivo();
		for (int i = 0; i < dados.getPrestadores().size(); i++) {
			if(dados.getPrestadores().get(i).getId()==id) {
				
				dados.getPrestadores().get(i).setNome(Prestador.getNome());
				dados.getPrestadores().get(i).setEmail(Prestador.getEmail());
				dados.getPrestadores().get(i).setCpf(Prestador.getCpf());
				dados.getPrestadores().get(i).setDataNascimento(Prestador.getDataNascimento());
				dados.getPrestadores().get(i).setSenha(Prestador.getSenha());
				dados.getPrestadores().get(i).setEndereco(Prestador.getEndereco());
				
				repo.gravarArquivo(dados);
				
				return dados.getPrestadores().get(i);
			}
		}

		return null;
	}
	
	/*------------DELETAR UM PRESTADOR-----------*/
	public MensagemRetorno deletePrestador(int id) throws FileNotFoundException, ClassNotFoundException, IOException {
		
		MensagemRetorno retorno = new MensagemRetorno();
		
		Dados dados = repo.lerArquivo();
		for (int i = 0; i < dados.getPrestadores().size(); i++) {
			if(dados.getPrestadores().get(i)!=null) {
				if(dados.getPrestadores().get(i).getId()==id) {
					dados.getPrestadores().set(i, null);
					repo.gravarArquivo(dados);
					retorno.setStatus("OK");
					retorno.setMensagem("Prestador deletado com sucesso");
					return retorno;
				}
			}
		}
		
		retorno.setStatus("ERRO");
		retorno.setMensagem("Prestador não encontrado");
		
		return retorno;
	}

}
