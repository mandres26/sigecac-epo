/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.epo.converters;

import edu.upn.sigecac.epo.beans.RubricaController;
import edu.upn.sigecac.pac.be.ResultadoPrograma;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author texai
 */
public class ResultadoProgramaConverter implements Converter {

    RubricaController controlador = new RubricaController();

    public ResultadoProgramaConverter() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        if (value == null || (value.trim().length() == 0)){
            return value;
        }else{
            return controlador.porIdRP(value);
        }
        
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof ResultadoPrograma) {
            return ((ResultadoPrograma) value).getIdResultadoPrograma().toString();
        } else {
            return null;
        }
    }



}
