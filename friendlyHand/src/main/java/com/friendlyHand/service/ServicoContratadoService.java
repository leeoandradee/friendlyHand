package com.friendlyHand.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;

import com.friendlyHand.model.Cliente;
import com.friendlyHand.model.MensagemRetorno;
import com.friendlyHand.model.Prestador;
import com.friendlyHand.model.Servico;
import com.friendlyHand.model.Servicocontratado;
import com.friendlyHand.utils.JPAUtil;
import com.friendlyHand.utils.TratamentoData;

@Service
public class ServicoContratadoService {
	
	public Servicocontratado getServicoContratado(int id){

		EntityManager manager = new JPAUtil().getEntityManager();
		Servicocontratado servicoContratado = manager.find(Servicocontratado.class, id);
		
		return servicoContratado;
	}
	
	public List<Servicocontratado> getAllServicosContratadosUsuario(String usuario, int id_usuario ,String referencia) throws ClassNotFoundException{
		
		EntityManager manager = new JPAUtil().getEntityManager();
		TypedQuery<Servicocontratado> consulta  = null;
		usuario = "com.friendlyHand.model."+usuario;
		Class<?> clazz = Class.forName(usuario);
		Object usuarioQuery = manager.find(clazz, id_usuario);
		String auxId;
		if(usuarioQuery!=null) {
			if(usuarioQuery instanceof Cliente) auxId = "id_cliente";
			else auxId = "id_prestador";
			consulta = manager.createQuery("from Servicocontratado where "+referencia+" = true and "+auxId+"="+id_usuario, Servicocontratado.class);
			List<Servicocontratado> servicosContratados = consulta.getResultList();
			return servicosContratados;
		}
		return null;
	}
	
public List<Servicocontratado> getAllServicosContratadosPrestador(String referencia, int id_prestador){
		
		EntityManager manager = new JPAUtil().getEntityManager();
		TypedQuery<Servicocontratado> consulta  = null;
		if(referencia.equals("confirmado")) {
			consulta = manager.createQuery("from Servicocontratado where confirmado = true", Servicocontratado.class);
			List<Servicocontratado> servicosContratados = consulta.getResultList();
			return servicosContratados;
		}
		if(referencia.equals("concluido")) {
			consulta = manager.createQuery("from Servicocontratado where concluido = true", Servicocontratado.class);
			List<Servicocontratado> servicosContratados = consulta.getResultList();
			return servicosContratados;
		}
		
		return null;
	}
	
	public Servicocontratado createServicoContratado(Servicocontratado servicoContratado){
		
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
	
	public Servicocontratado updateServicoContratado(Servicocontratado servicoContratado){
		
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
							Servicocontratado servicoContratadoRetorno = manager.find(Servicocontratado.class, servicoContratado.getId());
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
		Servicocontratado servicoContratado = manager.find(Servicocontratado.class, idServicoContratado);
		
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
