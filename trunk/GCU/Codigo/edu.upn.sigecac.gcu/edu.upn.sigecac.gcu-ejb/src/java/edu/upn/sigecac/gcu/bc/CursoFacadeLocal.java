/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.sigecac.gcu.bc;

import edu.upn.sigecac.gcu.be.Curso;
import javax.ejb.Local;

/**
 *
 * @author XTUDiO
 */
@Local
public interface CursoFacadeLocal {

    public void crear(Curso objCurso) throws java.lang.Exception;

    public java.util.List<Curso> listar() throws java.lang.Exception;

    public Curso buscar(Long id) throws java.lang.Exception;

    public void eliminar(Curso objCurso) throws java.lang.Exception;

    public void actualizar(Curso objCurso) throws java.lang.Exception;

    public java.util.List<Curso> filtrar(java.lang.String criterio, java.lang.String valor) throws java.lang.Exception;
}
