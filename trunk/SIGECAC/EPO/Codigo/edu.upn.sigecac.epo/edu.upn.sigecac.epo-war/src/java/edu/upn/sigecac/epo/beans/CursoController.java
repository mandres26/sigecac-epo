/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.sigecac.epo.beans;

import edu.upn.sigecac.gcu.bc.CursoFacadeLocal;
import edu.upn.sigecac.gcu.be.Curso;
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
public class CursoController {

    private CursoFacadeLocal local;

    public CursoController() {
        local = lookup();
    }

    public List<Curso> listar() {

        try {
            return local.listar();
        } catch (Exception e) {
            local = lookup();
            e.printStackTrace();
        }
        return null;
    }

    public SelectItem[] getItemsCursos() {
        List<Curso> lista = listar();
        SelectItem[] select = new SelectItem[lista.size()];
        int i = 0;
        for (Curso x : lista) {
            select[i++] = new SelectItem(x, x.getNombre());
        }
        return select;
    }

    public Curso porId(Long id) {
        try {
            return local.buscar(id);
        } catch (Exception e) {
            local = lookup();
            e.printStackTrace();
        }
        return null;
    }

    private CursoFacadeLocal lookup() {
        try {
            Context c = new InitialContext();
            return (CursoFacadeLocal) c.lookup("java:comp/env/CursoFacadeBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
