package edu.upn.sigecac.seg.beans;

import edu.upn.sigecac.gen.be.Persona;
import edu.upn.sigecac.seg.bc.GrupoFacadeLocal;
import edu.upn.sigecac.seg.bc.UsuarioFacadeLocal;
import edu.upn.sigecac.seg.be.Grupo;
import edu.upn.sigecac.seg.be.Usuario;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

public class UsuarioController {

    private Usuario usuario;
    private Persona persona;
    private DataModel model;
    private String nombreUsuario = "";
    private String apellidoPaterno = "";
    private String paginaRedireccion;
    private Grupo grupo;
    private String password;
    private String passwordAnterior;
    private String nuevoPassword;
    private String confirmarPassword;
    @EJB
    private UsuarioFacadeLocal localusuario;
    @EJB
    private GrupoFacadeLocal localgrupo;

    /** Creates a new instance of UsuarioController */
    public UsuarioController() {
        //usuario = new Usuario();
    }

    public String getPasswordAnterior() {
        return passwordAnterior;
    }

    public void setPasswordAnterior(String passwordAnterior) {
        this.passwordAnterior = passwordAnterior;
    }

    public String getConfirmarPassword() {
        return confirmarPassword;
    }

    public void setConfirmarPassword(String confirmarPassword) {
        this.confirmarPassword = confirmarPassword;
    }

    public String getNuevoPassword() {
        return nuevoPassword;
    }

