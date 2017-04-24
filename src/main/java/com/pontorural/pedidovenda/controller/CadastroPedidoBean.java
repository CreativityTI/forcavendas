/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pontorural.pedidovenda.controller;

import com.pontorural.pedidovenda.model.Cfop;
import com.pontorural.pedidovenda.model.Ciclo;
import com.pontorural.pedidovenda.model.Condicao;
import com.pontorural.pedidovenda.model.Empresa;
import com.pontorural.pedidovenda.model.Operacao;
import com.pontorural.pedidovenda.model.Parceiro;
import com.pontorural.pedidovenda.model.Pedido;
import com.pontorural.pedidovenda.model.Pessoal;
import com.pontorural.pedidovenda.model.Propriedade;
import com.pontorural.pedidovenda.repository.Cfops;
import com.pontorural.pedidovenda.repository.Ciclos;
import com.pontorural.pedidovenda.repository.Condicoes;
import com.pontorural.pedidovenda.repository.Empresas;
import com.pontorural.pedidovenda.repository.Operacoes;
import com.pontorural.pedidovenda.repository.Parceiros;
import com.pontorural.pedidovenda.repository.Pessoas;
import com.pontorural.pedidovenda.repository.Propriedades;
import com.pontorural.pedidovenda.service.CadastroPedidoService;
import com.pontorural.pedidovenda.util.jsf.FacesUtil;
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

    private Operacao operacao;

    private Parceiro parceiro;

    @Inject
    private Operacoes repositoryOperacoes;

    @Inject
    private Cfops repositoryCfops;

    @Inject
    private Ciclos repositoryCiclos;

    @Inject
    private Condicoes repositoryCondicoes;

    @Inject
    private Parceiros repositoryParceiros;

    @Inject
    private Propriedades repositoryPropriedades;

    @Inject
    private Pessoas respositoryPessoas;

    @Inject
    private Empresas repositoryEmpresas;

    private List<Operacao> operacoes;
    private List<Cfop> cfops;
    private List<Ciclo> ciclos;
    private List<Condicao> condicoes;
    private List<Parceiro> parceiros;
    private List<Propriedade> propriedades;
    private List<Pessoal> pessoas;
    private List<Empresa> empresas;

    @Inject
    private CadastroPedidoService cadastroPedidoService;

    public CadastroPedidoBean() {
        limpar();

    }

    public void inicializar() {
        if (this.pedido == null) {
            limpar();
        }
        if (FacesUtil.isNotPostback()) {
            this.operacoes = this.repositoryOperacoes.todasOperacoes();
            this.ciclos = this.repositoryCiclos.todosCiclos();
            this.condicoes = this.repositoryCondicoes.todasCondicoes();
            this.empresas = this.repositoryEmpresas.todasEmpresas();
            if (this.operacao != null) {
                carregarCfops();

            }

            if (this.parceiro != null) {
                carregarPropriedades();
            }
        }
    }

    public List<Parceiro> completarCliente(String nome) {
        return this.repositoryParceiros.porNome(nome);
    }

    public List<Pessoal> completarConsultor(String nome) {
        return this.respositoryPessoas.porNome(nome);
    }

    public void carregarCfops() {

        cfops = repositoryCfops.todosCFOPSPorOperacao(pedido.getOperacao());

    }

    public void carregarPropriedades() {
        propriedades = repositoryPropriedades.todasPropriedadesPorParceiro(pedido.getParceiro());
    }

    public void salvar() {

        this.pedido = this.cadastroPedidoService.salvar(this.pedido);

        FacesUtil.addInfoMessage("Pedido saldo com sucesso!");
    }

    private void limpar() {

        pedido = new Pedido();

    }

    public boolean isEditando() {
        return this.pedido.getCodigo() != null;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
        if (this.pedido != null) {
            this.operacao = this.pedido.getOperacao();
            this.parceiro = this.pedido.getParceiro();

        }
    }

    public List<Operacao> getOperacoes() {
        return operacoes;
    }

    public void setOperacoes(List<Operacao> operacoes) {
        this.operacoes = operacoes;
    }

    public List<Cfop> getCfops() {
        return cfops;
    }

    public void setCfops(List<Cfop> cfops) {
        this.cfops = cfops;
    }

    public Operacao getOperacao() {
        return operacao;
    }

    public void setOperacao(Operacao operacao) {
        this.operacao = operacao;
    }

    public List<Ciclo> getCiclos() {
        return ciclos;
    }

    public void setCiclos(List<Ciclo> ciclos) {
        this.ciclos = ciclos;
    }

    public List<Condicao> getCondicoes() {
        return condicoes;
    }

    public void setCondicoes(List<Condicao> condicoes) {
        this.condicoes = condicoes;
    }

    public Parceiro getParceiro() {
        return parceiro;
    }

    public void setParceiro(Parceiro parceiro) {
        this.parceiro = parceiro;
    }

    public List<Parceiro> getParceiros() {
        return parceiros;
    }

    public void setParceiros(List<Parceiro> parceiros) {
        this.parceiros = parceiros;
    }

    public List<Propriedade> getPropriedades() {
        return propriedades;
    }

    public void setPropriedades(List<Propriedade> propriedades) {
        this.propriedades = propriedades;
    }

    public List<Pessoal> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoal> pessoas) {
        this.pessoas = pessoas;
    }

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<Empresa> empresas) {
        this.empresas = empresas;
    }

}
