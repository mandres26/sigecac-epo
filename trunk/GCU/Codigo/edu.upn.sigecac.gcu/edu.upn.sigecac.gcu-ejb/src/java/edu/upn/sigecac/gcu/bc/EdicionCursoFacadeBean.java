/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.sigecac.gcu.bc;

import javax.ejb.Stateless;
import edu.upn.sigecac.gcu.be.EdicionCurso;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author XTUDiO
 */
@Stateless
public class EdicionCursoFacadeBean implements EdicionCursoFacadeLocal {

    @PersistenceContext(name = "edu.upn.sigecac.gcu-ejbPU")
    private EntityManager em;

    public EdicionCursoFacadeBean() {
    }

    @Override
    public void crear(EdicionCurso objEdicionCurso) throws Exception {
        try {
            em.persist(objEdicionCurso);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<EdicionCurso> listar() throws Exception {
        List<EdicionCurso> lista = null;
        try {
            lista = (List<EdicionCurso>) em.createNamedQuery("EdicionCurso.findAll").getResultList();
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

    @Override
    public EdicionCurso buscar(long id) throws Exception {
        try {
            return em.find(EdicionCurso.class, id);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void eliminar(EdicionCurso objEdicionCurso) throws Exception {
        try {
            em.remove(em.merge(objEdicionCurso));
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void actualizar(EdicionCurso objEdicionCurso) throws Exception {
        try {
            em.merge(objEdicionCurso);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<EdicionCurso> EdicionCursoxCurso(long valor) throws Exception {
        List<EdicionCurso> lista = null;
        try {
            lista = (List<EdicionCurso>) em.createQuery("Select object(o) from EdicionCurso o Where o.fxIdcurso.idCurso = ?1 ").setParameter(1, valor).getResultList();
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }
}
