/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pontorural.pedidovenda.controller;

import com.pontorural.pedidovenda.model.Operacao;
import com.pontorural.pedidovenda.model.Pedido;
import com.pontorural.pedidovenda.repository.Operacoes;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author rafael.lima
 */
@Named
@ViewScoped
public class CadastroPedidoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Pedido pedido;

    @Inject
    private Operacoes repositoryOperacoes;
    
    private List<Operacao> operacoes;

    public CadastroPedidoBean() {
        limpar();

    }

    public void inicializar() {

        if (this.pedido == null) {
            limpar();
        }
        
        this.operacoes = this.repositoryOperacoes.todasOperacoes();

    }

    private void limpar() {
        
        pedido = new Pedido();
        

    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public List<Operacao> getOperacoes() {
        return operacoes;
    }

    public void setOperacoes(List<Operacao> operacoes) {
        this.operacoes = operacoes;
    }
    
    
    
    

}