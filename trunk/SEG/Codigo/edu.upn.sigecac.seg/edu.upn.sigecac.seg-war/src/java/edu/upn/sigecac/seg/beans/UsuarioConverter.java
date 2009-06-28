package edu.upn.sigecac.seg.beans;

import edu.upn.sigecac.seg.be.Usuario;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class UsuarioConverter implements Converter {

    public UsuarioConverter() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.length() == 0) {
            return null;
        }
        try {
            Long idUsuario = new Long(value);
            UsuarioController controller = (UsuarioController) context.getApplication().getELResolver().getValue(context.getELContext(), null, "UsuarioController");
            return controller.buscarID(idUsuario);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof Usuario) {
            Usuario o = (Usuario) value;
            return o.getIdUsuario() == null ? "" : o.getIdUsuario().toString();
        } else {
            throw new IllegalArgumentException("object " + value + " is of type " + value.getClass().getName() + "; expected type: edu.upn.sigecac.seg.be.Usuario");
        }
    }
}