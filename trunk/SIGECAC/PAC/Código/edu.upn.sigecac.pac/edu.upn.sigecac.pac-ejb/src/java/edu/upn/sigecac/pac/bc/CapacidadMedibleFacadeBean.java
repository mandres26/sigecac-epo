package edu.upn.sigecac.pac.bc;

import edu.upn.sigecac.pac.be.CapacidadMedible;
import edu.upn.sigecac.pac.be.ResultadoPrograma;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class CapacidadMedibleFacadeBean implements CapacidadMedibleFacadeLocal {

 @PersistenceContext(name="edu.upn.sigecac.pac-ejbPU")
    private EntityManager em;

    public CapacidadMedibleFacadeBean() {
    }

    @Override
    public void registrar(CapacidadMedible c) throws Exception {
        try {
            em.persist(c);
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public void actualizar(CapacidadMedible c) throws Exception {
        try {
            em.merge(c);
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(CapacidadMedible c) throws Exception {
        try {
            em.remove(em.merge(c));
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public CapacidadMedible buscarPorId(Long idCapacidadMedible) throws Exception {
        try {
            return (CapacidadMedible) em.createQuery("SELECT c FROM CapacidadMedible c WHERE c.idCapacidadMedible = :idCapacidadMedible").setParameter("idCapacidadMedible", idCapacidadMedible).getSingleResult();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public List<CapacidadMedible> listar() throws Exception {
        try {
            return (List<CapacidadMedible>) em.createQuery("SELECT c FROM CapacidadMedible c ").getResultList();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public List<CapacidadMedible> capacidadxResultado(ResultadoPrograma resultadoSeleccionado) {
        try {
            return (List<CapacidadMedible>) em.createQuery("SELECT c FROM CapacidadMedible c where c.fidResultadoPrograma=?1").setParameter(1, resultadoSeleccionado).getResultList();
        } catch (Exception e) {
            return new ArrayList<CapacidadMedible>();
        }
    }

    public List<CapacidadMedible> findAll() {
        return em.createQuery("select object(o) from CapacidadMedible as o").getResultList();
    }
//    @Override
//    public List<CapacidadMedible> buscarCapacidadPorResultadoPrograma(Long idResultadoPrograma) {
//            return em.createQuery("select object(o) from CapacidadMedible as o where o.fidResultadoPrograma.idResultadoPrograma=?1").setParameter(1, idResultadoPrograma).getResultList();
//
//    }
}
