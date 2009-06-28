package edu.upn.sigecac.pac.bc;

import javax.ejb.Local;

@Local
public interface CriterioFacadeLocal {

    public void registrar(edu.upn.sigecac.pac.be.Criterio c) throws java.lang.Exception;

    public void actualizar(edu.upn.sigecac.pac.be.Criterio c) throws java.lang.Exception;

    public void eliminar(edu.upn.sigecac.pac.be.Criterio c) throws java.lang.Exception;

    public edu.upn.sigecac.pac.be.Criterio buscarPorId(java.lang.Long idCriterio) throws java.lang.Exception;

    public java.util.List<edu.upn.sigecac.pac.be.Criterio> listar() throws java.lang.Exception;

    public java.util.List<edu.upn.sigecac.pac.be.Criterio> criterioxCapacidad(edu.upn.sigecac.pac.be.CapacidadMedible capacidadSeleccionada);

    public java.util.List<edu.upn.sigecac.pac.be.Criterio> findAll();

}
