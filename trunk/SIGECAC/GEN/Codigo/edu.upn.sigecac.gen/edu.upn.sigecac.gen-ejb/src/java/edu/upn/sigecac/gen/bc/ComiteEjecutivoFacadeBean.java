/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.sigecac.gen.bc;

import edu.upn.sigecac.gen.be.ComiteEjecutivo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Administrador
 */
@Stateless
public class ComiteEjecutivoFacadeBean implements ComiteEjecutivoFacadeLocal {

    @PersistenceContext(name = "edu.upn.sigecac.gen-ejbPU")
    private EntityManager em;

    public ComiteEjecutivoFacadeBean() {
    }

    @Override
    public void registrar(ComiteEjecutivo a) throws Exception {
        try {
            em.persist(a);
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public void editar(ComiteEjecutivo a) throws Exception {
        try {
            em.merge(a);
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(ComiteEjecutivo a) throws Exception {
        try {
            em.remove(em.merge(a));
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public ComiteEjecutivo buscarPorId(Long idAlumno) throws Exception {
        try {
            return (ComiteEjecutivo) em.createQuery("SELECT a FROM ComiteEjecutivo a WHERE a.idComiteEjecutivo = :idComiteEjecutivo").setParameter("idComiteEjecutivo", idAlumno).getSingleResult();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public List<ComiteEjecutivo> listar() throws Exception {
        try {
            return (List<ComiteEjecutivo>) em.createQuery("SELECT a FROM ComiteEjecutivo a ").getResultList();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }
}
