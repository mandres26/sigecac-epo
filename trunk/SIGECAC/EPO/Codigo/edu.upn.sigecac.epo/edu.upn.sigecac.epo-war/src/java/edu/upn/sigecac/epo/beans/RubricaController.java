 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.sigecac.epo.beans;

import edu.upn.sigecac.epo.bc.CriterioEvaluacionLocal;
import edu.upn.sigecac.epo.bc.RubricaLocal;
import edu.upn.sigecac.epo.be.CriterioEvaluacion;
import edu.upn.sigecac.epo.be.Rubrica;
import edu.upn.sigecac.pac.bc.CapacidadMedibleFacadeLocal;
import edu.upn.sigecac.pac.bc.CriterioFacadeLocal;
import edu.upn.sigecac.pac.bc.NivelFacadeLocal;
import edu.upn.sigecac.pac.bc.ResultadoProgramaFacadeLocal;
import edu.upn.sigecac.pac.be.CapacidadMedible;
import edu.upn.sigecac.pac.be.Criterio;
import edu.upn.sigecac.pac.be.Nivel;
import edu.upn.sigecac.pac.be.ResultadoPrograma;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.model.SelectItem;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author texai
 */
public class RubricaController {

    private RubricaLocal local;
    private ResultadoProgramaFacadeLocal localResultadoPrograma;
    private CapacidadMedibleFacadeLocal localCapacidadMedible;
    private CriterioFacadeLocal localCriterio;
    private CriterioEvaluacionLocal localCriterioEvaluacion;
    private NivelFacadeLocal localNivel;
    private ResultadoPrograma resultadoProgramaSeleccionado;
    private CapacidadMedible capacidadMedibleSeleccionada;
    private Criterio criterioSeleccionado;
    private Rubrica rubrica;
    private Rubrica rubricaSeleccionada;
    private CriterioEvaluacion criterioEvaluacion;
    private List<CriterioEvaluacion> listaCriteriosEvaluacion;
    private CriterioEvaluacion criterioEvaluacionEliminar;

    public CriterioEvaluacion getCriterioEvaluacionEliminar() {
        return criterioEvaluacionEliminar;
    }

    public void setCriterioEvaluacionEliminar(CriterioEvaluacion criterioEvaluacionEliminar) {
        this.criterioEvaluacionEliminar = criterioEvaluacionEliminar;
    }

    public List<CriterioEvaluacion> getListaCriteriosEvaluacion() {
        return listaCriteriosEvaluacion;
    }

    public void setListaCriteriosEvaluacion(List<CriterioEvaluacion> listaCriteriosEvaluacion) {
        this.listaCriteriosEvaluacion = listaCriteriosEvaluacion;
    }

    public String agregarCriterio() {
        if (listaCriteriosEvaluacion == null) {
            listaCriteriosEvaluacion = new ArrayList<CriterioEvaluacion>();
        }
        criterioEvaluacion.setFidPACCriterio(criterioSeleccionado);
        this.listaCriteriosEvaluacion.add(criterioEvaluacion);
        return "ok";
    }

    public String eliminarCriterio() {
        listaCriteriosEvaluacion.remove(criterioEvaluacionEliminar);
        return "refresh";
    }

    public CapacidadMedible getCapacidadMedibleSeleccionada() {
        return capacidadMedibleSeleccionada;
    }

    public void setCapacidadMedibleSeleccionada(CapacidadMedible capacidadMedibleSeleccionada) {
        this.capacidadMedibleSeleccionada = capacidadMedibleSeleccionada;
    }

    public Criterio getCriterioSeleccionado() {
        return criterioSeleccionado;
    }

    public void setCriterioSeleccionado(Criterio criterioSeleccionado) {
        this.criterioSeleccionado = criterioSeleccionado;
    }

    public ResultadoPrograma getResultadoProgramaSeleccionado() {
        return resultadoProgramaSeleccionado;
    }

