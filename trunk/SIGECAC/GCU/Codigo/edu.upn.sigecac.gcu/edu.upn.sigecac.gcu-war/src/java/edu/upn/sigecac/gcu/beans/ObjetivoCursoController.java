/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.sigecac.gcu.beans;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import edu.upn.sigecac.gcu.bc.ObjetivoCursoFacadeLocal;
import edu.upn.sigecac.gcu.be.ObjetivoCurso;
import edu.upn.sigecac.gcu.bc.EdicionCursoFacadeLocal;
import edu.upn.sigecac.gcu.be.EdicionCurso;
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
public class ObjetivoCursoController {

    @EJB
    private ObjetivoCursoFacadeLocal local;
    @EJB
    private EdicionCursoFacadeLocal localEdicionCurso;
    private ObjetivoCurso ObjetivoCurso;
    private EdicionCurso EdicionCurso;
    private List<SelectItem> ObjetivoCursos;
    private String selectedItem;

    public ObjetivoCursoController() {
        ObjetivoCurso = new ObjetivoCurso();
        EdicionCurso = new EdicionCurso();
    }

    public List<SelectItem> getObjetivoCursos() {
        return ObjetivoCursos;
    }

    public void setObjetivoCursos(List<SelectItem> ObjetivoCursos) {
        this.ObjetivoCursos = ObjetivoCursos;
    }

    public EdicionCurso getEdicionCurso() {
        return EdicionCurso;
    }

    public void setEdicionCurso(EdicionCurso EdicionCurso) {
        this.EdicionCurso = EdicionCurso;
    }

    // Get y Set ----------------------------------------------------------------------------------------
    public ObjetivoCurso getObjetivoCurso() {
        return ObjetivoCurso;
    }

    public void setObjetivoCurso(ObjetivoCurso ObjetivoCurso) {
        this.ObjetivoCurso = ObjetivoCurso;
    }

    public List<SelectItem> getObjetivoCursoes() {
        return null;
    }

    public List<SelectItem> getListaEdicionCursos() {
        List<SelectItem> combo = null;
        try {

            List<EdicionCurso> lista = localEdicionCurso.listar();
            combo = new ArrayList<SelectItem>();
            if (lista.size() > 0) {
                combo.add(new SelectItem(String.valueOf(0), "Seleccionar EdicionCurso"));
                for (EdicionCurso t : lista) {
                    combo.add(new SelectItem(String.valueOf(t.getIdEdicionCurso()), t.getEdicion()));
                }
            } else {
                combo.add(new SelectItem(String.valueOf(0), "No hay Registros"));
            }

        } catch (Exception e) {
            combo.add(new SelectItem(String.valueOf(0), "ERROR"));
        }

        return combo;
    }

    public void setObjetivoCurso(List<SelectItem> ObjetivoCursos) {
        this.ObjetivoCursos = ObjetivoCursos;
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
    public String crearObjetivoCurso() throws Exception {

        try {
            if (ObjetivoCurso.getDescripcion().toLowerCase().toLowerCase().trim().equals("") || EdicionCurso.getIdEdicionCurso() == 0) {
                addErrorMessage("La operacion realizada no se pudo completar, existen campos vacios");
            } else {
                if (!ObjetivoCurso.getDescripcion().trim().equals("")) {
                    ObjetivoCurso.setFxIdedicion(EdicionCurso);
                    local.crear(ObjetivoCurso);
                    return "";
                }
            }
        } catch (Exception e) {
            throw new Exception("Crear. " + e.getMessage(), e);
        }
        return "";
    }

    public String buscarObjetivoCurso(long id) throws Exception {
        try {
            if (ObjetivoCurso.getIdObjetivocurso() != 0) {
                ObjetivoCurso = local.buscar(id);
            } else {
                //lanzar error
            }
        } catch (Exception e) {
            throw new Exception("Buscar. " + e.getMessage(), e);
        }
        return "";
    }

    public String editarObjetivoCurso() throws Exception {
        try {
            if (ObjetivoCurso.getIdObjetivocurso() != 0) {
                local.actualizar(ObjetivoCurso);
            } else {
                //lanzar error
            }
        } catch (Exception e) {
            throw new Exception("Editar. " + e.getMessage(), e);
        }
        return "";
    }

    public String borrarObjetivoCurso() throws Exception {
        try {
            if (ObjetivoCurso.getIdObjetivocurso() != 0) {
                local.eliminar(ObjetivoCurso);
            } else {
                //lanzar error
            }
        } catch (Exception e) {
            throw new Exception("Borrar. " + e.getMessage(), e);
        }
        return "";
    }

    public List<ObjetivoCurso> getListarObjetivoCurso() {
        try {
            return local.listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    // Navegacion ---------------------------------------------------------------------------------------

    public String nuevaObjetivoCurso() {
        ObjetivoCurso = new ObjetivoCurso();
        EdicionCurso = new EdicionCurso();
        return "";
    }

    public boolean isObjetivoCursoRegistrado() {
        if (ObjetivoCurso != null) {
            if (ObjetivoCurso.getIdObjetivocurso() != null) {
                return true;
            }
        }
        return false;
    }
}