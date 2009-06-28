package edu.upn.sigecac.pac.bc;

import edu.upn.sigecac.pac.be.DetalleMatrizAlineamientoObjetivosEducacionales;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DetalleMatrizAlineamientoObjetivosEducacionalesFacadeBean implements DetalleMatrizAlineamientoObjetivosEducacionalesFacadeLocal {
    @PersistenceContext(name="edu.upn.sigecac.pac-ejbPU")
    private EntityManager em;

    public DetalleMatrizAlineamientoObjetivosEducacionalesFacadeBean() {
    }

    @Override
    public void registrar(DetalleMatrizAlineamientoObjetivosEducacionales maoe) throws Exception {
        try {
            em.persist(maoe);
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public void actualizar(DetalleMatrizAlineamientoObjetivosEducacionales maoe) throws Exception {
        try {
            em.merge(maoe);
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(DetalleMatrizAlineamientoObjetivosEducacionales maoe) throws Exception {
        try {
            em.remove(em.merge(maoe));
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public DetalleMatrizAlineamientoObjetivosEducacionales buscarPorId(Long idDetalleMatrizAlineamientoObjetivosEducacionales) throws Exception {
        try {
            return (DetalleMatrizAlineamientoObjetivosEducacionales) em.createQuery("SELECT maoe FROM DetalleMatrizAlineamientoObjetivosEducacionales maoe WHERE maoe.idDetalleMatrizAlineamientoObjetivosEducacionales = :idDetalleMatrizAlineamientoObjetivosEducacionales").setParameter("idDetalleMatrizAlineamientoObjetivosEducacionales", idDetalleMatrizAlineamientoObjetivosEducacionales).getSingleResult();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public List<DetalleMatrizAlineamientoObjetivosEducacionales> listar() throws Exception {
        try {
            return (List<DetalleMatrizAlineamientoObjetivosEducacionales>) em.createQuery("SELECT maoe FROM DetalleMatrizAlineamientoObjetivosEducacionales maoe ").getResultList();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public DetalleMatrizAlineamientoObjetivosEducacionales find(Object id) {
        return em.find(DetalleMatrizAlineamientoObjetivosEducacionales.class, id);
    }

    @Override
    public List<DetalleMatrizAlineamientoObjetivosEducacionales> findAll() {
        return em.createQuery("select object(o) from DetalleMatrizAlineamientoObjetivosEducacionales as o").getResultList();
    }
}
