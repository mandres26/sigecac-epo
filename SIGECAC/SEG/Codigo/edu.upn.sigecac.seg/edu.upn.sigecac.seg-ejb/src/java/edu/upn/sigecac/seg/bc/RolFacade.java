package edu.upn.sigecac.seg.bc;

import edu.upn.sigecac.seg.be.Rol;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class RolFacade implements RolFacadeLocal {

    @PersistenceContext(unitName = "edu.upn.sigecac.seg-ejbPU")
    private EntityManager em;

    public RolFacade() {
    }

    @Override
    public void registrar(Rol rol) throws Exception {
        try {
            em.persist(rol);
        } catch (Exception ex) {
            throw new Exception("Error: " + ex.getMessage());
        }
    }

    @Override
    public void editar(Rol rol) throws Exception {
        try {
            em.merge(rol);
        } catch (Exception ex) {
            throw new Exception("Error: " + ex.getMessage());
        }
    }

    @Override
    public void eliminar(Rol rol) throws Exception {
        try {
            em.remove(em.merge(rol));
        } catch (Exception ex) {
            throw new Exception("Error: " + ex.getMessage());
        }
    }

    @Override
    public Rol buscarID(Long idRol) throws Exception {
        try {
            return (Rol) em.createQuery("SELECT r FROM Rol r WHERE r.idRol = :idRol").setParameter("idRol", idRol).getSingleResult();
        } catch (Exception ex) {
            throw new Exception("Error: " + ex.getMessage());
        }
    }

    @Override
    public List<Rol> listar() throws Exception {
//        try {
//            return (List<Rol>) em.createNamedQuery("Rol.findAll").getResultList();
//        } catch (Exception ex) {
//            throw new Exception("Error: " + ex.getMessage());
//        }
        try {
            Query q = em.createNamedQuery("Rol.findAll");
            List<Rol> roles = q.getResultList();
            return roles;
        } catch (Exception ex) {
            throw new Exception("Error: " + ex.getMessage());
        }
    }

    @Override
    public List<Rol> listarxNombre(String nombre) throws Exception {
        if (nombre == null || nombre.toLowerCase().trim().equals("")) {
            return (List<Rol>) em.createNamedQuery("Rol.findAll").getResultList();
        } else {
            return (List<Rol>) em.createQuery("SELECT object(r) FROM Rol as r WHERE LOWER(r.nombre) LIKE ?1 ORDER BY r.nombre").setParameter(1, "%" + nombre + "%").getResultList();
        }
    }
}