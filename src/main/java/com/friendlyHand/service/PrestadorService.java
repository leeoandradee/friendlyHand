package com.friendlyHand.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;

import com.friendlyHand.model.MensagemRetorno;
import com.friendlyHand.model.Prestador;
import com.friendlyHand.utils.JPAUtil;

@Service
public class PrestadorService {
	

	
	/*------------MOSTRAR UM PRESTADOR-----------*/
	public Prestador getPrestador(int id){

		EntityManager manager = new JPAUtil().getEntityManager();
		Prestador prestador = manager.find(Prestador.class, id);
		
		return prestador;
	}
	
	/*------------MOSTRAR TODOS OS PRESTADOR-----------*/
	public List<Prestador> getAllPrestadors(){
		
		EntityManager manager = new JPAUtil().getEntityManager();
		TypedQuery<Prestador> consulta = manager.createQuery("FROM Prestador", Prestador.class);
		List<Prestador> prestadores = consulta.getResultList();

		return prestadores;
	}
	
	/*------------CRIAR UM PRESTADOR-----------*/
	public Prestador createPrestador(Prestador prestador){
		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		manager.persist(prestador);
		manager.getTransaction().commit();
		manager.close();
		
		return prestador;	
	}

	/*------------ATUALIZAR UM PRESTADOR-----------*/
	public Prestador updatePrestador(Prestador prestador, int id)  {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		Prestador prestadorBanco = manager.find(Prestador.class, id);
		if(prestadorBanco!=null) {
			prestadorBanco.setNome(prestador.getNome());
			prestadorBanco.setEmail(prestador.getEmail());
			prestadorBanco.setCpf(prestador.getCpf());
			prestadorBanco.setEndereco(prestador.getEndereco());
			prestadorBanco.setDataNascimento(prestador.getDataNascimento());
			prestadorBanco.setCelular(prestador.getCelular());
			prestadorBanco.setFoto(prestador.getFoto());
			prestadorBanco.setSenha(prestador.getSenha());
			prestadorBanco.setServicos(prestador.getServicos());
			prestadorBanco.setServicosContratados(prestador.getServicosContratados());
			manager.merge(prestadorBanco);
			manager.getTransaction().commit();
			manager.close();
			return prestadorBanco;
		}

		return null;
	}
	
	/*------------DELETAR UM PRESTADOR-----------*/
	public MensagemRetorno deletePrestador(int id){
		
		EntityManager manager = new JPAUtil().getEntityManager();
		MensagemRetorno retorno = new MensagemRetorno();
		Prestador prestador = manager.find(Prestador.class, id);
		
		if(prestador!=null) {
			manager.getTransaction().begin();
			manager.remove(prestador);
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
