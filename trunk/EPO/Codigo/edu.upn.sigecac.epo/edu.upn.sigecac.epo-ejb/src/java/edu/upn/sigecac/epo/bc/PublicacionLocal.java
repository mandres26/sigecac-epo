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
public interface PublicacionLocal {

    public void registrar(edu.upn.sigecac.epo.be.Publicacion a) throws java.lang.Exception;

    public void editar(edu.upn.sigecac.epo.be.Publicacion a) throws java.lang.Exception;

    public void eliminar(edu.upn.sigecac.epo.be.Publicacion a) throws java.lang.Exception;

    public edu.upn.sigecac.epo.be.Publicacion buscarPorId(java.lang.Long id) throws java.lang.Exception;

    public java.util.List<edu.upn.sigecac.epo.be.Publicacion> listar() throws java.lang.Exception;

    public java.util.List<edu.upn.sigecac.epo.be.Publicacion> buscarPorTitulo(java.lang.String cadena) throws java.lang.Exception;

    public java.util.List<edu.upn.sigecac.epo.be.Publicacion> listarPorPeticion(edu.upn.sigecac.epo.be.Peticion P) throws java.lang.Exception;


    
}
