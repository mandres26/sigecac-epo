/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.sigecac.pac.bc;

import edu.upn.sigecac.pac.be.ResultadoPrograma;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ResultadoProgramaFacadeLocal {

    void create(ResultadoPrograma resultadoPrograma);

    void edit(ResultadoPrograma resultadoPrograma);

    void remove(ResultadoPrograma resultadoPrograma);

    ResultadoPrograma find(Object id);

    List<ResultadoPrograma> findAll();

    public java.util.List<edu.upn.sigecac.pac.be.ResultadoPrograma> listarxEstado(boolean var);

    public List<edu.upn.sigecac.pac.be.ResultadoPrograma> listarxCarrera(Long idCarrera);
}
