/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pontorural.pedidovenda.repository;

import com.pontorural.pedidovenda.model.Produto;
import com.pontorural.pedidovenda.model.Tabela;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

/**
 *
 * @author Creativity
 */
public class Tabelas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Tabela porId(Integer codigo) {
        return manager.find(Tabela.class, codigo);
    }

    public List<Tabela> todasTabelas() {
        return manager.createQuery("from Tabela where situacao = 'A'", Tabela.class).getResultList();

    }

    public List<Tabela> porProduto(Produto produto) {
        try {
            return manager.createQuery("from Tabela t where t.produto = :produto and t.situacao = 'A'"
                    + "and t.cabtab.situacao = 'A'", Tabela.class)
                    .setParameter("produto", produto)
                    .getResultList();
        } catch (NoResultException e) {
            return null;
        }
        
       
    }

}
