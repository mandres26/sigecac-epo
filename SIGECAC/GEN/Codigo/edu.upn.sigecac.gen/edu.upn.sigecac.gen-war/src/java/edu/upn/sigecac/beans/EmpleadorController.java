/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.sigecac.beans;

import edu.upn.sigecac.gen.bc.EmpleadorFacadeLocal;
import edu.upn.sigecac.gen.be.Empleador;
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
public class EmpleadorController {

    private Empleador empleador;
    private EmpleadorFacadeLocal local;

    public EmpleadorController() {
        local = lookupEmpleadorFacadeBean();
    }

    public Empleador getEmpleador() {
        return empleador;
    }

    public void setEmpleador(Empleador empleador) {
        this.empleador = empleador;
    }

    public String nuevo() {
        empleador = new Empleador();
        return "nuevo";
    }

    public String cancelar() {
        empleador = null;
        return "listar";
    }

    public String registrar() {
        try {
            if (empleador != null) {
                local.registrar(empleador);
                mostrarMensaje("Exito", "El registro del empleador se realizó exitosamente.", FacesMessage.SEVERITY_INFO);
            } else {
                mostrarMensaje("Error", "Asegúrese de haber creado un empleador", FacesMessage.SEVERITY_ERROR);
                empleador = new Empleador();
                return "";
            }
        } catch (Exception e) {
            local = lookupEmpleadorFacadeBean();
            mostrarMensaje(e.getMessage(), e.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
        return "listar";
    }

    public String actualizar() {
        try {
            if (empleador != null) {
                local.editar(empleador);
                mostrarMensaje("Exito", "La actualización del empleador se realizó exitosamente.", FacesMessage.SEVERITY_INFO);
            } else {
                mostrarMensaje("Error", "Asegúrese de haber seleccionado un empleador", FacesMessage.SEVERITY_ERROR);
                return "";
            }
        } catch (Exception e) {
            local = lookupEmpleadorFacadeBean();
            mostrarMensaje(e.getMessage(), e.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
        return "listar";
    }

    public String eliminar() {
        try {
            if (empleador != null) {
                local.eliminar(empleador);
                mostrarMensaje("Exito", "La eliminación del empleador se realizó exitosamente.", FacesMessage.SEVERITY_INFO);
            } else {
                mostrarMensaje("Error", "Asegúrese de haber seleccionado un empleador", FacesMessage.SEVERITY_ERROR);
                return "";
            }
        } catch (Exception e) {
            local = lookupEmpleadorFacadeBean();
            mostrarMensaje(e.getMessage(), e.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
        return "listar";
    }

    public List<Empleador> getEmpleadores() {
        try {
            return local.listar();
        } catch (Exception e) {
            local = lookupEmpleadorFacadeBean();
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

    private EmpleadorFacadeLocal lookupEmpleadorFacadeBean() {
        try {
            Context c = new InitialContext();
            return (EmpleadorFacadeLocal) c.lookup("java:comp/env/EmpleadorFacadeBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
