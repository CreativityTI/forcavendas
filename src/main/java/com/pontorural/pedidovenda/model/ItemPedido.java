/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pontorural.pedidovenda.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Creativity
 */
@Entity
@Table(name = "IPEDIDO")
public class ItemPedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @ManyToOne
    @JoinColumn(name = "PEDI_PED", referencedColumnName = "PEDI_PED")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "CODI_EMP", referencedColumnName = "CODI_EMP")
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "CODI_PSV", referencedColumnName = "CODI_PSV")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "CCFO_CFO", referencedColumnName = "CCFO_CFO")
    private Cfop cfop;

    @Column(name = "VLOR_IPE")
    private BigDecimal valorUnitario;

    @Column(name = "QTDE_IPE")
    private Integer quantidade;

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Cfop getCfop() {
        return cfop;
    }

    public void setCfop(Cfop cfop) {
        this.cfop = cfop;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    
    

    @Transient
    public BigDecimal getValorTotal() {

        return this.getValorUnitario().multiply(new BigDecimal(this.getQuantidade()));
        
    }

}
