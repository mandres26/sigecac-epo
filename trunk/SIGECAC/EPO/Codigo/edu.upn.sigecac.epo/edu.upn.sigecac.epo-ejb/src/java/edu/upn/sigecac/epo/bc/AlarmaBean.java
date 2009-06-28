/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.epo.bc;

import edu.upn.sigecac.epo.be.Alarma;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import javax.ejb.Stateless;

/**
 *
 * @author Nancy Espinola
 */
@Stateless
public class AlarmaBean implements AlarmaLocal {

  @PersistenceContext(name = "edu.upn.sigecac.epo-ejbPU")
    private EntityManager em;

    public AlarmaBean() {
    }

    @Override
    public void registrar(Alarma a) throws Exception {
        try {
            em.persist(a);
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }


    @Override
    public void editar(Alarma a) throws Exception {
        try {
            em.merge(a);
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }


    @Override
    public void eliminar(Alarma a) throws Exception {
        try {
            em.remove(em.merge(a));
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }


    @Override
    public Alarma buscarPorId(Long id) throws Exception {
        try {
            return (Alarma) em.createQuery("SELECT a FROM Alarma a WHERE a.idAlarma = :id").setParameter("id", id).getSingleResult();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }


    @Override
    public List<Alarma> listar() throws Exception {
        try {
            return (List<Alarma>) em.createNamedQuery("Alarma.findAll").getResultList();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }
}
