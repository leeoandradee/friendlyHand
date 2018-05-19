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
		TypedQuery<ServicoContratado> consulta = manager.createQuery("FROM Servico", ServicoContratado.class);
		List<ServicoContratado> servicosContratados = consulta.getResultList();

		return servicosContratados;
	}
	
	public ServicoContratado createServicoContratado(int idPrestador, int idCliente, int idServico){
		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		
		Cliente cliente = manager.find(Cliente.class, idCliente);
		if(cliente!=null) {
			Prestador prestador = manager.find(Prestador.class, idPrestador);
			if(prestador!=null) {
				for (Servico servicos : prestador.getServicos()) {
					if(servicos.getId()==idServico) {
						Servico servico = manager.find(Servico.class, idServico);
						if(servico!=null) {
							ServicoContratado servicoContratado = new ServicoContratado();
							servicoContratado.setId_cliente(idCliente);
							servicoContratado.setId_servico(idServico);
							servicoContratado.setId_prestador(idPrestador);
							TratamentoData bean = new TratamentoData();
							servicoContratado.setData(bean.gerarData());
							return servicoContratado;
						}
					}
				}
			}
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
			retorno.setMensagem("Prestador deletado com sucesso!");

		}else {
			retorno.setStatus("ERRO");
			retorno.setMensagem("Prestador não encontrado.");
		}
		
		return retorno;	
	}

}
