/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.sigecac.epo.beans;

import edu.upn.sigecac.epo.bc.EsquemaGrupoLocal;
import edu.upn.sigecac.epo.be.EsquemaGrupo;
import edu.upn.sigecac.gen.be.Clase;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author texai
 */
public class EsquemaGrupoController {

    private EsquemaGrupoLocal local;
    private Clase selClase = null;

    public Clase getSelClase() {
        return selClase;
    }

    public void setSelClase(Clase selClase) {
        this.selClase = selClase;
    }

    public EsquemaGrupoController() {
        local = lookup();
    }

    public List<EsquemaGrupo> listarPorClase(String idClase) {
        try {
            return local.listarPorClase(idClase);
        } catch (Exception e) {
            local = lookup();
            e.printStackTrace();
        }
        return null;
    }

    public SelectItem[] getItemsEsquemasGrupoPorClase() {
        List<EsquemaGrupo> lista = listarPorClase(selClase.getIdClase().toString());
        SelectItem[] select = new SelectItem[lista.size()];
        int i = 0;
        for (EsquemaGrupo x : lista) {
            select[i++] = new SelectItem(x, x.getNombre());
        }
        return select;
    }

    public SelectItem[] getItemsEsquemasGrupoPorClaseRV() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Clase c = (Clase) fc.getApplication().getVariableResolver().resolveVariable(fc, "item");
        List<EsquemaGrupo> lista = listarPorClase(c.getIdClase().toString());
        SelectItem[] select = new SelectItem[lista.size()];
        int i = 0;
        for (EsquemaGrupo x : lista) {
            select[i++] = new SelectItem(x, x.getNombre());
        }
        return select;
    }

    public List<EsquemaGrupo> getEsquemasGrupoPorClase() {
        return listarPorClase(this.selClase.getIdClase().toString());
    }

    private EsquemaGrupoLocal lookup() {
        try {
            Context c = new InitialContext();
            return (EsquemaGrupoLocal) c.lookup("java:comp/env/EsquemaGrupoBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}