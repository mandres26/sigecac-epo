/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.gcu.beans;

import edu.upn.sigecac.gcu.bc.NivelProfesionalFacadeLocal;
import edu.upn.sigecac.gcu.be.NivelProfesional;
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
public class NivelProfesionalController {
    @EJB
    private NivelProfesionalFacadeLocal local;
    private NivelProfesional NivelProfesional;
    private String criterioNivelProfesional;
    private String valorNivelProfesional;
    private List<SelectItem> NivelProfesionales;
    private String selectedItem;
    public NivelProfesionalController() {
           NivelProfesional=new NivelProfesional();
    }
    
    // Get y Set ----------------------------------------------------------------------------------------
    public NivelProfesional getNivelProfesional() {
        return NivelProfesional;
    }
    public void setNivelProfesional(NivelProfesional NivelProfesional) {
        this.NivelProfesional = NivelProfesional;
    }
    public List<SelectItem> getNivelProfesionales() {
        try{
            NivelProfesionales = new ArrayList<SelectItem>();
                for (NivelProfesional t : local.listar()){
                  NivelProfesionales.add(new SelectItem(String.valueOf(t.getIdNivelProfesional()),t.getNivelProfesional()));
                }
            }catch (Exception e) {
            }
            return NivelProfesionales;
    }
    public void setNivelProfesionales(List<SelectItem> NivelProfesionales) {
        this.NivelProfesionales = NivelProfesionales;
    }
    public String getCriterioNivelProfesional() {
        return criterioNivelProfesional;
    }
    public void setCriterioNivelProfesional(String criterioNivelProfesional) {
        this.criterioNivelProfesional = criterioNivelProfesional;
    }
    public String getSelectedItem() {
        return selectedItem;
    }
    public void setSelectedItem(String selectedItem) {
        this.selectedItem = selectedItem;
    }
    public String getValorNivelProfesional() {
        return valorNivelProfesional;
    }
    public void setValorNivelProfesional(String valorNivelProfesional) {
        this.valorNivelProfesional = valorNivelProfesional;
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
    public String crearNivelProfesional() throws Exception {
        try {
            if (NivelProfesional.getNivelProfesional().trim().equals("")) {
                 addErrorMessage("La operacion realizada no se pudo completar, existen campos vacios");
            }else{
                local.crear(NivelProfesional);
            }
        } catch (Exception e) {
            throw new Exception("Crear. " + e.getMessage(), e);
        }
        return "listar";
    }
    public List<NivelProfesional> listarNivelProfesional() throws Exception{
        try{
            return local.listar();
        }catch (Exception e) {
            throw new Exception("Listar. " + e.getMessage(), e);
        }
    }
    public String buscarNivelProfesional(long id) throws Exception{
        try{
            if (NivelProfesional.getIdNivelProfesional()!=0) {
               NivelProfesional = local.buscar(id);
            } else {
                //lanzar error
            }
        }catch (Exception e) {
            throw new Exception("Buscar. " + e.getMessage(), e);
        }
        return "";
    }
    public String editarNivelProfesional() throws Exception{
        try{
            if (NivelProfesional.getIdNivelProfesional()!= 0) {
                local.actualizar(NivelProfesional);
            } else {
                //lanzar error
            }
        }catch (Exception e) {
            throw new Exception("Editar. " + e.getMessage(), e);
        }
        return "listar";
    }
    public String borrarNivelProfesional() throws Exception{
        try{
            if (NivelProfesional.getIdNivelProfesional()!= 0) {
                local.eliminar(NivelProfesional);
            } else {
                //lanzar error
            }
        }catch (Exception e) {
            throw new Exception("Borrar. " + e.getMessage(), e);
        }
        return "";
    }
    public List<NivelProfesional> getFiltrarNivelProfesional(String criterio,String valor) throws Exception {
        try {
            return local.filtrar("", valor);
        } catch (Exception e) {
            throw new Exception("Filtrar. " + e.getMessage(), e);
        }
    }
    public List<NivelProfesional> getListaNivelProfesionales(){
        try {
            return local.listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
   

    // Navegacion ---------------------------------------------------------------------------------------
      public String nuevoNivelProfesional(){
        NivelProfesional=new NivelProfesional();
        return "nuevo";
    }
   
}
