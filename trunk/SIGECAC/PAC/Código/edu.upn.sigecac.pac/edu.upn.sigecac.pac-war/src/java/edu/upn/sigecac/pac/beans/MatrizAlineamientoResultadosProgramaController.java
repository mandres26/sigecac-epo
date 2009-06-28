package edu.upn.sigecac.pac.beans;

import edu.upn.sigecac.pac.bc.MatrizAlineamientoResultadosProgramaFacadeLocal;
import edu.upn.sigecac.pac.be.DetalleMatrizAlineamientoResultadosPrograma;
import edu.upn.sigecac.pac.be.MatrizAlineamientoResultadosPrograma;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;



public class MatrizAlineamientoResultadosProgramaController {
    private MatrizAlineamientoResultadosProgramaFacadeLocal local;
    private MatrizAlineamientoResultadosPrograma matrizAlineamientoResultadosPrograma;
    private DetalleMatrizAlineamientoResultadosPrograma detalleMatrizAlineamientoResultadosPrograma;

public MatrizAlineamientoResultadosProgramaController() {
        local = lookupMatrizAlineamientoResultadosProgramaFacade();
    }

    public DetalleMatrizAlineamientoResultadosPrograma getDetalleMatrizAlineamientoResultadosPrograma() {
        return detalleMatrizAlineamientoResultadosPrograma;
    }

    public void setDetalleMatrizAlineamientoResultadosPrograma(DetalleMatrizAlineamientoResultadosPrograma detalleMatrizAlineamientoResultadosPrograma) {
        this.detalleMatrizAlineamientoResultadosPrograma = detalleMatrizAlineamientoResultadosPrograma;
    }

    public MatrizAlineamientoResultadosProgramaFacadeLocal getLocal() {
        return local;
    }

    public void setLocal(MatrizAlineamientoResultadosProgramaFacadeLocal local) {
        this.local = local;
    }

    public MatrizAlineamientoResultadosPrograma getMatrizAlineamientoResultadosPrograma() {
        return matrizAlineamientoResultadosPrograma;
    }

    public void setMatrizAlineamientoResultadosPrograma(MatrizAlineamientoResultadosPrograma matrizAlineamientoResultadosPrograma) {
        this.matrizAlineamientoResultadosPrograma = matrizAlineamientoResultadosPrograma;
    }

    public String nuevo() {
        matrizAlineamientoResultadosPrograma = new MatrizAlineamientoResultadosPrograma();
        detalleMatrizAlineamientoResultadosPrograma = new DetalleMatrizAlineamientoResultadosPrograma();
        return "nuevoMatrizResultadoPrograma";
    }

    public String cancelar() {
        return "listarMatrizResultadoPrograma";
    }

      public String registrar() {
        try {
            if (matrizAlineamientoResultadosPrograma != null) {
                local.create(matrizAlineamientoResultadosPrograma);
                mostrarMensaje("Éxito: ", "El registro de la Matriz de Alineamiento de Resultados del Programa se realizó exitosamente.", FacesMessage.SEVERITY_INFO);
            } else {
                mostrarMensaje("Error: ", "Error en el registro de la Matriz de Alineamiento de Resultados del Programa", FacesMessage.SEVERITY_ERROR);
                matrizAlineamientoResultadosPrograma = new MatrizAlineamientoResultadosPrograma();
                return "";
            }
        } catch (Exception e) {
            local = lookupMatrizAlineamientoResultadosProgramaFacade();
            mostrarMensaje(e.getMessage(), e.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
        return "listarMatrizResultadoPrograma";
    }

    public String actualizar() {
        try {
            if (matrizAlineamientoResultadosPrograma != null) {
                local.edit(matrizAlineamientoResultadosPrograma);
                mostrarMensaje("Éxito: ", "La actualización de la Matriz de Alineamiento de Resultados del Programa se realizó exitosamente.", FacesMessage.SEVERITY_INFO);
            } else {
                mostrarMensaje("Error: ", "Asegúrese de haber ingresado una Matriz de Alineamiento de Resultados del Programa", FacesMessage.SEVERITY_ERROR);
                return "";
            }
        } catch (Exception e) {
            local = lookupMatrizAlineamientoResultadosProgramaFacade();
            mostrarMensaje(e.getMessage(), e.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
        return "listarMatrizResultadoPrograma";
    }

    public String eliminar() {
        try {
            if (matrizAlineamientoResultadosPrograma != null) {
                local.remove(matrizAlineamientoResultadosPrograma);
                mostrarMensaje("Éxito: ", "La eliminación de la Matriz de Alineamiento de Resultados del Programa se realizó exitosamente.", FacesMessage.SEVERITY_INFO);
            } else {
                mostrarMensaje("Error: ", "Asegúrese de haber seleccionado una Matriz de Alineamiento de Resultados del Programa", FacesMessage.SEVERITY_ERROR);
                return "";
            }
        } catch (Exception e) {
            local = lookupMatrizAlineamientoResultadosProgramaFacade();
            mostrarMensaje(e.getMessage(), e.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
        return "listarMatrizResultadoPrograma";
    }

    public List<MatrizAlineamientoResultadosPrograma> getMatricesAlineamientoResultadosPrograma() {
        try {
            return local.findAll();
        } catch (Exception e) {
            local = lookupMatrizAlineamientoResultadosProgramaFacade();
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

    public MatrizAlineamientoResultadosPrograma buscarMatrizAlineamientoResultadosPrograma(Long id) throws Exception {
        try {
            return local.find(id);
        } catch (Exception e) {
            local = lookupMatrizAlineamientoResultadosProgramaFacade();
            throw new Exception(e.getStackTrace().toString(), e);
        }

    }

    private MatrizAlineamientoResultadosProgramaFacadeLocal lookupMatrizAlineamientoResultadosProgramaFacade() {
        try {
            Context c = new InitialContext();
            return (MatrizAlineamientoResultadosProgramaFacadeLocal) c.lookup("java:comp/env/MatrizAlineamientoResultadosProgramaFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

   

}

