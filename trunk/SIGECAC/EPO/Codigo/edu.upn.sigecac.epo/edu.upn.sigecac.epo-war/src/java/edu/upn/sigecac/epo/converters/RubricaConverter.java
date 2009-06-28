/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.epo.converters;

import edu.upn.sigecac.epo.beans.RubricaController;
import edu.upn.sigecac.epo.be.Rubrica;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author texai
 */
public class RubricaConverter implements Converter {

    RubricaController controlador = new RubricaController();

    public RubricaConverter() {
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
        if (value instanceof Rubrica) {
            return ((Rubrica) value).getIdRubrica().toString();
        } else {
            return null;
        }


    }


}
