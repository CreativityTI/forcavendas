/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pontorural.pedidovenda.converter;

import com.pontorural.pedidovenda.model.Produto;
import com.pontorural.pedidovenda.repository.Produtos;
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
@FacesConverter(forClass = Produto.class)
public class ProdutoConverter implements Converter {

    @Inject
    private Produtos produtos;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Produto retorno = null;

        if (StringUtils.isNotEmpty(value)) {
            String codigo = value;
            retorno = produtos.porId(codigo);
        }

        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            return ((Produto) value).getCodigo();
        }

        return "";
    }

}
