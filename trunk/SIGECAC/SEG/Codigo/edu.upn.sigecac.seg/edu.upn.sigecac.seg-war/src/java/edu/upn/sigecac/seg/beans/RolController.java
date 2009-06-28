package edu.upn.sigecac.seg.beans;

import edu.upn.sigecac.seg.bc.RolFacadeLocal;
import edu.upn.sigecac.seg.be.Rol;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

public class RolController {

    private String nombreRol;
    private Rol rol;
    private DataModel model;
    @EJB
    private RolFacadeLocal local;

    /** Creates a new instance of RolController */
    public RolController() {
        
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public String nuevo() {
        this.rol = new Rol();
        this.rol.setEstado(true);
        return "nuevo_rol";
    }

    public String listar_roles() {
        return "listar_roles";
    }

    public String retornar() {
        return "";
    }

    public String filtrar(){
        return "";
    }

    public String mostrar() {
        return "mostrar_rol";
    }

    public String guardar() {
        String str = "success";
        try {
            if (rol.getNombre().toLowerCase().trim().equals("")) {
                addErrorMessage("La operacion realizada no se puede completar, el campo nombre esta vacio");
            } else {
                if (rol.getIdRol() == null) {
                    local.registrar(rol);
                    return str;
                } else {
                    local.editar(rol);
                    return str;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            str = "failed";
        }
        //return str;
        return "";
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

    public String eliminar() {
        String str = "rol_deleted";
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestParameterMap = (Map) context.getExternalContext().getRequestParameterMap();

        try {
            Long idRol = Long.parseLong(requestParameterMap.get("idRol").toString());
            Rol r = local.buscarID(idRol);
            String nombre = r.getNombre();
            
            local.eliminar(r);
            addSuccessMessage("El rol: " + nombre + " - Eliminacion satisfactoria.");
            return str;
        } catch (NumberFormatException ne) {
            addErrorMessage("La operacion realizada no se puede completar, existe una o muchas relaciones con este rol.");
            str = "failed";
        } catch (Exception e) {
            addErrorMessage("La operacion realizada no se puede completar, existe una o muchas relaciones con este rol.");
            str = "failed";
        }
        return "";
    }

    public String editar() throws Exception {
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestParameterMap = (Map) context.getExternalContext().getRequestParameterMap();

        Long idRol = Long.parseLong(requestParameterMap.get("idRol").toString());
        this.rol = local.buscarID(idRol);
        return "editar_rol";
    }

    public DataModel getListar() throws Exception {
        model = new ListDataModel(local.listar());
        return model;
    }

    public Rol buscarID(Long idRol) throws Exception {
        String str = "success";
        try {
            return local.buscarID(idRol);
        } catch (Exception ex) {
            ex.printStackTrace();
            str = "failed";
        }
        return null;
    }

    public List<Rol> listaPorNombre(String nombre) throws Exception {
        return local.listarxNombre(nombre);
    }

    public List<Rol> getlistarxNombre() throws Exception {
        return listaPorNombre(nombreRol);
    }
}
