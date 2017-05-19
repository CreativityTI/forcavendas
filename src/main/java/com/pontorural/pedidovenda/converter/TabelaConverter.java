/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pontorural.pedidovenda.converter;

import com.pontorural.pedidovenda.model.Operacao;
import com.pontorural.pedidovenda.model.Produto;
import com.pontorural.pedidovenda.model.Tabela;
import com.pontorural.pedidovenda.repository.Operacoes;
import com.pontorural.pedidovenda.repository.Produtos;
import com.pontorural.pedidovenda.repository.Tabelas;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author rafael.lima
 */
@FacesConverter(forClass = Tabela.class)
public class TabelaConverter implements Converter {

    @Inject
    private Tabelas tabelas;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Tabela retorno = null;

        if (StringUtils.isNotEmpty(value)) {
            Integer codigo = new Integer(value);
            retorno = tabelas.porId(codigo);
        }

        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            return ((Tabela) value).getTabela().toString();
        }

        return "";
    }

}
