/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.epo.beans;

import edu.upn.sigecac.gcu.be.Curso;
import edu.upn.sigecac.gen.bc.ClaseFacadeLocal;
import edu.upn.sigecac.gen.be.Clase;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.model.SelectItem;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author texai
 */
public class ClaseController {

    private ClaseFacadeLocal local;
    private Curso selCurso = null;

    public Curso getSelCurso() {
        return selCurso;
    }

    public void setSelCurso(Curso selCurso) {
        this.selCurso = selCurso;
    }

    public ClaseController() {
        local = lookup();
    }

    public List<Clase> listar() {

        try {
            return local.listar();
        } catch (Exception e) {
            local = lookup();
            e.printStackTrace();
        }
        return null;
    }


    public SelectItem[] getItemsClases() {
        List<Clase> lista = listar();
        SelectItem[] select = new SelectItem[lista.size()];
        int i = 0;
        for (Clase x : lista) {
            select[i++] = new SelectItem(x, x.getCodigo());
        }
        return select;
    }

    public List<Clase> getClasesPorCurso(){
        return listar();
    }

    public Clase porId(String id) {
        try {
            return local.porId(id);
        } catch (Exception e) {
            local = lookup();
            e.printStackTrace();
        }
        return null;
    }

    
    private ClaseFacadeLocal lookup() {
        try {
            Context c = new InitialContext();
            return (ClaseFacadeLocal) c.lookup("java:comp/env/ClaseFacadeBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }


}
