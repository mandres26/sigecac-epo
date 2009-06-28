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
public interface EvaluacionPublicacionLocal {

    public void registrar(edu.upn.sigecac.epo.be.EvaluacionPublicacion x) throws java.lang.Exception;
    
}
