/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pontorural.pedidovenda.repository;

import com.pontorural.pedidovenda.model.Cfop;
import com.pontorural.pedidovenda.model.Operacao;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author rafael.lima
 */
public class Cfops implements Serializable{
    

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Cfop porId(String codigo) {
        return manager.find(Cfop.class, codigo);
    }

    public List<Cfop> todosCFOPS() {
        return manager.createQuery("from Cfop c where c.operacao = 20", Cfop.class).getResultList();

    }
    
  
    
     public List<Cfop> todosCFOPSPorOperacao(Operacao operacao) {
        return manager.createQuery("from Cfop where operacao = :operacao", Cfop.class).setParameter("operacao", operacao).getResultList();

    }
}
