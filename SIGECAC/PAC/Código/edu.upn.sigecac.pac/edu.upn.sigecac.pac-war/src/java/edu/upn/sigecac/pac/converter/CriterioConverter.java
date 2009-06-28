package edu.upn.sigecac.pac.converter;

import edu.upn.sigecac.pac.be.Criterio;
import edu.upn.sigecac.pac.beans.CriterioController;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class CriterioConverter implements Converter {

    public CriterioConverter() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null ) {
            return null;
        }
        try {
            Long id = new Long(value);
            CriterioController controller = (CriterioController) context.getApplication().getELResolver().getValue(context.getELContext(), null, "CriterioController");
            return controller.buscarCriterio(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof Criterio) {
            Criterio o = (Criterio) value;
            return o.getIdCriterio().toString();
        } else {
            throw new IllegalArgumentException("object " + value + " is of type " + value.getClass().getName() + "; expected type: edu.upn.sigecac.pac.be");
        }

    }
}