    public void setResultadoProgramaSeleccionado(ResultadoPrograma resultadoProgramaSeleccionado) {
        this.resultadoProgramaSeleccionado = resultadoProgramaSeleccionado;
    }

    public CriterioEvaluacion getCriterioEvaluacion() {
        return criterioEvaluacion;
    }

    public void setCriterioEvaluacion(CriterioEvaluacion criterioEvaluacion) {
        this.criterioEvaluacion = criterioEvaluacion;
    }

    public Rubrica getRubricaSeleccionada() {
        return rubricaSeleccionada;
    }

    public void setRubricaSeleccionada(Rubrica rubricaSeleccionada) {
        this.rubricaSeleccionada = rubricaSeleccionada;
    }

    public Rubrica getRubrica() {
        return rubrica;
    }

    public void setRubrica(Rubrica rubrica) {
        this.rubrica = rubrica;
    }

    public RubricaController() {
        local = lookup();
        localResultadoPrograma = lookupRP();
        localCapacidadMedible = lookupCM();
        localCriterio = lookupCriterio();
        localNivel = lookupNivel();
        localCriterioEvaluacion = lookupCriterioEvaluacion();
    }

    public String verDetalleRubrica() {
        rubricaSeleccionada.setCriterioEvaluacionCollection(getListaCriteriosEvaluacionPorRubrica(rubricaSeleccionada));
        return "rubrica_ver";
    }

    public String nuevo() {
        rubrica = new Rubrica();
        if (listaCriteriosEvaluacion != null) {
            listaCriteriosEvaluacion = null;
        }
        return "rubrica_nuevo";
    }

    public String nuevoCE() {
        criterioEvaluacion = new CriterioEvaluacion();
        resultadoProgramaSeleccionado = null;
        capacidadMedibleSeleccionada = null;
        criterioSeleccionado = null;
        return "rubrica_nuevoCriterio";
    }

