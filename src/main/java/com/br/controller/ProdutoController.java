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
import com.br.model.Produto;
import com.br.repository.ProdutoRepository;

@RequestMapping("/cproduto/")
@RestController
@CrossOrigin(origins = "*")

public class ProdutoController {
	
	@Autowired
	private ProdutoRepository prep;
	
	//metodo listar
	@GetMapping("/produto")
	public List<Produto>listar(){
		return this.prep.findAll(Sort.by(Sort.Direction.DESC, "codigo"));
	}
	//método consultar
	@GetMapping("/produto/{id}")
	public ResponseEntity<Produto> consultar(@PathVariable Long id){
		Produto produto = this.prep.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Produto não encontrado:" + id));
		return ResponseEntity.ok(produto);
		
	}

	//metodo inserir
	@PostMapping("/produto")
	public Produto inserir(@RequestBody Produto produto) {
		return this.prep.save(produto);
	}
	
	//metodo alterar
	@PutMapping("/produto/{id}")
	public ResponseEntity<Produto> alterar(@PathVariable Long id,@RequestBody Produto produtoAtualizado){
	Produto produto = this.prep.findById(id)
		.orElseThrow(()-> new ResourceNotFoundException("Produto não encontrado:" + id));
	
	produto.setNome(produtoAtualizado.getNome());
	produto.setDescricao(produtoAtualizado.getDescricao());
	produto.setPreco(produtoAtualizado.getPreco());
	produto.setDataCadastro(produtoAtualizado.getDataCadastro());
	produto.setDisponivel(produtoAtualizado.getDisponivel());
	produto.setCategoria(produtoAtualizado.getCategoria());
	
	return ResponseEntity.ok(this.prep.save(produto));
	}
	
	//metodo excluir
	@DeleteMapping("/produto/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id){
		Produto produto = this.prep.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Produto não encontrado:" + id));
		this.prep.delete(produto);
		return ResponseEntity.noContent().build();
	}
}









