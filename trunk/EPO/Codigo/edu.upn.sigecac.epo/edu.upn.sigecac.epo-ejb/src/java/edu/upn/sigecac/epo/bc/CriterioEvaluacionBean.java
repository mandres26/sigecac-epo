/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.epo.bc;

import edu.upn.sigecac.epo.be.CriterioEvaluacion;
import edu.upn.sigecac.epo.be.Rubrica;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author texai
 */
@Stateless
public class CriterioEvaluacionBean implements CriterioEvaluacionLocal {
    
    @PersistenceContext(name = "edu.upn.sigecac.epo-ejbPU")
    private EntityManager em;

    public CriterioEvaluacionBean() {
    }

    @Override
    public void registrar(CriterioEvaluacion x) throws Exception {
        try {
            em.persist(x);
        } catch (Exception e) {
            throw e;
        }
    }


    @Override
    public List<CriterioEvaluacion> buscarPorRubrica(Rubrica R) throws Exception {
        try {
            return (List<CriterioEvaluacion>) em.createQuery("SELECT c FROM CriterioEvaluacion c WHERE c.fidRubrica = :R").setParameter("R", R).getResultList();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

 
}
