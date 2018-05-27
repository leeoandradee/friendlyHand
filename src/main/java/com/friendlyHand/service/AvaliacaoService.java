package com.friendlyHand.service;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;

import com.friendlyHand.model.AvaliacaoCliente;
import com.friendlyHand.model.AvaliacaoPrestador;
import com.friendlyHand.model.Cliente;
import com.friendlyHand.model.Prestador;
import com.friendlyHand.model.Servicocontratado;
import com.friendlyHand.utils.JPAUtil;

@Service
public class AvaliacaoService {
	
	public AvaliacaoCliente criarAvaliacaoCliente(AvaliacaoCliente avaliacao){
		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		Cliente cliente = manager.find(Cliente.class, avaliacao.getAvaliador());
		Prestador prestador = manager.find(Prestador.class, avaliacao.getAvaliado());
		Servicocontratado servicoContratado = manager.find(Servicocontratado.class, avaliacao.getIdServicoContratado());
		if(cliente!=null && prestador!=null && servicoContratado!=null) {
			for (Servicocontratado servicos : prestador.getServicosContratados()) {
				if(servicos.getId()==avaliacao.getIdServicoContratado()) {
					for (Servicocontratado servicos2 : cliente.getServicosContratados()) {
						if(servicos2.getId()==avaliacao.getIdServicoContratado()) {
							prestador.getAvaliações().add(avaliacao);
							manager.persist(prestador);
							manager.getTransaction().commit();
							manager.close();
							return avaliacao;
						}
					}
				}
			}		
		}
		return null;	
	}
	
	public AvaliacaoPrestador criarAvaliacaoPrestador(AvaliacaoPrestador avaliacao){
		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		Prestador prestador = manager.find(Prestador.class, avaliacao.getAvaliador());
		Cliente cliente = manager.find(Cliente.class, avaliacao.getAvaliado());
		Servicocontratado servicoContratado = manager.find(Servicocontratado.class, avaliacao.getIdServicoContratado());
		if(cliente!=null && prestador!=null && servicoContratado!=null) {
			for (Servicocontratado servicos : prestador.getServicosContratados()) {
				if(servicos.getId()==avaliacao.getIdServicoContratado()) {
					for (Servicocontratado servicos2 : cliente.getServicosContratados()) {
						if(servicos2.getId()==avaliacao.getIdServicoContratado()) {
							cliente.getAvaliações().add(avaliacao);
							manager.persist(cliente);
							manager.getTransaction().commit();
							manager.close();
							return avaliacao;
						}
					}
				}
			}
		}
		return null;	
	}


}
