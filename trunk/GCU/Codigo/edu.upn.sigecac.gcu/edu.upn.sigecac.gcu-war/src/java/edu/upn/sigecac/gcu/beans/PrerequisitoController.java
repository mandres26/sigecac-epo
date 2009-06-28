/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.gcu.beans;
import edu.upn.sigecac.gcu.bc.PrerequisitoFacadeLocal;
import edu.upn.sigecac.gcu.bc.CursoFacadeLocal;
import edu.upn.sigecac.gcu.be.Curso;
import edu.upn.sigecac.gcu.be.Prerequisito;
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
public class PrerequisitoController {
   @EJB
    private CursoFacadeLocal localCurso;
    @EJB
    private PrerequisitoFacadeLocal local;
    private Prerequisito Prerequisito;
    private Curso Curso;
    private String criterioPrerequisito;
    private String valorPrerequisito;
    private long idCursoPadre;
    private List<SelectItem> Prerequisitos;
    private String selectedItem;

    public PrerequisitoController() {
        Prerequisito = new Prerequisito();
        Curso = new Curso();
    }

    public List<SelectItem> getPrerequisitos() {
        return Prerequisitos;
    }

    public long getIdCursoPadre() {
        return idCursoPadre;
    }

    public void setIdCursoPadre(long idCursoPadre) {
        this.idCursoPadre = idCursoPadre;
    }

    public void setPrerequisitos(List<SelectItem> Prerequisitos) {
        this.Prerequisitos = Prerequisitos;
    }

    public Curso getCurso() {
        return Curso;
    }

    public void setCurso(Curso Curso) {
        this.Curso = Curso;
    }


    // Get y Set ----------------------------------------------------------------------------------------
    public Prerequisito getPrerequisito() {
        return Prerequisito;
    }

    public void setPrerequisito(Prerequisito Prerequisito) {
        this.Prerequisito = Prerequisito;
    }

    public List<SelectItem> getPrerequisitoes() {
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

    public void setPrerequisito(List<SelectItem> Prerequisitos) {
        this.Prerequisitos = Prerequisitos;
    }

    public String getCriterioPrerequisito() {
        return criterioPrerequisito;
    }

    public void setCriterioPrerequisito(String criterioPrerequisito) {
        this.criterioPrerequisito = criterioPrerequisito;
    }

    public String getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(String selectedItem) {
        this.selectedItem = selectedItem;
    }

    public String getValorPrerequisito() {
        return valorPrerequisito;
    }

    public void setValorPrerequisito(String valorPrerequisito) {
        this.valorPrerequisito = valorPrerequisito;
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
    public String crearPrerequisito() throws Exception {
        try {
            if (Prerequisito.getNombre().toLowerCase().trim().equals("") || Curso.getIdCurso() == 0) {
                addErrorMessage("La operacion realizada no se pudo completar, existen campos vacios");
            } else {
                if (Prerequisito.getIdPrerequisito() == null) {
                    Curso.setIdCurso(idCursoPadre);
                    Prerequisito.setFxIdcurso(Curso);
                    local.crear(Prerequisito);
                    return "";
                }
            }
        } catch (Exception e) {
            throw new Exception("Crear. " + e.getMessage(), e);
        }
        return "";
    }
public String setDataPrerequisito(){
    Prerequisito.setAbreviatura(Curso.getAbreviatura());
    Prerequisito.setNombre(Curso.getNombre());
    return "";
}
    public List<Prerequisito> listarPrerequisito() throws Exception {
        try {
            return local.listar();
        } catch (Exception e) {
            throw new Exception("Listar. " + e.getMessage(), e);
        }
    }

    public String buscarPrerequisito(long id) throws Exception {
        try {
            if (Prerequisito.getIdPrerequisito() != 0) {
                Prerequisito = local.buscar(id);
            } else {
                //lanzar error
            }
        } catch (Exception e) {
            throw new Exception("Buscar. " + e.getMessage(), e);
        }
        return "";
    }

    public String editarPrerequisito() throws Exception {
        try {
            if (Prerequisito.getNombre().toLowerCase().trim().equals("") ) {
                addErrorMessage("La operacion realizada no se pudo completar, existen campos vacios");
            } else {
                if (Prerequisito.getIdPrerequisito() != 0) {
                    local.actualizar(Prerequisito);
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

    public String borrarPrerequisito() throws Exception {
        try {
            if (Prerequisito.getIdPrerequisito() != 0) {
                local.eliminar(Prerequisito);
            } else {
                //lanzar error
            }
        } catch (Exception e) {
            throw new Exception("Borrar. " + e.getMessage(), e);
        }
        return "";
    }

    public List<Prerequisito> getListaPrerequisitos() {
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
    public String nuevaPrerequisito() {
        Prerequisito = new Prerequisito();
        Curso = new Curso();
        return "";
    }
}