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

    @EmbeddedId
    private PedidoPK pedidoPK;

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
    private BigDecimal valorUnitario = BigDecimal.ZERO;

    @Column(name = "QTDE_IPE")
    private Integer quantidade = 1;

    @Column(name = " VLDO_IPE")
    private BigDecimal descontoOferta;

    @Transient
    private BigDecimal valorTabelaPreco = BigDecimal.ONE;

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

    public BigDecimal getValorTabelaPreco() {
        return valorTabelaPreco;
    }

    public void setValorTabelaPreco(BigDecimal valorTabelaPreco) {
        this.valorTabelaPreco = valorTabelaPreco;
    }

    public BigDecimal getDescontoOferta() {
        return descontoOferta = this.getValorTabelaPreco().subtract(this.valorUnitario);
    }

    public void setDescontoOferta(BigDecimal descontoOferta) {
        this.descontoOferta = descontoOferta;
    }

    public PedidoPK getPedidoPK() {
        return pedidoPK;
    }

    public void setPedidoPK(PedidoPK pedidoPK) {
        this.pedidoPK = pedidoPK;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

 

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.pedidoPK);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItemPedido other = (ItemPedido) obj;
        if (!Objects.equals(this.pedidoPK, other.pedidoPK)) {
            return false;
        }
        return true;
    }

    @Transient
    public BigDecimal getValorTotalProdutos() {
        return this.getDescontoOferta().multiply(new BigDecimal(this.getQuantidade())).add(this.valorUnitario);
    }

    @Transient
    public BigDecimal getValorTotal() {

        return this.getValorUnitario().multiply(new BigDecimal(this.getQuantidade()));

    }

    @Transient
    public boolean isProdutoAssociado() {
        return this.getProduto() != null && this.getProduto().getCodigo() != null;
    }

}
