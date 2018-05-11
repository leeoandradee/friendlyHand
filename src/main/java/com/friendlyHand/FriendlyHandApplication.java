package com.friendlyHand;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.friendlyHand.model.Dados;


@SpringBootApplication
public class FriendlyHandApplication {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		SpringApplication.run(FriendlyHandApplication.class, args);

		File arquivo = new File("src/main/resources/dados");
		if(!arquivo.exists()) {
			Dados dados = new Dados();
			ObjectOutputStream objectOut = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("src/main/resources/dados")));			
			objectOut.writeObject(dados);
			objectOut.close();
		}
	}
}
