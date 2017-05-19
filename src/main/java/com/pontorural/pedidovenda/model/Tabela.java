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
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TABELA")
public class Tabela implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "TABE_CTA")
    private Integer tabela;

    @JoinColumn(name = "CODI_PSV", referencedColumnName = "CODI_PSV")
    @ManyToOne(fetch = FetchType.LAZY)
    private Produto produto;

    @Column(name = "BASI_TAB")
    private BigDecimal valorPrecoVenda;

    @Column(name = "SITU_TAB")
     private Character situacao;

    public Integer getTabela() {
        return tabela;
    }

    public void setTabela(Integer tabela) {
        this.tabela = tabela;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public BigDecimal getValorPrecoVenda() {
        return valorPrecoVenda;
    }

    public void setValorPrecoVenda(BigDecimal valorPrecoVenda) {
        this.valorPrecoVenda = valorPrecoVenda;
    }

    public Character getSituacao() {
        return situacao;
    }

    public void setSituacao(Character situacao) {
        this.situacao = situacao;
    }


    
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.tabela);
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
        final Tabela other = (Tabela) obj;
        if (!Objects.equals(this.tabela, other.tabela)) {
            return false;
        }
        return true;
    }

}
