/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.sigecac.beans;

import edu.upn.sigecac.gen.bc.AlumnoFacadeLocal;
import edu.upn.sigecac.gen.be.Alumno;
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
public class AlumnoController {

    private AlumnoFacadeLocal local;
    private Alumno alumno;
    private String criterio;

    public AlumnoController() {
        local = lookupAlumnoFacadeBean();
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public String getCriterio() {
        return criterio;
    }

    public void setCriterio(String criterio) {
        this.criterio = criterio;
    }

    public String nuevo() {
        alumno = new Alumno();
        return "nuevo";
    }

    public String cancelar() {
        alumno = null;
        return "listar";
    }

    public String registrar() {
        try {
            if (alumno != null) {
                local.registrar(alumno);
                mostrarMensaje("Exito", "El registro del alumno se realizó exitosamente.", FacesMessage.SEVERITY_INFO);
            } else {
                mostrarMensaje("Error", "Asegúrese de haber creado un alumno", FacesMessage.SEVERITY_ERROR);
                alumno = new Alumno();
                return "";
            }
        } catch (Exception e) {
            local = lookupAlumnoFacadeBean();
            mostrarMensaje(e.getMessage(), e.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
        return "listar";
    }

    public String actualizar() {
        try {
            if (alumno != null) {
                local.editar(alumno);
                mostrarMensaje("Exito", "La actualización del alumno se realizó exitosamente.", FacesMessage.SEVERITY_INFO);
            } else {
                mostrarMensaje("Error", "Asegúrese de haber seleccionado un alumno", FacesMessage.SEVERITY_ERROR);
                return "";
            }
        } catch (Exception e) {
            local = lookupAlumnoFacadeBean();
            mostrarMensaje(e.getMessage(), e.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
        return "listar";
    }

    public String eliminar() {
        try {
            if (alumno != null) {
                local.eliminar(alumno);
                mostrarMensaje("Exito", "La eliminación del alumno se realizó exitosamente.", FacesMessage.SEVERITY_INFO);
            } else {
                mostrarMensaje("Error", "Asegúrese de haber seleccionado un alumno", FacesMessage.SEVERITY_ERROR);
                return "";
            }
        } catch (Exception e) {
            local = lookupAlumnoFacadeBean();
            mostrarMensaje(e.getMessage(), e.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
        return "listar";
    }

    public List<Alumno> getAlumnos() {
        try {
            return local.listar();
        } catch (Exception e) {
            local = lookupAlumnoFacadeBean();
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

    private AlumnoFacadeLocal lookupAlumnoFacadeBean() {
        try {
            Context c = new InitialContext();
            return (AlumnoFacadeLocal) c.lookup("java:comp/env/AlumnoFacadeBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
