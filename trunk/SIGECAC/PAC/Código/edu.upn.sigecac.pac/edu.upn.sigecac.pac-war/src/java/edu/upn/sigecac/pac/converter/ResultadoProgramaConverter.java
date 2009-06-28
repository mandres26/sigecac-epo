/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.sigecac.pac.converter;

import edu.upn.sigecac.pac.be.ResultadoPrograma;
import edu.upn.sigecac.pac.beans.ResultadoProgramaController;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class ResultadoProgramaConverter implements Converter {

    public ResultadoProgramaConverter() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.length() == 0) {
            return null;
        }
        try {
            Long id = new Long(value);
            ResultadoProgramaController controller = (ResultadoProgramaController) context.getApplication().getELResolver().getValue(context.getELContext(), null, "ResultadoProgramaController");
            return controller.buscarResultados(id);
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof ResultadoPrograma) {
            ResultadoPrograma o = (ResultadoPrograma) value;
            return o.getIdResultadoPrograma() == null ? "" : o.getIdResultadoPrograma().toString();
        } else {
            throw new IllegalArgumentException("object " + value + " is of type " + value.getClass().getName() + "; expected type: edu.upn.sigecac.pac.be");
        }

    }
}
