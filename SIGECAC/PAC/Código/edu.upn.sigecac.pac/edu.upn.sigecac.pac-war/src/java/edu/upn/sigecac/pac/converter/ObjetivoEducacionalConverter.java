package edu.upn.sigecac.pac.converter;

import edu.upn.sigecac.pac.be.ObjetivoEducacional;
import edu.upn.sigecac.pac.beans.ObjetivoEducacionalController;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class ObjetivoEducacionalConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.length() == 0) {
            return null;
        }
        try {
            Long id = new Long(value);
            ObjetivoEducacionalController controller = (ObjetivoEducacionalController) context.getApplication().getELResolver().getValue(context.getELContext(), null, "ObjetivoEducacionalController");
            return controller.buscarObjetivos(id);
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof ObjetivoEducacional) {
            ObjetivoEducacional o = (ObjetivoEducacional) value;
            return o.getIdObjetivoEducacional() == null ? "" : o.getIdObjetivoEducacional().toString();
        } else {
            throw new IllegalArgumentException("object " + value + " is of type " + value.getClass().getName() + "; expected type: edu.upn.sigecac.pac.be");
        }

    }
}
