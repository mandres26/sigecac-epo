/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.sigecac.gen.bc;

import edu.upn.sigecac.gen.be.Alumno;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Administrador
 */
@Local
public interface AlumnoFacadeLocal {

    public java.util.List<edu.upn.sigecac.gen.be.Alumno> buscarXSegmento(String cicloVida, String perfil, int notaMin, int notaMax) throws java.lang.Exception;

    public List<Alumno> listarxNotas(int notaMin, int notaMax) throws Exception;

    public List<Alumno> buscarCicloxCVida(String cicloSeleccionada, String carreraVidaSeleccionada, int notaMin, int notaMax) throws Exception;

    public List<Alumno> buscarCicloxCVidaxPerfil(String cicloSeleccionada, String carreraVidaSeleccionada, int notaMin, int notaMax, String perfilSeleccionado) throws Exception;

    public List<Alumno> buscarXCiclo(String cicloSeleccionada, int notaMin, int notaMax) throws Exception;

    public List<Alumno> buscarXCicloPerfilNotas(String cicloSeleccionada, String perfilSeleccionado, int notaMin, int notaMax) throws Exception;

    public List<Alumno> buscarXPerfil(String perfilSeleccionado, int notaMin, int notaMax) throws Exception;

    public List<Alumno> buscarXCicloVida(String cicloVidaSeleccionado, int notaMin, int notaMax) throws Exception;

    public void registrar(edu.upn.sigecac.gen.be.Alumno a) throws java.lang.Exception;

    public void editar(edu.upn.sigecac.gen.be.Alumno a) throws java.lang.Exception;

    public void eliminar(edu.upn.sigecac.gen.be.Alumno a) throws java.lang.Exception;

    public edu.upn.sigecac.gen.be.Alumno buscarPorId(java.lang.Long idAlumno) throws java.lang.Exception;

    public java.util.List<edu.upn.sigecac.gen.be.Alumno> listar() throws java.lang.Exception;
}
