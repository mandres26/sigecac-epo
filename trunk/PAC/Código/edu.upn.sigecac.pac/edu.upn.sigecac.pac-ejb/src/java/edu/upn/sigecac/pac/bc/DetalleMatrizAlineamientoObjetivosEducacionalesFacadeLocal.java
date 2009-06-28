package edu.upn.sigecac.pac.bc;

import javax.ejb.Local;

@Local
public interface DetalleMatrizAlineamientoObjetivosEducacionalesFacadeLocal {

    public void registrar(edu.upn.sigecac.pac.be.DetalleMatrizAlineamientoObjetivosEducacionales maoe) throws java.lang.Exception;

    public void actualizar(edu.upn.sigecac.pac.be.DetalleMatrizAlineamientoObjetivosEducacionales maoe) throws java.lang.Exception;

    public void eliminar(edu.upn.sigecac.pac.be.DetalleMatrizAlineamientoObjetivosEducacionales maoe) throws java.lang.Exception;

    public edu.upn.sigecac.pac.be.DetalleMatrizAlineamientoObjetivosEducacionales buscarPorId(java.lang.Long idDetalleMatrizAlineamientoObjetivosEducacionales) throws java.lang.Exception;

    public java.util.List<edu.upn.sigecac.pac.be.DetalleMatrizAlineamientoObjetivosEducacionales> listar() throws java.lang.Exception;

    public edu.upn.sigecac.pac.be.DetalleMatrizAlineamientoObjetivosEducacionales find(java.lang.Object id);

    public java.util.List<edu.upn.sigecac.pac.be.DetalleMatrizAlineamientoObjetivosEducacionales> findAll();
    
}
