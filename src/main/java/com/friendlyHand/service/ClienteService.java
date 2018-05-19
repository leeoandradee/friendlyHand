package com.friendlyHand.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Service;
import com.friendlyHand.model.MensagemRetorno;
import com.friendlyHand.model.Cliente;
import com.friendlyHand.utils.JPAUtil;

@Service
public class ClienteService {
	
	
	/*------------MOSTRAR UM Cliente-----------*/
	public Cliente getCliente(int id){

		EntityManager manager = new JPAUtil().getEntityManager();
		Cliente cliente = manager.find(Cliente.class, id);
		
		return cliente;
	}
	
	/*------------MOSTRAR TODOS OS Cliente-----------*/
	public List<Cliente> getAllClientes(){
		
		EntityManager manager = new JPAUtil().getEntityManager();
		TypedQuery<Cliente> consulta = manager.createQuery("FROM Cliente", Cliente.class);
		List<Cliente> clientes = consulta.getResultList();

		return clientes;
	}
	
	/*------------CRIAR UM Cliente-----------*/
	public Cliente createCliente(Cliente cliente){
		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		manager.persist(cliente);
		manager.getTransaction().commit();
		manager.close();
		
		return cliente;	
	}

	/*------------ATUALIZAR UM Cliente-----------*/
	public Cliente updateCliente(Cliente cliente, int id)  {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		Cliente ClienteBanco = manager.find(Cliente.class, id);
		if(ClienteBanco!=null) {
			ClienteBanco.setNome(cliente.getNome());
			ClienteBanco.setEmail(cliente.getEmail());
			ClienteBanco.setCpf(cliente.getCpf());
			ClienteBanco.setEndereco(cliente.getEndereco());
			ClienteBanco.setDataNascimento(cliente.getDataNascimento());
			ClienteBanco.setSenha(cliente.getSenha());
			ClienteBanco.setServicosContratados(cliente.getServicosContratados());
			manager.merge(cliente);
			manager.getTransaction().commit();
			manager.close();
		}

		return ClienteBanco;
	}
	
	/*------------DELETAR UM Cliente-----------*/
	public MensagemRetorno deleteCliente(int id){
		
		EntityManager manager = new JPAUtil().getEntityManager();
		MensagemRetorno retorno = new MensagemRetorno();
		Cliente cliente = manager.find(Cliente.class, id);
		
		if(cliente!=null) {
			manager.getTransaction().begin();
			manager.remove(cliente);
			manager.getTransaction().commit();
			retorno.setStatus("OK");
			retorno.setMensagem("Cliente deletado com sucesso!");

		}else {
			retorno.setStatus("ERRO");
			retorno.setMensagem("Cliente não encontrado.");
		}
		
		return retorno;	
	}

}
