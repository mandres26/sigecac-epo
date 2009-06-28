package edu.upn.sigecac.seg.bc;

import edu.upn.sigecac.seg.be.Usuario;
import javax.ejb.Local;


@Local
public interface UsuarioFacadeLocal {

    Usuario getUsuario();

    void setUsuario(Usuario usuario);

    public void registrar(edu.upn.sigecac.seg.be.Usuario usuario) throws java.lang.Exception;

    public void editar(edu.upn.sigecac.seg.be.Usuario usuario) throws java.lang.Exception;

    public void eliminar(edu.upn.sigecac.seg.be.Usuario usuario) throws java.lang.Exception;

    public edu.upn.sigecac.seg.be.Usuario buscarID(java.lang.Long idUsuario) throws java.lang.Exception;

    public java.util.List<edu.upn.sigecac.seg.be.Usuario> listar() throws java.lang.Exception;

    public java.util.List<edu.upn.sigecac.seg.be.Usuario> listarxUsername(java.lang.String userName) throws java.lang.Exception;

    public boolean agregarGrupo(edu.upn.sigecac.seg.be.Grupo grupo) throws java.lang.Exception;

    public boolean quitarGrupo(edu.upn.sigecac.seg.be.Grupo grupo) throws java.lang.Exception;

    public java.util.List<edu.upn.sigecac.gen.be.Persona> listarxPersona(java.lang.String apellidoPaterno) throws java.lang.Exception;

}
