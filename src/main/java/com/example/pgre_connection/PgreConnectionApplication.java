package com.example.pgre_connection;

import com.example.pgre_connection.model.Person;
import com.example.pgre_connection.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PgreConnectionApplication implements CommandLineRunner {

	@Autowired
	private PersonRepo repo;

	public static void main(String[] args) {
		SpringApplication.run(PgreConnectionApplication.class, args);
	}

	@Override
	public void run(String... args) {
		// Criar uma nova pessoa
		Person newPerson = new Person();
		newPerson.setName("Vinicius Teste");

		// Salvar a nova pessoa no banco de dados
		repo.save(newPerson);
	}
}
