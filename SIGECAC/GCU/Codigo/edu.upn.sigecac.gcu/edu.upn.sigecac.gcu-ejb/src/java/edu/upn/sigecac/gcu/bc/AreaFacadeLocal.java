/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.gcu.bc;

import edu.upn.sigecac.gcu.be.Area;
import javax.ejb.Local;

/**
 *
 * @author XTUDiO
 */
@Local
public interface AreaFacadeLocal {
      public void crear(Area objArea) throws java.lang.Exception;
      public java.util.List<Area> listar() throws java.lang.Exception;
      public Area buscar(long id) throws java.lang.Exception;
      public void eliminar(Area objArea) throws java.lang.Exception;
      public void actualizar(Area objArea) throws java.lang.Exception;
      public java.util.List<Area> filtrar(java.lang.String criterio, java.lang.String valor) throws java.lang.Exception;
}
