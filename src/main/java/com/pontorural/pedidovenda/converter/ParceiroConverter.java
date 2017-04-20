/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pontorural.pedidovenda.converter;

import com.pontorural.pedidovenda.model.Ciclo;
import com.pontorural.pedidovenda.model.Condicao;
import com.pontorural.pedidovenda.model.Operacao;
import com.pontorural.pedidovenda.model.Parceiro;
import com.pontorural.pedidovenda.repository.Ciclos;
import com.pontorural.pedidovenda.repository.Condicoes;
import com.pontorural.pedidovenda.repository.Operacoes;
import com.pontorural.pedidovenda.repository.Parceiros;
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
@FacesConverter(forClass = Parceiro.class)
public class ParceiroConverter implements Converter {

    @Inject
    private Parceiros parceiros;

    

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Parceiro retorno = null;

        if (StringUtils.isNotEmpty(value)) {
            Integer codigo = new Integer(value);
            retorno = parceiros.porId(codigo);
        }

        return retorno;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            return ((Parceiro) value).getCodigo().toString();
        }

        return "";
    }

}
