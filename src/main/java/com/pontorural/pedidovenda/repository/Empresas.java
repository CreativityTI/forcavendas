/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pontorural.pedidovenda.repository;

import com.pontorural.pedidovenda.model.Empresa;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author Creativity
 */
public class Empresas implements Serializable{
    
        private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Empresa porId(Integer codigo) {
        return manager.find(Empresa.class, codigo);
    }

    public List<Empresa> todasEmpresas() {
        return manager.createQuery("from Empresa e where e.codigo = 1", Empresa.class).getResultList();

    }

}
