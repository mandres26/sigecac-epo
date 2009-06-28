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
public interface ComiteEjecutivoFacadeLocal {

    public void registrar(edu.upn.sigecac.gen.be.ComiteEjecutivo a) throws java.lang.Exception;

    public void editar(edu.upn.sigecac.gen.be.ComiteEjecutivo a) throws java.lang.Exception;

    public void eliminar(edu.upn.sigecac.gen.be.ComiteEjecutivo a) throws java.lang.Exception;

    public edu.upn.sigecac.gen.be.ComiteEjecutivo buscarPorId(java.lang.Long idAlumno) throws java.lang.Exception;

    public java.util.List<edu.upn.sigecac.gen.be.ComiteEjecutivo> listar() throws java.lang.Exception;
}
