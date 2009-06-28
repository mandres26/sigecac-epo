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
public interface TipoArchivoLocal {

    public java.util.List<edu.upn.sigecac.epo.be.TipoArchivo> listar() throws java.lang.Exception;

    public edu.upn.sigecac.epo.be.TipoArchivo porId(java.lang.String id) throws java.lang.Exception;

    

   
    
}
