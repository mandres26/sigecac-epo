/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.gcu.bc;

import edu.upn.sigecac.gcu.be.EstandaresCuantificadores;
import javax.ejb.Local;

/**
 *
 * @author XTUDiO
 */
@Local
public interface EstandaresCuantificadoresFacadeLocal {
      public void crear(EstandaresCuantificadores objEstandaresCuantificadores) throws java.lang.Exception;
      public java.util.List<EstandaresCuantificadores> listar() throws java.lang.Exception;
      public EstandaresCuantificadores buscar(long id) throws java.lang.Exception;
      public void eliminar(EstandaresCuantificadores objEstandaresCuantificadores) throws java.lang.Exception;
      public void actualizar(EstandaresCuantificadores objEstandaresCuantificadores) throws java.lang.Exception;
      public java.util.List<EstandaresCuantificadores> filtrar(java.lang.String criterio, java.lang.String valor) throws java.lang.Exception;
}
