/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.sigecac.gcu.bc;

import edu.upn.sigecac.gcu.be.Ciclo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CicloFacadeBean implements CicloFacadeLocal {

    @PersistenceContext
    private EntityManager em;

    public void create(Ciclo ciclo) {
        em.persist(ciclo);
    }

    public void edit(Ciclo ciclo) {
        em.merge(ciclo);
    }

    public void remove(Ciclo ciclo) {
        em.remove(em.merge(ciclo));
    }

    public Ciclo find(Object id) {
        return em.find(Ciclo.class, id);
    }

    public List<Ciclo> findAll() {
        return em.createQuery("select object(o) from Ciclo as o").getResultList();
    }

    public List<Ciclo> findByName(String ciclo) {
        return em.createQuery("select object(o) from Ciclo as o Where o.ciclo = ?1").setParameter(1, ciclo).getResultList();
    }
}
