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
    public void registrar(EsquemaGrupo eg) throws Exception {
        try {
            em.persist(eg);
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public void editar(EsquemaGrupo eg) throws Exception {
        try {
            em.merge(eg);
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(EsquemaGrupo eg) throws Exception {
        try {
            em.remove(em.merge(eg));
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public List<EsquemaGrupo> listar() throws Exception {
        try {
            return (List<EsquemaGrupo>) em.createNamedQuery("EsquemaGrupo.findAll").getResultList();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
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
