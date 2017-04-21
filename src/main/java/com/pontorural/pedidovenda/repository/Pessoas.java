/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pontorural.pedidovenda.repository;

import com.pontorural.pedidovenda.model.Pessoal;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author Creativity
 */
public class Pessoas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Pessoal porId(Integer codigo) {
        return manager.find(Pessoal.class, codigo);
    }

    public List<Pessoal> todasPessoas() {
        return manager.createQuery("from Pessoal", Pessoal.class).getResultList();

    }

    public List<Pessoal> porNome(String nome) {
        return this.manager.createQuery("from Pessoal "
                + "where upper(nome) like :nome", Pessoal.class)
                .setParameter("nome", nome.toUpperCase() + "%")
                .getResultList();
    }

}