    public void setNuevoPassword(String nuevoPassword) {
        this.nuevoPassword = nuevoPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getEntity() {
        return localusuario.getUsuario();
    }

    public void setEntity(Usuario usuario) {
        localusuario.setUsuario(usuario);
    }

    public String getPaginaRedireccion() {
        return paginaRedireccion;
    }

    public void setPaginaRedireccion(String paginaRedireccion) {
        this.paginaRedireccion = paginaRedireccion;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String filtrar() {
        return "";
    }

    public String nuevo() {
        this.usuario = new Usuario();
        this.usuario.setEstado(true);
        return "nuevo_usuario";
    }

    public String listar_usuarios() {
        return "listar_usuarios";
    }

    public String retornar() {
        return "";
    }

    public String regresar() {
        return "";
    }

    public String mostrar() {
        return "mostrar_usuario";
    }

    // public String nuevoGrupo() {
    //grupo = new Grupo();
    // return "nuevoGrupo";
    //}
    public String seleccionarUsuarioGrupo() {
        return "nuevoUsuarioGrupo";
    }

    public String guardar() {
        String str = "success";

        try {
            if (usuario.getUserName().toLowerCase().trim().equals("") || usuario.getPassword().toLowerCase().trim().equals("")) {
                addErrorMessage("La operacion realizada no se pudo completar, existen campos vacios");
            } else {
                if (usuario.getIdUsuario() == null) {
                    boolean usernameExists = localusuario.userNameExists(usuario.getUserName());



                    if (!usernameExists) {
                        localusuario.registrar(usuario);
                        grupo = new Grupo();
                        return "nuevoGrupo";
                    } else {
                        addErrorMessage("El Usuario " + usuario.getUserName() + " ya existe.");
                        str = "try_again";
                    }
                } else {
                    localusuario.editar(usuario);
                    grupo = new Grupo();
                    return "nuevoGrupo";
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            str = "failed";
        }
        return "";
    }

    public String edicion() {

        String str = "success";
        try {
            if (usuario.getUserName().toLowerCase().trim().equals("") || usuario.getPassword().toLowerCase().trim().equals("")) {
                addErrorMessage("La operacion realizada no se puede completar, confirme o ingrese un nuevo Password");
            } else {
                if (usuario.getIdUsuario() == null) {
                    localusuario.registrar(usuario);
                    grupo = new Grupo();
                // return "nuevoGrupo";
                } else {
                    localusuario.editar(usuario);
                    grupo = new Grupo();
                // return "nuevoGrupo";
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            str = "failed";
        }
        return str;
    }

    public String edicionclave() {

        String str = "success";
        try {

            if (usuario.getPassword().toLowerCase().trim().equals("")) {
                addErrorMessage("Existe algun cuadro vacio.");
                return "";
            }

            boolean passwordExists = localusuario.passwordExists(getPassword());
            if (!passwordExists) {

                if (usuario.getPassword().equals(getNuevoPassword())) {
                    if (usuario.getIdUsuario() == null) {
                        localusuario.registrar(usuario);
                        grupo = new Grupo();
                    } else {
                        localusuario.editar(usuario);
                        grupo = new Grupo();
                        return str;
                    }
                } else {
                    addErrorMessage("Existe algun cuadro vacio o Verifique que coincidan tanto nuevo Password como Password de confirmacion.");
                    return "";
                }

            } else {
                addErrorMessage("Su password anterior no coincide con el ingresado.");
                str = "try_again";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            str = "failed";
        }
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
        String str = "usuario_deleted";
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestParameterMap = (Map) context.getExternalContext().getRequestParameterMap();

        try {
            Long idUsuario = Long.parseLong(requestParameterMap.get("idUsuario").toString());
            Usuario u = localusuario.buscarID(idUsuario);
            String userName = u.getUserName();
            localusuario.eliminar(u);
            addSuccessMessage("Usuario " + userName + " Eliminacion satisfactoria.");
            return str;
        } catch (NumberFormatException ne) {
            //addErrorMessage(ne.getLocalizedMessage());
            addErrorMessage("La operacion realizada no se puede completar, existe una o muchas relaciones con este Usuario.");
            str = "failed";
        } catch (Exception e) {
            //addErrorMessage(e.getLocalizedMessage());
            addErrorMessage("La operacion realizada no se puede completar, existe una o muchas relaciones con este Usuario.");
            str = "failed";
        }
        return "";
    }

    public String editar() throws Exception {
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestParameterMap = (Map) context.getExternalContext().getRequestParameterMap();

        Long idUsuario = Long.parseLong(requestParameterMap.get("idUsuario").toString());
        this.usuario = localusuario.buscarID(idUsuario);
        return "editar_usuario";
    }

    public String editarcuenta() throws Exception {
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestParameterMap = (Map) context.getExternalContext().getRequestParameterMap();

        Long idUsuario = Long.parseLong(requestParameterMap.get("idUsuario").toString());
        this.usuario = localusuario.buscarID(idUsuario);
        return "editar_cuentausuario";
    }

    public String editarclave() throws Exception {
        FacesContext context = FacesContext.getCurrentInstance();
        Map requestParameterMap = (Map) context.getExternalContext().getRequestParameterMap();

        Long idUsuario = Long.parseLong(requestParameterMap.get("idUsuario").toString());
        this.usuario = localusuario.buscarID(idUsuario);
        this.passwordAnterior = this.usuario.getPassword();

        return "editar_claveusuario";
    }

    public DataModel getlistarUsuarios() throws Exception {
        model = new ListDataModel(localusuario.listar());
        return model;
    }

    public Usuario buscarID(Long idUsuario) throws Exception {
        String str = "success";
        try {
            return localusuario.buscarID(idUsuario);
        } catch (Exception ex) {
            ex.printStackTrace();
            str = "failed";
        }
        return null;
    }

    public List<Usuario> listarPorNombre(String nombre) throws Exception {
        return localusuario.listarxUsername(nombre);
    }

    public List<Usuario> getlistarxNombre() throws Exception {
        return listarPorNombre(nombreUsuario);
    }

    public List<Persona> listarPorPersona(String apellidoPaterno) throws Exception {
        return localusuario.listarxPersona(apellidoPaterno);
    }

    public List<Persona> getlistarxPersona() throws Exception {
        return listarPorPersona(apellidoPaterno);
    }

    public boolean agregar(Grupo grupo) throws Exception {
        try {
            return localusuario.agregarGrupo(grupo);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public boolean quitar(Grupo grupo) throws Exception {
        try {
            return localusuario.quitarGrupo(grupo);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public String agregarGrupo() throws Exception {

        String str = "success";
        try {
            if (usuario.getIdUsuario() > 0) {
                setEntity(usuario);
                agregar(grupo);
                usuario = buscarID(getEntity().getIdUsuario());
            } else {
                usuario.getGrupoCollection().add(grupo);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            str = "failed";
        }
        return paginaRedireccion;
    }

    public String quitarGrupo() throws Exception {
        try {
            for (Grupo r : usuario.getGrupoCollection()) {
                if (r.getIdGrupo().equals(grupo.getIdGrupo())) {
                    setEntity(usuario);
                    quitar(r);
                    usuario = buscarID(getEntity().getIdUsuario());
                    return "";
                }
            }
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return "";
    }

    public boolean isGrupoEmpty() {
        try {
            return usuario.getGrupoCollection().isEmpty();
        } catch (Exception ex) {
            return true;
        }
    }
}
