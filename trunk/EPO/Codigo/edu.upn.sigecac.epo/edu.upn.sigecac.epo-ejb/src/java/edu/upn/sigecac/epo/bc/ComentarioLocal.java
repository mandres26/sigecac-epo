/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.epo.bc;

import javax.ejb.Local;

/**
 *
 * @author Programador
 */
@Local
public interface ComentarioLocal {

    public void registrar(edu.upn.sigecac.epo.be.Comentario c) throws java.lang.Exception;

    public void editar(edu.upn.sigecac.epo.be.Comentario c) throws java.lang.Exception;

    public void eliminar(edu.upn.sigecac.epo.be.Comentario c) throws java.lang.Exception;

    public edu.upn.sigecac.epo.be.Comentario buscarPorId(java.lang.Long id) throws java.lang.Exception;

    public java.util.List<edu.upn.sigecac.epo.be.Comentario> listar() throws java.lang.Exception;
    
}
