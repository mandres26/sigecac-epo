package edu.upn.sigecac.seg.bc;

import javax.ejb.Local;

@Local
public interface RolFacadeLocal {

    public void registrar(edu.upn.sigecac.seg.be.Rol rol) throws java.lang.Exception;

    public void editar(edu.upn.sigecac.seg.be.Rol rol) throws java.lang.Exception;

    public void eliminar(edu.upn.sigecac.seg.be.Rol rol) throws java.lang.Exception;

    public edu.upn.sigecac.seg.be.Rol buscarID(java.lang.Long idRol) throws java.lang.Exception;

    public java.util.List<edu.upn.sigecac.seg.be.Rol> listar() throws java.lang.Exception;

    public java.util.List<edu.upn.sigecac.seg.be.Rol> listarxNombre(java.lang.String nombre) throws java.lang.Exception;
}