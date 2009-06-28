/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.epo.converters;

import edu.upn.sigecac.epo.beans.TipoArchivoController;
import edu.upn.sigecac.epo.be.TipoArchivo;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;


/**
 *
 * @author texai
 */

public class TipoArchivoConverter implements Converter {

    TipoArchivoController controlador = new TipoArchivoController();

    public TipoArchivoConverter() {
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
        if (value instanceof TipoArchivo) {
            return ((TipoArchivo) value).getIdTipoArchivo().toString();
        } else {
            return null;
        }


    }


}
