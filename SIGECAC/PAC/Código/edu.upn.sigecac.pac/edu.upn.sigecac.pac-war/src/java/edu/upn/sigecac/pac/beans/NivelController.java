package edu.upn.sigecac.pac.beans;

import edu.upn.sigecac.pac.bc.NivelFacadeLocal;
import edu.upn.sigecac.pac.be.CapacidadMedible;
import edu.upn.sigecac.pac.be.Criterio;
import edu.upn.sigecac.pac.be.Nivel;
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

public class NivelController {

    private NivelFacadeLocal local;
    private Nivel nivel;
    public ResultadoPrograma resultadoSeleccionado;
    public CapacidadMedible capacidadSeleccionada;
    public Criterio criterioSeleccionado;
    private List<Nivel> listaNivel;

    public NivelController() {
        local = lookupNivelFacadeBean();
        resultadoSeleccionado = new ResultadoPrograma();
        capacidadSeleccionada = new CapacidadMedible();
        criterioSeleccionado = new Criterio();
        this.listaNivel = new ArrayList<Nivel>();

    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public CapacidadMedible getCapacidadSeleccionada() {
        return capacidadSeleccionada;
    }

    public void setCapacidadSeleccionada(CapacidadMedible capacidadSeleccionada) {
        this.capacidadSeleccionada = capacidadSeleccionada;
    }

    public Criterio getCriterioSeleccionado() {
        return criterioSeleccionado;
    }

    public void setCriterioSeleccionado(Criterio criterioSeleccionado) {
        this.criterioSeleccionado = criterioSeleccionado;
    }

    public List<Nivel> getListaNivel() {
        return listaNivel;
    }

    public void setListaNivel(List<Nivel> listaNivel) {
        this.listaNivel = listaNivel;
    }

    public ResultadoPrograma getResultadoSeleccionado() {
        return resultadoSeleccionado;
    }

    public void setResultadoSeleccionado(ResultadoPrograma resultadoSeleccionado) {
        this.resultadoSeleccionado = resultadoSeleccionado;
    }

    public String nuevo() {
        //NivelController.this.criterioSeleccionado.getIdCriterio();
        if(NivelController.this.resultadoSeleccionado != null && NivelController.this.capacidadSeleccionada != null && NivelController.this.criterioSeleccionado != null){
            nivel = new Nivel();
            nivel.setFidCriterio(criterioSeleccionado);
            return "nuevoNivel";
        }else{
            mostrarMensaje("Error: ", "Debe seleccionar un Resultado del Programa, una Capacidad Medible y un Criterio.", FacesMessage.SEVERITY_ERROR);
            return "";
        }      
    }

    public String cancelar() {
        return "listarNivel";
    }

    public String listarCriterio() {
        return "listarCriterio";
    }

    public String registrar() {
        try {
            if (!nivel.getNombre().equals("") && !nivel.getNombre().isEmpty()) {
                local.registrar(nivel);
                nivel = new Nivel();
                mostrarMensaje("Éxito: ", "El registro del Nivel se realizó exitosamente.", FacesMessage.SEVERITY_INFO);
            } else {
                mostrarMensaje("Error: ", "Ingrese un nombre de Nivel.", FacesMessage.SEVERITY_ERROR);
                
                return "";
            }
        } catch (Exception e) {
            local = lookupNivelFacadeBean();
            mostrarMensaje(e.getMessage(), e.getMessage(), FacesMessage.SEVERITY_ERROR);
            return "";
        }
        return "listarNivel";
    }

    public String actualizar() {
        try {
            if (!nivel.getNombre().equals("") && !nivel.getNombre().isEmpty()) {
                local.actualizar(nivel);
                mostrarMensaje("Éxito: ", "La actualización del Nivel se realizó exitosamente.", FacesMessage.SEVERITY_INFO);
            } else {
                mostrarMensaje("Error: ", "Asegúrese de haber ingresado un Nivel.", FacesMessage.SEVERITY_ERROR);
                this.cancelar();
                return "";
            }
        } catch (Exception e) {
            local = lookupNivelFacadeBean();
            mostrarMensaje(e.getMessage(), e.getMessage(), FacesMessage.SEVERITY_ERROR);
            return "";
        }
        return "listarNivel";
    }

    public String eliminar() {
        try {
            if (nivel != null) {
                local.eliminar(nivel);
                mostrarMensaje("Éxito: ", "La eliminación del Nivel se realizó Éxitosamente.", FacesMessage.SEVERITY_INFO);
            } else {
                mostrarMensaje("Error: ", "Asegúrese de haber seleccionado un Nivel.", FacesMessage.SEVERITY_ERROR);
                return "";
            }
        } catch (Exception e) {
            local = lookupNivelFacadeBean();
            mostrarMensaje(e.getMessage(), e.getMessage(), FacesMessage.SEVERITY_ERROR);
            return "";
        }
        return "listarNivel";
    }

    public List<Nivel> getNiveles() {
        try {
            return local.listar();
        } catch (Exception e) {
            local = lookupNivelFacadeBean();
            e.printStackTrace();
        }
        return null;
    }

    public String processValueChange(ValueChangeEvent event) {

        listaNivel = getNivelesPorCriterio();
        return "";

    }

    public List<Nivel> getNivelesPorCriterio() {
        try {
            return local.nivelxCriterio(criterioSeleccionado);
        } catch (Exception e) {
            local = lookupNivelFacadeBean();
            e.printStackTrace();
        }
        return null;
    }

    public List<Nivel> nivelxCriterio(Criterio criterioSeleccionado) throws Exception {
        try {
            return local.nivelxCriterio(criterioSeleccionado);
        } catch (Exception e) {
            local = lookupNivelFacadeBean();
            e.printStackTrace();
        }
        return null;
    }

    public String calcularCombo(ValueChangeEvent evt) {
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

            return comboCapacidades;

        } catch (Exception e) {
            //Mensaje al usuario
            lista = new ArrayList<CapacidadMedible>();
            SelectItem[] comboCapacidades = new SelectItem[1];
            comboCapacidades[0] = new SelectItem(new CapacidadMedible(), "No hay Capacidades Medibles.");

            return comboCapacidades;
        }

    }

    public String calcularComboCriterios() {
        getComboCriteriosxCapacidad();
        return "";
    }

    public SelectItem[] getComboCriteriosxCapacidad() {
        List<Criterio> lista;
        try {
            lista = new ArrayList<Criterio>();
            CriterioController delegateCriterio = new CriterioController();
            lista = delegateCriterio.criterioxCapacidad(capacidadSeleccionada);
            SelectItem[] comboCriterios = new SelectItem[lista.size()];
            for (int i = 0; i < lista.size(); i++) {
                comboCriterios[i] = new SelectItem(lista.get(i), lista.get(i).getNombre());
            }

            return comboCriterios;

        } catch (Exception e) {
            //Mensaje al usuario
            lista = new ArrayList<Criterio>();
            SelectItem[] comboCriterios = new SelectItem[1];
            comboCriterios[0] = new SelectItem(new Criterio(), "No hay Criterios.");

            return comboCriterios;
        }

    }

    public Nivel buscarNivel(Long id) throws Exception {
        try {
            return local.buscarPorId(id);
        } catch (Exception e) {
            mostrarMensaje(e.getMessage(), e.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
        return null;
//            local = lookupNivelFacadeBean();
//            throw new Exception(e.getStackTrace().toString(), e);
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

    private NivelFacadeLocal lookupNivelFacadeBean() {
        try {
            Context c = new InitialContext();
            return (NivelFacadeLocal) c.lookup("java:comp/env/NivelFacadeBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
