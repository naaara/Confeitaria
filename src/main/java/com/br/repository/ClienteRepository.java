package com.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.br.model.Cliente;

// Interface que fornece os métodos CRUD para a entidade Cliente
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}