package com.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.br.model.Pedido;

// Interface que fornece os métodos CRUD para a entidade Pedido
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}