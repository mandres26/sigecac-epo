/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.sigecac.gen.bc;

import javax.ejb.Local;

/**
 *
 * @author Administrador
 */
@Local
public interface DocenteFacadeLocal {

    public void registrar(edu.upn.sigecac.gen.be.Docente a) throws java.lang.Exception;

    public void editar(edu.upn.sigecac.gen.be.Docente a) throws java.lang.Exception;

    public void eliminar(edu.upn.sigecac.gen.be.Docente a) throws java.lang.Exception;

    public edu.upn.sigecac.gen.be.Docente buscarPorId(java.lang.Long idDocente) throws java.lang.Exception;

    public java.util.List<edu.upn.sigecac.gen.be.Docente> listar() throws java.lang.Exception;
}
