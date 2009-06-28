/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.gcu.beans;
import edu.upn.sigecac.gcu.bc.EquivalenciaFacadeLocal;
import edu.upn.sigecac.gcu.bc.CursoFacadeLocal;
import edu.upn.sigecac.gcu.be.Curso;
import edu.upn.sigecac.gcu.be.Equivalencia;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author MiamiWebmasters
 */
public class EquivalenciaController {
   @EJB
    private CursoFacadeLocal localCurso;
    @EJB
    private EquivalenciaFacadeLocal local;
    private Equivalencia Equivalencia;
    private Curso Curso;
    private String criterioEquivalencia;
    private String valorEquivalencia;
    private long idCursoPadre;
    private List<SelectItem> Equivalencias;
    private String selectedItem;

    public EquivalenciaController() {
        Equivalencia = new Equivalencia();
        Curso = new Curso();
    }

    public List<SelectItem> getEquivalencias() {
        return Equivalencias;
    }

    public long getIdCursoPadre() {
        return idCursoPadre;
    }

    public void setIdCursoPadre(long idCursoPadre) {
        this.idCursoPadre = idCursoPadre;
    }

    public void setEquivalencias(List<SelectItem> Equivalencias) {
        this.Equivalencias = Equivalencias;
    }

    public Curso getCurso() {
        return Curso;
    }

    public void setCurso(Curso Curso) {
        this.Curso = Curso;
    }


    // Get y Set ----------------------------------------------------------------------------------------
    public Equivalencia getEquivalencia() {
        return Equivalencia;
    }

    public void setEquivalencia(Equivalencia Equivalencia) {
        this.Equivalencia = Equivalencia;
    }

    public List<SelectItem> getEquivalenciaes() {
        return null;
    }

    public List<SelectItem> getListaCursosxCombo() {
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

    public void setEquivalencia(List<SelectItem> Equivalencias) {
        this.Equivalencias = Equivalencias;
    }

    public String getCriterioEquivalencia() {
        return criterioEquivalencia;
    }

    public void setCriterioEquivalencia(String criterioEquivalencia) {
        this.criterioEquivalencia = criterioEquivalencia;
    }

    public String getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(String selectedItem) {
        this.selectedItem = selectedItem;
    }

    public String getValorEquivalencia() {
        return valorEquivalencia;
    }

    public void setValorEquivalencia(String valorEquivalencia) {
        this.valorEquivalencia = valorEquivalencia;
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
    public String crearEquivalencia() throws Exception {
        try {
            if (Curso.getIdCurso()== null) {
                    addErrorMessage("Seleccione un Curso o Cancele la operacion");
            } else{
            if (Equivalencia.getNombre().toLowerCase().trim().equals("") || Curso.getIdCurso() == 0) {
                addErrorMessage("La operacion realizada no se pudo completar, existen campos vacios");
            } else {
                if (Equivalencia.getFxIdEquivalencia() == null) {
                    Curso.setIdCurso(idCursoPadre);
                    Equivalencia.setFxIdCurso(Curso);
                    local.crear(Equivalencia);
                    return "";
                }
            }}
        } catch (Exception e) {
            throw new Exception("Crear. " + e.getMessage(), e);
        }
        return "";
    }
public String setDataEquivalencia(){
    Equivalencia.setAbreviatura(Curso.getAbreviatura());
    Equivalencia.setNombre(Curso.getNombre());
    return "";
}
    public List<Equivalencia> listarEquivalencia() throws Exception {
        try {
            return local.listar();
        } catch (Exception e) {
            throw new Exception("Listar. " + e.getMessage(), e);
        }
    }

    public String buscarEquivalencia(long id) throws Exception {
        try {
            if (Equivalencia.getFxIdEquivalencia() != 0) {
                Equivalencia = local.buscar(id);
            } else {
                //lanzar error
            }
        } catch (Exception e) {
            throw new Exception("Buscar. " + e.getMessage(), e);
        }
        return "";
    }

    public String editarEquivalencia() throws Exception {
        try {
            if (Equivalencia.getNombre().toLowerCase().trim().equals("") ) {
                addErrorMessage("La operacion realizada no se pudo completar, existen campos vacios");
            } else {
                if (Equivalencia.getFxIdEquivalencia() != 0) {
                    local.actualizar(Equivalencia);
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

    public String borrarEquivalencia() throws Exception {
        try {
            if (Equivalencia.getFxIdEquivalencia() != 0) {
                local.eliminar(Equivalencia);
            } else {
                //lanzar error
            }
        } catch (Exception e) {
            throw new Exception("Borrar. " + e.getMessage(), e);
        }
        return "";
    }

    public List<Equivalencia> getListaEquivalencias() {
        try {
            return local.listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Curso> getListaCursos() {
        try {
            return localCurso.listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Navegacion ---------------------------------------------------------------------------------------
    public String nuevaEquivalencia() {
        Equivalencia = new Equivalencia();
        Curso = new Curso();
        return "";
    }
     public boolean isEquivalenciaRegistrado() {
        if (Equivalencia != null) {
            if (Equivalencia.getFxIdEquivalencia() != null) {
                return true;
            }
        }
        return false;
    }
}