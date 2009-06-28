/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.gcu.bc;

import edu.upn.sigecac.gcu.be.Equivalencia;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Administrador
 */
@Local
public interface EquivalenciaFacadeLocal {

      public void crear(Equivalencia objEquivalencia) throws java.lang.Exception;
      public java.util.List<Equivalencia> listar() throws java.lang.Exception;
      public Equivalencia buscar(long id) throws java.lang.Exception;
      public void eliminar(Equivalencia objEquivalencia) throws java.lang.Exception;
      public void actualizar(Equivalencia objEquivalencia) throws java.lang.Exception;
      public java.util.List<Equivalencia> EquivalenciaxCurso(long valor) throws java.lang.Exception;

}
