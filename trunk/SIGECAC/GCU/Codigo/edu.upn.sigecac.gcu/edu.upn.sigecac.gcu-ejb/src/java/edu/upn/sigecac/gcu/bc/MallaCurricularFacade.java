/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.gcu.bc;

import edu.upn.sigecac.gcu.be.MallaCurricular;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class MallaCurricularFacade implements MallaCurricularFacadeLocal {
    @PersistenceContext
    private EntityManager em;

    public void create(MallaCurricular mallaCurricular) {
        em.persist(mallaCurricular);
    }

    public void edit(MallaCurricular mallaCurricular) {
        em.merge(mallaCurricular);
    }

    public void remove(MallaCurricular mallaCurricular) {
        em.remove(em.merge(mallaCurricular));
    }

    public MallaCurricular find(Object id) {
        return em.find(MallaCurricular.class, id);
    }

    public List<MallaCurricular> findAll() {
        return em.createQuery("select object(o) from MallaCurricular as o").getResultList();
    }

}
