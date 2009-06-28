/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.sigecac.gcu.bc;

import edu.upn.sigecac.gcu.be.Ciclo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Administrador
 */
@Local
public interface CicloFacadeLocal {

    void create(Ciclo ciclo);

    void edit(Ciclo ciclo);

    void remove(Ciclo ciclo);

    Ciclo find(Object id);

    List<Ciclo> findAll();

    public java.util.List<edu.upn.sigecac.gcu.be.Ciclo> findByName(java.lang.String ciclo);
}
