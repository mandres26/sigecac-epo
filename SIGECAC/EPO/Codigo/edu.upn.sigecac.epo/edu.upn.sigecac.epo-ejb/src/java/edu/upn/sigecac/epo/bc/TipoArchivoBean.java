/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.epo.bc;

import edu.upn.sigecac.epo.be.TipoArchivo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author texai
 */
@Stateless
public class TipoArchivoBean implements TipoArchivoLocal {

    @PersistenceContext(name = "edu.upn.sigecac.epo-ejbPU")
    private EntityManager em;

    public TipoArchivoBean() {
    }



    @Override
    public List<TipoArchivo> listar() throws Exception {
        List<TipoArchivo> lista = null;
        try {
            lista = (List<TipoArchivo>) em.createNamedQuery("TipoArchivo.findAll").getResultList();
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

    @Override
    public TipoArchivo porId(String id) throws Exception {
        TipoArchivo x = null;
        try {
            if (id.trim().equals("")) {
                return null;
            } else {
                x = (TipoArchivo) em.createQuery("Select object(o) from TipoArchivo o Where o.idTipoArchivo = ?1 ").setParameter(1,  Long.parseLong(id) ).getSingleResult();
            }
        } catch (Exception e) {
            throw e;
        }
        return x;
    }


    
 
}
