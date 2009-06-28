/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.sigecac.epo.converters;

import edu.upn.sigecac.epo.beans.CursoController;
import edu.upn.sigecac.gcu.be.Curso;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author texai
 */
public class CursoConverter implements Converter {

    CursoController controlador = new CursoController();

    public CursoConverter() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null) {
            return value;
        } else {
            try {
                Long id = Long.parseLong(value);
                return controlador.porId(id);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof Curso) {
            return ((Curso) value).getIdCurso().toString();
        } else {
            return null;
        }
    }
}
