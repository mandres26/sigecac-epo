/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.epo.bc;

import edu.upn.sigecac.epo.be.PeriodoAcademico;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author texai
 */
@Stateless
public class PeriodoAcademicoBean implements PeriodoAcademicoLocal {
    
    @PersistenceContext(name = "edu.upn.sigecac.epo-ejbPU")
    private EntityManager em;

    public PeriodoAcademicoBean() {
    }


    @Override
    public void registrar(PeriodoAcademico a) throws Exception {
        try {
            em.persist(a);
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public void editar(PeriodoAcademico a) throws Exception {
        try {
            em.merge(a);
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(PeriodoAcademico a) throws Exception {
        try {
            em.remove(em.merge(a));
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public PeriodoAcademico buscarPorId(Long id) throws Exception {
        try {
            return (PeriodoAcademico) em.createQuery("SELECT a FROM PeriodoAcademico a WHERE a.idPeriodoAcademico = :id").setParameter("id", id).getSingleResult();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public List<PeriodoAcademico> listar() throws Exception {
        try {
            return (List<PeriodoAcademico>) em.createNamedQuery("PeriodoAcademico.findAll").getResultList();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }
}
