package edu.upn.sigecac.pac.bc;

import edu.upn.sigecac.pac.be.CapacidadMedible;
import edu.upn.sigecac.pac.be.ResultadoPrograma;

import java.util.List;
import javax.ejb.Local;

@Local
public interface CapacidadMedibleFacadeLocal {

    public void registrar(edu.upn.sigecac.pac.be.CapacidadMedible c) throws java.lang.Exception;

    public void actualizar(edu.upn.sigecac.pac.be.CapacidadMedible c) throws java.lang.Exception;

    public void eliminar(edu.upn.sigecac.pac.be.CapacidadMedible c) throws java.lang.Exception;

    public edu.upn.sigecac.pac.be.CapacidadMedible buscarPorId(java.lang.Long idCapacidadMedible) throws java.lang.Exception;

    public java.util.List<edu.upn.sigecac.pac.be.CapacidadMedible> listar() throws java.lang.Exception;

    public java.util.List<edu.upn.sigecac.pac.be.CapacidadMedible> capacidadxResultado(edu.upn.sigecac.pac.be.ResultadoPrograma resultadoSeleccionado);

    public java.util.List<edu.upn.sigecac.pac.be.CapacidadMedible> findAll();

}
