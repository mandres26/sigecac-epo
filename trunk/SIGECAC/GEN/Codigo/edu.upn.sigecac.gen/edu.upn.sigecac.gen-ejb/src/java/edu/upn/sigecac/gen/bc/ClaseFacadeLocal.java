/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.sigecac.gen.bc;

import edu.upn.sigecac.gen.be.Clase;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Administrador
 */
@Local
public interface ClaseFacadeLocal {

    public List<Clase> listar() throws Exception;

    public List<Clase> listarPorCurso(String idCurso) throws Exception;

    public Clase porId(String id) throws Exception;
}
