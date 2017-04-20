/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pontorural.pedidovenda.converter;

import com.pontorural.pedidovenda.model.Propriedade;
import com.pontorural.pedidovenda.repository.Propriedades;
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
@FacesConverter(forClass = Propriedade.class)
public class PropriedadeConverter implements Converter {

    @Inject
    private Propriedades propriedades;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Propriedade retorno = null;

        if (StringUtils.isNotEmpty(value)) {
            Integer codigo = new Integer(value);
            retorno = propriedades.porId(codigo);
        }

        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            return ((Propriedade) value).getCodigo().toString();
        }

        return "";
    }

}
