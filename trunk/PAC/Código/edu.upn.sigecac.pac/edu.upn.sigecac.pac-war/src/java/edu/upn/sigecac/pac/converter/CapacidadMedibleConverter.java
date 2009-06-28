package edu.upn.sigecac.pac.converter;
import edu.upn.sigecac.pac.be.CapacidadMedible;
import edu.upn.sigecac.pac.beans.CapacidadMedibleController;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.component.UIComponent;

public class CapacidadMedibleConverter implements Converter{

    public CapacidadMedibleConverter() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null) {
            return null;
        }
        try {
            Long id = new Long(value);
            CapacidadMedibleController controller = (CapacidadMedibleController) context.getApplication().getELResolver().getValue(context.getELContext(), null, "CapacidadMedibleController");
            return controller.buscarCapacidadMedible(id);

        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof CapacidadMedible) {
            CapacidadMedible o = (CapacidadMedible) value;
            return o.getIdCapacidadMedible().toString();
        } else {
            throw new IllegalArgumentException("object " + value + " is of type " + value.getClass().getName() + "; expected type: edu.upn.sigecac.pac.be");
        }

    }
}
