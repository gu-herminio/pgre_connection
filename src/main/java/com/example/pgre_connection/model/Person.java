package com.example.pgre_connection.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data // Anotação do Lombok que gera automaticamente getters, setters, toString, equals e hashCode
        // Lombok é uma biblioteca que ajuda a reduzir a quantidade de código boilerplate em classes Java
            // boilerplate é um código que deve ser incluído em muitos lugares com pouca ou nenhuma alteração
                // O Lombok ajuda a reduzir a quantidade de código que você precisa escrever, economizando tempo e esforço

@Entity // Define que esta classe é uma entidade do JPA, mapeada para uma tabela no banco de dados
            // O JPA (Java Persistence API) é uma especificação do Java que descreve como os objetos Java devem ser mapeados para o banco de dados relacional
                // O JPA é uma API de persistência de objetos que fornece um framework para mapear objetos Java para tabelas de banco de dados e vice-versa
                    // O JPA é uma especificação e não uma implementação, o que significa que você precisa de uma implementação específica, como o Hibernate, para usar o JPA

@Table(name = "person") // Especifica o nome da tabela no banco de dados para esta entidade
                            // Se você não especificar o nome da tabela, o JPA usará o nome da classe como o nome da tabela por padrão
public class Person {
    @Id // Define que este campo é a chave primária da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração automática do ID usando uma estratégia específica
    private Long id; // Use Long em vez de long para permitir que o ID seja nulo
    private String name;
}
