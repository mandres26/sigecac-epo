/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.epo.beans;

import edu.upn.sigecac.epo.bc.ComentarioLocal;
import edu.upn.sigecac.epo.be.Comentario;
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

    private ComentarioLocal localComentario;
    private Comentario comentarioSeleccionado;

    public Comentario getComentarioSeleccionado() {
        return comentarioSeleccionado;
    }

    public void setComentarioSeleccionado(Comentario comentarioSeleccionado) {
        this.comentarioSeleccionado = comentarioSeleccionado;
    }

    public ComentarioController() {
        this.localComentario = lookupComentario();
    }

    public String validarComentario(){
        String r = "error";
        try {
            comentarioSeleccionado.setValidado(true);
            localComentario.editar(comentarioSeleccionado);
            r= "ok";
        } catch (Exception ex) {
            Logger.getLogger(ComentarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    public String descartarComentario(){
        String r = "error";
        try {
            //comentarioSeleccionado.setValidado(true);
            localComentario.eliminar(comentarioSeleccionado);
            r= "ok";
        } catch (Exception ex) {
            Logger.getLogger(ComentarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }



    private ComentarioLocal lookupComentario() {
        try {
            Context c = new InitialContext();
            return (ComentarioLocal) c.lookup("java:comp/env/ComentarioBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }


}
