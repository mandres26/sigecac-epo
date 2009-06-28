/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.gcu.bc;

import javax.ejb.Local;
import edu.upn.sigecac.gcu.be.NivelProfesional;
/**
 *
 * @author Programador
 */
@Local
public interface NivelProfesionalFacadeLocal {
      public void crear(NivelProfesional objNivelProfesional) throws java.lang.Exception;
      public java.util.List<NivelProfesional> listar() throws java.lang.Exception;
      public NivelProfesional buscar(long id) throws java.lang.Exception;
      public void eliminar(NivelProfesional objNivelProfesional) throws java.lang.Exception;
      public void actualizar(NivelProfesional objNivelProfesional) throws java.lang.Exception;
      public java.util.List<NivelProfesional> filtrar(java.lang.String criterio, java.lang.String valor) throws java.lang.Exception;
}
