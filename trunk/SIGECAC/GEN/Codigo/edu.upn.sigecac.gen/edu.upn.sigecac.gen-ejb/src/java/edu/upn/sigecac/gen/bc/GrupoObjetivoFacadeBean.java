/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.sigecac.gen.bc;

import edu.upn.sigecac.gen.be.GrupoObjetivo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Administrador
 */
@Stateless
public class GrupoObjetivoFacadeBean implements GrupoObjetivoFacadeLocal {

    @PersistenceContext(name = "edu.upn.sigecac.gen-ejbPU")
    private EntityManager em;

    public GrupoObjetivoFacadeBean() {
    }

    @Override
    public void registrar(GrupoObjetivo a) throws Exception {
        try {
            em.persist(a);
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public void editar(GrupoObjetivo a) throws Exception {
        try {
            em.merge(a);
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(GrupoObjetivo a) throws Exception {
        try {
            em.remove(em.merge(a));
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public GrupoObjetivo buscarPorId(Long idGrupoObjetivo) throws Exception {
        try {
            return (GrupoObjetivo) em.createQuery("SELECT a FROM GrupoObjetivo a WHERE a.idGrupoObjetivo = :idGrupoObjetivo").setParameter("idGrupoObjetivo", idGrupoObjetivo).getSingleResult();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public List<GrupoObjetivo> listar() throws Exception {
        try {
            return (List<GrupoObjetivo>) em.createQuery("SELECT a FROM GrupoObjetivo a ").getResultList();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }
}
