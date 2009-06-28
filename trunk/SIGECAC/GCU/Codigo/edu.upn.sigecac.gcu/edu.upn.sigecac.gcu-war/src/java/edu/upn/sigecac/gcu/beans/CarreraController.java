/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.sigecac.gcu.beans;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import edu.upn.sigecac.gcu.bc.CarreraFacadeLocal;
import edu.upn.sigecac.gcu.be.Carrera;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author
 */
public class CarreraController {

    @EJB
    private CarreraFacadeLocal local;
     private Carrera Carrera;
     private List<SelectItem> Carreras;
    private String selectedItem;

    public CarreraController() {
        Carrera = new Carrera();
    }

    public List<SelectItem> getCarreras() {
        return Carreras;
    }

    public void setCarreras(List<SelectItem> Carreras) {
        this.Carreras = Carreras;
    }

    // Get y Set ----------------------------------------------------------------------------------------
    public Carrera getCarrera() {
        return Carrera;
    }

    public void setCarrera(Carrera Carrera) {
        this.Carrera = Carrera;
    }

    public List<SelectItem> getCarreraes() {
        return null;
    }

    public void setCarrera(List<SelectItem> Carreras) {
        this.Carreras = Carreras;
    }

    public String getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(String selectedItem) {
        this.selectedItem = selectedItem;
    }

    // Mensajes
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
    public String crearCarrera() throws Exception {

        try {
            if (Carrera.getNombre().toLowerCase().toLowerCase().trim().equals("") || Carrera.getIdCarrera() == 0) {
                addErrorMessage("La operacion realizada no se pudo completar, existen campos vacios");
            } else {
                if (!Carrera.getNombre().trim().equals("")) {
                    local.crear(Carrera);
                    return "";
                }
            }
        } catch (Exception e) {
            throw new Exception("Crear. " + e.getMessage(), e);
        }
        return "";
    }

    public String buscarCarrera(long id) throws Exception {
        try {
            if (Carrera.getIdCarrera() != 0) {
                Carrera = local.buscar(id);
            } else {
                //lanzar error
            }
        } catch (Exception e) {
            throw new Exception("Buscar. " + e.getMessage(), e);
        }
        return "";
    }

    public String editarCarrera() throws Exception {
        try {
            if (Carrera.getIdCarrera() != 0) {
                local.actualizar(Carrera);
            } else {
                //lanzar error
            }
        } catch (Exception e) {
            throw new Exception("Editar. " + e.getMessage(), e);
        }
        return "";
    }

    public String borrarCarrera() throws Exception {
        try {
            if (Carrera.getIdCarrera() != 0) {
                local.eliminar(Carrera);
            } else {
                //lanzar error
            }
        } catch (Exception e) {
            throw new Exception("Borrar. " + e.getMessage(), e);
        }
        return "";
    }

    public List<Carrera> getListarCarrera() {
        try {
            return local.listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    // Navegacion ---------------------------------------------------------------------------------------

    public String nuevaCarrera() {
        Carrera = new Carrera();
        return "";
    }

    public boolean isCarreraRegistrado() {
        if (Carrera != null) {
            if (Carrera.getIdCarrera() != null) {
                return true;
            }
        }
        return false;
    }
}