/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.sigecac.beans;

import edu.upn.sigecac.gen.bc.ComiteEjecutivoFacadeLocal;
import edu.upn.sigecac.gen.be.ComiteEjecutivo;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Administrador
 */
public class ComiteEjecutivoController {

    private ComiteEjecutivoFacadeLocal local;
    private ComiteEjecutivo comiteEjecutivo;

    public ComiteEjecutivoController() {
        local = lookupComiteEjecutivoFacadeBean();
    }

    public ComiteEjecutivo getComiteEjecutivo() {
        return comiteEjecutivo;
    }

    public void setComiteEjecutivo(ComiteEjecutivo comiteEjecutivo) {
        this.comiteEjecutivo = comiteEjecutivo;
    }

    public String nuevo() {
        comiteEjecutivo = new ComiteEjecutivo();
        return "nuevo";
    }

    public String cancelar() {
        comiteEjecutivo = null;
        return "listar";
    }

    public String registrar() {
        try {
            if (comiteEjecutivo != null) {
                local.registrar(comiteEjecutivo);
                mostrarMensaje("Exito", "El registro del Comité Ejecutivo se realizó exitosamente.", FacesMessage.SEVERITY_INFO);
            } else {
                mostrarMensaje("Error", "Asegúrese de haber creado un Comité Ejecutivo", FacesMessage.SEVERITY_ERROR);
                comiteEjecutivo = new ComiteEjecutivo();
                return "";
            }
        } catch (Exception e) {
            local = lookupComiteEjecutivoFacadeBean();
            mostrarMensaje(e.getMessage(), e.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
        return "listar";
    }

    public String actualizar() {
        try {
            if (comiteEjecutivo != null) {
                local.editar(comiteEjecutivo);
                mostrarMensaje("Exito", "La actualización del Comité Ejecutivo se realizó exitosamente.", FacesMessage.SEVERITY_INFO);
            } else {
                mostrarMensaje("Error", "Asegúrese de haber seleccionado un Comité Ejecutivo", FacesMessage.SEVERITY_ERROR);
                return "";
            }
        } catch (Exception e) {
            local = lookupComiteEjecutivoFacadeBean();
            mostrarMensaje(e.getMessage(), e.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
        return "listar";
    }

    public String eliminar() {
        try {
            if (comiteEjecutivo != null) {
                local.eliminar(comiteEjecutivo);
                mostrarMensaje("Exito", "La eliminación del Comité Ejecutivo se realizó exitosamente.", FacesMessage.SEVERITY_INFO);
            } else {
                mostrarMensaje("Error", "Asegúrese de haber seleccionado un Comité Ejecutivo", FacesMessage.SEVERITY_ERROR);
                return "";
            }
        } catch (Exception e) {
            local = lookupComiteEjecutivoFacadeBean();
            mostrarMensaje(e.getMessage(), e.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
        return "listar";
    }

    public List<ComiteEjecutivo> getComitesEjecutivos() {
        try {
            return local.listar();
        } catch (Exception e) {
            local = lookupComiteEjecutivoFacadeBean();
            e.printStackTrace();
        }
        return null;
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

    private ComiteEjecutivoFacadeLocal lookupComiteEjecutivoFacadeBean() {
        try {
            Context c = new InitialContext();
            return (ComiteEjecutivoFacadeLocal) c.lookup("java:comp/env/ComiteEjecutivoFacadeBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
