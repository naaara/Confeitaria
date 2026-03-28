package com.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.model.Cliente;

//Indica que essa interface é um repositório Spring
//JpaRepository já fornece os métodos básicos de CRUD automaticamente

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	// O Spring Data JPA já implementa automaticamente:
    // save() -> incluir e alterar
    // findById() -> consultar por id
    // findAll() -> listar todos
    // deleteById() -> excluir por id
}