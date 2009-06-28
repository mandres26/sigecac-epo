package edu.upn.sigecac.pac.bc;

import edu.upn.sigecac.pac.be.MatrizAlineamientoObjetivosEducacionales;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class MatrizAlineamientoObjetivosEducacionalesFacadeBean implements MatrizAlineamientoObjetivosEducacionalesFacadeLocal {

 @PersistenceContext(name="edu.upn.sigecac.pac-ejbPU")

    private EntityManager em;

    public MatrizAlineamientoObjetivosEducacionalesFacadeBean() {
    }

    @Override
    public void registrar(MatrizAlineamientoObjetivosEducacionales maoe) throws Exception {
        try {
            em.persist(maoe);
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public void actualizar(MatrizAlineamientoObjetivosEducacionales maoe) throws Exception {
        try {
            em.merge(maoe);
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(MatrizAlineamientoObjetivosEducacionales maoe) throws Exception {
        try {
            em.remove(em.merge(maoe));
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public MatrizAlineamientoObjetivosEducacionales buscarPorId(Long idMatrizAlineamientoObjetivosEducacionales) throws Exception {
        try {
            return (MatrizAlineamientoObjetivosEducacionales) em.createQuery("SELECT maoe FROM MatrizAlineamientoObjetivosEducacionales maoe WHERE maoe.idMatrizAlineamientoObjetivosEducacionales = :idMatrizAlineamientoObjetivosEducacionales").setParameter("idMatrizAlineamientoObjetivosEducacionales", idMatrizAlineamientoObjetivosEducacionales).getSingleResult();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public List<MatrizAlineamientoObjetivosEducacionales> listar() throws Exception {
        try {
            return (List<MatrizAlineamientoObjetivosEducacionales>) em.createQuery("SELECT maoe FROM MatrizAlineamientoObjetivosEducacionales maoe ").getResultList();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public List<MatrizAlineamientoObjetivosEducacionales> buscarCapacidadPorResultadoPrograma(Long idResultadoPrograma) {
        return em.createQuery("select object(o) from MatrizAlineamientoObjetivosEducacionales as o where o.fidResultadoPrograma.idResultadoPrograma=?1").setParameter(1, idResultadoPrograma).getResultList();
    }

    @Override
    public MatrizAlineamientoObjetivosEducacionales find(Object id) {
        return em.find(MatrizAlineamientoObjetivosEducacionales.class, id);
    }

    @Override
    public List<MatrizAlineamientoObjetivosEducacionales> findAll() {
        return em.createQuery("select object(o) from MatrizAlineamientoObjetivosEducacionales as o").getResultList();
    }
}
