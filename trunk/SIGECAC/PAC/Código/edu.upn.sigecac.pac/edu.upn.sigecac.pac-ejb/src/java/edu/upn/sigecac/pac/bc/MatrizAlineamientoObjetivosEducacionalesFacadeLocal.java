package edu.upn.sigecac.pac.bc;

import javax.ejb.Local;

@Local
public interface MatrizAlineamientoObjetivosEducacionalesFacadeLocal {

  
    public void registrar(edu.upn.sigecac.pac.be.MatrizAlineamientoObjetivosEducacionales maoe) throws java.lang.Exception;

    public void actualizar(edu.upn.sigecac.pac.be.MatrizAlineamientoObjetivosEducacionales maoe) throws java.lang.Exception;

    public void eliminar(edu.upn.sigecac.pac.be.MatrizAlineamientoObjetivosEducacionales maoe) throws java.lang.Exception;

    public edu.upn.sigecac.pac.be.MatrizAlineamientoObjetivosEducacionales buscarPorId(java.lang.Long idMatrizAlineamientoObjetivosEducacionales) throws java.lang.Exception;

    public java.util.List<edu.upn.sigecac.pac.be.MatrizAlineamientoObjetivosEducacionales> listar() throws java.lang.Exception;

    public java.util.List<edu.upn.sigecac.pac.be.MatrizAlineamientoObjetivosEducacionales> buscarCapacidadPorResultadoPrograma(java.lang.Long idResultadoPrograma);

    public edu.upn.sigecac.pac.be.MatrizAlineamientoObjetivosEducacionales find(java.lang.Object id);

    public java.util.List<edu.upn.sigecac.pac.be.MatrizAlineamientoObjetivosEducacionales> findAll();


    
}
