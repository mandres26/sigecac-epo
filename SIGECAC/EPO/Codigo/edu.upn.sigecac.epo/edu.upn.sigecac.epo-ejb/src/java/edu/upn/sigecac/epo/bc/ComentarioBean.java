/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.epo.bc;

import edu.upn.sigecac.epo.be.Comentario;
import edu.upn.sigecac.epo.be.Publicacion;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Nancy Espinola
 */
@Stateless
public class ComentarioBean implements ComentarioLocal {


    @PersistenceContext(name = "edu.upn.sigecac.epo-ejbPU")
    private EntityManager em;

    public ComentarioBean(){

    }

    @Override
    public void registrar(Comentario c) throws Exception {
        try {
            em.persist(c);
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }


    @Override
    public void editar(Comentario c) throws Exception {
        try {
            em.merge(c);
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(Comentario c) throws Exception {
        try {
            em.remove(em.merge(c));
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public Comentario buscarPorId(Long id) throws Exception {
        try {
            return (Comentario) em.createQuery("SELECT a FROM Comentario a WHERE a.idComentario = :id").setParameter("id", id).getSingleResult();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public List<Comentario> listar() throws Exception {
        try {
            return (List<Comentario>) em.createNamedQuery("Comentario.findAll").getResultList();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public List<Comentario> listarNoValidados(Publicacion pub) throws Exception {
        try {
            return (List<Comentario>) em.createQuery("SELECT a FROM Comentario a WHERE a.validado = 0 AND a.fidPublicacion = :id").setParameter("id", pub).getResultList();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public List<Comentario> listarValidados(Publicacion pub) throws Exception {
        try {
            return (List<Comentario>) em.createQuery("SELECT a FROM Comentario a WHERE a.validado = 1 AND a.fidPublicacion = :id").setParameter("id", pub).getResultList();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }



}
