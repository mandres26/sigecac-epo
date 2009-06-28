/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.sigecac.seg.beans;

import edu.upn.sigecac.seg.be.Rol;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author Juaneco
 */
public class RolConverter implements Converter {

    public RolConverter() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.length() == 0) {
            return null;
        }
        try {
            Long idRol = new Long(value);
            RolController controller = (RolController) context.getApplication().getELResolver().getValue(context.getELContext(), null, "RolController");
            return controller.buscarID(idRol);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof Rol) {
            Rol o = (Rol) value;
            return o.getIdRol() == null ? "" : o.getIdRol().toString();
        } else {
            throw new IllegalArgumentException("object " + value + " is of type " + value.getClass().getName() + "; expected type: edu.upn.sigecac.seg.be.Rol");
        }
    }
}