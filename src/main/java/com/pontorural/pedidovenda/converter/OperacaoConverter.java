/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pontorural.pedidovenda.converter;

import com.pontorural.pedidovenda.model.Operacao;
import com.pontorural.pedidovenda.repository.Operacoes;
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
@FacesConverter(forClass = Operacao.class)
public class OperacaoConverter implements Converter {

    @Inject
    private Operacoes operacoes;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Operacao retorno = null;

        if (StringUtils.isNotEmpty(value)) {
            Integer id = new Integer(value);
            retorno = operacoes.porId(id);
        }

        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            return ((Operacao) value).getCodigo().toString();
        }

        return "";
    }

}
