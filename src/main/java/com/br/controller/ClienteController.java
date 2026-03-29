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
import com.br.model.Cliente;
import com.br.repository.ClienteRepository;

@RequestMapping("/ccliente/")
@RestController
@CrossOrigin(origins = "*")

public class ClienteController {
	
	@Autowired
	private ClienteRepository crep;
	
	//metodo listar
	@GetMapping("/cliente")
	public List<Cliente>listar(){
		return this.crep.findAll(Sort.by(Sort.Direction.DESC, "codigo"));
	}
	//método consultar
	@GetMapping("/cliente/{id}")
	public ResponseEntity<Cliente> consultar(@PathVariable Long id){
		Cliente cliente = this.crep.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Cliente não encontrado:" + id));
		return ResponseEntity.ok(cliente);
		
	}

	//metodo inserir
	@PostMapping("/cliente")
	public Cliente inserir(@RequestBody Cliente cliente) {
		return this.crep.save(cliente);
	}
	
	//metodo alterar
	@PutMapping("/cliente/{id}")
	public ResponseEntity<Cliente> alterar(@PathVariable Long id,@RequestBody Cliente clienteAtualizado){
	Cliente cliente = this.crep.findById(id)
		.orElseThrow(()-> new ResourceNotFoundException("Cliente não encontrado:" + id));
	
	cliente.setNome(clienteAtualizado.getNome());
	cliente.setEmail(clienteAtualizado.getEmail());
	cliente.setTelefone(clienteAtualizado.getTelefone());
	cliente.setDataNascimento(clienteAtualizado.getDataNascimento());
	cliente.setAtivo(clienteAtualizado.getAtivo());
	cliente.setCpf(clienteAtualizado.getCpf());
	
	return ResponseEntity.ok(this.crep.save(cliente));
	}
	
	//metodo excluir
	@DeleteMapping("/cliente/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id){
		Cliente cliente = this.crep.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Cliente não encontrado:" + id));
		this.crep.delete(cliente);
		return ResponseEntity.noContent().build();
	}
}









