/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.gcu.bc;

import edu.upn.sigecac.gcu.be.Especializacion;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class EspecializacionFacade implements EspecializacionFacadeLocal {
    @PersistenceContext
    private EntityManager em;

    public void create(Especializacion especializacion) {
        em.persist(especializacion);
    }

    public void edit(Especializacion especializacion) {
        em.merge(especializacion);
    }

    public void remove(Especializacion especializacion) {
        em.remove(em.merge(especializacion));
    }

    public Especializacion find(Object id) {
        return em.find(Especializacion.class, id);
    }

    public List<Especializacion> findAll() {
        return em.createQuery("select object(o) from Especializacion as o").getResultList();
    }

}
