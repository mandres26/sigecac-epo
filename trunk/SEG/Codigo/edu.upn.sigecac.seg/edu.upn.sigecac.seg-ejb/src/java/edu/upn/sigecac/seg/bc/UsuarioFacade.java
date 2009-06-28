/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.sigecac.seg.bc;

import edu.upn.sigecac.gen.be.Persona;
import edu.upn.sigecac.seg.be.Grupo;
import edu.upn.sigecac.seg.be.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class UsuarioFacade implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "edu.upn.sigecac.seg-ejbPU")
    private EntityManager em;
    private Usuario usuario;

    public UsuarioFacade() {
    }

    @Override
    public Usuario getUsuario() {
        return usuario;
    }

    @Override
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public void registrar(Usuario usuario) throws Exception {
        try {
            em.persist(usuario);
        } catch (Exception ex) {
            throw new Exception("Error: " + ex.getMessage());
        }
    }

    @Override
    public void editar(Usuario usuario) throws Exception {
        try {
            em.merge(usuario);
        } catch (Exception ex) {
            throw new Exception("Error: " + ex.getMessage());
        }
    }

    @Override
    public void eliminar(Usuario usuario) throws Exception {
        try {
            em.remove(em.merge(usuario));
        } catch (Exception ex) {
            throw new Exception("Error: " + ex.getMessage());
        }
    }

    @Override
    public Usuario buscarID(Long idUsuario) throws Exception {
        try {
            return (Usuario) em.createQuery("SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario").setParameter("idUsuario", idUsuario).getSingleResult();
        } catch (Exception ex) {
            throw new Exception("Error: " + ex.getMessage());
        }
    }

    @Override
    public List<Usuario> listar() throws Exception {
//        try {
//            return (List<Usuario>) em.createNamedQuery("Usuario.findAll").getResultList();
//        } catch (Exception ex) {
//            throw new Exception("Error: " + ex.getMessage());
//        }
        try {
            Query q = em.createNamedQuery("Usuario.findAll");
            List<Usuario> usuarios = q.getResultList();
            return usuarios;
        } catch (Exception ex) {
            throw new Exception("Error: " + ex.getMessage());
        }
    }

    @Override
    public List<Persona> listarxPersona(String apellidoPaterno) throws Exception {
        if (apellidoPaterno.isEmpty() || apellidoPaterno.trim().equals("")) {
            return (List<Persona>) em.createQuery("SELECT p FROM Persona p").getResultList();
        } else {
            return (List<Persona>) em.createQuery("SELECT p FROM Persona p WHERE LOWER(p.apellidoPaterno) LIKE ?1 ORDER BY p.apellidoPaterno").setParameter(1, "%" + apellidoPaterno + "%").getResultList();
        }
    }

    @Override
    public List<Usuario> listarxUsername(String userName) throws Exception {
        if (userName == null || userName.toLowerCase().trim().equals("")) {
            return (List<Usuario>) em.createNamedQuery("Usuario.findAll").getResultList();
        } else {
            return (List<Usuario>) em.createQuery("SELECT object(u) FROM Usuario as u WHERE LOWER(u.userName) LIKE ?1 ORDER BY u.userName").setParameter(1, "%" + userName + "%").getResultList();
        }
    }

    @Override
    public boolean agregarGrupo(Grupo grupo) throws Exception {
        try {
            boolean existe = usuario.getGrupoCollection().contains(grupo);
            if (!existe) {
                usuario = em.getReference(Usuario.class, usuario.getIdUsuario());
                grupo = em.getReference(Grupo.class, grupo.getIdGrupo());
                grupo.getUsuarioCollection().add(usuario);
                usuario.getGrupoCollection().add(grupo);

                em.merge(usuario);
                em.merge(grupo);
                return true;
            }
            return false;
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public boolean quitarGrupo(Grupo grupo) throws Exception {
        try {
            usuario = getUsuario();
            usuario = em.getReference(Usuario.class, usuario.getIdUsuario());
            grupo = em.getReference(Grupo.class, grupo.getIdGrupo());
            usuario.getGrupoCollection().remove(grupo);
            grupo.getUsuarioCollection().remove(usuario);
            em.merge(usuario);
            return true;
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
}