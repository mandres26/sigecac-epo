/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.sigecac.gen.bc;

import edu.upn.sigecac.gen.be.Docente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Administrador
 */
@Stateless
public class DocenteFacadeBean implements DocenteFacadeLocal {

    @PersistenceContext(name = "edu.upn.sigecac.gen-ejbPU")
    private EntityManager em;

    public DocenteFacadeBean() {
    }

    @Override
    public void registrar(Docente a) throws Exception {
        try {
            em.persist(a);
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public void editar(Docente a) throws Exception {
        try {
            em.merge(a);
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(Docente a) throws Exception {
        try {
            em.remove(em.merge(a));
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public Docente buscarPorId(Long idDocente) throws Exception {
        try {
            return (Docente) em.createQuery("SELECT a FROM Docente a WHERE a.idPersona = :idPersona").setParameter("idPersona", idDocente).getSingleResult();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public List<Docente> listar() throws Exception {
        try {
            return (List<Docente>) em.createNamedQuery("Docente.findAll").getResultList();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }
}
