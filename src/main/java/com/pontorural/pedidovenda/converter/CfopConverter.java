/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pontorural.pedidovenda.converter;

import com.pontorural.pedidovenda.model.Cfop;
import com.pontorural.pedidovenda.model.Operacao;
import com.pontorural.pedidovenda.repository.Cfops;
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
@FacesConverter(forClass = Cfop.class)
public class CfopConverter implements Converter {

    @Inject
    private Cfops cfops;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Cfop retorno = null;

        if (StringUtils.isNotEmpty(value)) {
            String codigo = new String(value);
            retorno = cfops.porId(codigo);
        }

        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            return ((Cfop) value).getCodigo();
        }

        return "";
    }

}
