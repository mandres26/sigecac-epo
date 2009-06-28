package edu.upn.sigecac.pac.converter;

import edu.upn.sigecac.gcu.be.Curso;
import edu.upn.sigecac.pac.beans.ResultadoProgramaController;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class CursoConverter implements Converter {

    public CursoConverter() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null) {
            return null;
        }
        try {
            Long id = new Long(value);
            ResultadoProgramaController controller = (ResultadoProgramaController) context.getApplication().getVariableResolver().resolveVariable(context, "ResultadoProgramaController");
            return controller.buscarCurso(id);
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
        if (value instanceof Curso) {
            Curso o = (Curso) value;
            return o.getIdCurso().toString();
        } else {
            throw new IllegalArgumentException("object " + value + " is of type " + value.getClass().getName() + "; expected type: edu.upn.sigecac.gcu.be");
        }

    }
}
