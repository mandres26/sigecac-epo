package edu.upn.sigecac.pac.beans;

import edu.upn.sigecac.pac.bc.CriterioFacadeLocal;
import edu.upn.sigecac.pac.be.CapacidadMedible;
import edu.upn.sigecac.pac.be.Criterio;
import edu.upn.sigecac.pac.be.ResultadoPrograma;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class CriterioController {

    private CriterioFacadeLocal local;
    private Criterio criterio;
    public ResultadoPrograma resultadoSeleccionado;
    public CapacidadMedible capacidadSeleccionada;
    private List<Criterio> listaCriterio;

    public CriterioController() {
        local = lookupCriterioFacadeBean();
        resultadoSeleccionado = new ResultadoPrograma();
        capacidadSeleccionada = new CapacidadMedible();
        this.listaCriterio = new ArrayList<Criterio>();
    }

    public Criterio getCriterio() {
        return criterio;
    }

    public void setCriterio(Criterio criterio) {
        this.criterio = criterio;
    }

    public CapacidadMedible getCapacidadSeleccionada() {
        return capacidadSeleccionada;
    }

    public void setCapacidadSeleccionada(CapacidadMedible capacidadSeleccionada) {
        this.capacidadSeleccionada = capacidadSeleccionada;
    }

    public ResultadoPrograma getResultadoSeleccionado() {
        return resultadoSeleccionado;
    }

    public void setResultadoSeleccionado(ResultadoPrograma resultadoSeleccionado) {
        this.resultadoSeleccionado = resultadoSeleccionado;
    }

    public List<Criterio> getListaCriterio() {
        return listaCriterio;
    }

    public void setListaCriterio(List<Criterio> listaCriterio) {
        this.listaCriterio = listaCriterio;
    }

    public String nuevo() {
        //CriterioController.this.capacidadSeleccionada.getIdCapacidadMedible();
        if(CriterioController.this.resultadoSeleccionado != null && CriterioController.this.capacidadSeleccionada != null){
            criterio = new Criterio();
            criterio.setFidCapacidadMedible(capacidadSeleccionada);
            return "nuevoCriterio";
        }else{
            mostrarMensaje("Error: ", "Debe seleccionar un Resultado del Programa y una Capacidad Medible.", FacesMessage.SEVERITY_ERROR);
            return "";
        }
        
    }

    public String cancelar() {
        return "listarCriterio";
    }

    public String listarCapacidadMedible() {
        return "listarCapacidad";
    }

    public String registrar() {
        try {
            if (!criterio.getNombre().equals("") && !criterio.getNombre().isEmpty()) {
                local.registrar(criterio);
                criterio = new Criterio();
                mostrarMensaje("Éxito: ", "El registro del Criterio se realizó exitosamente.", FacesMessage.SEVERITY_INFO);
            } else {
                mostrarMensaje("Error: ", "Ingrese un nombre de Criterio.", FacesMessage.SEVERITY_ERROR);
                
                return "";
            }
        } catch (Exception e) {
            local = lookupCriterioFacadeBean();         
            mostrarMensaje("Error: ", "Error en el registro del Criterio.", FacesMessage.SEVERITY_ERROR);
            return "";
        }
        return "listarCriterio";
    }

    public String actualizar() {
        try {
            if (!criterio.getNombre().equals("") && !criterio.getNombre().isEmpty()) {
                local.actualizar(criterio);
                mostrarMensaje("Éxito: ", "La actualización del Criterio se realizó exitosamente.", FacesMessage.SEVERITY_INFO);
            } else {
                mostrarMensaje("Error: ", "Asegúrese de haber ingresado un Criterio.", FacesMessage.SEVERITY_ERROR);
                this.cancelar();
                return "";
            }
        } catch (Exception e) {
            local = lookupCriterioFacadeBean();
            mostrarMensaje(e.getMessage(), e.getMessage(), FacesMessage.SEVERITY_ERROR);
            return "";
        }
        return "listarCriterio";
    }

    public String eliminar() {
        try {
            if (criterio != null) {
                local.eliminar(criterio);
                mostrarMensaje("Éxito: ", "La eliminación del Criterio se realizó exitosamente.", FacesMessage.SEVERITY_INFO);
            } else {
                mostrarMensaje("Error: ", "Asegúrese de haber seleccionado un Criterio.", FacesMessage.SEVERITY_ERROR);
                return "";
            }
        } catch (Exception e) {
            local = lookupCriterioFacadeBean();
            mostrarMensaje(e.getMessage(), e.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
        return "listarCriterio";
    }

    public Criterio buscarCriterio(Long idCriterio) {

        try {
            return local.buscarPorId(idCriterio);

        } catch (Exception e) {
//            local=lookupCriterioFacadeBean();
//            return new Criterio();
            mostrarMensaje(e.getMessage(), e.getMessage(), FacesMessage.SEVERITY_ERROR);
        }return null;

    }

    public List<Criterio> getCriterios() {
        try {
            return local.listar();
        } catch (Exception e) {
            local = lookupCriterioFacadeBean();
            e.printStackTrace();
        }
        return null;
    }

    public String processValueChange(ValueChangeEvent event) {

        listaCriterio = getCriteriosPorCapacidad();
        return "";
    }

    public List<Criterio> getCriteriosPorCapacidad() {
        try {
            return local.criterioxCapacidad(capacidadSeleccionada);

        } catch (Exception e) {
            local = lookupCriterioFacadeBean();
            e.printStackTrace();
        }
        return null;
    }

     public List<Criterio> criterioxCapacidad(CapacidadMedible capacidadSeleccionada)throws Exception {
        try {
            return local.criterioxCapacidad(capacidadSeleccionada);
        } catch (Exception e) {
            local = lookupCriterioFacadeBean();
            e.printStackTrace();
        }
        return null;
    }

    public SelectItem[] getComboCriterios() {
        List<Criterio> listaCriterios1;
        try {
            listaCriterios1 = new ArrayList<Criterio>();
            listaCriterios1 = local.findAll();
            SelectItem[] comboCriterios = new SelectItem[listaCriterios1.size()];
            for (int i = 0; i < listaCriterios1.size(); i++) {
                comboCriterios[i] = new SelectItem(listaCriterios1.get(i), listaCriterios1.get(i).getNombre());
            }
            return comboCriterios;

        } catch (Exception e) {
            //Mensaje al usuario
            listaCriterios1 = new ArrayList<Criterio>();
            SelectItem[] comboCriterios = new SelectItem[1];
            comboCriterios[0] = new SelectItem(new Criterio(), "No hay Criterios.");
            return comboCriterios;
        }

    }

    public String calcularCombo() {
        getComboCapacidadesxResultado();
        return "";
    }


    public SelectItem[] getComboCapacidadesxResultado() {
        List<CapacidadMedible> lista;
        try {
            lista = new ArrayList<CapacidadMedible>();
            CapacidadMedibleController delegateCapacidad = new CapacidadMedibleController();
            lista = delegateCapacidad.capacidadxResultado(resultadoSeleccionado);
            SelectItem[] comboCapacidades = new SelectItem[lista.size()];
            for (int i = 0; i < lista.size(); i++) {
                comboCapacidades[i] = new SelectItem(lista.get(i), lista.get(i).getNombre());
            }
            //cambiarListaCriterios();
            return comboCapacidades;

        } catch (Exception e) {
            //Mensaje al usuario
            lista = new ArrayList<CapacidadMedible>();
            SelectItem[] comboCapacidades = new SelectItem[1];
            comboCapacidades[0] = new SelectItem(new CapacidadMedible(), "No hay Capacidades Medibles.");
            //cambiarListaCriterios();
            return comboCapacidades;
        }

    }



    //Metodo para mostrar mensajes en la pagina
    public void mostrarMensaje(String resumen, String detalle, FacesMessage.Severity severidad) {
        try {
            FacesMessage fm = new FacesMessage(severidad, resumen, detalle);
            FacesContext.getCurrentInstance().addMessage(fm.toString(), fm);
        } catch (Exception e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext.getCurrentInstance().addMessage(fm.toString(), fm);
        }
    }

    private CriterioFacadeLocal lookupCriterioFacadeBean() {
        try {
            Context c = new InitialContext();
            return (CriterioFacadeLocal) c.lookup("java:comp/env/CriterioFacadeBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
