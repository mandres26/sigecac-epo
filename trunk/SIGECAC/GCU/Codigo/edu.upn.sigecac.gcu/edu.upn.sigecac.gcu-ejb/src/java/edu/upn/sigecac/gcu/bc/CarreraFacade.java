/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.gcu.bc;

import edu.upn.sigecac.gcu.be.Carrera;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class CarreraFacade implements CarreraFacadeLocal {
    @PersistenceContext
    private EntityManager em;

    public void create(Carrera carrera) {
        em.persist(carrera);
    }

    public void edit(Carrera carrera) {
        em.merge(carrera);
    }

    public void remove(Carrera carrera) {
        em.remove(em.merge(carrera));
    }

    public Carrera find(Object id) {
        return em.find(Carrera.class, id);
    }

    public List<Carrera> findAll() {
        return em.createQuery("select object(o) from Carrera as o").getResultList();
    }

}
