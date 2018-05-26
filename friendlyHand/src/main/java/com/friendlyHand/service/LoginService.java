package com.friendlyHand.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;

import com.friendlyHand.model.Cliente;
import com.friendlyHand.model.Prestador;
import com.friendlyHand.utils.JPAUtil;

@Service
public class LoginService {
	
	
	public Cliente loginCliente(String email, String senha){

		EntityManager manager = new JPAUtil().getEntityManager();
		TypedQuery<Cliente> consulta = manager.createQuery("FROM Cliente", Cliente.class);
		List<Cliente> clientes = consulta.getResultList();
		
		for (Cliente cliente : clientes) {
			if(cliente.getEmail().equals(email) && cliente.getSenha().equals(senha))
				return cliente;
		}

		
		return null;
	}
	
	public Prestador loginPrestador(String email, String senha){

		EntityManager manager = new JPAUtil().getEntityManager();
		TypedQuery<Prestador> consulta = manager.createQuery("FROM Prestador", Prestador.class);
		List<Prestador> prestadores = consulta.getResultList();
		
		for (Prestador prestador : prestadores) {
			if(prestador.getEmail().equals(email) && prestador.getSenha().equals(senha))
				return prestador;
		}

		
		return null;
	}

}
