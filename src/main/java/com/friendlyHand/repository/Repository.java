package com.friendlyHand.repository;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.springframework.stereotype.Component;

import com.friendlyHand.model.Dados;

@Component
public class Repository{

	public Dados lerArquivo() throws FileNotFoundException, IOException, ClassNotFoundException {

		
		ObjectInputStream objectIn = new ObjectInputStream(new BufferedInputStream(new FileInputStream("src/main/resources/dados")));
		Dados dados = (Dados)objectIn.readObject();
		objectIn.close();
		
		System.out.println("REPOSITORY - Dados lidos com sucesso!");
		
		return dados;
		
	}
	
	public void gravarArquivo(Dados dado) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		ObjectOutputStream objectOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("src/main/resources/dados")));			
		objectOut.writeObject(dado);
		objectOut.close();
		
		System.out.println("REPOSITORY - Dados gravados com sucesso!");
		
	}

}
