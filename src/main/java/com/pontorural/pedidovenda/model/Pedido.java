/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pontorural.pedidovenda.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/**
 *
 * @author rafael.lima
 */
@Entity
@Table(name = "PEDIDO")
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "PEDI_PED")
    private Integer codigo;

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

    @Column(name = "DEMI_PED")
    private LocalDateTime emissao;
    @NotNull
    @Column(name = "VCTO_PED")
    private LocalDateTime vencimento;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

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

    public LocalDateTime getEmissao() {
        return emissao;
    }

    public void setEmissao(LocalDateTime emissao) {
        this.emissao = emissao;
    }

    public LocalDateTime getVencimento() {
        return vencimento;
    }

    public void setVencimento(LocalDateTime vencimento) {
        this.vencimento = vencimento;
    }

    public Propriedade getPropriedade() {
        return propriedade;
    }

    public void setPropriedade(Propriedade propriedade) {
        this.propriedade = propriedade;
    }

    @Transient
    public boolean isNovo() {
        return getCodigo() == null;
    }

    @Transient
    public boolean isExistente() {
        return !isNovo();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.codigo);
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
