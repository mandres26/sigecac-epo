package edu.upn.sigecac.pac.beans;

import edu.upn.sigecac.pac.bc.CapacidadMedibleFacadeLocal;
import edu.upn.sigecac.pac.be.CapacidadMedible;
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

public class CapacidadMedibleController {

    private CapacidadMedibleFacadeLocal local;
    private CapacidadMedible capacidadMedible;
    public ResultadoPrograma resultadoSeleccionado;
    private List<CapacidadMedible> listaCapacidadMedible;

    public CapacidadMedibleController() {
        local = lookupCapacidadMedibleFacadeBean();
        resultadoSeleccionado = new ResultadoPrograma();
        this.listaCapacidadMedible = new ArrayList<CapacidadMedible>();

    }

   public CapacidadMedible getCapacidadMedible() {
        return capacidadMedible;
    }

    public void setCapacidadMedible(CapacidadMedible capacidadMedible) {
        this.capacidadMedible = capacidadMedible;
    }

    public ResultadoPrograma getResultadoSeleccionado() {
        return resultadoSeleccionado;
    }

    public void setResultadoSeleccionado(ResultadoPrograma resultadoSeleccionado) {
        this.resultadoSeleccionado = resultadoSeleccionado;
    }

    public String nuevo() {
        
        if(CapacidadMedibleController.this.resultadoSeleccionado != null){
        capacidadMedible = new CapacidadMedible();
        capacidadMedible.setFidResultadoPrograma(resultadoSeleccionado);
        return "nuevoCapacidad";
        }else{
            mostrarMensaje("Error: ", "Debe seleccionar un Resultado del Programa.", FacesMessage.SEVERITY_ERROR);
            return "";
        }
    }

    public String cancelar() {
        
        return "listarCapacidad";
    }

    public String listarResultados() {
        return "listarResultado";
    }

    public String registrar() {
        try {
            if (!capacidadMedible.getNombre().equals("") && !capacidadMedible.getNombre().isEmpty()) {
                local.registrar(capacidadMedible);
                capacidadMedible = new CapacidadMedible();
                mostrarMensaje("Éxito: ", "El registro de la Capacidad Medible se realizó exitosamente.", FacesMessage.SEVERITY_INFO);
                
            } else {
                mostrarMensaje("Error: ", "Ingrese un nombre de Capacidad Medible.", FacesMessage.SEVERITY_ERROR);         
                return "";
            }
        } catch (Exception e) {
            local = lookupCapacidadMedibleFacadeBean();
            mostrarMensaje("Error: ", "Error en el registro de la Capacidad Medible.", FacesMessage.SEVERITY_ERROR);           
            return "";
        }
        return "listarCapacidad";
    }

    public String actualizar() {
        try {
            if (!capacidadMedible.getNombre().equals("") && !capacidadMedible.getNombre().isEmpty()) {
                local.actualizar(capacidadMedible);
                mostrarMensaje("Éxito: ", "La actualización de la Capacidad Medible se realizó exitosamente.", FacesMessage.SEVERITY_INFO);
            } else {
                mostrarMensaje("Error: ", "Ingrese un nombre de Capacidad Medible.", FacesMessage.SEVERITY_ERROR);
                this.cancelar();
                return "";
            }
        } catch (Exception e) {
            local = lookupCapacidadMedibleFacadeBean();
            mostrarMensaje(e.getMessage(), e.getMessage(), FacesMessage.SEVERITY_ERROR);
            return "";
        }
        return "listarCapacidad";
    }

    public String eliminar() {
        try {
            if (capacidadMedible != null) {
                local.eliminar(capacidadMedible);
                mostrarMensaje("Éxito: ", "La eliminación de la Capacidad Medible se realizó exitosamente.", FacesMessage.SEVERITY_INFO);
            } else {
                mostrarMensaje("Error: ", "Asegúrese de haber seleccionado una Capacidad Medible.", FacesMessage.SEVERITY_ERROR);
                return "";
            }
        } catch (Exception e) {
            local = lookupCapacidadMedibleFacadeBean();
            mostrarMensaje(e.getMessage(), e.getMessage(), FacesMessage.SEVERITY_ERROR);
            return "";
        }
        return "listarCapacidad";
    }

    public List<CapacidadMedible> getCapacidadesMedible() {
        try {
            return local.listar();
        } catch (Exception e) {
            local = lookupCapacidadMedibleFacadeBean();
            e.printStackTrace();
        }
        return null;
    }

    //
    public List<CapacidadMedible> getCapacidadesMediblePorResultado() {
        try {
            return local.capacidadxResultado(resultadoSeleccionado);
        } catch (Exception e) {
            local = lookupCapacidadMedibleFacadeBean();
            e.printStackTrace();
        }
        return null;
    }

    public CapacidadMedible buscarCapacidadMedible(Long id) throws Exception {
        try {
            return local.buscarPorId(id);
        } catch (Exception e) {
            mostrarMensaje(e.getMessage(), e.getMessage(), FacesMessage.SEVERITY_ERROR);
        }return null;
    }

    public List<CapacidadMedible> capacidadxResultado(ResultadoPrograma resultadoSeleccionado)throws Exception {
        try {
            return local.capacidadxResultado(resultadoSeleccionado);
        } catch (Exception e) {
            local = lookupCapacidadMedibleFacadeBean();
            e.printStackTrace();
        }
        return null;
    }

   public SelectItem[] getComboCapacidades() {
        List<CapacidadMedible> listaCapacidades1;
        try {
            listaCapacidades1 = new ArrayList<CapacidadMedible>();
            listaCapacidades1 = local.findAll();
            SelectItem[] comboCapacidades = new SelectItem[listaCapacidades1.size()];
            for (int i = 0; i < listaCapacidades1.size(); i++) {
                comboCapacidades[i] = new SelectItem(listaCapacidades1.get(i), listaCapacidades1.get(i).getNombre());
            }
            return comboCapacidades;

        } catch (Exception e) {
            //Mensaje al usuario
            listaCapacidades1 = new ArrayList<CapacidadMedible>();
            SelectItem[] comboCapacidades = new SelectItem[1];
            comboCapacidades[0] = new SelectItem(new CapacidadMedible(), "No hay Capacidades Medibles.");
            return comboCapacidades;
        }

    }


    public void mostrarMensaje(String resumen, String detalle, FacesMessage.Severity severidad) {
        try {
            FacesMessage fm = new FacesMessage(severidad, resumen, detalle);
            FacesContext.getCurrentInstance().addMessage(fm.toString(), fm);
        } catch (Exception e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            FacesContext.getCurrentInstance().addMessage(fm.toString(), fm);
        }
    }

    private CapacidadMedibleFacadeLocal lookupCapacidadMedibleFacadeBean() {
        try {
            Context c = new InitialContext();
            return (CapacidadMedibleFacadeLocal) c.lookup("java:comp/env/CapacidadMedibleFacadeBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public String processValueChange(ValueChangeEvent event) {

        listaCapacidadMedible = getCapacidadesMediblePorResultado();
        return "";
    }

    public List<CapacidadMedible> getListaCapacidadMedible() {
        return listaCapacidadMedible;
    }

    public void setListaCapacidadMedible(List<CapacidadMedible> listaCapacidadMedible) {
        this.listaCapacidadMedible = listaCapacidadMedible;
    }

  }