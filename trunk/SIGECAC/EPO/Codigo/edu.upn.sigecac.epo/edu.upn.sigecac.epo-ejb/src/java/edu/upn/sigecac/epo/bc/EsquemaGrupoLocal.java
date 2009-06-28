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
public interface EsquemaGrupoLocal {

    public java.util.List<edu.upn.sigecac.epo.be.EsquemaGrupo> listarPorClase(java.lang.String idClase) throws java.lang.Exception;
    
}
