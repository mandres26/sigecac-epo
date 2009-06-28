/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.epo.bc;

import edu.upn.sigecac.epo.be.EvaluacionCriterio;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author texai
 */
@Stateless
public class EvaluacionCriterioBean implements EvaluacionCriterioLocal {
    
    @PersistenceContext(name = "edu.upn.sigecac.epo-ejbPU")
    private EntityManager em;

    public EvaluacionCriterioBean() {
    }

    
    @Override
    public void registrar(EvaluacionCriterio x) throws Exception {
        try {
            em.persist(x);
        } catch (Exception e) {
            throw e;
        }
    }
 
}
