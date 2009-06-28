/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.sigecac.gen.bc;

import edu.upn.sigecac.gen.be.Empleador;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Administrador
 */
@Stateless
public class EmpleadorFacadeBean implements EmpleadorFacadeLocal {

    @PersistenceContext(name = "edu.upn.sigecac.gen-ejbPU")
    private EntityManager em;

    public EmpleadorFacadeBean() {
    }

    @Override
    public void registrar(Empleador a) throws Exception {
        try {
            em.persist(a);
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public void editar(Empleador a) throws Exception {
        try {
            em.merge(a);
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(Empleador a) throws Exception {
        try {
            em.remove(em.merge(a));
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public Empleador buscarPorId(Long idAlumno) throws Exception {
        try {
            return (Empleador) em.createQuery("SELECT a FROM Empleador a WHERE a.idEmpleador = :idEmpleador").setParameter("idEmpleador", idAlumno).getSingleResult();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public List<Empleador> listar() throws Exception {
        try {
            return (List<Empleador>) em.createQuery("SELECT a FROM Empleador a ").getResultList();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }
}
