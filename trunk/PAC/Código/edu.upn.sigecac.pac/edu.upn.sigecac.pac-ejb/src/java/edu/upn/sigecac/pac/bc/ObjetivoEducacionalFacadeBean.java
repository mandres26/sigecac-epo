/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.pac.bc;

import edu.upn.sigecac.pac.be.ObjetivoEducacional;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Administrador
 */
@Stateless
public class ObjetivoEducacionalFacadeBean implements ObjetivoEducacionalFacadeLocal {
    
 @PersistenceContext
    private EntityManager em;

    public void create(ObjetivoEducacional objetivoEducacional) {
        em.persist(objetivoEducacional);
    }

    public void edit(ObjetivoEducacional objetivoEducacional) {
        em.merge(objetivoEducacional);
    }

    public void remove(ObjetivoEducacional objetivoEducacional) {
        em.remove(em.merge(objetivoEducacional));
    }

    public ObjetivoEducacional find(Object id) {
        return em.find(ObjetivoEducacional.class, id);
    }

    public List<ObjetivoEducacional> findAll() {
        return em.createQuery("select object(o) from ObjetivoEducacional as o").getResultList();
    }

    public List<ObjetivoEducacional> listarxEstado(boolean var) {
        return em.createQuery("select object(o) from ObjetivoEducacional as o where o.estado=?1").setParameter(1, var).getResultList();
    }

    @Override
    public List<ObjetivoEducacional> listarxCarrera(Long idCarrera) {
        return em.createQuery("select object(o) from ObjetivoEducacional as o where o.fidCarrera.idCarrera=?1").setParameter(1, idCarrera).getResultList();
    }
}
