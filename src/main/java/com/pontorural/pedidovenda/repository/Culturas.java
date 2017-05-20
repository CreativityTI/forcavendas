/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pontorural.pedidovenda.repository;

import com.pontorural.pedidovenda.model.Cultura;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author Creativity
 */
public class Culturas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Cultura porId(Integer codigo) {
        return manager.find(Cultura.class, codigo);
    }

    public List<Cultura> todasCulturas() {
        return manager.createQuery("from Cultura", Cultura.class).getResultList();

    }

}
