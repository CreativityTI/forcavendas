/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pontorural.pedidovenda.repository;

import com.pontorural.pedidovenda.model.Pedido;
import java.io.Serializable;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author Creativity
 */
public class Pedidos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;
    
       public Pedido porId(Integer codigo) {
        return manager.find(Pedido.class, codigo);
    }

    public Pedido guardar(Pedido pedido) {
        return this.manager.merge(pedido);
    }
}
