/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pontorural.pedidovenda.service;

import com.pontorural.pedidovenda.model.ItemPedido;
import com.pontorural.pedidovenda.model.Pedido;
import com.pontorural.pedidovenda.repository.Pedidos;
import com.pontorural.pedidovenda.util.jpa.Transactional;
import com.sun.jndi.url.iiop.iiopURLContext;
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
        ItemPedido item = new ItemPedido();
        if (pedido.isNovo()) {
            pedido.setEmissao(new Date());
            pedido.setSerie("PE");
            pedido.setFormaPagamento("03");
            pedido.setTipoFaturamento("1");
       
        }
        
        pedido.recalcularValorTotal();
        
        if (pedido.getItens().isEmpty()) {
            throw new NegocioException("O Pedido deve possuir pelo menos um item.");
        }
        
        if (pedido.isValorTotalNegativo()) {
            throw new NegocioException("O Valor total do pedido não pode ser negativo");
        }
        
        pedido = this.pedidos.salvar(pedido);
        return pedido;
    }
    
}
