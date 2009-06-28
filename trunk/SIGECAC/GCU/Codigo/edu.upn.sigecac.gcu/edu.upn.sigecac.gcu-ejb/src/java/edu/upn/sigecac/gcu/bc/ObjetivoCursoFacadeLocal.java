/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.sigecac.gcu.bc;

import edu.upn.sigecac.gcu.be.ObjetivoCurso;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Administrador
 */
@Local
public interface ObjetivoCursoFacadeLocal {

    void create(ObjetivoCurso objetivoCurso);

    void edit(ObjetivoCurso objetivoCurso);

    void remove(ObjetivoCurso objetivoCurso);

    List<ObjetivoCurso> findAll();

    public edu.upn.sigecac.gcu.be.ObjetivoCurso find(java.lang.Long idObjetivocurso) throws Exception;

    public java.util.List<edu.upn.sigecac.gcu.be.ObjetivoCurso> listarObjCursoPorEdicion(edu.upn.sigecac.gcu.be.EdicionCurso edicion);
}
