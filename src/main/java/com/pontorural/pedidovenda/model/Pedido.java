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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

/**
 *
 * @author rafael.lima
 */
@Entity
@Table(name = "PEDIDO")
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @JoinColumn(name = "CODI_EMP", referencedColumnName = "CODI_EMP")
    @ManyToOne
    private Empresa empresa;

    @Id
    @Column(name = "PEDI_PED")
    private Integer codigo;

    @Column(name = "SERI_PED")
    private String serie;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "CODI_TOP", referencedColumnName = "CODI_TOP")
    private Operacao operacao;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "CCFO_CFO", referencedColumnName = "CCFO_CFO")
    private Cfop cfop;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "CODI_CIC", referencedColumnName = "CODI_CIC")
    private Ciclo ciclo;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "COND_CON", referencedColumnName = "COND_CON")
    private Condicao condicao;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "CODI_TRA", referencedColumnName = "CODI_TRA")
    private Parceiro parceiro;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "PROP_PRO", referencedColumnName = "PROP_PRO")
    private Propriedade propriedade;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "COD1_PES", referencedColumnName = "CODI_PES")
    private Pessoal pessoal;

    @Column(name = "DEMI_PED")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date emissao;
    @NotNull
    @Column(name = "VCTO_PED")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date vencimento;

    @Column(name = "FPGT_PED")
    private String formaPagamento;

    @Column(name = "TOTA_PED")
    private BigDecimal totalPedido;

    @Column(name = "TPRO_PED")
    private BigDecimal totalProduto;

    @Column(name = "TFAT_PED")
    private String tipoFaturamento;

    public Operacao getOperacao() {
        return operacao;
    }

    public void setOperacao(Operacao operacao) {
        this.operacao = operacao;
    }

    public Cfop getCfop() {
        return cfop;
    }

    public void setCfop(Cfop cfop) {
        this.cfop = cfop;
    }

    public Ciclo getCiclo() {
        return ciclo;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }

    public Condicao getCondicao() {
        return condicao;
    }

    public void setCondicao(Condicao condicao) {
        this.condicao = condicao;
    }

    public Parceiro getParceiro() {
        return parceiro;
    }

    public void setParceiro(Parceiro parceiro) {
        this.parceiro = parceiro;
    }

    public Date getEmissao() {
        return emissao;
    }

    public void setEmissao(Date emissao) {
        this.emissao = emissao;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public Propriedade getPropriedade() {
        return propriedade;
    }

    public void setPropriedade(Propriedade propriedade) {
        this.propriedade = propriedade;
    }

    public Pessoal getPessoal() {
        return pessoal;
    }

    public void setPessoal(Pessoal pessoal) {
        this.pessoal = pessoal;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public BigDecimal getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(BigDecimal totalPedido) {
        this.totalPedido = totalPedido;
    }

    public BigDecimal getTotalProduto() {
        return totalProduto;
    }

    public void setTotalProduto(BigDecimal totalProduto) {
        this.totalProduto = totalProduto;
    }

    public String getTipoFaturamento() {
        return tipoFaturamento;
    }

    public void setTipoFaturamento(String tipoFaturamento) {
        this.tipoFaturamento = tipoFaturamento;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public boolean isNovo() {
        return getCodigo() == null;
    }

    public boolean isExistente() {
        return !isNovo();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.codigo);
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
        final Pedido other = (Pedido) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

}
