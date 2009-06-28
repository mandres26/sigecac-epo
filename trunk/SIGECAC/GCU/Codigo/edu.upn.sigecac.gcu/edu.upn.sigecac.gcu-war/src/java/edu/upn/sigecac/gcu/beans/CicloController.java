/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.sigecac.gcu.beans;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import edu.upn.sigecac.gcu.bc.CicloFacadeLocal;
import edu.upn.sigecac.gcu.be.Ciclo;
import edu.upn.sigecac.gcu.bc.CursoFacadeLocal;
import edu.upn.sigecac.gcu.be.Curso;
import edu.upn.sigecac.gcu.be.MallaCurricular;
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
public class CicloController {

    @EJB
    private CicloFacadeLocal local;
    @EJB
    private CursoFacadeLocal localCurso;
    private Ciclo Ciclo;
    private Curso Curso;
    private MallaCurricular MallaCurricular;
    private List<SelectItem> Ciclos;
    private String selectedItem;
    private long idMallaCurricularPadre;
    private String SelectCiclo;

    public CicloController() {
        Ciclo = new Ciclo();
        Curso = new Curso();
        MallaCurricular = new MallaCurricular();
    }

    public List<SelectItem> getCiclos() {
        return Ciclos;
    }

    public long getIdMallaCurricularPadre() {
        return idMallaCurricularPadre;
    }

    public void setIdMallaCurricularPadre(long idMallaCurricularPadre) {
        this.idMallaCurricularPadre = idMallaCurricularPadre;
    }

    public void setCiclos(List<SelectItem> Ciclos) {
        this.Ciclos = Ciclos;
    }

    public MallaCurricular getMallaCurricular() {
        return MallaCurricular;
    }

    public String getSelectCiclo() {
        return SelectCiclo;
    }

    public void setSelectCiclo(String SelectCiclo) {
        this.SelectCiclo = SelectCiclo;
    }

    public void setMallaCurricular(MallaCurricular MallaCurricular) {
        this.MallaCurricular = MallaCurricular;
    }

    public Curso getCurso() {
        return Curso;
    }

    public void setCurso(Curso Curso) {
        this.Curso = Curso;
    }

    // Get y Set ----------------------------------------------------------------------------------------
    public Ciclo getCiclo() {
        return Ciclo;
    }

    public void setCiclo(Ciclo Ciclo) {
        this.Ciclo = Ciclo;
    }

    public List<SelectItem> getCicloes() {
        return null;
    }

    public void setCiclo(List<SelectItem> Ciclos) {
        this.Ciclos = Ciclos;
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
    public String crearCiclo() throws Exception {

        try {
             if (Curso.getIdCurso()== null) {
                    addErrorMessage("Seleccione un Curso o Cancele la operacion");
            } else{
                if (idMallaCurricularPadre == 0 || Curso.getIdCurso() == 0) {
                    addErrorMessage("La operacion realizada no se pudo completar, existen campos vacios");
                } else {
                    if (!Ciclo.getCiclo().trim().equals("")) {
                        Ciclo.setFkCurso(Curso);
                        MallaCurricular.setIdMallacurricular(idMallaCurricularPadre);
                        Ciclo.setFkMallaCurricular(MallaCurricular);
                        local.crear(Ciclo);
                        return "";
                    }
                }
            }
        } catch (Exception e) {
            throw new Exception("Crear. " + e.getMessage(), e);
        }
        return "";
    }

    public String buscarCiclo(long id) throws Exception {
        try {
            if (Ciclo.getIdCiclo() != 0) {
                Ciclo = local.buscar(id);
            } else {
                //lanzar error
            }
        } catch (Exception e) {
            throw new Exception("Buscar. " + e.getMessage(), e);
        }
        return "";
    }

    public String editarCiclo() throws Exception {
        try {
            if (Ciclo.getIdCiclo() != 0) {
                local.actualizar(Ciclo);
            } else {
                //lanzar error
            }
        } catch (Exception e) {
            throw new Exception("Editar. " + e.getMessage(), e);
        }
        return "";
    }

    public String borrarCiclo() throws Exception {
        try {
            if (Ciclo.getIdCiclo() != 0) {
                local.eliminar(Ciclo);
            } else {
                //lanzar error
            }
        } catch (Exception e) {
            throw new Exception("Borrar. " + e.getMessage(), e);
        }
        return "";
    }

    public List<Ciclo> getListarCiclo() {
        try {
            return local.listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public String setDataCiclo(){
        Ciclo.setCiclo(SelectCiclo);
        return "";
    }
    // Navegacion ---------------------------------------------------------------------------------------

    public String nuevaCiclo() {
        Ciclo = new Ciclo();
        Curso = new Curso();
        MallaCurricular = new MallaCurricular();
        return "";
    }

    public boolean isCicloRegistrado() {
        if (Ciclo != null) {
            if (Ciclo.getIdCiclo() != null) {
                return true;
            }
        }
        return false;
    }
}