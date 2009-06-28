/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.epo.beans;

import edu.upn.sigecac.epo.bc.ComentarioLocal;
import edu.upn.sigecac.epo.be.Comentario;
import java.util.Date;
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
public class ComentarioController {

    private ComentarioLocal local;
    private List<Comentario> lista;
    private Comentario comentario;

    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }

    public ComentarioController () {
    this.local = lookup();

    }

    public String verPublicacion(){
        nuevo();
        return "publicacion_ver";
    }


    public void nuevo(){
        comentario = new Comentario();
        //return "comentario_nuevo";
    }

    public String Registrar (){
        try {
            comentario.setFecha(new Date());
            local.registrar(comentario);
            nuevo();

        } catch (Exception ex) {
            Logger.getLogger(ComentarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "ok";
    }

        public List<Comentario> listar() {
        try {
            return local.listar();
        } catch (Exception e) {
            local = lookup();
            e.printStackTrace();
        }
        return null;
    }

    public List<Comentario> getListaComentarios() {
        lista = listar();
        return lista;
    }



    private ComentarioLocal lookup() {
        try {
            Context c = new InitialContext();
            return (ComentarioLocal) c.lookup("java:comp/env/ComentarioBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }




}
