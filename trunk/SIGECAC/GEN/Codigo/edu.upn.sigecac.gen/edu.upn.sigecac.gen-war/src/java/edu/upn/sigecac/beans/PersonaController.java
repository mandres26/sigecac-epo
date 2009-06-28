/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.sigecac.beans;

import edu.upn.sigecac.gen.bc.AlumnoFacadeLocal;
import edu.upn.sigecac.gen.bc.PersonaFacadeLocal;
import edu.upn.sigecac.gen.be.Persona;
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
public class PersonaController {

    private PersonaFacadeLocal local;
    private Persona persona;

    public PersonaController() {
        local = lookupPersonaFacade();
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public String nuevo() {
        persona = new Persona();
        return "nuevo";
    }

    public String cancelar() {
        persona = null;
        return "listar";
    }

    public String registrar() {
        try {
            if (persona != null) {
                local.create(persona);
                mostrarMensaje("Exito", "El registro de la persona se realizó exitosamente.", FacesMessage.SEVERITY_INFO);
            } else {
                mostrarMensaje("Error", "Asegúrese de haber creado una persona", FacesMessage.SEVERITY_ERROR);
                persona = new Persona();
                return "";
            }
        } catch (Exception e) {
            local = lookupPersonaFacade();
            mostrarMensaje(e.getMessage(), e.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
        return "listar";
    }

    public String actualizar() {
        try {
            if (persona != null) {
                local.edit(persona);
                mostrarMensaje("Exito", "La actualización de la persona se realizó exitosamente.", FacesMessage.SEVERITY_INFO);
            } else {
                mostrarMensaje("Error", "Asegúrese de haber seleccionado una persona", FacesMessage.SEVERITY_ERROR);
                return "";
            }
        } catch (Exception e) {
            local = lookupPersonaFacade();
            mostrarMensaje(e.getMessage(), e.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
        return "listar";
    }

    public String eliminar() {
        try {
            if (persona != null) {
                local.remove(persona);
                mostrarMensaje("Exito", "La eliminación de la persona se realizó exitosamente.", FacesMessage.SEVERITY_INFO);
            } else {
                mostrarMensaje("Error", "Asegúrese de haber seleccionado una persona", FacesMessage.SEVERITY_ERROR);
                return "";
            }
        } catch (Exception e) {
            local = lookupPersonaFacade();
            mostrarMensaje(e.getMessage(), e.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
        return "listar";
    }

    public List<Persona> getPersonas() {
        try {
            return local.findAll();
        } catch (Exception e) {
            local = lookupPersonaFacade();
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

    private PersonaFacadeLocal lookupPersonaFacade() {
        try {
            Context c = new InitialContext();
            return (PersonaFacadeLocal) c.lookup("java:comp/env/PersonaFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
