/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pontorural.pedidovenda.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

/**
 *
 * @author rafael.lima
 */
@Entity
@Table(name = "PEDIDO")
@SequenceGenerator(name = "PEDIDO_SEQ", sequenceName = "AFV_PEDIDO_SEQ", initialValue = 1, allocationSize = 1)
public class Pedido implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @NotNull
    @JoinColumn(name = "CODI_EMP", referencedColumnName = "CODI_EMP")
    @ManyToOne
    private Empresa empresa;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PEDIDO_SEQ")
    @Column(name = "PEDI_PED")
    private Integer codigo;
    
    @Column(name = "SERI_PED")
    private String serie;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "CODI_TOP", referencedColumnName = "CODI_TOP")
    private Operacao operacao;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "CCFO_CFO", referencedColumnName = "CCFO_CFO")
    private Cfop cfop;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "CODI_CIC", referencedColumnName = "CODI_CIC")
    private Ciclo ciclo;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "COND_CON", referencedColumnName = "COND_CON")
    private Condicao condicao;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "CODI_TRA", referencedColumnName = "CODI_TRA")
    private Parceiro parceiro;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "PROP_PRO", referencedColumnName = "PROP_PRO")
    private Propriedade propriedade;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "COD1_PES", referencedColumnName = "CODI_PES")
    private Pessoal pessoal;
    
    @Column(name = "DEMI_PED")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date emissao;
    @NotNull
    @Column(name = "VCTO_PED")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date vencimento;
    
    @Column(name = "FPGT_PED")
    private String formaPagamento;
    
    @Column(name = "TOTA_PED")
    private BigDecimal valorTotalPedido = BigDecimal.TEN;
    
    @Column(name = "TPRO_PED")
    private BigDecimal valorTotalProdutos = BigDecimal.ZERO;
    
    @Column(name = "DESC_PED")
    private BigDecimal valorTotalDesconto = BigDecimal.ZERO;
    
    @Column(name = "TFAT_PED")
    private String tipoFaturamento;
    
    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itens = new ArrayList<>();
    
    public Empresa getEmpresa() {
        return empresa;
    }
    
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    
    public Integer getCodigo() {
        return codigo;
    }
    
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    
    public String getSerie() {
        return serie;
    }
    
    public void setSerie(String serie) {
        this.serie = serie;
    }
    
    public Operacao getOperacao() {
        return operacao;
    }
    
    public void setOperacao(Operacao operacao) {
        this.operacao = operacao;
    }
    
    public Cfop getCfop() {
        return cfop;
    }
    
    public void setCfop(Cfop cfop) {
        this.cfop = cfop;
    }
    
    public Ciclo getCiclo() {
        return ciclo;
    }
    
    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }
    
    public Condicao getCondicao() {
        return condicao;
    }
    
    public void setCondicao(Condicao condicao) {
        this.condicao = condicao;
    }
    
    public Parceiro getParceiro() {
        return parceiro;
    }
    
    public void setParceiro(Parceiro parceiro) {
        this.parceiro = parceiro;
    }
    
    public Propriedade getPropriedade() {
        return propriedade;
    }
    
    public void setPropriedade(Propriedade propriedade) {
        this.propriedade = propriedade;
    }
    
    public Pessoal getPessoal() {
        return pessoal;
    }
    
    public void setPessoal(Pessoal pessoal) {
        this.pessoal = pessoal;
    }
    
    public Date getEmissao() {
        return emissao;
    }
    
    public void setEmissao(Date emissao) {
        this.emissao = emissao;
    }
    
    public Date getVencimento() {
        return vencimento;
    }
    
    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }
    
    public String getFormaPagamento() {
        return formaPagamento;
    }
    
    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
    
    public BigDecimal getValorTotalPedido() {
        return valorTotalPedido;
    }
    
    public void setValorTotalPedido(BigDecimal valorTotalPedido) {
        this.valorTotalPedido = valorTotalPedido;
    }
    
    public BigDecimal getValorTotalProdutos() {
        return valorTotalProdutos;
    }
    
    public void setValorTotalProdutos(BigDecimal valorTotalProdutos) {
        this.valorTotalProdutos = valorTotalProdutos;
    }
    
    public BigDecimal getValorTotalDesconto() {
        return valorTotalDesconto;
    }
    
    public void setValorTotalDesconto(BigDecimal valorTotalDesconto) {
        this.valorTotalDesconto = valorTotalDesconto;
    }
    
    public String getTipoFaturamento() {
        return tipoFaturamento;
    }
    
    public void setTipoFaturamento(String tipoFaturamento) {
        this.tipoFaturamento = tipoFaturamento;
    }
    
    public List<ItemPedido> getItens() {
        return itens;
    }
    
    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }
    
    public boolean isNovo() {
        return getCodigo() == null;
    }
    
    public boolean isExistente() {
        return !isNovo();
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.codigo);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pedido other = (Pedido) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }
    
    public void recalcularValorTotal() {
        BigDecimal total = BigDecimal.ZERO;
        total = total.add(getValorTotalPedido().subtract(getValorTotalDesconto()));
        for (ItemPedido item : this.getItens()) {
            if (item.getProduto() != null && item.getProduto().getCodigo() != null) {
                total = total.add(item.getValorTotal());
            }
            
        }
        
        this.setValorTotalPedido(total);
    }
    
    public void adicionarItemVazio() {
        Produto produto = new Produto();
        produto.setQuantidadeEstoque(1);
        
        ItemPedido item = new ItemPedido();
        item.setProduto(produto);
        item.setPedido(this);
        this.getItens().add(0, item);
        
    }
    
}
