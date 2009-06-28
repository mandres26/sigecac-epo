/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.gcu.beans;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.upn.sigecac.gcu.bc.AreaFacadeLocal;
import edu.upn.sigecac.gcu.bc.NivelProfesionalFacadeLocal;
import edu.upn.sigecac.gcu.be.Area;
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
public class AreaController {
    @EJB
    private NivelProfesionalFacadeLocal localnivelProfesional;
    @EJB
    private AreaFacadeLocal local;
    private Area Area;
    private NivelProfesional NivelProfesional;
    private String criterioArea;
    private String valorArea;
    private List<SelectItem> Areas;
    private String selectedItem;
    public AreaController() {
           Area=new Area();
           NivelProfesional=new NivelProfesional();
    }

    public List<SelectItem> getAreas() {
        return Areas;
    }

    public void setAreas(List<SelectItem> Areas) {
        this.Areas = Areas;
    }

    public NivelProfesional getNivelProfesional() {
        return NivelProfesional;
    }

    public void setNivelProfesional(NivelProfesional NivelProfesional) {
        this.NivelProfesional = NivelProfesional;
    }

 

    // Get y Set ----------------------------------------------------------------------------------------
    public Area getArea() {
        return Area;
    }
    public void setArea(Area Area) {
        this.Area = Area;
    }
    public List<SelectItem> getAreaes() {
       return null;
    }
     public  List<SelectItem> getListaNiveles() {
        List<SelectItem> combo = null;
        try {

            List<NivelProfesional> lista = localnivelProfesional.listar();
            combo = new ArrayList<SelectItem>();
            if (lista.size() > 0) {
                combo.add(new SelectItem(String.valueOf(0),"Seleccionar Nivel Profesional"));
                for (NivelProfesional t : lista) {
                    combo.add(new SelectItem(String.valueOf(t.getIdNivelProfesional()),t.getNivelProfesional()));
                }
            } else {
               combo.add(new SelectItem(String.valueOf(0),"No hay Registros"));
            }

        } catch (Exception e) {
           combo.add(new SelectItem(String.valueOf(0),"ERROR"));
        }

        return combo;
    }
    public void setArea(List<SelectItem> Areas) {
        this.Areas = Areas;
    }
    public String getCriterioArea() {
        return criterioArea;
    }
    public void setCriterioArea(String criterioArea) {
        this.criterioArea = criterioArea;
    }
    public String getSelectedItem() {
        return selectedItem;
    }
    public void setSelectedItem(String selectedItem) {
        this.selectedItem = selectedItem;
    }
    public String getValorArea() {
        return valorArea;
    }
    public void setValorArea(String valorArea) {
        this.valorArea = valorArea;
    }

    // Metodos ----------------------------------------------------------------------------------------
    public String crearArea(Area Area) throws Exception {
        try {
            if (Area.getArea().trim().equals("") || NivelProfesional.getIdNivelProfesional()==0 ) {
                addErrorMessage("La operacion realizada no se pudo completar, existen campos vacios");
            }else{
                Area.setFxNivelProfesional(NivelProfesional);
                local.crear(Area);
            }
        } catch (Exception e) {
            throw new Exception("Crear. " + e.getMessage(), e);
        }
        return "";
    }
    public List<Area> listarArea() throws Exception{
        try{
            return local.listar();
        }catch (Exception e) {
            throw new Exception("Listar. " + e.getMessage(), e);
        }
    }
    public String buscarArea(long id) throws Exception{
        try{
            if (Area.getIdArea()!=0) {
               Area = local.buscar(id);
            } else {
                //lanzar error
            }
        }catch (Exception e) {
            throw new Exception("Buscar. " + e.getMessage(), e);
        }
        return "";
    }
    public String editarArea(Area Area) throws Exception{
        try{
            if (Area.getIdArea()!= 0) {
                local.actualizar(Area);
            } else {
                //lanzar error
            }
        }catch (Exception e) {
            throw new Exception("Editar. " + e.getMessage(), e);
        }
        return "";
    }
    public String borrarArea(Area Area) throws Exception{
        try{
            if (Area.getIdArea()!= 0) {
                local.eliminar(Area);
            } else {
                //lanzar error
            }
        }catch (Exception e) {
            throw new Exception("Borrar. " + e.getMessage(), e);
        }
        return "";
    }
    public List<Area> getFiltrarArea(String criterio,String valor) throws Exception {
        try {
            return local.filtrar("", valor);
        } catch (Exception e) {
            throw new Exception("Filtrar. " + e.getMessage(), e);
        }
    }
    public List<Area> getListaAreas(){
        try {
            return local.listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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

    // Navegacion ---------------------------------------------------------------------------------------
    public String nuevaArea(){
        Area=new Area();
        NivelProfesional=new NivelProfesional();
        return "nuevo";
    }
    public String registrarArea(){
        try {
            crearArea(Area);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "listar";
    }
    public String eliminarArea(){
        try {
            borrarArea(Area);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    public String actualizarArea(){
        try {
            editarArea(Area);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "listar";
    }
}