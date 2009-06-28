package edu.upn.sigecac.converters;

import edu.upn.sigecac.beans.GrupoObjetivoController;
import edu.upn.sigecac.gen.be.GrupoObjetivo;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

public class GrupoObjetivoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) throws ConverterException {
        if (arg2 == null) {
            return null;
        }
        try {
            Long codigo = Long.parseLong(arg2);
            GrupoObjetivoController goc = new GrupoObjetivoController();
            return goc.buscar(codigo);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) throws ConverterException {
        if (arg2 == null) {
            return null;
        }
        if (arg2 instanceof GrupoObjetivo) {
            GrupoObjetivo go = (GrupoObjetivo) arg2;
            return go.getIdGrupoObjetivo().toString();
        } else {
            throw new IllegalArgumentException("El objeto que se ha pasado no es de tipo Grupo Objetivo");
        }
    }
}
