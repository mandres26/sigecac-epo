/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.sigecac.gcu.bc;

import edu.upn.sigecac.gcu.be.EdicionCurso;
import javax.ejb.Local;

/**
 *
 * @author XTUDiO
 */
@Local
public interface EdicionCursoFacadeLocal {
      public void crear(EdicionCurso objEdicionCurso) throws java.lang.Exception;
      public java.util.List<EdicionCurso> listar() throws java.lang.Exception;
      public EdicionCurso buscar(long id) throws java.lang.Exception;
      public void eliminar(EdicionCurso objEdicionCurso) throws java.lang.Exception;
      public void actualizar(EdicionCurso objEdicionCurso) throws java.lang.Exception;
      public java.util.List<EdicionCurso> EdicionCursoxCurso(long valor) throws java.lang.Exception;
}

