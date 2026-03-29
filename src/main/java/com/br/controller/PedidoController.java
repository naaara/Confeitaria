package com.br.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.exception.ResourceNotFoundException;
import com.br.model.Pedido;
import com.br.repository.PedidoRepository;

@RequestMapping("/cpedido/")
@RestController
@CrossOrigin(origins = "*")

public class PedidoController {
	
	@Autowired
	private PedidoRepository orep;
	
	//metodo listar
	@GetMapping("/pedido")
	public List<Pedido>listar(){
		return this.orep.findAll(Sort.by(Sort.Direction.DESC, "codigo"));
	}
	//método consultar
	@GetMapping("/pedido/{id}")
	public ResponseEntity<Pedido> consultar(@PathVariable Long id){
		Pedido pedido = this.orep.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Pedido não encontrado:" + id));
		return ResponseEntity.ok(pedido);
		
	}

	//metodo inserir
	@PostMapping("/pedido")
	public Pedido inserir(@RequestBody Pedido pedido) {
		return this.orep.save(pedido);
	}
	
	//metodo alterar
	@PutMapping("/pedido/{id}")
	public ResponseEntity<Pedido> alterar(@PathVariable Long id,@RequestBody Pedido pedidoAtualizado){
	Pedido pedido = this.orep.findById(id)
		.orElseThrow(()-> new ResourceNotFoundException("Pedido não encontrado:" + id));
	
	pedido.setStatus(pedidoAtualizado.getStatus());
	pedido.setValorTotal(pedidoAtualizado.getValorTotal());
	pedido.setObservacao(pedidoAtualizado.getObservacao());
	pedido.setDataPedido(pedidoAtualizado.getDataPedido());
	pedido.setEntrega(pedidoAtualizado.getEntrega());
	pedido.setCliente(pedidoAtualizado.getCliente());
	pedido.setProdutos(pedidoAtualizado.getProdutos());
	
	return ResponseEntity.ok(this.orep.save(pedido));
	}
	
	//metodo excluir
	@DeleteMapping("/pedido/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id){
		Pedido pedido = this.orep.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("pedido não encontrado:" + id));
		this.orep.delete(pedido);
		return ResponseEntity.noContent().build();
	}
}









