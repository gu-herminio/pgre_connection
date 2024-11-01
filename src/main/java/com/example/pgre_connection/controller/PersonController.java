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
    PersonRepo repo;

    @Autowired
    RestTemplate restTemplate;

    @PostMapping("/addPerson")
    public void addPerson(@RequestBody Person person) {
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


