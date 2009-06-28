/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.sigecac.seg.beans;

import edu.upn.sigecac.seg.be.Grupo;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class GrupoConverter implements Converter {

    public GrupoConverter() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.length() == 0) {
            return null;
        }
        try {
            Long idGrupo = new Long(value);
            GrupoController controller = (GrupoController) context.getApplication().getELResolver().getValue(context.getELContext(), null, "GrupoController");
            return controller.buscarID(idGrupo);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof Grupo) {
            Grupo o = (Grupo) value;
            return o.getIdGrupo() == null ? "" : o.getIdGrupo().toString();
        } else {
            throw new IllegalArgumentException("object " + value + " is of type " + value.getClass().getName() + "; expected type: edu.upn.sigecac.seg.be.Grupo");
        }
    }
}