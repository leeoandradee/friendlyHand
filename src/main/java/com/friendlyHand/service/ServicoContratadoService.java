package com.friendlyHand.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;

import com.friendlyHand.model.Cliente;
import com.friendlyHand.model.MensagemRetorno;
import com.friendlyHand.model.Prestador;
import com.friendlyHand.model.Servico;
import com.friendlyHand.model.ServicoContratado;
import com.friendlyHand.utils.JPAUtil;
import com.friendlyHand.utils.TratamentoData;

@Service
public class ServicoContratadoService {
	
	public ServicoContratado getServicoContratado(int id){

		EntityManager manager = new JPAUtil().getEntityManager();
		ServicoContratado servicoContratado = manager.find(ServicoContratado.class, id);
		
		return servicoContratado;
	}
	
	public List<ServicoContratado> getAllServicosContratados(){
		
		EntityManager manager = new JPAUtil().getEntityManager();
		TypedQuery<ServicoContratado> consulta = manager.createQuery("FROM servicocontratado", ServicoContratado.class);
		List<ServicoContratado> servicosContratados = consulta.getResultList();

		return servicosContratados;
	}
	
	public ServicoContratado createServicoContratado(ServicoContratado servicoContratado){
		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		
		Cliente cliente = manager.find(Cliente.class, servicoContratado.getId_cliente());
		if(cliente!=null) {
			Prestador prestador = manager.find(Prestador.class,servicoContratado.getId_prestador());
			if(prestador!=null) {
				for (Servico servicos : prestador.getServicos()) {
					if(servicos.getId()==servicoContratado.getId_servico()) {
						Servico servico = manager.find(Servico.class,servicoContratado.getId_servico());
						if(servico!=null) {
							TratamentoData bean = new TratamentoData();
							servicoContratado.setData(bean.gerarData());
							cliente.getServicosContratados().add(servicoContratado);
							prestador.getServicosContratados().add(servicoContratado);
							manager.persist(prestador);
							manager.persist(cliente);
							manager.getTransaction().commit();
							manager.close();
							return servicoContratado;
						}
					}
				}
			}
		}
		manager.close();
		return null;
	}
	
	public ServicoContratado updateServicoContratado(ServicoContratado servicoContratado){
		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		Cliente cliente = manager.find(Cliente.class, servicoContratado.getId_cliente());
		if(cliente!=null) {
			Prestador prestador = manager.find(Prestador.class,servicoContratado.getId_prestador());
			if(prestador!=null) {
				for (Servico servicos : prestador.getServicos()) {
					if(servicos.getId()==servicoContratado.getId_servico()) {
						Servico servico = manager.find(Servico.class,servicoContratado.getId_servico());
						if(servico!=null) {
							ServicoContratado servicoContratadoRetorno = manager.find(ServicoContratado.class, servicoContratado.getId());
							if(servicoContratadoRetorno!=null) {
								servicoContratadoRetorno.setConfirmado(servicoContratado.isConfirmado());
								servicoContratadoRetorno.setConcluido(servicoContratado.isConcluido());
								manager.merge(servicoContratadoRetorno);
								manager.getTransaction().commit();
								manager.close();
								return servicoContratadoRetorno;
							}
						}
					}
				}
			}
		}
		
		manager.close();
		return null;
	}
	
	public MensagemRetorno deleteServico(int idServicoContratado) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		MensagemRetorno retorno = new MensagemRetorno();
		ServicoContratado servicoContratado = manager.find(ServicoContratado.class, idServicoContratado);
		
		if(servicoContratado!=null) {
			manager.getTransaction().begin();
			manager.remove(servicoContratado);
			manager.getTransaction().commit();
			retorno.setStatus("OK");
			retorno.setMensagem("Servico Contratado deletado com sucesso!");

		}else {
			retorno.setStatus("ERRO");
			retorno.setMensagem("Servico Contratado não encontrado.");
		}
		manager.close();
		return retorno;	
	}

}
