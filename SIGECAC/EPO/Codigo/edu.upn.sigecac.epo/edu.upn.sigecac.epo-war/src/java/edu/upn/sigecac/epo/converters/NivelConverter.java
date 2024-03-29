/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.epo.converters;

import edu.upn.sigecac.epo.beans.RubricaController;
import edu.upn.sigecac.pac.be.Nivel;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author texai
 */
public class NivelConverter implements Converter {

    RubricaController controlador = new RubricaController();

    public NivelConverter() {
    }


    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
         if (value == null || (value.trim().length() == 0)){
            return value;
        }else{
            return controlador.porIdNivel(value);
        }

            }


    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

         if (value == null) {
            return null;
        }
        if (value instanceof Nivel) {
            return ((Nivel) value).getIdNivel().toString();
        } else {
            return null;
        }


        }


}
