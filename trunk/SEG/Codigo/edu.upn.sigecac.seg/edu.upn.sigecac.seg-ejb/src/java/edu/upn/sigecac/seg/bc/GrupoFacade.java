/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.sigecac.seg.bc;

import edu.upn.sigecac.seg.be.Grupo;
import edu.upn.sigecac.seg.be.Rol;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class GrupoFacade implements GrupoFacadeLocal {

    @PersistenceContext(unitName = "edu.upn.sigecac.seg-ejbPU")
    private EntityManager em;
    private Grupo grupo;

    public GrupoFacade() {
    }

    @Override
    public Grupo getGrupo() {
        return grupo;
    }

    @Override
    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    @Override
    public void registrar(Grupo grupo) throws Exception {
        try {
            em.persist(grupo);
        } catch (Exception ex) {
            throw new Exception("Error: " + ex.getMessage());
        }
    }

    @Override
    public void editar(Grupo grupo) throws Exception {
        try {
            em.merge(grupo);
        } catch (Exception ex) {
            throw new Exception("Error: " + ex.getMessage());
        }
    }

    @Override
    public void eliminar(Grupo grupo) throws Exception {
        try {
            em.remove(em.merge(grupo));
        } catch (Exception ex) {
            throw new Exception("Error: " + ex.getMessage());
        }
    }

    @Override
    public Grupo buscarID(Long idGrupo) throws Exception {
        try {
            return (Grupo) em.createQuery("SELECT g FROM Grupo g WHERE g.idGrupo = :idGrupo").setParameter("idGrupo", idGrupo).getSingleResult();
        } catch (Exception ex) {
            throw new Exception("Error: " + ex.getMessage());
        }
    }

    @Override
    public List<Grupo> listar() throws Exception {
//        try {
//            return (List<Grupo>) em.createQuery("SELECT g FROM Grupo g").getResultList();
//        } catch (Exception ex) {
//            throw new Exception("Error: " + ex.getMessage());
//        }
        try {
            Query q = em.createNamedQuery("Grupo.findAll");
            List<Grupo> grupos = q.getResultList();
            return grupos;
        } catch (Exception ex) {
            throw new Exception("Error: " + ex.getMessage());
        }
    }

    @Override
    public List<Grupo> listarxNombre(String nombre) throws Exception {
        if (nombre == null || nombre.toLowerCase().trim().equals("")) {
            return (List<Grupo>) em.createQuery("SELECT g FROM Grupo g").getResultList();
        } else {
            return (List<Grupo>) em.createQuery("SELECT object(g) FROM Grupo as g WHERE LOWER(g.nombre) LIKE ?1 ORDER BY g.nombre").setParameter(1, "%" + nombre + "%").getResultList();
        }
    }

    @Override
    public boolean agregarRol(Rol rol) throws Exception {
        try {
            boolean existe = grupo.getRolCollection().contains(rol);
            if (!existe) {
                grupo = em.getReference(Grupo.class, grupo.getIdGrupo());
                rol = em.getReference(Rol.class, rol.getIdRol());
                rol.getGrupoCollection().add(grupo);
                grupo.getRolCollection().add(rol);


                em.merge(grupo);
                em.merge(rol);
                return true;
            }
            return false;
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public boolean quitarRol(Rol rol) throws Exception {
        try {
            grupo = getGrupo();
            grupo = em.getReference(Grupo.class, grupo.getIdGrupo());
            rol = em.getReference(Rol.class, rol.getIdRol());
            grupo.getRolCollection().remove(rol);
            rol.getGrupoCollection().remove(grupo);
            em.merge(grupo);
            return true;
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
}