/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pontorural.pedidovenda.repository;

import com.pontorural.pedidovenda.model.Cfop;
import com.pontorural.pedidovenda.model.Ciclo;
import com.pontorural.pedidovenda.model.Operacao;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author rafael.lima
 */
public class Ciclos implements Serializable{
    

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Ciclo porId(Integer codigo) {
        return manager.find(Ciclo.class, codigo);
    }

    public List<Ciclo> todosCiclos() {
        return manager.createQuery("from Ciclo c where c.situacao = 'A'"
                + "order by c.descricao desc", Ciclo.class).getResultList();

    }
    
  
    
     public List<Cfop> todosCFOPSPorOperacao(Operacao operacao) {
        return manager.createQuery("from Cfop where codigo in (510200,610200, 592200, 692200) and operacao = :operacao", Cfop.class).setParameter("operacao", operacao).getResultList();

    }
}
