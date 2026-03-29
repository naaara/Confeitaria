package com.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.br.model.Produto;

// Interface que fornece os métodos CRUD para a entidade Produto
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}