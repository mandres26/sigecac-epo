/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.epo.bc;

import edu.upn.sigecac.epo.be.EsquemaGrupo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author texai
 */
@Stateless
public class EsquemaGrupoBean implements EsquemaGrupoLocal {
    
    @PersistenceContext(name = "edu.upn.sigecac.epo-ejbPU")
    private EntityManager em;

    public EsquemaGrupoBean() {

    }


    @Override
    public List<EsquemaGrupo> listarPorClase(String idClase) throws Exception {
        List<EsquemaGrupo> lista = null;
        try {
            lista = (List<EsquemaGrupo>) em.createQuery("SELECT e FROM EsquemaGrupo e WHERE e.fidGenClase = :idClase").setParameter("idClase",  Long.parseLong(idClase)).getResultList();
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }
 
}
