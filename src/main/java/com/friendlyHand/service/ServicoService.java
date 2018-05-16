//package com.friendlyHand.service;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//import com.friendlyHand.model.Dados;
//import com.friendlyHand.model.MensagemRetorno;
//import com.friendlyHand.model.Prestador;
//import com.friendlyHand.model.Servico;
//import com.friendlyHand.repository.Repository;
//
//@Service
//public class ServicoService {
//	
//	@Autowired
//	Repository repo;
//	
//	/*------------MOSTRAR UM SERVICO-----------*/
//	public Servico getServico(int id) throws FileNotFoundException, ClassNotFoundException, IOException {
//
//		Dados dados = repo.lerArquivo();
//		
//		for (int i = 0; i < dados.getServicos().size(); i++) {
//			
//			if(dados.getServicos().get(i).getId()==id) {
//				return dados.getServicos().get(i);
//			}
//		}	
//		return null;
//	}
//	
//	/*------------MOSTRAR TODOS OS SERVICOS-----------*/
//	public List<Servico> getAllServicos() throws FileNotFoundException, ClassNotFoundException, IOException{
//		
//		Dados dados = repo.lerArquivo();
//		return dados.getServicos();
//
//	}
//	
//	/*------------CRIAR UM SERVICO-----------*/
//	public Servico createServico(int idPrestador, Servico servico) throws FileNotFoundException, ClassNotFoundException, IOException {
//		
//		Dados dados = repo.lerArquivo();
//			
//		for (Prestador prestador : dados.getPrestadores()) {
//			if(prestador.getId()==idPrestador) {
//				if(dados.getServicos().size()==0) {
//					servico.setId(1);
//				}else {
//					int ultimoId = dados.getServicos().get(dados.getServicos().size()-1).getId();
//					servico.setId(ultimoId+1);
//				}
//				servico.setPrestador(prestador);
//				prestador.getServicos().add(servico);
//				dados.getServicos().add(servico);
//				repo.gravarArquivo(dados);
//				return servico;
//			}
//		}		
//		
//		return null;
//	}
//
//
//	/*------------ATUALIZAR UM SERVICO-----------*/
//	public Servico updateServico(int idPrestador, int idServico, Servico servicoCanal) throws FileNotFoundException, ClassNotFoundException, IOException {
//		
//		Dados dados = repo.lerArquivo();
//		
//		for (Prestador prestador : dados.getPrestadores()) {
//			if(prestador.getId()==idPrestador) {
//				for (Servico servico : prestador.getServicos()) {
//					if(servico.getId()==idServico) {
//						servico.setNomeServico(servicoCanal.getNomeServico());
//						servico.setPreco(servicoCanal.getPreco());
//						servico.setDescricao(servicoCanal.getDescricao());
//						repo.gravarArquivo(dados);
//						return servico;
//					}
//				}	
//			}
//		}
//
//		return null;
//	}
//	
//	/*------------DELETAR UM SERVICO-----------*/
//	public MensagemRetorno deleteServico(int id) throws FileNotFoundException, ClassNotFoundException, IOException {
//		
//		MensagemRetorno retorno = new MensagemRetorno();
//		
//		Dados dados = repo.lerArquivo();
//		for (int i = 0; i < dados.getServicos().size(); i++) {
//			if(dados.getServicos().get(i)!=null) {
//				if(dados.getServicos().get(i).getId()==id) {
//					dados.getServicos().set(i, null);
//					repo.gravarArquivo(dados);
//					retorno.setStatus("OK");
//					retorno.setMensagem("Servico deletado com sucesso");
//					return retorno;
//				}
//			}
//		}
//		
//		retorno.setStatus("ERRO");
//		retorno.setMensagem("Servico não encontrado");
//		
//		return retorno;
//	}
//
//}
