/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.sigecac.gcu.bc;

import javax.ejb.Stateless;
import edu.upn.sigecac.gcu.be.Prerequisito;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author XTUDiO
 */
@Stateless
public class PrerequisitoFacadeBean implements PrerequisitoFacadeLocal {

    @PersistenceContext(name = "edu.upn.sigecac.gcu-ejbPU")
    private EntityManager em;

    public PrerequisitoFacadeBean() {
    }

    @Override
    public void crear(Prerequisito objPrerequisito) throws Exception {
        try {
            em.persist(objPrerequisito);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Prerequisito> listar() throws Exception {
        List<Prerequisito> lista = null;
        try {
            lista = (List<Prerequisito>) em.createNamedQuery("Prerequisito.findAll").getResultList();
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

    @Override
    public Prerequisito buscar(long id) throws Exception {
        try {
            return em.find(Prerequisito.class, id);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void eliminar(Prerequisito objPrerequisito) throws Exception {
        try {
            em.remove(em.merge(objPrerequisito));
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void actualizar(Prerequisito objPrerequisito) throws Exception {
        try {
            em.merge(objPrerequisito);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Prerequisito> PrerequisitoxCurso(Long valor) throws Exception {
        List<Prerequisito> lista = null;
        try {
            if (valor != null) {
                lista = (List<Prerequisito>) em.createQuery("Select object(o) from Prerequisito o Where o.fxIdcurso.idCurso = ?1 ").setParameter(1, valor).getResultList();
            } else {
                lista = null;
            }
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }
}
