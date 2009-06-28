package edu.upn.sigecac.pac.converter;

import edu.upn.sigecac.pac.be.Nivel;
import edu.upn.sigecac.pac.beans.NivelController;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class NivelConverter implements Converter {

    public NivelConverter() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null) {
            return null;
        }
        try {
            Long id = new Long(value);
            NivelController controller = (NivelController) context.getApplication().getELResolver().getValue(context.getELContext(), null, "NivelController");
            return controller.buscarNivel(id);
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof Nivel) {
            Nivel o = (Nivel) value;
            return o.getIdNivel().toString();
        } else {
            throw new IllegalArgumentException("object " + value + " is of type " + value.getClass().getName() + "; expected type: edu.upn.sigecac.pac.be");
        }

    }
}