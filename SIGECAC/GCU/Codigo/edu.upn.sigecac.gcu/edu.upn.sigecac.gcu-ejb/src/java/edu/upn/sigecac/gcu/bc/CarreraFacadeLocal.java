/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.gcu.bc;

import edu.upn.sigecac.gcu.be.Carrera;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Administrador
 */
@Local
public interface CarreraFacadeLocal {

    void create(Carrera carrera);

    void edit(Carrera carrera);

    void remove(Carrera carrera);

    Carrera find(Object id);

    List<Carrera> findAll();

}
