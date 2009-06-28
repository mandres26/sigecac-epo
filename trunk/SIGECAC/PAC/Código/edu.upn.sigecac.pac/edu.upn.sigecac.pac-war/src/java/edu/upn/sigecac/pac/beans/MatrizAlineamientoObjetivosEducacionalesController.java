package edu.upn.sigecac.pac.beans;

import edu.upn.sigecac.pac.bc.MatrizAlineamientoObjetivosEducacionalesFacadeLocal;
import edu.upn.sigecac.pac.be.DetalleMatrizAlineamientoObjetivosEducacionales;
import edu.upn.sigecac.pac.be.MatrizAlineamientoObjetivosEducacionales;
import edu.upn.sigecac.pac.be.ObjetivoEducacional;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MatrizAlineamientoObjetivosEducacionalesController {
    private MatrizAlineamientoObjetivosEducacionalesFacadeLocal local;
    private MatrizAlineamientoObjetivosEducacionales matrizAlineamientoObjetivosEducacionales;
    private DetalleMatrizAlineamientoObjetivosEducacionales detalleMatrizAlineamientoObjetivosEducacionales;
    public List<ObjetivoEducacional> listaObjetivos;
    private List<ObjetivoEducacional> listaObjetivosTemporal;
    private ObjetivoEducacionalController delegateObjetivo;


public MatrizAlineamientoObjetivosEducacionalesController() {
        local = lookupMatrizAlineamientoObjetivosEducacionalesFacadeBean();
        listaObjetivos = new ArrayList<ObjetivoEducacional>();
        listaObjetivosTemporal = new ArrayList<ObjetivoEducacional>();
    }

    public MatrizAlineamientoObjetivosEducacionales getMatrizAlineamientoObjetivosEducacionales() {
        return matrizAlineamientoObjetivosEducacionales;
    }

    public void setMatrizAlineamientoObjetivosEducacionales(MatrizAlineamientoObjetivosEducacionales matrizAlineamientoObjetivosEducacionales) {
        this.matrizAlineamientoObjetivosEducacionales = matrizAlineamientoObjetivosEducacionales;
    }

    public DetalleMatrizAlineamientoObjetivosEducacionales getDetalleMatrizAlineamientoObjetivosEducacionales() {
        return detalleMatrizAlineamientoObjetivosEducacionales;
    }

    public void setDetalleMatrizAlineamientoObjetivosEducacionales(DetalleMatrizAlineamientoObjetivosEducacionales detalleMatrizAlineamientoObjetivosEducacionales) {
        this.detalleMatrizAlineamientoObjetivosEducacionales = detalleMatrizAlineamientoObjetivosEducacionales;
    }

    public List<ObjetivoEducacional> getListaObjetivos() {
        return listaObjetivos;
    }

    public void setListaObjetivos(List<ObjetivoEducacional> listaObjetivos) {
        this.listaObjetivos = listaObjetivos;
    }

    public List<ObjetivoEducacional> getListaObjetivosTemporal() {
        return listaObjetivosTemporal;
    }

    public void setListaObjetivosTemporal(List<ObjetivoEducacional> listaObjetivosTemporal) {
        this.listaObjetivosTemporal = listaObjetivosTemporal;
    }

    public String nuevo() {
        matrizAlineamientoObjetivosEducacionales = new MatrizAlineamientoObjetivosEducacionales();
        detalleMatrizAlineamientoObjetivosEducacionales = new DetalleMatrizAlineamientoObjetivosEducacionales();
        
        return "nuevoMatrizObjetivosEducacionales";
      
    }

    public String cancelar() {
        return "listarMatrizObjetivosEducacionales";
    }

      public String registrar() {
        try {
            if (!matrizAlineamientoObjetivosEducacionales.getNombre().equals("") && !matrizAlineamientoObjetivosEducacionales.getNombre().isEmpty()) {
                local.registrar(matrizAlineamientoObjetivosEducacionales);
                matrizAlineamientoObjetivosEducacionales = new MatrizAlineamientoObjetivosEducacionales();
                mostrarMensaje("Éxito: ", "El registro de la Matriz de Alineamiento de Objetivos Educacionales se realizó exitosamente.", FacesMessage.SEVERITY_INFO);
            } else {
                mostrarMensaje("Error: ", "Ingrese un nombre de Matriz de Alineamiento de Objetivos Educacionales.", FacesMessage.SEVERITY_ERROR);
                
                return "";
            }
        } catch (Exception e) {
            local = lookupMatrizAlineamientoObjetivosEducacionalesFacadeBean();
            mostrarMensaje("Error: ", "Error en el registro de la Matriz de Alineamiento de Objetivos Educacionales.", FacesMessage.SEVERITY_ERROR);
            return "";
        }
        return "listarMatrizObjetivosEducacionales";
    }

    public String actualizar() {
        try {
            if (!matrizAlineamientoObjetivosEducacionales.getNombre().equals("") && !matrizAlineamientoObjetivosEducacionales.getNombre().isEmpty()) {
                local.actualizar(matrizAlineamientoObjetivosEducacionales);
                mostrarMensaje("Éxito: ", "La actualización de la Matriz de Alineamiento de Objetivos Educacionales se realizó exitosamente.", FacesMessage.SEVERITY_INFO);
            } else {
                mostrarMensaje("Error: ", "Ingrese un nombre de Matriz de Alineamiento de Objetivos Educacionales", FacesMessage.SEVERITY_ERROR);
                return "";
            }
        } catch (Exception e) {
            local = lookupMatrizAlineamientoObjetivosEducacionalesFacadeBean();
            mostrarMensaje(e.getMessage(), e.getMessage(), FacesMessage.SEVERITY_ERROR);
            return "";
        }
        return "listarMatrizObjetivosEducacionales";
    }

    public String eliminar() {
        try {
            if (matrizAlineamientoObjetivosEducacionales != null) {
                local.eliminar(matrizAlineamientoObjetivosEducacionales);
                mostrarMensaje("Éxito: ", "La eliminación de la Matriz de Alineamiento de Objetivos Educacionales se realizó exitosamente.", FacesMessage.SEVERITY_INFO);
                
            } else {
                mostrarMensaje("Error: ", "Asegúrese de haber seleccionado una Matriz de Alineamiento de Objetivos Educacionales", FacesMessage.SEVERITY_ERROR);
                return "";
            }
        } catch (Exception e) {
            local = lookupMatrizAlineamientoObjetivosEducacionalesFacadeBean();
            mostrarMensaje(e.getMessage(), e.getMessage(), FacesMessage.SEVERITY_ERROR);
            return "";
        }
        return "listarMatrizObjetivosEducacionales";
    }

    public List<MatrizAlineamientoObjetivosEducacionales> getMatricesAlineamientoObjetivosEducacionales() {
        try {
            return local.listar();
        } catch (Exception e) {
            local = lookupMatrizAlineamientoObjetivosEducacionalesFacadeBean();
            e.printStackTrace();
        }
        return null;
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

    public MatrizAlineamientoObjetivosEducacionales buscarMatrizAlineamientoObjetivosEducacionales(Long id) throws Exception {
        try {
            return local.buscarPorId(id);
        } catch (Exception e) {
            local = lookupMatrizAlineamientoObjetivosEducacionalesFacadeBean();
            throw new Exception(e.getStackTrace().toString(), e);
        }

    }

    private MatrizAlineamientoObjetivosEducacionalesFacadeLocal lookupMatrizAlineamientoObjetivosEducacionalesFacadeBean() {
        try {
            Context c = new InitialContext();
            return (MatrizAlineamientoObjetivosEducacionalesFacadeLocal) c.lookup("java:comp/env/MatrizAlineamientoObjetivosEducacionalesFacadeBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}

