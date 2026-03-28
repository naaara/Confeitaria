package com.br.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
@Table(name = "produto")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(name = "nome")
	private String nome;
	
	
	@Column(name = "descricao")
	private String descricao;
	
	
	@Column(name = "categoria")
	private String categoria;
	
	
	@Column(name = "preco")
	private Double preco;
	
	
	@Column(name = "disponivel")
	private Boolean disponivel;
	
	
	@Column(name = "dataCadastro")
	private Date dataCadastro;
	
	//construtor padrão
	public Pedido() {
		
		super();
	}
	public Pedido(Long codigo, String nome, String descricao, String categoria, Double preco, Date dataCadastro, boolean disponivel) {
		
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.categoria = categoria;
		this.dataCadastro = dataCadastro;
		this.preco = preco;
		this.disponivel = disponivel;
	
	}

	//get e sets
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public String getdescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public Double getpreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	public Boolean isDisponivel() {
		return disponivel;
	}
	public void setDisponivel(Boolean disponivel) {
		this.disponivel = disponivel;
	}
	

}
