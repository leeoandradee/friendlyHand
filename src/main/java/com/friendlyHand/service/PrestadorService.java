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
	
	
	EntityManager manager = new JPAUtil().getEntityManager();
	
	/*------------MOSTRAR UM PRESTADOR-----------*/
	public Prestador getPrestador(int id){

		Prestador prestador = manager.find(Prestador.class, id);
		
		return prestador;
	}
	
	/*------------MOSTRAR TODOS OS PRESTADOR-----------*/
	public List<Prestador> getAllPrestadors(){
		
		TypedQuery<Prestador> consulta = manager.createQuery("FROM Prestador", Prestador.class);
		List<Prestador> artigos = consulta.getResultList();

		return artigos;
	}
	
	/*------------CRIAR UM PRESTADOR-----------*/
	public Prestador createPrestador(Prestador prestador){
		
		manager.getTransaction().begin();
		manager.persist(prestador);
		manager.getTransaction().commit();
		
		return prestador;	
	}

	/*------------ATUALIZAR UM PRESTADOR-----------*/
	public Prestador updatePrestador(Prestador prestador, int id)  {
		
		
		Prestador prestadorBanco = manager.find(Prestador.class, id);
		if(prestadorBanco!=null) {
			prestadorBanco.setNome(prestador.getNome());
			prestadorBanco.setEmail(prestador.getEmail());
			prestadorBanco.setCpf(prestador.getCpf());
			prestadorBanco.setEndereco(prestador.getEndereco());
			prestadorBanco.setDataNascimento(prestador.getDataNascimento());
			prestadorBanco.setSenha(prestador.getSenha());
			prestadorBanco.setServicos(prestador.getServicos());
			prestadorBanco.setServicosContratados(prestador.getServicosContratados());
			manager.getTransaction().begin();
			manager.getTransaction().commit();
		}

		return prestadorBanco;
	}
	
	/*------------DELETAR UM PRESTADOR-----------*/
	public MensagemRetorno deletePrestador(int id){
		
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
