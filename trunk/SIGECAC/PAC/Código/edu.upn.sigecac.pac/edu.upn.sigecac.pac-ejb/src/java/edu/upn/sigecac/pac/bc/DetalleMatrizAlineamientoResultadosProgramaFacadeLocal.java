

package edu.upn.sigecac.pac.bc;

import edu.upn.sigecac.pac.be.DetalleMatrizAlineamientoResultadosPrograma;
import java.util.List;
import javax.ejb.Local;


@Local
public interface DetalleMatrizAlineamientoResultadosProgramaFacadeLocal {

    void create(DetalleMatrizAlineamientoResultadosPrograma detalleMatrizAlineamientoResultadosPrograma);

    void edit(DetalleMatrizAlineamientoResultadosPrograma detalleMatrizAlineamientoResultadosPrograma);

    void remove(DetalleMatrizAlineamientoResultadosPrograma detalleMatrizAlineamientoResultadosPrograma);

    DetalleMatrizAlineamientoResultadosPrograma find(Object id);

    List<DetalleMatrizAlineamientoResultadosPrograma> findAll();

}
