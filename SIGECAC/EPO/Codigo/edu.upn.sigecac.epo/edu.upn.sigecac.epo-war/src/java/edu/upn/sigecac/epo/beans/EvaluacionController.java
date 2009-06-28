/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.epo.beans;

import edu.upn.sigecac.epo.bc.EvaluacionCriterioLocal;
import edu.upn.sigecac.epo.bc.EvaluacionPublicacionLocal;
import edu.upn.sigecac.epo.bc.PublicacionLocal;
import edu.upn.sigecac.epo.be.Peticion;
import edu.upn.sigecac.epo.be.Publicacion;
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
public class EvaluacionController {
    
    EvaluacionPublicacionLocal localEvaluacionPublicacion;
    EvaluacionCriterioLocal localEvaluacionCriterio;
    PublicacionLocal localPublicacion;
    Peticion peticionSeleccionada;
    Publicacion publicacionSeleccionada;
    List<Publicacion> listaPublicaciones;



    public EvaluacionController() {
        localEvaluacionPublicacion = lookupEvaluacionPublicacionBean();
        localEvaluacionCriterio = lookupEvaluacionCriterioBean();
        localPublicacion = lookupPublicacionBean();
        //PublicacionController ct = new PublicacionController();
        //localPublicacion = ct.lookup();
    }

    public Peticion getPeticionSeleccionada() {
        return peticionSeleccionada;
    }

    public void setPeticionSeleccionada(Peticion peticionSeleccionada) {
        this.peticionSeleccionada = peticionSeleccionada;
    }

    public Publicacion getPublicacionSeleccionada() {
        return publicacionSeleccionada;
    }

    public void setPublicacionSeleccionada(Publicacion publicacionSeleccionada) {
        this.publicacionSeleccionada = publicacionSeleccionada;
    }

    public List<Publicacion> getListaPublicaciones() {
        return listaPublicaciones;
    }

    public void setListaPublicaciones(List<Publicacion> listaPublicaciones) {
        this.listaPublicaciones = listaPublicaciones;
    }

    public List<Publicacion> getListaPublicacionesPorPeticion() {
        try {
            return localPublicacion.listarPorPeticion(peticionSeleccionada);
        } catch (Exception e) {
            localPublicacion = lookupPublicacionBean();
            e.printStackTrace();
        }
        return null;
    }

    public String irASeleccionarPeticion(){
        listaPublicaciones = getListaPublicacionesPorPeticion();
        return "publicacion_seleccionarCalificar";
    }

    private EvaluacionPublicacionLocal lookupEvaluacionPublicacionBean() {
        try {
            Context c = new InitialContext();
            return (EvaluacionPublicacionLocal) c.lookup("java:comp/env/EvaluacionPublicacionBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private PublicacionLocal lookupPublicacionBean() {
        try {
            Context c = new InitialContext();
            return (PublicacionLocal) c.lookup("java:comp/env/PublicacionBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private EvaluacionCriterioLocal lookupEvaluacionCriterioBean() {
        try {
            Context c = new InitialContext();
            return (EvaluacionCriterioLocal) c.lookup("java:comp/env/EvaluacionCriterioBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    

}
