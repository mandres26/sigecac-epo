/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.epo.beans;

import edu.upn.sigecac.epo.bc.TipoArchivoLocal;
import edu.upn.sigecac.epo.be.TipoArchivo;
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
public class TipoArchivoController {

    private TipoArchivoLocal local;



    public TipoArchivoController() {
        local = lookup();
    }

    public List<TipoArchivo> listar() {
        try {
            return local.listar();
        } catch (Exception e) {
            local = lookup();
            e.printStackTrace();
        }
        return null;
    }

    public TipoArchivo porId(String id) {
        try {
            return local.porId(id);
        } catch (Exception e) {
            local = lookup();
            e.printStackTrace();
        }
        return null;
    }

    public SelectItem[] getItemsTipoArchivos() {
        List<TipoArchivo> lista = listar();
        SelectItem[] select = new SelectItem[lista.size()];
        int i = 0;
        for (TipoArchivo x : lista) {
            select[i++] = new SelectItem(x, x.getNombre());
        }
        return select;
    }

    private TipoArchivoLocal lookup() {
        try {
            Context c = new InitialContext();
            return (TipoArchivoLocal) c.lookup("java:comp/env/TipoArchivoBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }




}

