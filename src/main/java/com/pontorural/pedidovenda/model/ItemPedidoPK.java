/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pontorural.pedidovenda.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Creativity
 */
@Embeddable
public class ItemPedidoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "CODI_EMP")
    private Integer empresa;
    @Basic(optional = false)
    @Column(name = "PEDI_PED")
    private Integer pedido;
    @Basic(optional = false)
    @Column(name = "SERI_PED")
    private String serie;
    @Basic(optional = false)
    @Column(name = "CODI_PSV")
    private String produto;

    public ItemPedidoPK() {
    }

    public ItemPedidoPK(Integer empresa, Integer pedido, String serie, String produto) {
        this.empresa = empresa;
        this.pedido = pedido;
        this.serie = serie;
        this.produto = produto;
    }

    public Integer getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Integer empresa) {
        this.empresa = empresa;
    }

    public Integer getPedido() {
        return pedido;
    }

    public void setPedido(Integer pedido) {
        this.pedido = pedido;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.empresa);
        hash = 67 * hash + Objects.hashCode(this.pedido);
        hash = 67 * hash + Objects.hashCode(this.serie);
        hash = 67 * hash + Objects.hashCode(this.produto);
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
        final ItemPedidoPK other = (ItemPedidoPK) obj;
        if (!Objects.equals(this.serie, other.serie)) {
            return false;
        }
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        if (!Objects.equals(this.empresa, other.empresa)) {
            return false;
        }
        if (!Objects.equals(this.pedido, other.pedido)) {
            return false;
        }
        return true;
    }

}