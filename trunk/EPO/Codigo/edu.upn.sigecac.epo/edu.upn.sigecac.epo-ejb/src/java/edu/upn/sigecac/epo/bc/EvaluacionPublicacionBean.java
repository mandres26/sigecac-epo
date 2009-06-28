/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.epo.bc;

import edu.upn.sigecac.epo.be.EvaluacionPublicacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author texai
 */
@Stateless
public class EvaluacionPublicacionBean implements EvaluacionPublicacionLocal {
    

    @PersistenceContext(name = "edu.upn.sigecac.epo-ejbPU")
    private EntityManager em;

    public EvaluacionPublicacionBean() {
    }




    @Override
    public void registrar(EvaluacionPublicacion x) throws Exception {
        try {
            em.persist(x);
        } catch (Exception e) {
            throw e;
        }
    }

}
