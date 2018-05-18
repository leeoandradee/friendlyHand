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
	
	
	EntityManager manager = new JPAUtil().getEntityManager();
	
	/*------------MOSTRAR UM Cliente-----------*/
	public Cliente getCliente(int id){

		Cliente cliente = manager.find(Cliente.class, id);
		
		return cliente;
	}
	
	/*------------MOSTRAR TODOS OS Cliente-----------*/
	public List<Cliente> getAllClientes(){
		
		TypedQuery<Cliente> consulta = manager.createQuery("FROM Cliente", Cliente.class);
		List<Cliente> clientes = consulta.getResultList();

		return clientes;
	}
	
	/*------------CRIAR UM Cliente-----------*/
	public Cliente createCliente(Cliente cliente){
		
		manager.getTransaction().begin();
		manager.persist(cliente);
		manager.getTransaction().commit();
		
		return cliente;	
	}

	/*------------ATUALIZAR UM Cliente-----------*/
	public Cliente updateCliente(Cliente cliente, int id)  {
		
		
		Cliente ClienteBanco = manager.find(Cliente.class, id);
		if(ClienteBanco!=null) {
			ClienteBanco.setNome(cliente.getNome());
			ClienteBanco.setEmail(cliente.getEmail());
			ClienteBanco.setCpf(cliente.getCpf());
			ClienteBanco.setEndereco(cliente.getEndereco());
			ClienteBanco.setDataNascimento(cliente.getDataNascimento());
			ClienteBanco.setSenha(cliente.getSenha());
			ClienteBanco.setServicosContratados(cliente.getServicosContratados());
			manager.getTransaction().begin();
			manager.getTransaction().commit();
		}

		return ClienteBanco;
	}
	
	/*------------DELETAR UM Cliente-----------*/
	public MensagemRetorno deleteCliente(int id){
		
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
