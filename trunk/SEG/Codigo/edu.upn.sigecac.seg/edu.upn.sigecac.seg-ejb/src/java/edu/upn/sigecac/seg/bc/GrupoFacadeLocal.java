/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.seg.bc;

import edu.upn.sigecac.seg.be.Grupo;
import edu.upn.sigecac.seg.be.Rol;
import javax.ejb.Local;


@Local
public interface GrupoFacadeLocal {

    Grupo getGrupo();

    void setGrupo(Grupo grupo);

    public void registrar(edu.upn.sigecac.seg.be.Grupo grupo) throws java.lang.Exception;

    public void editar(edu.upn.sigecac.seg.be.Grupo grupo) throws java.lang.Exception;

    public void eliminar(edu.upn.sigecac.seg.be.Grupo grupo) throws java.lang.Exception;

    public edu.upn.sigecac.seg.be.Grupo buscarID(java.lang.Long idGrupo) throws java.lang.Exception;

    public java.util.List<edu.upn.sigecac.seg.be.Grupo> listar() throws java.lang.Exception;

    public java.util.List<edu.upn.sigecac.seg.be.Grupo> listarxNombre(java.lang.String nombre) throws java.lang.Exception;

    boolean agregarRol(Rol rol) throws Exception;

    boolean quitarRol(Rol rol) throws Exception;


}
