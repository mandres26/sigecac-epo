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
public interface PeticionLocal {

    public void registrar(edu.upn.sigecac.epo.be.Peticion x) throws java.lang.Exception;

    public java.util.List<edu.upn.sigecac.epo.be.Peticion> listar() throws java.lang.Exception;

    public java.util.List<edu.upn.sigecac.gen.be.Clase> listarClasesPorCurso(java.lang.String idCurso) throws java.lang.Exception;
    
}
