/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pontorural.pedidovenda.service;

import com.pontorural.pedidovenda.model.Empresa;
import com.pontorural.pedidovenda.model.Pedido;
import com.pontorural.pedidovenda.repository.Pedidos;
import com.pontorural.pedidovenda.util.jpa.Transactional;
import java.io.Serializable;
import java.util.Date;
import javax.inject.Inject;

/**
 *
 * @author Creativity
 */
public class CadastroPedidoService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Pedidos pedidos;

    @Transactional
    public Pedido salvar(Pedido pedido) {
        if (pedido.isNovo()) {
            pedido.setEmissao(new Date());
            pedido.setSerie("PE");
            pedido.setFormaPagamento("03");
            pedido.setTipoFaturamento("1");
        }

        pedido = this.pedidos.guardar(pedido);
        return pedido;
    }

}
