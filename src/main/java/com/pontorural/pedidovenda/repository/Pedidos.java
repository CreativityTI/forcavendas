/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pontorural.pedidovenda.repository;

import com.pontorural.pedidovenda.model.Empresa;
import com.pontorural.pedidovenda.model.Pedido;

import com.pontorural.pedidovenda.repository.filter.PedidoFilter;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

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

    public Pedido salvar(Pedido pedido) {

        return this.manager.merge(pedido);

    }

    @SuppressWarnings("unchecked")
    public List<Pedido> filtrados(PedidoFilter filtro
    ) {
        Session session = this.manager.unwrap(Session.class);

        Criteria criteria = session.createCriteria(Pedido.class);

        if (filtro.getNumeroDe() != null) {
            // id deve ser maior ou igual (ge = greater or equals) a filtro.numeroDe
            criteria.add(Restrictions.ge("codigo", filtro.getNumeroDe()));
        }

        if (filtro.getNumeroAte() != null) {
            // id deve ser menor ou igual (le = lower or equal) a filtro.numeroDe
            criteria.add(Restrictions.le("codigo", filtro.getNumeroAte()));
        }

        if (filtro.getEmissaoDe() != null) {
            criteria.add(Restrictions.ge("emissao", filtro.getEmissaoDe()));
        }

        if (filtro.getEmissaoAte() != null) {
            criteria.add(Restrictions.le("emissao", filtro.getEmissaoAte()));
        }

        return criteria.addOrder(Order.asc("codigo")).list();

    }
}
