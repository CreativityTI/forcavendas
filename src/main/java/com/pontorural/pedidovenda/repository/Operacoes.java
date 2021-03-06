/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pontorural.pedidovenda.repository;

import com.pontorural.pedidovenda.model.Operacao;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author rafael.lima
 */
public class Operacoes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Operacao porId(Integer codigo) {
        return manager.find(Operacao.class, codigo);
    }

    public List<Operacao> todasOperacoes() {
        return manager.createQuery("from Operacao o where o.codigo IN( 20, 81)", Operacao.class).getResultList();

    }
}
