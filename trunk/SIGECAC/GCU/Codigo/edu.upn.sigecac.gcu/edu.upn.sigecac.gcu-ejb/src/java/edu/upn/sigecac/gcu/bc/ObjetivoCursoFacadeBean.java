/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.sigecac.gcu.bc;

import edu.upn.sigecac.gcu.be.EdicionCurso;
import edu.upn.sigecac.gcu.be.ObjetivoCurso;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ObjetivoCursoFacadeBean implements ObjetivoCursoFacadeLocal {

    @PersistenceContext(name = "edu.upn.sigecac.gcu-ejbPU")
    private EntityManager em;

    @Override
    public void create(ObjetivoCurso objetivoCurso) {
        em.persist(objetivoCurso);
    }

    @Override
    public void edit(ObjetivoCurso objetivoCurso) {
        em.merge(objetivoCurso);
    }

    @Override
    public void remove(ObjetivoCurso objetivoCurso) {
        em.remove(em.merge(objetivoCurso));
    }

    @Override
    public ObjetivoCurso find(Long idObjetivocurso) throws Exception {
        try {
            return (ObjetivoCurso) em.createQuery("SELECT o FROM ObjetivoCurso o WHERE o.idObjetivocurso = :idObjetivocurso").setParameter("idObjetivocurso", idObjetivocurso).getSingleResult();
        } catch (Exception ex) {
            throw new Exception("Error: " + ex.getMessage());
        }
    }

    @Override
    public List<ObjetivoCurso> findAll() {
        Query q = em.createNamedQuery("ObjetivoCurso.findAll");
        List<ObjetivoCurso> objCurso = q.getResultList();
        return objCurso;
    }

    @Override
    public List<ObjetivoCurso> listarObjCursoPorEdicion(EdicionCurso edicion) {
        return em.createQuery("select object(o) from ObjetivoCurso as o where o.fxIdedicion = ?1").setParameter(1, edicion).getResultList();
    }
}
