/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pontorural.pedidovenda.repository;

import com.pontorural.pedidovenda.model.Produto;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

/**
 *
 * @author Creativity
 */
public class Produtos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Produto guardar(Produto produto) {
        return manager.merge(produto);
    }

    public Produto porSku(String codigo) {
        try {
            return manager.createQuery("from Produto where upper(codigo) = :codigo", Produto.class)
                    .setParameter("codigo", codigo.toUpperCase())
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public Produto porId(String codigo) {
        return manager.find(Produto.class, codigo);
    }

    public List<Produto> porDescricao(String descricao) {
        return this.manager.createQuery("from Produto where upper(descricao) like :descricao", Produto.class)
                .setParameter("descricao", descricao.toUpperCase() + "%").getResultList();
    }

}
