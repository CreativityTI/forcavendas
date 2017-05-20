/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pontorural.pedidovenda.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Creativity
 */
@Entity
@Table(name = "CABTAB")
public class Cabtab implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "TABE_CTA")
    private Integer cabTab;

    @Column(name = "DESC_CTA")
    private String descricao;

    @Column(name = "SITU_CTA")
    private Character situacao;

    @Column(name = "DTBA_CTA")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date vencimento;
    
        
    @Column(name = "FAPV_CTA")
    private Double jurosAposVencimento;

    public Integer getCabTab() {
        return cabTab;
    }

    public void setCabTab(Integer cabTab) {
        this.cabTab = cabTab;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Character getSituacao() {
        return situacao;
    }

    public void setSituacao(Character situacao) {
        this.situacao = situacao;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public Double getJurosAposVencimento() {
        return jurosAposVencimento;
    }

    public void setJurosAposVencimento(Double jurosAposVencimento) {
        this.jurosAposVencimento = jurosAposVencimento;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.cabTab);
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
        final Cabtab other = (Cabtab) obj;
        if (!Objects.equals(this.cabTab, other.cabTab)) {
            return false;
        }
        return true;
    }

}
