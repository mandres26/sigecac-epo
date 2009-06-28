package edu.upn.sigecac.pac.bc;

import edu.upn.sigecac.pac.be.MatrizAlineamientoResultadosPrograma;
import java.util.List;
import javax.ejb.Local;


@Local
public interface MatrizAlineamientoResultadosProgramaFacadeLocal {

    void create(MatrizAlineamientoResultadosPrograma matrizAlineamientoResultadosPrograma);

    void edit(MatrizAlineamientoResultadosPrograma matrizAlineamientoResultadosPrograma);

    void remove(MatrizAlineamientoResultadosPrograma matrizAlineamientoResultadosPrograma);

    MatrizAlineamientoResultadosPrograma find(Object id);

    List<MatrizAlineamientoResultadosPrograma> findAll();

}
