/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.sigecac.gcu.beans;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import edu.upn.sigecac.gcu.bc.CursoFacadeLocal;
import edu.upn.sigecac.gcu.bc.EdicionCursoFacadeLocal;
import edu.upn.sigecac.gcu.bc.EquivalenciaFacadeLocal;
import edu.upn.sigecac.gcu.bc.PrerequisitoFacadeLocal;
import edu.upn.sigecac.gcu.bc.SubAreaFacadeLocal;
import edu.upn.sigecac.gcu.be.Curso;
import edu.upn.sigecac.gcu.be.EdicionCurso;
import edu.upn.sigecac.gcu.be.Equivalencia;
import edu.upn.sigecac.gcu.be.Prerequisito;
import edu.upn.sigecac.gcu.be.SubArea;
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
public class CursoController {

    @EJB
    private EquivalenciaFacadeLocal localequivalencia;
    @EJB
    private PrerequisitoFacadeLocal localprerequisito;
    @EJB
    private EdicionCursoFacadeLocal localedicionCurso;
    @EJB
    private SubAreaFacadeLocal localSubArea;
    @EJB
    private CursoFacadeLocal local;
    private Curso Curso;
    private SubArea SubArea;
    private List<SelectItem> Cursos;
    private String selectedItem;

    public CursoController() {
        Curso = new Curso();
        SubArea = new SubArea();
    }

    public List<SelectItem> getCursos() {
        return Cursos;
    }

    public void setCursos(List<SelectItem> Cursos) {
        this.Cursos = Cursos;
    }

    public SubArea getSubArea() {
        return SubArea;
    }

    public void setSubArea(SubArea SubArea) {
        this.SubArea = SubArea;
    }

    // Get y Set ----------------------------------------------------------------------------------------
    public Curso getCurso() {
        return Curso;
    }

    public void setCurso(Curso Curso) {
        this.Curso = Curso;
    }

    public List<SelectItem> getCursoes() {
        return null;
    }

    public List<SelectItem> getListaSubAreas() {
        List<SelectItem> combo = null;
        try {

            List<SubArea> lista = localSubArea.listar();
            combo = new ArrayList<SelectItem>();
            if (lista.size() > 0) {
                combo.add(new SelectItem(String.valueOf(0), "Seleccionar SubArea"));
                for (SubArea t : lista) {
                    combo.add(new SelectItem(String.valueOf(t.getIdSubArea()), t.getNombre()));
                }
            } else {
                combo.add(new SelectItem(String.valueOf(0), "No hay Registros"));
            }

        } catch (Exception e) {
            combo.add(new SelectItem(String.valueOf(0), "ERROR"));
        }

        return combo;
    }

    public List<SelectItem> getListaEspecializaciones() {
        List<SelectItem> combo = null;
        try {
            combo = new ArrayList<SelectItem>();
            combo.add(new SelectItem(String.valueOf(0), "Seleccionar Especializacion"));
            combo.add(new SelectItem(String.valueOf(7), "Desarrollo Software"));
            combo.add(new SelectItem(String.valueOf(8), "Redes Seguridad"));
            combo.add(new SelectItem(String.valueOf(9), "Tecnologias Informacion"));

        } catch (Exception e) {
            combo.add(new SelectItem(String.valueOf(0), "ERROR"));
        }

        return combo;
    }

    public void setCurso(List<SelectItem> Cursos) {
        this.Cursos = Cursos;
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
    public String crearCurso() throws Exception {

        try {
            if (Curso.getNombre().toLowerCase().toLowerCase().trim().equals("") || SubArea.getIdSubArea() == 0) {
                addErrorMessage("La operacion realizada no se pudo completar, existen campos vacios");
            } else {
                if (!Curso.getNombre().trim().equals("")) {
                    Curso.setFxSubarea(SubArea);
                    local.crear(Curso);
                    return "";
                }
            }
        } catch (Exception e) {
            throw new Exception("Crear. " + e.getMessage(), e);
        }
        return "";
    }

    public List<Curso> listarCurso() throws Exception {
        try {
            return local.listar();
        } catch (Exception e) {
            throw new Exception("Listar. " + e.getMessage(), e);
        }
    }

    public String buscarCurso(long id) throws Exception {
        try {
            if (Curso.getIdCurso() != 0) {
                Curso = local.buscar(id);
            } else {
                //lanzar error
            }
        } catch (Exception e) {
            throw new Exception("Buscar. " + e.getMessage(), e);
        }
        return "";
    }

    public String editarCurso() throws Exception {
        try {
            if (Curso.getIdCurso() != 0) {
                local.actualizar(Curso);
            } else {
                //lanzar error
            }
        } catch (Exception e) {
            throw new Exception("Editar. " + e.getMessage(), e);
        }
        return "";
    }

    public String borrarCurso() throws Exception {
        try {
            if (Curso.getIdCurso() != 0) {
                local.eliminar(Curso);
            } else {
                //lanzar error
            }
        } catch (Exception e) {
            throw new Exception("Borrar. " + e.getMessage(), e);
        }
        return "";
    }

    public List<Curso> getListaCursos() {
        try {
            return local.listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<EdicionCurso> getListaEdicionesCurso() {
        try {
            if (Curso != null) {
                return localedicionCurso.EdicionCursoxCurso(Curso.getIdCurso());
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Prerequisito> getListaPrerequisito() {
        try {
            if (Curso != null) {
                return localprerequisito.PrerequisitoxCurso(Curso.getIdCurso());
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Equivalencia> getListaEquivalencia() {
        try {
            if (Curso != null) {
                return localequivalencia.EquivalenciaxCurso(Curso.getIdCurso());
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    // Navegacion ---------------------------------------------------------------------------------------

    public String nuevaCurso() {
        Curso = new Curso();
        SubArea = new SubArea();
        return "";
    }

    public boolean isCursoRegistrado() {
        if (Curso != null) {
            if (Curso.getIdCurso() != null) {
                return true;
            }
        }
        return false;
    }
}