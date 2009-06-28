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
public interface PeriodoAcademicoLocal {

    public void registrar(edu.upn.sigecac.epo.be.PeriodoAcademico a) throws java.lang.Exception;

    public void editar(edu.upn.sigecac.epo.be.PeriodoAcademico a) throws java.lang.Exception;

    public void eliminar(edu.upn.sigecac.epo.be.PeriodoAcademico a) throws java.lang.Exception;

    public edu.upn.sigecac.epo.be.PeriodoAcademico buscarPorId(java.lang.Long id) throws java.lang.Exception;

    public java.util.List<edu.upn.sigecac.epo.be.PeriodoAcademico> listar() throws java.lang.Exception;
    
}
