/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.epo.beans;

import edu.upn.sigecac.epo.bc.AlarmaLocal;
import edu.upn.sigecac.epo.be.Alarma;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Nancy Espinola
 */
public class AlarmaController {

    private AlarmaLocal local;
    private List<Alarma> lista;
    private Alarma alarma;

    public Alarma getAlarma() {
        return alarma;
    }

    public void setAlarma(Alarma alarma) {
        this.alarma = alarma;
    }

    public AlarmaController () {
    this.local = lookup();

    }

    public String nuevo(){
        alarma = new Alarma();
        return "alarma_nuevo";
    }

    public String Registrar (){
        try {
            local.registrar(alarma);
           
        } catch (Exception ex) {
            Logger.getLogger(AlarmaController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return "ok";
    }

        public List<Alarma> listar() {
        try {
            return local.listar();
        } catch (Exception e) {
            local = lookup();
            e.printStackTrace();
        }
        return null;
    }

    public List<Alarma> getListaAlarmas() {
        lista = listar();
        return lista;
    }


    private AlarmaLocal lookup() {
        try {
            Context c = new InitialContext();
            return (AlarmaLocal) c.lookup("java:comp/env/AlarmaBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }



}
