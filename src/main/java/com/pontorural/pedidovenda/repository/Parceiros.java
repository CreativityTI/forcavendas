/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pontorural.pedidovenda.repository;

import com.pontorural.pedidovenda.model.Parceiro;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author rafael.lima
 */
public class Parceiros implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Parceiro porId(Integer codigo) {
        return manager.find(Parceiro.class, codigo);
    }

    public List<Parceiro> todosParceiros() {
        return manager.createQuery("from Parceiro", Parceiro.class).getResultList();

    }

    public List<Parceiro> porNome(String nome) {
        return this.manager.createQuery("from Parceiro "
                + "where upper(nome) like :nome", Parceiro.class)
                .setParameter("nome", nome.toUpperCase() + "%")
                .getResultList();
    }

}
