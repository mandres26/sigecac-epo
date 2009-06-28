/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.gcu.beans;

import edu.upn.sigecac.gcu.bc.EstandaresCuantificadoresFacadeLocal;
import edu.upn.sigecac.gcu.be.EstandaresCuantificadores;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author
 */
public class EstandaresCuantificadoresController {
    @EJB
    private EstandaresCuantificadoresFacadeLocal local;
    private EstandaresCuantificadores EstandaresCuantificadores;
    private String criterioEstandaresCuantificadores;
    private String valorEstandaresCuantificadores;
    private List<SelectItem> EstandaresCuantificadoreses;
    private String selectedItem;
    private String message;
    public EstandaresCuantificadoresController() {
           EstandaresCuantificadores=new EstandaresCuantificadores();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // Get y Set ----------------------------------------------------------------------------------------
    
    public EstandaresCuantificadores getEstandaresCuantificadores() {
        return EstandaresCuantificadores;
    }
    public void setEstandaresCuantificadores(EstandaresCuantificadores EstandaresCuantificadores) {
        this.EstandaresCuantificadores = EstandaresCuantificadores;
    }
    public List<SelectItem> getEstandaresCuantificadoreses() {
        try{
            EstandaresCuantificadoreses = new ArrayList<SelectItem>();
                for (EstandaresCuantificadores t : local.listar()){
                  EstandaresCuantificadoreses.add(new SelectItem(String.valueOf(t.getIdEstandares()),t.getDescripcion()));
                }
            }catch (Exception e) {
            }
            return EstandaresCuantificadoreses;
    }
    public void setEstandaresCuantificadoreses(List<SelectItem> EstandaresCuantificadoreses) {
        this.EstandaresCuantificadoreses = EstandaresCuantificadoreses;
    }
    public String getCriterioEstandaresCuantificadores() {
        return criterioEstandaresCuantificadores;
    }
    public void setCriterioEstandaresCuantificadores(String criterioEstandaresCuantificadores) {
        this.criterioEstandaresCuantificadores = criterioEstandaresCuantificadores;
    }
    public String getSelectedItem() {
        return selectedItem;
    }
    public void setSelectedItem(String selectedItem) {
        this.selectedItem = selectedItem;
    }
    public String getValorEstandaresCuantificadores() {
        return valorEstandaresCuantificadores;
    }
    public void setValorEstandaresCuantificadores(String valorEstandaresCuantificadores) {
        this.valorEstandaresCuantificadores = valorEstandaresCuantificadores;
    }

    private void addSuccessMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage("successInfo", facesMsg);
    }

    private void addErrorMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage(null, facesMsg);
    }
    // Metodos ----------------------------------------------------------------------------------------
    public String crearEstandaresCuantificadores() throws Exception {
        try {
            if (EstandaresCuantificadores.getDescripcion().trim().equals("")) {
                addErrorMessage("La operacion realizada no se pudo completar, existen campos vacios");
            }else{
                local.crear(EstandaresCuantificadores);
                 message = "Registro exitoso";
            }
        } catch (Exception e) {
           
            throw new Exception("Crear. " + e.getMessage(), e);
        }
        return "listar";
    }
    public List<EstandaresCuantificadores> listarEstandaresCuantificadores() throws Exception{
        try{
            return local.listar();
        }catch (Exception e) {
            throw new Exception("Listar. " + e.getMessage(), e);
        }
    }
    public String buscarEstandaresCuantificadores(long id) throws Exception{
        try{
            if (EstandaresCuantificadores.getIdEstandares()!=0) {
               EstandaresCuantificadores = local.buscar(id);
            } else {
                //lanzar error
            }
        }catch (Exception e) {
            throw new Exception("Buscar. " + e.getMessage(), e);
        }
        return "";
    }
    public String editarEstandaresCuantificadores() throws Exception{
        try{
            if(EstandaresCuantificadores.getDescripcion().trim().equals("")) {
                addErrorMessage("La operacion realizada no se pudo completar, existen campos vacios");
            }
            else{

            if (EstandaresCuantificadores.getIdEstandares()!= 0) {
                local.actualizar(EstandaresCuantificadores);
                message = "Actualizacion exitosa";
            } else {
                //lanzar error
            }
            }
        }catch (Exception e) {
            throw new Exception("Editar. " + e.getMessage(), e);
        }
        return "listar";
    }
    public String borrarEstandaresCuantificadores() throws Exception{
        try{
            if (EstandaresCuantificadores.getIdEstandares()!= 0) {
                local.eliminar(EstandaresCuantificadores);
                 message = "Eliminacion exitosa";
            } else {
                //lanzar error
            }
        }catch (Exception e) {
            throw new Exception("Borrar. " + e.getMessage(), e);
        }
        return "";
    }
    public List<EstandaresCuantificadores> getFiltrarEstandaresCuantificadores(String criterio,String valor) throws Exception {
        try {
            return local.filtrar("", valor);
        } catch (Exception e) {
            throw new Exception("Filtrar. " + e.getMessage(), e);
        }
    }
    public List<EstandaresCuantificadores> getListaEstandaresCuantificadoreses(){
        try {
            return local.listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    // Navegacion ---------------------------------------------------------------------------------------
      public String nuevoEstandaresCuantificadores(){
        EstandaresCuantificadores=new EstandaresCuantificadores();
        return "nuevo";
    }

}