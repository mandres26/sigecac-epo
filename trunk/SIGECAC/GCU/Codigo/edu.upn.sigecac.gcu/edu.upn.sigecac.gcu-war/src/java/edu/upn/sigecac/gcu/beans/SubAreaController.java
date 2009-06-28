/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.sigecac.gcu.beans;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.upn.sigecac.gcu.bc.SubAreaFacadeLocal;
import edu.upn.sigecac.gcu.bc.AreaFacadeLocal;
import edu.upn.sigecac.gcu.be.Area;
import edu.upn.sigecac.gcu.be.SubArea;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.model.SelectItem;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author
 */
public class SubAreaController {
    @EJB
    private AreaFacadeLocal localArea;
    @EJB
    private SubAreaFacadeLocal local;
    private SubArea SubArea;
    private Area Area;
    private String criterioSubArea;
    private String valorSubArea;
    private List<SelectItem> SubAreas;
    private String selectedItem;
    public SubAreaController() {
           SubArea=new SubArea();
           Area=new Area();
    }

    public List<SelectItem> getSubAreas() {
        return SubAreas;
    }

    public void setSubAreas(List<SelectItem> SubAreas) {
        this.SubAreas = SubAreas;
    }

    public Area getArea() {
        return Area;
    }

    public void setArea(Area Area) {
        this.Area = Area;
    }

    
    // Get y Set ----------------------------------------------------------------------------------------
    public SubArea getSubArea() {
        return SubArea;
    }
    public void setSubArea(SubArea SubArea) {
        this.SubArea = SubArea;
    }
    public List<SelectItem> getSubAreaes() {
       return null;
    }
     public  List<SelectItem> getListaAreas() {
        List<SelectItem> combo = null;
        try {

            List<Area> lista = localArea.listar();
            combo = new ArrayList<SelectItem>();
            if (lista.size() > 0) {
                combo.add(new SelectItem(String.valueOf(0),"Seleccionar Area"));
                for (Area t : lista) {
                    combo.add(new SelectItem(String.valueOf(t.getIdArea()),t.getArea()));
                }
            } else {
               combo.add(new SelectItem(String.valueOf(0),"No hay Registros"));
            }

        } catch (Exception e) {
           combo.add(new SelectItem(String.valueOf(0),"ERROR"));
        }

        return combo;
    }
    public void setSubArea(List<SelectItem> SubAreas) {
        this.SubAreas = SubAreas;
    }
    public String getCriterioSubArea() {
        return criterioSubArea;
    }
    public void setCriterioSubArea(String criterioSubArea) {
        this.criterioSubArea = criterioSubArea;
    }
    public String getSelectedItem() {
        return selectedItem;
    }
    public void setSelectedItem(String selectedItem) {
        this.selectedItem = selectedItem;
    }
    public String getValorSubArea() {
        return valorSubArea;
    }
    public void setValorSubArea(String valorSubArea) {
        this.valorSubArea = valorSubArea;
    }

    // Metodos ----------------------------------------------------------------------------------------
    public String crearSubArea() throws Exception {
        try {
            if (!SubArea.getNombre().trim().equals("")) {
                SubArea.setFxIdarea(Area);
                local.crear(SubArea);
            }
        } catch (Exception e) {
            throw new Exception("Crear. " + e.getMessage(), e);
        }
        return "listar";
    }
    public List<SubArea> listarSubArea() throws Exception{
        try{
            return local.listar();
        }catch (Exception e) {
            throw new Exception("Listar. " + e.getMessage(), e);
        }
    }
    public String buscarSubArea(long id) throws Exception{
        try{
            if (SubArea.getIdSubArea()!=0) {
               SubArea = local.buscar(id);
            } else {
                //lanzar error
            }
        }catch (Exception e) {
            throw new Exception("Buscar. " + e.getMessage(), e);
        }
        return "";
    }
    public String editarSubArea() throws Exception{
        try{
            if (SubArea.getIdSubArea()!= 0) {
                local.actualizar(SubArea);
            } else {
                //lanzar error
            }
        }catch (Exception e) {
            throw new Exception("Editar. " + e.getMessage(), e);
        }
        return "listar";
    }
    public String borrarSubArea() throws Exception{
        try{
            if (SubArea.getIdSubArea()!= 0) {
                local.eliminar(SubArea);
            } else {
                //lanzar error
            }
        }catch (Exception e) {
            throw new Exception("Borrar. " + e.getMessage(), e);
        }
        return "";
    }
    public List<SubArea> getFiltrarSubArea(String criterio,String valor) throws Exception {
        try {
            return local.filtrar("", valor);
        } catch (Exception e) {
            throw new Exception("Filtrar. " + e.getMessage(), e);
        }
    }
    public List<SubArea> getListaSubAreas(){
        try {
            return local.listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    // Navegacion ---------------------------------------------------------------------------------------
    public String nuevaSubArea(){
        SubArea=new SubArea();
        Area=new Area();
        return "nuevo";
    }
}