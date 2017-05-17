/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pontorural.pedidovenda.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

    @Id
    @GeneratedValue
    @Column(name = "PB2B_IPE")
    private Integer id;

    @Column(name = "DEMI_PED")
    @Temporal(TemporalType.DATE)
    private Date emissao;

    @Column(name = "SERI_PED")
    private String serie;

    @Column(name = "QTDE_IPE")
    private Double quantidade = Double.valueOf(1);

    @Column(name = "VLOR_IPE")
    private BigDecimal valorUnitario = BigDecimal.ZERO;

    @Column(name = "CGFI_IPE")
    private BigDecimal valorCutoGerFinanceiro;

    @JoinColumn(name = "PEDI_PED", referencedColumnName = "PEDI_PED")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pedido pedido;

    @JoinColumn(name = "CODI_EMP", referencedColumnName = "CODI_EMP")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empresa empresa;

    @JoinColumn(name = "CODI_PSV", referencedColumnName = "CODI_PSV")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Produto produto;

    @JoinColumn(name = "CCFO_CFO", referencedColumnName = "CCFO_CFO")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cfop cfop;

    public Date getEmissao() {
        return emissao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Cfop getCfop() {
        return cfop;
    }

    public void setCfop(Cfop cfop) {
        this.cfop = cfop;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
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

    @Transient
    public boolean isProdutoAssociado() {
        return this.getProduto() != null && this.getProduto().getCodigo() != null;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.id);
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
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}