    public String registrar() {
        try {
            local.registrar(rubrica);
            int i;
            for (i = 0; i < listaCriteriosEvaluacion.size(); i++) {
                CriterioEvaluacion ce = listaCriteriosEvaluacion.get(i);
                ce.setFidRubrica(rubrica);
                localCriterioEvaluacion.registrar(ce);
            }
        } catch (Exception ex) {
            Logger.getLogger(RubricaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "ok";
    }

    public List<Rubrica> getListaRubrica() {
        try {
            return local.listar();
        } catch (Exception e) {
            local = lookup();
            e.printStackTrace();
        }
        return null;
    }

    public SelectItem[] getListaRubricaAsItems() {
        List<Rubrica> lista = getListaRubrica();
        SelectItem[] select = new SelectItem[lista.size()];
        int i = 0;
        for (Rubrica x : lista) {
            select[i++] = new SelectItem(x, x.getNombre());
        }
        return select;
    }

    public List<ResultadoPrograma> getListaRP() {
        try {
            return localResultadoPrograma.findAll();
        } catch (Exception e) {
            local = lookup();
            e.printStackTrace();
        }
        return null;
    }

    public SelectItem[] getListaRPAsItems() {
        List<ResultadoPrograma> lista = getListaRP();
        SelectItem[] select = new SelectItem[lista.size()];
        int i = 0;
        for (ResultadoPrograma x : lista) {
            select[i++] = new SelectItem(x, x.getNombre());
        }
        return select;
    }

    public List<CapacidadMedible> getListaCMPorRP() {
        try {
            return localCapacidadMedible.capacidadxResultado(resultadoProgramaSeleccionado);
        } catch (Exception e) {
            local = lookup();
            e.printStackTrace();
        }
        return null;
    }

    public SelectItem[] getListaCMPorRPAsItems() {
        List<CapacidadMedible> lista = getListaCMPorRP();
        SelectItem[] select = new SelectItem[lista.size()];
        int i = 0;
        for (CapacidadMedible x : lista) {
            select[i++] = new SelectItem(x, x.getNombre());
        }
        return select;
    }

    public List<Criterio> getListaCriteriosPorCM() {
        try {
            return localCriterio.criterioxCapacidad(capacidadMedibleSeleccionada);
        } catch (Exception e) {
            local = lookup();
            e.printStackTrace();
        }
        return null;
    }

    public SelectItem[] getListaCriteriosPorCMAsItems() {
        List<Criterio> lista = getListaCriteriosPorCM();
        SelectItem[] select = new SelectItem[lista.size()];
        int i = 0;
        for (Criterio x : lista) {
            select[i++] = new SelectItem(x, x.getNombre());
        }
        return select;
    }

    public List<Nivel> getListaNivelesPorCriterio() {
        try {
            return localNivel.nivelxCriterio(criterioSeleccionado);
        } catch (Exception e) {
            local = lookup();
            e.printStackTrace();
        }
        return null;
    }

    public SelectItem[] getListaNivelesPorCriterioAsItems() {
        List<Nivel> lista = getListaNivelesPorCriterio();
        SelectItem[] select = new SelectItem[lista.size()];
        int i = 0;
        for (Nivel x : lista) {
            select[i++] = new SelectItem(x, x.getNombre());
        }
        return select;
    }

    public List<CriterioEvaluacion> getListaCriteriosEvaluacionPorRubrica(Rubrica r) {
        try {
            return localCriterioEvaluacion.buscarPorRubrica(r);
        } catch (Exception e) {
            local = lookup();
            e.printStackTrace();
        }
        return null;
    }

    public Rubrica porId(String id) {
        try {
            return local.porId(id);
        } catch (Exception e) {
            local = lookup();
            e.printStackTrace();
        }
        return null;
    }

    public ResultadoPrograma porIdRP(String id) {
        try {
            return localResultadoPrograma.find(Long.valueOf(id));
        } catch (Exception e) {
            local = lookup();
            e.printStackTrace();
        }
        return null;
    }

    public CapacidadMedible porIdCM(String id) {
        try {
            return localCapacidadMedible.buscarPorId(Long.valueOf(id));
        } catch (Exception e) {
            local = lookup();
            e.printStackTrace();
        }
        return null;
    }

    public Criterio porIdCriterio(String id) {
        try {
            return localCriterio.buscarPorId(Long.valueOf(id));
        } catch (Exception e) {
            local = lookup();
            e.printStackTrace();
        }
        return null;
    }

    public Nivel porIdNivel(String id) {
        try {
            return localNivel.buscarPorId(Long.valueOf(id));
        } catch (Exception e) {
            local = lookup();
            e.printStackTrace();
        }
        return null;
    }

    private RubricaLocal lookup() {
        try {
            Context c = new InitialContext();
            return (RubricaLocal) c.lookup("java:comp/env/RubricaBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private ResultadoProgramaFacadeLocal lookupRP() {
        try {
            Context c = new InitialContext();
            return (ResultadoProgramaFacadeLocal) c.lookup("java:comp/env/ResultadoProgramaFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private CapacidadMedibleFacadeLocal lookupCM() {
        try {
            Context c = new InitialContext();
            return (CapacidadMedibleFacadeLocal) c.lookup("java:comp/env/CapacidadMedibleFacadeBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private CriterioFacadeLocal lookupCriterio() {
        try {
            Context c = new InitialContext();
            return (CriterioFacadeLocal) c.lookup("java:comp/env/CriterioFacadeBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private NivelFacadeLocal lookupNivel() {
        try {
            Context c = new InitialContext();
            return (NivelFacadeLocal) c.lookup("java:comp/env/NivelFacadeBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private CriterioEvaluacionLocal lookupCriterioEvaluacion() {
        try {
            Context c = new InitialContext();
            return (CriterioEvaluacionLocal) c.lookup("java:comp/env/CriterioEvaluacionBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}

