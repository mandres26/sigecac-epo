/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.gcu.bc;

import edu.upn.sigecac.gcu.be.MallaCurricular;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Administrador
 */
@Local
public interface MallaCurricularFacadeLocal {

    void create(MallaCurricular mallaCurricular);

    void edit(MallaCurricular mallaCurricular);

    void remove(MallaCurricular mallaCurricular);

    MallaCurricular find(Object id);

    List<MallaCurricular> findAll();

}
