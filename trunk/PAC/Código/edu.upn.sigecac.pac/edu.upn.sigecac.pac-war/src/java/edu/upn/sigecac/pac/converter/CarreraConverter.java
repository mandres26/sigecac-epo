/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.pac.converter;

//import edu.upn.sigecac.gcu.be.Carrera;
import edu.upn.sigecac.gcu.be.Carrera;
import edu.upn.sigecac.pac.beans.ObjetivoEducacionalController;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;


public class CarreraConverter implements Converter{
@Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.length() == 0) {
            return null;
        }
        try {
            Long id = new Long(value);
            ObjetivoEducacionalController controller = (ObjetivoEducacionalController) context.getApplication().getELResolver().getValue(context.getELContext(), null, "ObjetivoEducacionalController");
            return controller.buscarCarrera(id);
//            return null;//quitar
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof Carrera) {
            Carrera o = (Carrera) value;
            return o.getIdCarrera() == null ? "" : o.getIdCarrera().toString();
        } else {
            throw new IllegalArgumentException("object " + value + " is of type " + value.getClass().getName() + "; expected type: edu.upn.sigecac.gcu.be.Carrera");
        }
//        return "";//quitar
    }
}
