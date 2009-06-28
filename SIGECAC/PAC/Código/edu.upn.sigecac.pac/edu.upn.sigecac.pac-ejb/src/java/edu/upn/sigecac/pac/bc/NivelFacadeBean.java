package edu.upn.sigecac.pac.bc;

import edu.upn.sigecac.pac.be.Criterio;
import edu.upn.sigecac.pac.be.Nivel;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class NivelFacadeBean implements NivelFacadeLocal {

    @PersistenceContext(name="edu.upn.sigecac.pac-ejbPU")

    private EntityManager em;

    public NivelFacadeBean() {
    }

    @Override
    public void registrar(Nivel n) throws Exception {
        try {
            em.persist(n);
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public void actualizar(Nivel n) throws Exception {
        try {
            em.merge(n);
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(Nivel n) throws Exception {
        try {
            em.remove(em.merge(n));
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public Nivel buscarPorId(Long idNivel) throws Exception {
        try {
            return (Nivel) em.createQuery("SELECT n FROM Nivel n WHERE n.idNivel = :idNivel").setParameter("idNivel", idNivel).getSingleResult();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public List<Nivel> listar() throws Exception {
        try {
            return (List<Nivel>) em.createQuery("SELECT n FROM Nivel n ").getResultList();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public List<Nivel> nivelxCriterio(Criterio criterioSeleccionado) {
        try {
            return (List<Nivel>) em.createQuery("SELECT n FROM Nivel n where n.fidCriterio=?1").setParameter(1, criterioSeleccionado).getResultList();
        } catch (Exception e) {
            return new ArrayList<Nivel>();
        }
    }

    @Override
    public List<Nivel> findAll() {
        return em.createQuery("select object(o) from Nivel as o").getResultList();
    }
    //     @Override
//    public List<Nivel> buscarNivelPorCriterio(Long idCriterio) {
//        return em.createQuery("select object(o) from Nivel as o where o.fidCriterio.idCriterio=?1").setParameter(1, idCriterio).getResultList();
//    }
}
