/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.epo.converters;

import edu.upn.sigecac.epo.beans.ClaseController;
import edu.upn.sigecac.gen.be.Clase;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author texai
 */
public class ClaseConverter implements Converter {

    private ClaseController controlador = new ClaseController();

    public ClaseConverter() {
    }

    

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || (value.trim().length() == 0)){
            return value;
        }else{
            return controlador.porId(value);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof Clase) {
            return ((Clase) value).getIdClase().toString();
        } else {
            return null;
        }
    }

}
