/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pontorural.pedidovenda.repository.filter;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Creativity
 */
public class PedidoFilter implements Serializable {

	private static final long serialVersionUID = 1L;
        
        private Integer numeroDe;
        private Integer numeroAte;
        private Date emissaoDe;
        private Date emissaoAte;

    public Integer getNumeroDe() {
        return numeroDe;
    }

    public void setNumeroDe(Integer numeroDe) {
        this.numeroDe = numeroDe;
    }

    public Integer getNumeroAte() {
        return numeroAte;
    }

    public void setNumeroAte(Integer numeroAte) {
        this.numeroAte = numeroAte;
    }

    public Date getEmissaoDe() {
        return emissaoDe;
    }

    public void setEmissaoDe(Date emissaoDe) {
        this.emissaoDe = emissaoDe;
    }

    public Date getEmissaoAte() {
        return emissaoAte;
    }

    public void setEmissaoAte(Date emissaoAte) {
        this.emissaoAte = emissaoAte;
    }
        
        
        

}