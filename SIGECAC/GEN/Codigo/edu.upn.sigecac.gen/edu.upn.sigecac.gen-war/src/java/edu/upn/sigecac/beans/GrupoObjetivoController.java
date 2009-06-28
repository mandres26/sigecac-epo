/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.sigecac.beans;

import edu.upn.sigecac.gen.bc.GrupoObjetivoFacadeLocal;
import edu.upn.sigecac.gen.be.GrupoObjetivo;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Administrador
 */
public class GrupoObjetivoController {

    private GrupoObjetivoFacadeLocal local;
    private GrupoObjetivo grupoObjetivo;

    public GrupoObjetivoController() {
        local = lookupGrupoObjetivoFacadeBean();
    }

    public GrupoObjetivo getGrupoObjetivo() {
        return grupoObjetivo;
    }

    public void setGrupoObjetivo(GrupoObjetivo grupoObjetivo) {
        this.grupoObjetivo = grupoObjetivo;
    }

    public String nuevo() {
        grupoObjetivo = new GrupoObjetivo();
        return "nuevo";
    }

    public String cancelar() {
        grupoObjetivo = null;
        return "listar";
    }

    public String registrar() {
        try {
            if (grupoObjetivo != null) {
                local.registrar(grupoObjetivo);
                mostrarMensaje("Exito", "El registro del Grupo Objetivo se realizó exitosamente.", FacesMessage.SEVERITY_INFO);
            } else {
                mostrarMensaje("Error", "Asegúrese de haber creado un Grupo Objetivo", FacesMessage.SEVERITY_ERROR);
                grupoObjetivo = new GrupoObjetivo();
                return "";
            }
        } catch (Exception e) {
            local = lookupGrupoObjetivoFacadeBean();
            mostrarMensaje(e.getMessage(), e.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
        return "listar";
    }

    public String actualizar() {
        try {
            if (grupoObjetivo != null) {
                local.editar(grupoObjetivo);
                mostrarMensaje("Exito", "La actualización del Grupo Objetivo se realizó exitosamente.", FacesMessage.SEVERITY_INFO);
            } else {
                mostrarMensaje("Error", "Asegúrese de haber seleccionado un Grupo Objetivo", FacesMessage.SEVERITY_ERROR);
                return "";
            }
        } catch (Exception e) {
            local = lookupGrupoObjetivoFacadeBean();
            mostrarMensaje(e.getMessage(), e.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
        return "listar";
    }

    public String eliminar() {
        try {
            if (grupoObjetivo != null) {
                local.eliminar(grupoObjetivo);
                mostrarMensaje("Exito", "La eliminación del Grupo Objetivo se realizó exitosamente.", FacesMessage.SEVERITY_INFO);
            } else {
                mostrarMensaje("Error", "Asegúrese de haber seleccionado un Grupo Objetivo", FacesMessage.SEVERITY_ERROR);
                return "";
            }
        } catch (Exception e) {
            local = lookupGrupoObjetivoFacadeBean();
            mostrarMensaje(e.getMessage(), e.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
        return "listar";
    }

    public GrupoObjetivo buscar(Long idGrupoObjetivo) {
        try {
            return local.buscarPorId(idGrupoObjetivo);
        } catch (Exception e) {
            mostrarMensaje(e.getMessage(), e.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
        return null;
    }

    public List<GrupoObjetivo> getGruposObjetivo() {
        try {
            return local.listar();
        } catch (Exception e) {
            local = lookupGrupoObjetivoFacadeBean();
            e.printStackTrace();
        }
        return null;
    }

    public SelectItem[] getGruposObjetivoSI() {
        SelectItem[] select = null;
        try {
            List<GrupoObjetivo> lista = getGruposObjetivo();
            if (lista != null) {
                select = new SelectItem[lista.size() + 1];
                int i = 0;
                select[i++] = new SelectItem(null, "Seleccione un Grupo Objetivo");
                for (GrupoObjetivo go : lista) {
                    select[i++] = new SelectItem(go, go.getNombre());
                }
            } else {
                select = new SelectItem[1];
                select[0] = new SelectItem(null, "No se encontraron Grupos Objetivos");
            }
        } catch (Exception e) {
            mostrarMensaje(e.getMessage(), e.getMessage(), FacesMessage.SEVERITY_ERROR);
            select = new SelectItem[1];
            select[0] = new SelectItem(null, "Error al consultar los datos");
        }
        return select;
    }

    //Metodo para mostrar mensajes en la pagina
    public void mostrarMensaje(String resumen, String detalle, FacesMessage.Severity severidad) {
        try {
            FacesMessage fm = new FacesMessage(severidad, resumen, detalle);
            FacesContext.getCurrentInstance().addMessage(fm.toString(), fm);
        } catch (Exception e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext.getCurrentInstance().addMessage(fm.toString(), fm);
        }
    }

    private GrupoObjetivoFacadeLocal lookupGrupoObjetivoFacadeBean() {
        try {
            Context c = new InitialContext();
            return (GrupoObjetivoFacadeLocal) c.lookup("java:comp/env/GrupoObjetivoFacadeBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
