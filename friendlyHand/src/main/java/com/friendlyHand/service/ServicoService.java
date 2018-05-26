package com.friendlyHand.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;

import com.friendlyHand.model.MensagemRetorno;
import com.friendlyHand.model.Prestador;
import com.friendlyHand.model.Servico;
import com.friendlyHand.utils.JPAUtil;

@Service
public class ServicoService {
	
	
	/*------------MOSTRAR UM SERVICO-----------*/
	public Servico getServico(int id){

		EntityManager manager = new JPAUtil().getEntityManager();
		Servico servico = manager.find(Servico.class, id);
		
		return servico;
	}
	
	/*------------MOSTRAR TODOS OS SERVICOS-----------*/
	public List<Servico> getAllServicos(){
		
		EntityManager manager = new JPAUtil().getEntityManager();
		TypedQuery<Servico> consulta = manager.createQuery("FROM Servico", Servico.class);
		List<Servico> servicos = consulta.getResultList();

		return servicos;
	}
	
	/*------------CRIAR UM SERVICO-----------*/
	public Servico createServico(int idPrestador, Servico servico){
		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		Prestador prestador = manager.find(Prestador.class, idPrestador);
		if(prestador!=null) {
			servico.setId_prestador(idPrestador);
			prestador.getServicos().add(servico);
			manager.persist(prestador);
			manager.getTransaction().commit();
			manager.close();
			return servico;
		}
		return null;
	}
	
	/*------------ATUALIZAR UM SERVICO-----------*/
	public Servico updateServico(int idPrestador, int idServico, Servico servicoCanal){
		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		Prestador prestador = manager.find(Prestador.class, idPrestador);
		if(prestador!=null) {
			for (Servico servico : prestador.getServicos()) {
				if(servico.getId()==idServico) {
					Servico servicoBanco = manager.find(Servico.class, idServico);
					if(servicoBanco!=null) {
						servicoBanco = servicoCanal;
						servicoBanco.setId(idServico);
						servicoBanco.setId_prestador(idPrestador);
						manager.merge(servicoBanco);
						manager.getTransaction().commit();
						manager.close();
						return servicoBanco;
					}
				}
			}
		}
		
		return null;
	}
	
	/*------------DELETAR UM SERVICO-----------*/
	public MensagemRetorno deleteServico(int idServico) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		MensagemRetorno retorno = new MensagemRetorno();
		Servico servico = manager.find(Servico.class, idServico);
		
		if(servico!=null) {
			manager.getTransaction().begin();
			manager.remove(servico);
			manager.getTransaction().commit();
			retorno.setStatus("OK");
			retorno.setMensagem("Servico deletado com sucesso!");

		}else {
			retorno.setStatus("ERRO");
			retorno.setMensagem("Servico não encontrado.");
		}
		
		return retorno;	
	}

}
