package com.example.pgre_connection;

import com.example.pgre_connection.model.Person;
import com.example.pgre_connection.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PgreConnectionApplication implements CommandLineRunner {

	// A interface CommandLineRunner é usada para executar um bloco de código após a inicialização do aplicativo
	// É útil em casos de inicialização de dados, execução de tarefas agendadas, etc.
	// Pode ser usado para carregar dados iniciais no banco de dados, permitindo que injete dependências do spring
		// diretamente e execute o código desejado, a diferença desse método para o main é que ele é focado em spring,
			// carregando o contexto do spring e permitindo a injeção de dependências separadamente conforme a necessidade.
				// Mas é opcional...

	@Autowired // Injeção de dependência, o conceito ainda é um pouco confuso, mas bora tentar desmistificar isso ai...

	private PersonRepo repo; // Isso indica que a classe PgreConnectQueryApplication depende de um objeto do tipo PersonRepo.
								// Ao invés de criar uma instância de PersonRepo, o Spring Boot cria uma instância e a injeta
									// automaticamente na classe PgreConnectQueryApplication.


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
