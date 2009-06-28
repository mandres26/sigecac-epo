/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.sigecac.epo.bc;

import edu.upn.sigecac.epo.be.Peticion;
import edu.upn.sigecac.epo.be.Publicacion;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Programador
 */
@Stateless
public class PublicacionBean implements PublicacionLocal {

    @PersistenceContext(name = "edu.upn.sigecac.epo-ejbPU")
    private EntityManager em;

    public PublicacionBean() {
    }

    @Override
    public void registrar(Publicacion a) throws Exception {
        try {
            em.persist(a);
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public void editar(Publicacion a) throws Exception {
        try {
            em.merge(a);
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(Publicacion a) throws Exception {
        try {
            em.remove(em.merge(a));
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public Publicacion buscarPorId(Long id) throws Exception {
        try {
            return (Publicacion) em.createQuery("SELECT a FROM Publicacion a WHERE a.idPublicacion = :id").setParameter("id", id).getSingleResult();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public List<Publicacion> listarPorPeticion(Peticion P) throws Exception{
        try {
            return (List<Publicacion>) em.createQuery("SELECT c FROM Publicacion c WHERE c.fidPeticion = :P").setParameter("P", P).getResultList();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public List<Publicacion> buscarPorTitulo(String cadena) throws Exception {
        try {
            return (List<Publicacion>) em.createQuery("SELECT a FROM Publicacion a WHERE a.titulo LIKE ?1").setParameter(1, "%" + cadena.toUpperCase() + "%").getResultList();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public List<Publicacion> listar() throws Exception {
        try {
            return (List<Publicacion>) em.createNamedQuery("Publicacion.findAll").getResultList();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }
}
