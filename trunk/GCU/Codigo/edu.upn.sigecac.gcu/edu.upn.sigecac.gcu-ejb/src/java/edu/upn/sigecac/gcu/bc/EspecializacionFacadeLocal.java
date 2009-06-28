/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.gcu.bc;

import edu.upn.sigecac.gcu.be.Especializacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Administrador
 */
@Local
public interface EspecializacionFacadeLocal {

    void create(Especializacion especializacion);

    void edit(Especializacion especializacion);

    void remove(Especializacion especializacion);

    Especializacion find(Object id);

    List<Especializacion> findAll();

}
