/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pontorural.pedidovenda.converter;

import com.pontorural.pedidovenda.model.Ciclo;
import com.pontorural.pedidovenda.model.Cultura;
import java.util.Map;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.apache.commons.lang3.StringUtils;


/**
 *
 * @author rafael.lima
 */
@FacesConverter(forClass = Cultura.class)
public class CulturaConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null) {
            return this.getAttributesFrom(component).get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (StringUtils.isNotEmpty(value.toString())) {
            Cultura classe = (Cultura) value;
            this.addAttribute(component, classe);
            Integer codigo = classe.getCodigo();
            if (codigo != null) {
                return String.valueOf(codigo);
            }
        }
        return (String) value;
    }

    private void addAttribute(UIComponent component, Cultura classe) {
        this.getAttributesFrom(component).put(classe.getCodigo().toString(), classe);
    }

    private Map<String, Object> getAttributesFrom(UIComponent component) {
        return component.getAttributes();
    }
}
