/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pontorural.pedidovenda.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.FetchType;
import javax.persistence.JoinColumns;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
    protected ItemPedidoPK itemPedidoPK;

    @Column(name = "DEMI_PED")
    @Temporal(TemporalType.DATE)
    private Date emissao;

    @Column(name = "QTDE_IPE")
    private Double quantidade;

    @Column(name = "VLOR_IPE")
    private BigDecimal valorUnitario;

    @Column(name = "CGFI_IPE")
    private BigDecimal valorCutoGerFinanceiro;

    @JoinColumns({
        @JoinColumn(name = "CODI_EMP", referencedColumnName = "CODI_EMP", insertable = false, updatable = false)
        , @JoinColumn(name = "PEDI_PED", referencedColumnName = "PEDI_PED", insertable = false, updatable = false)
        , @JoinColumn(name = "SERI_PED", referencedColumnName = "SERI_PED", insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pedido pedido;

    @JoinColumn(name = "CODI_PSV", referencedColumnName = "CODI_PSV", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Produto produto;

    public ItemPedidoPK getItemPedidoPK() {
        return itemPedidoPK;
    }

    public void setItemPedidoPK(ItemPedidoPK itemPedidoPK) {
        this.itemPedidoPK = itemPedidoPK;
    }

    public Date getEmissao() {
        return emissao;
    }

    public void setEmissao(Date emissao) {
        this.emissao = emissao;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.itemPedidoPK);
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
        if (!Objects.equals(this.itemPedidoPK, other.itemPedidoPK)) {
            return false;
        }
        return true;

    }

    public BigDecimal getValorCutoGerFinanceiro() {
        return valorCutoGerFinanceiro;
    }

    public void setValorCutoGerFinanceiro(BigDecimal valorCutoGerFinanceiro) {
        this.valorCutoGerFinanceiro = valorCutoGerFinanceiro;
    }

    @Transient
    public BigDecimal getValorTotal() {
        return this.getValorUnitario().multiply(new BigDecimal(this.getQuantidade()));

    }

    @Transient
    public BigDecimal getValorTotalItem() {
        return this.getValorUnitario().multiply(new BigDecimal(this.getQuantidade()));
    }

    @Transient
    public BigDecimal getValorTotalCustoItem() {
        return this.getValorCutoGerFinanceiro().multiply(new BigDecimal(this.getQuantidade()));
    }

    @Transient
    public BigDecimal getMargemItem() {
        BigDecimal resultado = valorUnitario.subtract(valorCutoGerFinanceiro);
        return resultado.divide(valorUnitario, 0).multiply(new BigDecimal(100));

    }

}
