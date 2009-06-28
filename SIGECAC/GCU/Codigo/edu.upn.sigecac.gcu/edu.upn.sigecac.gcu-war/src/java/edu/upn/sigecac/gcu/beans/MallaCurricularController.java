/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.sigecac.gcu.beans;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import edu.upn.sigecac.gcu.bc.MallaCurricularFacadeLocal;
import edu.upn.sigecac.gcu.be.MallaCurricular;
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
public class MallaCurricularController {

    @EJB
    private MallaCurricularFacadeLocal local;
    @EJB
    private CarreraFacadeLocal localCarrera;
    private MallaCurricular MallaCurricular;
    private Carrera Carrera;
    private List<SelectItem> MallaCurriculars;
    private String selectedItem;

    public MallaCurricularController() {
        MallaCurricular = new MallaCurricular();
        Carrera = new Carrera();
    }

    public List<SelectItem> getMallaCurriculars() {
        return MallaCurriculars;
    }

    public void setMallaCurriculars(List<SelectItem> MallaCurriculars) {
        this.MallaCurriculars = MallaCurriculars;
    }

    public Carrera getCarrera() {
        return Carrera;
    }

    public void setCarrera(Carrera Carrera) {
        this.Carrera = Carrera;
    }

    // Get y Set ----------------------------------------------------------------------------------------
    public MallaCurricular getMallaCurricular() {
        return MallaCurricular;
    }

    public void setMallaCurricular(MallaCurricular MallaCurricular) {
        this.MallaCurricular = MallaCurricular;
    }

    public List<SelectItem> getMallaCurriculares() {
        return null;
    }

    public List<SelectItem> getListaCarreras() {
        List<SelectItem> combo = null;
        try {

            List<Carrera> lista = localCarrera.listar();
            combo = new ArrayList<SelectItem>();
            if (lista.size() > 0) {
                combo.add(new SelectItem(String.valueOf(0), "Seleccionar Carrera"));
                for (Carrera t : lista) {
                    combo.add(new SelectItem(String.valueOf(t.getIdCarrera()), t.getNombre()));
                }
            } else {
                combo.add(new SelectItem(String.valueOf(0), "No hay Registros"));
            }

        } catch (Exception e) {
            combo.add(new SelectItem(String.valueOf(0), "ERROR"));
        }

        return combo;
    }

    public void setMallaCurricular(List<SelectItem> MallaCurriculars) {
        this.MallaCurriculars = MallaCurriculars;
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
    public String crearMallaCurricular() throws Exception {

        try {
            if (MallaCurricular.getNombre().toLowerCase().toLowerCase().trim().equals("") || Carrera.getIdCarrera() == 0) {
                addErrorMessage("La operacion realizada no se pudo completar, existen campos vacios");
            } else {
                if (!MallaCurricular.getNombre().trim().equals("")) {
                    MallaCurricular.setFkIdCarrera(Carrera);
                    local.crear(MallaCurricular);
                    return "";
                }
            }
        } catch (Exception e) {
            throw new Exception("Crear. " + e.getMessage(), e);
        }
        return "";
    }

    public String buscarMallaCurricular(long id) throws Exception {
        try {
            if (MallaCurricular.getIdMallacurricular() != 0) {
                MallaCurricular = local.buscar(id);
            } else {
                //lanzar error
            }
        } catch (Exception e) {
            throw new Exception("Buscar. " + e.getMessage(), e);
        }
        return "";
    }

    public String editarMallaCurricular() throws Exception {
        try {
            if (MallaCurricular.getIdMallacurricular() != 0) {
                local.actualizar(MallaCurricular);
            } else {
                //lanzar error
            }
        } catch (Exception e) {
            throw new Exception("Editar. " + e.getMessage(), e);
        }
        return "";
    }

    public String borrarMallaCurricular() throws Exception {
        try {
            if (MallaCurricular.getIdMallacurricular() != 0) {
                local.eliminar(MallaCurricular);
            } else {
                //lanzar error
            }
        } catch (Exception e) {
            throw new Exception("Borrar. " + e.getMessage(), e);
        }
        return "";
    }

    public List<MallaCurricular> getListarMallaCurricular() {
        try {
            return local.listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<SelectItem> getListaCiclo() {
        List<SelectItem> combo = null;
        try {
            combo = new ArrayList<SelectItem>();
            int tope = 0,top = 0;
            if (MallaCurricular != null) {
                if (MallaCurricular.getIdMallacurricular() != null) {
                    tope=MallaCurricular.getNrociclos();
                }
            }
            combo.add(new SelectItem(String.valueOf(0), "Seleccionar Ciclo"));
            for (top=1;top<=tope;top++) {
                  combo.add(new SelectItem(String.valueOf(top),String.valueOf(top)));
            }
        } catch (Exception e) {
            combo.add(new SelectItem(String.valueOf(0), "ERROR"));
        }
        return combo;
    }
 
    // Navegacion ---------------------------------------------------------------------------------------

    public String nuevaMallaCurricular() {
        MallaCurricular = new MallaCurricular();
        Carrera = new Carrera();
        return "";
    }

    public boolean isMallaCurricularRegistrado() {
        if (MallaCurricular != null) {
            if (MallaCurricular.getIdMallacurricular() != null) {
                return true;
            }
        }
        return false;
    }
}