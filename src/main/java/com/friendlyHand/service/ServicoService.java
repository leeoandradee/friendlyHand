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
	
	EntityManager manager = new JPAUtil().getEntityManager();
	
	/*------------MOSTRAR UM SERVICO-----------*/
	public Servico getServico(int id){

		Servico servico = manager.find(Servico.class, id);
		
		return servico;
	}
	
	/*------------MOSTRAR TODOS OS SERVICOS-----------*/
	public List<Servico> getAllServicos(){
		
		TypedQuery<Servico> consulta = manager.createQuery("FROM Servico", Servico.class);
		List<Servico> servicos = consulta.getResultList();

		return servicos;
	}
	
	/*------------CRIAR UM SERVICO-----------*/
	public Servico createServico(int idPrestador, Servico servico){
		
		Prestador prestador = manager.find(Prestador.class, idPrestador);
		if(prestador!=null) {
			prestador.getServicos().add(servico);
			manager.getTransaction().begin();
			manager.persist(prestador);
			manager.getTransaction().commit();
			return servico;
		}
		
		return null;
	}


	/*------------ATUALIZAR UM SERVICO-----------*/
	public Servico updateServico(int idPrestador, int idServico, Servico servicoCanal){
		
		Prestador prestador = manager.find(Prestador.class, idPrestador);
		if(prestador!=null) {
			Servico servico = manager.find(Servico.class, idServico);
			if(servico!=null) {
				servico = servicoCanal;
				for (int i = 0; i < prestador.getServicos().size(); i++) {
					if(prestador.getServicos().get(i).getId()==idServico) {
						prestador.getServicos().get(i).setNomeServico(servicoCanal.getNomeServico());
						prestador.getServicos().get(i).setDescricao(servicoCanal.getDescricao());
						prestador.getServicos().get(i).setPreco(servicoCanal.getPreco());
					}
					
				}
				manager.getTransaction().begin();
				manager.getTransaction().commit();
				return servicoCanal;
			}
		}
		
		return null;
	}
	
	/*------------DELETAR UM SERVICO-----------*/
	public MensagemRetorno deleteServico(int idServico) {
		
		MensagemRetorno retorno = new MensagemRetorno();
		Servico servico = manager.find(Servico.class, idServico);
		
		if(servico!=null) {
			manager.getTransaction().begin();
			manager.remove(servico);
			manager.getTransaction().commit();
			retorno.setStatus("OK");
			retorno.setMensagem("Prestador deletado com sucesso!");

		}else {
			retorno.setStatus("ERRO");
			retorno.setMensagem("Prestador não encontrado.");
		}
		
		return retorno;	
	}

}
