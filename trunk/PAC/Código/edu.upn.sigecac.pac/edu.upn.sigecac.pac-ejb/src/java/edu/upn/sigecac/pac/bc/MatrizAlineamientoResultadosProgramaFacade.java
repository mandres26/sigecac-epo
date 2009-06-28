package edu.upn.sigecac.pac.bc;

import edu.upn.sigecac.pac.be.MatrizAlineamientoResultadosPrograma;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class MatrizAlineamientoResultadosProgramaFacade implements MatrizAlineamientoResultadosProgramaFacadeLocal {
    @PersistenceContext
    private EntityManager em;

    public void create(MatrizAlineamientoResultadosPrograma matrizAlineamientoResultadosPrograma) {
        em.persist(matrizAlineamientoResultadosPrograma);
    }

    public void edit(MatrizAlineamientoResultadosPrograma matrizAlineamientoResultadosPrograma) {
        em.merge(matrizAlineamientoResultadosPrograma);
    }

    public void remove(MatrizAlineamientoResultadosPrograma matrizAlineamientoResultadosPrograma) {
        em.remove(em.merge(matrizAlineamientoResultadosPrograma));
    }

    public MatrizAlineamientoResultadosPrograma find(Object id) {
        return em.find(MatrizAlineamientoResultadosPrograma.class, id);
    }

    public List<MatrizAlineamientoResultadosPrograma> findAll() {
        return em.createQuery("select object(o) from MatrizAlineamientoResultadosPrograma as o").getResultList();
    }

}
