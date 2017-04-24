/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pontorural.pedidovenda.converter;

import com.pontorural.pedidovenda.model.Pedido;
import com.pontorural.pedidovenda.repository.Pedidos;
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
@FacesConverter(forClass = Pedido.class)
public class PedidoConverter implements Converter {

    @Inject
    private Pedidos pedidos;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Pedido retorno = null;

        if (StringUtils.isNotEmpty(value)) {
            Integer codigo = new Integer(value);
            retorno = pedidos.porId(codigo);
        }

        return retorno;
    }

    @Override

    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Pedido pedido = (Pedido) value;
            return pedido.getCodigo() == null ? null : pedido.getCodigo().toString();
        }

        return "";
    }

}
