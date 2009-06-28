/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.sigecac.gcu.bc;

import edu.upn.sigecac.gcu.be.Curso;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author XTUDiO
 */
@Stateless
public class CursoFacadeBean implements CursoFacadeLocal {

    @PersistenceContext(name = "edu.upn.sigecac.gcu-ejbPU")
    private EntityManager em;

    public CursoFacadeBean() {
    }

    @Override
    public void crear(Curso objCurso) throws Exception {
        try {
            em.persist(objCurso);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Curso> listar() throws Exception {
        List<Curso> lista = null;
        try {
            lista = (List<Curso>) em.createNamedQuery("Curso.findAll").getResultList();
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

    @Override
    public Curso buscar(Long id) throws Exception {
        try {
            return em.find(Curso.class, id);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void eliminar(Curso objCurso) throws Exception {
        try {
            em.remove(em.merge(objCurso));
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void actualizar(Curso objCurso) throws Exception {
        try {
            em.merge(objCurso);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Curso> filtrar(String criterio, String valor) throws Exception {
        List<Curso> lista = null;
        try {
            if (valor.trim().equals("")) {
                lista = listar();
            } else {
                lista = (List<Curso>) em.createQuery("Select object(o) from Curso o Where o.FX_IDCURSO = ?1 ").setParameter(1, "%" + valor + "%").getResultList();
            }
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }
}
