/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.sigecac.gcu.beans;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import edu.upn.sigecac.gcu.bc.EdicionCursoFacadeLocal;
import edu.upn.sigecac.gcu.bc.CursoFacadeLocal;
import edu.upn.sigecac.gcu.be.Curso;
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
public class EdicionCursoController {

    @EJB
    private CursoFacadeLocal localCurso;
    @EJB
    private EdicionCursoFacadeLocal local;
    private EdicionCurso EdicionCurso;
    private Curso Curso;
    private String criterioEdicionCurso;
    private String valorEdicionCurso;
    private List<SelectItem> EdicionCursos;
    private String selectedItem;
    private long idCursoPadre;

    public EdicionCursoController() {
        EdicionCurso = new EdicionCurso();
        Curso = new Curso();
    }

    public List<SelectItem> getEdicionCursos() {
        return EdicionCursos;
    }

    public void setEdicionCursos(List<SelectItem> EdicionCursos) {
        this.EdicionCursos = EdicionCursos;
    }

    public long getIdCursoPadre() {
        return idCursoPadre;
    }

    public void setIdCursoPadre(long idCursoPadre) {
        this.idCursoPadre = idCursoPadre;
    }

    public Curso getCurso() {
        return Curso;
    }

    public void setCurso(Curso Curso) {
        this.Curso = Curso;
    }


    // Get y Set ----------------------------------------------------------------------------------------
    public EdicionCurso getEdicionCurso() {
        return EdicionCurso;
    }

    public void setEdicionCurso(EdicionCurso EdicionCurso) {
        this.EdicionCurso = EdicionCurso;
    }

    public List<SelectItem> getEdicionCursoes() {
        return null;
    }

    public List<SelectItem> getListaCursos() {
        List<SelectItem> combo = null;
        try {

            List<Curso> lista = localCurso.listar();
            combo = new ArrayList<SelectItem>();
            if (lista.size() > 0) {
                combo.add(new SelectItem(String.valueOf(0), "Seleccionar Curso"));
                for (Curso t : lista) {
                    combo.add(new SelectItem(String.valueOf(t.getIdCurso()), t.getNombre()));
                }
            } else {
                combo.add(new SelectItem(String.valueOf(0), "No hay Registros"));
            }

        } catch (Exception e) {
            combo.add(new SelectItem(String.valueOf(0), "ERROR"));
        }

        return combo;
    }

    public void setEdicionCurso(List<SelectItem> EdicionCursos) {
        this.EdicionCursos = EdicionCursos;
    }

    public String getCriterioEdicionCurso() {
        return criterioEdicionCurso;
    }

    public void setCriterioEdicionCurso(String criterioEdicionCurso) {
        this.criterioEdicionCurso = criterioEdicionCurso;
    }

    public String getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(String selectedItem) {
        this.selectedItem = selectedItem;
    }

    public String getValorEdicionCurso() {
        return valorEdicionCurso;
    }

    public void setValorEdicionCurso(String valorEdicionCurso) {
        this.valorEdicionCurso = valorEdicionCurso;
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
    public String crearEdicionCurso() throws Exception {
        try {
            if (EdicionCurso.getEdicion().toLowerCase().trim().equals("") || idCursoPadre == 0) {
                addErrorMessage("La operacion realizada no se pudo completar, existen campos vacios");
            } else {
                if (EdicionCurso.getIdEdicionCurso() == null) {
                    Curso.setIdCurso(idCursoPadre);
                    EdicionCurso.setFxIdcurso(Curso);
                    local.crear(EdicionCurso);
                    return "";
                }
            }
        } catch (Exception e) {
            throw new Exception("Crear. " + e.getMessage(), e);
        }
        return "";
    }

    public List<EdicionCurso> listarEdicionCurso() throws Exception {
        try {
            return local.listar();
        } catch (Exception e) {
            throw new Exception("Listar. " + e.getMessage(), e);
        }
    }

    public String buscarEdicionCurso(long id) throws Exception {
        try {
            if (EdicionCurso.getIdEdicionCurso() != 0) {
                EdicionCurso = local.buscar(id);
            } else {
                //lanzar error
            }
        } catch (Exception e) {
            throw new Exception("Buscar. " + e.getMessage(), e);
        }
        return "";
    }

    public String editarEdicionCurso() throws Exception {
        try {
            if (EdicionCurso.getEdicion().toLowerCase().trim().equals("") ) {
                addErrorMessage("La operacion realizada no se pudo completar, existen campos vacios");
            } else {
                if (EdicionCurso.getIdEdicionCurso() != 0) {
                    local.actualizar(EdicionCurso);
                    return "";
                } else {
                    //lanzar error
                }
            }
        } catch (Exception e) {
            throw new Exception("Editar. " + e.getMessage(), e);
        }
        return "";
    }

    public String borrarEdicionCurso() throws Exception {
        try {
            if (EdicionCurso.getIdEdicionCurso() != 0) {
                local.eliminar(EdicionCurso);
            } else {
                //lanzar error
            }
        } catch (Exception e) {
            throw new Exception("Borrar. " + e.getMessage(), e);
        }
        return "";
    }

    public List<EdicionCurso> getListaEdicionCursos() {
        try {
            return local.listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    // Navegacion ---------------------------------------------------------------------------------------
    public String nuevaEdicionCurso() {
        EdicionCurso = new EdicionCurso();
        Curso = new Curso();
        return "";
    }
}