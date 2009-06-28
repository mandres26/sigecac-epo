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

    public String guardar() {
        String ret = "";
        try {
            if(periodoAcademico.getInicio().before(periodoAcademico.getFin())){
                local.registrar(periodoAcademico);
                ret = "ok";
            }else{
                ret = "error";
            }
        } catch (Exception ex) {
            Logger.getLogger(PeticionController.class.getName()).log(Level.SEVERE, null, ex);
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
