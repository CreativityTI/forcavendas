/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pontorural.pedidovenda.converter;

import com.pontorural.pedidovenda.model.Empresa;
import com.pontorural.pedidovenda.repository.Empresas;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Creativity
 */
@FacesConverter(forClass = Empresa.class)
public class EmpresaConverter implements Converter {

    @Inject
    private Empresas empresas;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Empresa retorno = null;

        if (StringUtils.isNotEmpty(value)) {
            Integer codigo = new Integer(value);
            retorno = empresas.porId(codigo);
        }

        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            return ((Empresa) value).getCodigo().toString();
        }

        return "";
    }

}
