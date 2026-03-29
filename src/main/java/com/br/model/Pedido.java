package com.br.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long codigo;

    @Column(name="dataPedido")
    private Date dataPedido;

    @Column(name="status")
    private String status;

    @Column(name = "observacao")
    private String observacao;

    @Column(name="valorTotal")
    private Double valorTotal;

    @Column(name="entrega")
    private Boolean entrega;

    // Relacionamento com Cliente (muitos pedidos pertencem a um cliente)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Cliente cliente;

    // Relacionamento com Produto (um pedido pode ter muitos produtos)
    // Cria automaticamente a tabela intermediária "pedido_produto" no banco
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "pedido_produto",
        joinColumns = @JoinColumn(name = "pedido_id"),
        inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private List<Produto> produtos;

    // Construtor padrão
    public Pedido() {
        super();
    }

    // Construtor com todos os atributos
    public Pedido(Long codigo, String observacao, String status, Date dataPedido, double valorTotal,
            boolean entrega, Cliente cliente, List<Produto> produtos) {
        super();
        this.codigo = codigo;
        this.observacao = observacao;
        this.status = status;
        this.dataPedido = dataPedido;
        this.entrega = entrega;
        this.valorTotal = valorTotal;
        this.cliente = cliente;
        this.produtos = produtos;
    }

    // Gets & Sets
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public boolean getEntrega() {
        return entrega;
    }

    public void setEntrega(boolean entrega) {
        this.entrega = entrega;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    // Get e Set da lista de produtos do pedido
    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}