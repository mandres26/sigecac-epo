/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.epo.bc;

import javax.ejb.Local;

/**
 *
 * @author texai
 */
@Local
public interface CriterioEvaluacionLocal {

    public void registrar(edu.upn.sigecac.epo.be.CriterioEvaluacion x) throws java.lang.Exception;

    public java.util.List<edu.upn.sigecac.epo.be.CriterioEvaluacion> buscarPorRubrica(edu.upn.sigecac.epo.be.Rubrica R) throws java.lang.Exception;
    
}
