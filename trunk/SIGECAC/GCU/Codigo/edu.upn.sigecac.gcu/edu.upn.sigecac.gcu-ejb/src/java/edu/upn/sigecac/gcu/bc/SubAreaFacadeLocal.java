/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.gcu.bc;

import edu.upn.sigecac.gcu.be.SubArea;
import javax.ejb.Local;

/**
 *
 * @author XTUDiO
 */
@Local
public interface SubAreaFacadeLocal {
      public void crear(SubArea objSubArea) throws java.lang.Exception;
      public java.util.List<SubArea> listar() throws java.lang.Exception;
      public SubArea buscar(long id) throws java.lang.Exception;
      public void eliminar(SubArea objSubArea) throws java.lang.Exception;
      public void actualizar(SubArea objSubArea) throws java.lang.Exception;
      public java.util.List<SubArea> filtrar(java.lang.String criterio, java.lang.String valor) throws java.lang.Exception;
}
