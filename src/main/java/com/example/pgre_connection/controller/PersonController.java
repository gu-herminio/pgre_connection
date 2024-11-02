package com.example.pgre_connection.controller;

import com.example.pgre_connection.model.Person;
import com.example.pgre_connection.repo.PersonRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PersonController {

    @Autowired
    PersonRepo repo; // Injeção de dependência


    @Autowired
    RestTemplate restTemplate; // Injeção de dependência

    @PostMapping("/addPerson") // Mapeia a URL /addPerson para este método, que é executado quando a URL é acessada.
    public void addPerson(@RequestBody Person person) { // O método recebe um objeto Person como parâmetro, que é enviado no corpo da solicitação HTTP.
                            // Esse @RequestBody é uma anotação do Spring que indica que o parâmetro do método deve ser vinculado ao corpo da solicitação HTTP.
                                // O Spring converte automaticamente o corpo da solicitação em um objeto Person.

        // Salvar a pessoa no banco de dados
        repo.save(person);

        // Opcional: Caso você queira também fazer uma requisição para um endpoint REST
        String url = "http://localhost:8080/addPerson"; // URL do seu endpoint
        try {
            restTemplate.postForObject(url, person, Void.class);
        } catch (Exception e) {
            System.err.println("Error adding person via REST: " + e.getMessage());
        }
    }
}


