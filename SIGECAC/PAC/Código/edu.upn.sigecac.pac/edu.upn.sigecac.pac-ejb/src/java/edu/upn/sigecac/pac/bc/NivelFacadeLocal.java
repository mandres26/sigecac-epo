

package edu.upn.sigecac.pac.bc;

import javax.ejb.Local;


@Local
public interface NivelFacadeLocal {

    public void registrar(edu.upn.sigecac.pac.be.Nivel n) throws java.lang.Exception;

    public void actualizar(edu.upn.sigecac.pac.be.Nivel n) throws java.lang.Exception;

    public void eliminar(edu.upn.sigecac.pac.be.Nivel n) throws java.lang.Exception;

    public edu.upn.sigecac.pac.be.Nivel buscarPorId(java.lang.Long idNivel) throws java.lang.Exception;

    public java.util.List<edu.upn.sigecac.pac.be.Nivel> listar() throws java.lang.Exception;

    public java.util.List<edu.upn.sigecac.pac.be.Nivel> nivelxCriterio(edu.upn.sigecac.pac.be.Criterio criterioSeleccionado);

    public java.util.List<edu.upn.sigecac.pac.be.Nivel> findAll();

    //public java.util.List<edu.upn.sigecac.pac.be.Nivel> buscarNivelPorCriterio(java.lang.Long idCriterio);
}