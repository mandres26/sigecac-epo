package edu.upn.sigecac.pac.bc;

import edu.upn.sigecac.pac.be.CapacidadMedible;
import edu.upn.sigecac.pac.be.Criterio;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CriterioFacadeBean implements CriterioFacadeLocal {

    @PersistenceContext(name = "edu.upn.sigecac.pac-ejbPU")
    private EntityManager em;

    public CriterioFacadeBean() {
    }

    @Override
    public void registrar(Criterio c) throws Exception {
        try {
            em.persist(c);
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public void actualizar(Criterio c) throws Exception {
        try {
            em.merge(c);
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(Criterio c) throws Exception {
        try {
            em.remove(em.merge(c));
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public Criterio buscarPorId(Long idCriterio) throws Exception {
        try {
            return (Criterio) em.createQuery("SELECT c FROM Criterio c WHERE c.idCriterio = :idCriterio").setParameter("idCriterio", idCriterio).getSingleResult();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public List<Criterio> listar() throws Exception {
        try {
            return (List<Criterio>) em.createQuery("SELECT c FROM Criterio c ").getResultList();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public List<Criterio> findAll() {
        return em.createQuery("select object(o) from Criterio as o").getResultList();
    }

    @Override
    public List<Criterio> criterioxCapacidad(CapacidadMedible capacidadSeleccionada) {
        try {
            return (List<Criterio>) em.createQuery("SELECT c FROM Criterio c where c.fidCapacidadMedible=?1").setParameter(1, capacidadSeleccionada).getResultList();
        } catch (Exception e) {
            return new ArrayList<Criterio>();
        }
    }
}
