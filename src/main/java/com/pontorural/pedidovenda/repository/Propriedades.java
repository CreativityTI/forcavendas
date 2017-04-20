/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pontorural.pedidovenda.repository;

import com.pontorural.pedidovenda.model.Parceiro;
import com.pontorural.pedidovenda.model.Propriedade;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author Creativity
 */

public class Propriedades implements Serializable{

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Propriedade porId(Integer codigo) {
        return manager.find(Propriedade.class, codigo);
    }
    
    public List<Propriedade> todasPropriedadesPorParceiro(Parceiro parceiro){
        return manager.createQuery("from Propriedade where parceiro = :parceiro", Propriedade.class).setParameter("parceiro", parceiro).getResultList();
        
    }

}
