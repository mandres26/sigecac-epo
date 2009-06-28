/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.sigecac.epo.beans;

import edu.upn.sigecac.epo.bc.PeriodoAcademicoLocal;
import edu.upn.sigecac.epo.be.PeriodoAcademico;
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
 * @author texai
 */
public class PeriodoAcademicoController {

    private PeriodoAcademicoLocal local;
    private List<PeriodoAcademico> lista;
    private PeriodoAcademico periodoAcademico;

    public PeriodoAcademico getPeriodoAcademico() {
        return periodoAcademico;
    }

    public void setPeriodoAcademico(PeriodoAcademico periodoAcademico) {
        this.periodoAcademico = periodoAcademico;
    }

    public PeriodoAcademicoController() {
        this.local = lookup();
    }

    public String nuevo(){
        periodoAcademico = new PeriodoAcademico();
        return "periodo_nuevo";
    }

    public String editar(){
        try {
            local.editar(periodoAcademico);

        } catch (Exception ex) {
            Logger.getLogger(PeriodoAcademicoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "ok";
    }


    public String eliminar(){
        try {
            local.eliminar(periodoAcademico);

        } catch (Exception ex) {
            Logger.getLogger(PeriodoAcademicoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "ok";
    }

    public String guardar() {
        String ret = "";
        try {
            if(periodoAcademico.getInicio().before(periodoAcademico.getFin())){
                local.registrar(periodoAcademico);
                mostrarMensaje("Exito", "El registro del Periodo Academico se ha realizado exitosamente.", FacesMessage.SEVERITY_INFO);
                ret = "ok";
            }else{
                mostrarMensaje("Error", "Asegúrese de haber creado un alumno", FacesMessage.SEVERITY_ERROR);
                periodoAcademico = new PeriodoAcademico();
                ret = "error";
            }
        } catch (Exception e) {
            local = lookup();
            mostrarMensaje(e.getMessage(), e.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
        return ret;
    }

    public List<PeriodoAcademico> listar() {
        try {
            return local.listar();
        } catch (Exception e) {
            local = lookup();
            e.printStackTrace();
        }
        return null;
    }

    public List<PeriodoAcademico> getListaPeriodosAcademicos() {
        lista = listar();
        return lista;
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


    private PeriodoAcademicoLocal lookup() {
        try {
            Context c = new InitialContext();
            return (PeriodoAcademicoLocal) c.lookup("java:comp/env/PeriodoAcademicoBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
