/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.sigecac.beans;

import edu.upn.sigecac.gen.bc.DocenteFacadeLocal;
import edu.upn.sigecac.gen.be.Docente;
import edu.upn.sigecac.gen.be.TipoDocente;
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
public class DocenteController {

    private DocenteFacadeLocal local;
    private Docente docente;
    private String criterio;

    public DocenteController() {
        local = lookupDocenteFacadeBean();
    }

    public String getCriterio() {
        return criterio;
    }

    public void setCriterio(String criterio) {
        this.criterio = criterio;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public String nuevo() {
        docente = new Docente();
        return "nuevo";
    }

    public String cancelar() {
        docente = null;
        return "listar";
    }

    public String registrar() {
        try {
            if (docente != null) {
                local.registrar(docente);
                mostrarMensaje("Exito", "El registro del docente se realizó exitosamente.", FacesMessage.SEVERITY_INFO);
            } else {
                mostrarMensaje("Error", "Asegúrese de haber creado un docente", FacesMessage.SEVERITY_ERROR);
                docente = new Docente();
                return "";
            }
        } catch (Exception e) {
            local = lookupDocenteFacadeBean();
            mostrarMensaje(e.getMessage(), e.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
        return "listar";
    }

    public String actualizar() {
        try {
            if (docente != null) {
                local.editar(docente);
                mostrarMensaje("Exito", "La actualización del docente se realizó exitosamente.", FacesMessage.SEVERITY_INFO);
            } else {
                mostrarMensaje("Error", "Asegúrese de haber seleccionado un docente", FacesMessage.SEVERITY_ERROR);
                return "";
            }
        } catch (Exception e) {
            local = lookupDocenteFacadeBean();
            mostrarMensaje(e.getMessage(), e.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
        return "listar";
    }

    public String eliminar() {
        try {
            if (docente != null) {
                local.eliminar(docente);
                mostrarMensaje("Exito", "La eliminación del docente se realizó exitosamente.", FacesMessage.SEVERITY_INFO);
            } else {
                mostrarMensaje("Error", "Asegúrese de haber seleccionado un docente", FacesMessage.SEVERITY_ERROR);
                return "";
            }
        } catch (Exception e) {
            local = lookupDocenteFacadeBean();
            mostrarMensaje(e.getMessage(), e.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
        return "listar";
    }

    public List<Docente> getDocentes() {
        try {
            return local.listar();
        } catch (Exception e) {
            local = lookupDocenteFacadeBean();
            e.printStackTrace();
        }
        return null;
    }

    public SelectItem[] getTiposDocente() {
        TipoDocente[] lista = TipoDocente.values();
        SelectItem[] select = new SelectItem[lista.length];
        int i = 0;
        for (TipoDocente td : lista) {
            select[i++] = new SelectItem(td, td.toString());
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

    private DocenteFacadeLocal lookupDocenteFacadeBean() {
        try {
            Context c = new InitialContext();
            return (DocenteFacadeLocal) c.lookup("java:comp/env/DocenteFacadeBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
