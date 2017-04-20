/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pontorural.pedidovenda.repository;

import com.pontorural.pedidovenda.model.Cfop;
import com.pontorural.pedidovenda.model.Ciclo;
import com.pontorural.pedidovenda.model.Condicao;
import com.pontorural.pedidovenda.model.Operacao;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author rafael.lima
 */
public class Condicoes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Condicao porId(Integer codigo) {
        return manager.find(Condicao.class, codigo);
    }

    public List<Condicao> todasCondicoes() {
        return manager.createQuery("from Condicao c where c.codigo = 101", Condicao.class).getResultList();

    }

}
