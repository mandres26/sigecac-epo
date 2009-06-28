/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.gcu.bc;

import edu.upn.sigecac.gcu.be.Prerequisito;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Administrador
 */
@Local
public interface PrerequisitoFacadeLocal {

      public void crear(Prerequisito objPrerequisito) throws java.lang.Exception;
      public java.util.List<Prerequisito> listar() throws java.lang.Exception;
      public Prerequisito buscar(long id) throws java.lang.Exception;
      public void eliminar(Prerequisito objPrerequisito) throws java.lang.Exception;
      public void actualizar(Prerequisito objPrerequisito) throws java.lang.Exception;
      public java.util.List<Prerequisito> PrerequisitoxCurso(Long valor) throws java.lang.Exception;

}
