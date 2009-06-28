package edu.upn.sigecac.seg.beans;

import edu.upn.sigecac.seg.bc.GrupoFacadeLocal;
import edu.upn.sigecac.seg.bc.RolFacadeLocal;
import edu.upn.sigecac.seg.be.Grupo;
import edu.upn.sigecac.seg.be.Rol;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

public class GrupoController {

    private String nombreGrupo;
    private Grupo grupo;
    private DataModel model;
    private Rol rol;
    private String paginaRedireccion;
    @EJB
    private GrupoFacadeLocal localgrupo;
    @EJB
    private RolFacadeLocal localrol;

    /** Creates a new instance of GrupoController */
    public GrupoController() {
        //grupo = new Grupo();
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Grupo getEntity() {
        return localgrupo.getGrupo();
    }

    public void setEntity(Grupo grupo) {
        localgrupo.setGrupo(grupo);
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getPaginaRedireccion() {
        return paginaRedireccion;
    }

    public void setPaginaRedireccion(String paginaRedireccion) {
        this.paginaRedireccion = paginaRedireccion;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

    public String nuevo() {
        this.grupo = new Grupo();
        this.grupo.setEstado(true);
        return "nuevo_grupo";
    }

   

    public String listar_grupos() {
        return "listar_grupos";
    }

    public String retornar() {
        return "";
    }

    public String filtrar() {
        return "";
    }

    public String mostrar() {
        return "mostrar_grupo";
    }

//    public String nuevoRol() {
//        rol = new Rol();
//        return "nuevoRol";
//    }
    public String seleccionarGrupoRol() {
        return "nuevoGrupoRol";
    }

//    public void insertar() throws Exception {
//        localgrupo.registrar(grupo);
//    }
    public String guardar() {

        String str = "success";
        try {
            if (grupo.getNombre().toLowerCase().trim().equals("")) {
                addErrorMessage("La operacion realizada no se pudo completar, existen campos vacios");
            } else {
                if (grupo.getIdGrupo() == null) {
                    localgrupo.registrar(grupo);
                    rol = new Rol();
                    return "nuevoRol";
                } else {
                    localgrupo.editar(grupo);
                    rol = new Rol();
                    return "nuevoRol";
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            str = "failed";
        }
        return "";
    }

//    public String grabar(){
//        String str = "success";
//        try{
//            if(rol.getIdRol() == null){
//                addErrorMessage("La operacion realizada no se pudo completar, no ha seleccionado ningun rol");
//            }else{
//                return str;
//            }
//            }catch (Exception ex){
//            ex.printStackTrace();
//            str="failed";
//        }
//        return "";
//    }
    
    public String edicion() {

        String str = "success";
        try {
            if (grupo.getNombre().toLowerCase().trim().equals("")) {
                addErrorMessage("La operacion realizada no se pudo completar, existen campos vacios");
            } else {
                if (grupo.getIdGrupo() == null) {
                    localgrupo.registrar(grupo);
                    rol = new Rol();
                    //return "nuevoRol";
                } else {
                    localgrupo.editar(grupo);
                    rol = new Rol();
                    //return "nuevoRol";
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            str = "failed";
        }
        return str;
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
        String str = "grupo_deleted";
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestParameterMap = (Map) context.getExternalContext().getRequestParameterMap();

        try {
            Long idGrupo = Long.parseLong(requestParameterMap.get("idGrupo").toString());
            Grupo g = localgrupo.buscarID(idGrupo);
            String nombre = g.getNombre();

            localgrupo.eliminar(g);
            addSuccessMessage("Grupo " + nombre + " Eliminacion satisfactoria.");
            return str;
        } catch (NumberFormatException ne) {
            //addErrorMessage(ne.getLocalizedMessage());
            addErrorMessage("La operacion realizada no se puede completar, existe una o muchas relaciones con este grupo.");
            str = "failed";
        } catch (Exception e) {
            addErrorMessage("La operacion realizada no se puede completar, existe una o muchas relaciones con este grupo.");
            str = "failed";
        }
        return "";
    }

    public String editar() throws Exception {
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestParameterMap = (Map) context.getExternalContext().getRequestParameterMap();

        Long idGrupo = Long.parseLong(requestParameterMap.get("idGrupo").toString());
        this.grupo = localgrupo.buscarID(idGrupo);
        return "editar_grupo";
    }

    public DataModel getlistarGrupo() throws Exception {
        model = new ListDataModel(localgrupo.listar());
        return model;
    }

    public Grupo buscarID(Long idGrupo) throws Exception {
        String str = "success";
        try {
            return localgrupo.buscarID(idGrupo);
        } catch (Exception ex) {
            ex.printStackTrace();
            str = "failed";
        }
        return null;
    }

    public boolean agregar(Rol rol) throws Exception {
        try {
            return localgrupo.agregarRol(rol);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public boolean quitar(Rol rol) throws Exception {
        try {
            return localgrupo.quitarRol(rol);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public String agregarRol() throws Exception {
//        try {
//            if (grupo.getIdGrupo() > 0) {
//                setEntity(grupo);
//                agregar(rol);
//                grupo = buscarID(getEntity().getIdGrupo());
//            } else {
//                grupo.getRolCollection().add(rol);
//            }
//        } catch (Exception ex) {
//            throw new Exception(ex.getMessage());
//        }
//        return paginaRedireccion;

//aqui empezo el asuntito

//           try {
//            if (grupo.getIdGrupo() > 0) {
//                setEntity(grupo);
//                agregar(rol);
//                grupo = buscarID(getEntity().getIdGrupo());
//            }
//            else {
//                grupo.getRolCollection().add(rol);
//            }
//        } catch (Exception ex) {
//            throw new Exception(ex.getMessage());
//        }
//          return paginaRedireccion;
//return "nuevo_grupo";

        String str = "success";
        try {
            if (grupo.getIdGrupo() > 0) {
                setEntity(grupo);
                agregar(rol);
                grupo = buscarID(getEntity().getIdGrupo());
            } else {
                grupo.getRolCollection().add(rol);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            str = "failed";
        }
        return paginaRedireccion;
    }

    public String quitarRol() throws Exception {
        try {
            for (Rol r : grupo.getRolCollection()) {
                if (r.getIdRol().equals(rol.getIdRol())) {
                    setEntity(grupo);
                    quitar(r);
                    grupo = buscarID(getEntity().getIdGrupo());
                    return "";
                }
            }
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return "";
    }

    public List<Grupo> listarPorNombre(String nombre) throws Exception {
        return localgrupo.listarxNombre(nombre);
    }

    public List<Grupo> getlistarxNombre() throws Exception {
        return listarPorNombre(nombreGrupo);
    }

    public boolean isRolEmpty() {
        try {
            return grupo.getRolCollection().isEmpty();
        } catch (Exception ex) {
            return true;
        }
    }
}
