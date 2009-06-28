package edu.upn.sigecac.pac.bc;

import edu.upn.sigecac.pac.be.DetalleMatrizAlineamientoResultadosPrograma;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DetalleMatrizAlineamientoResultadosProgramaFacade implements DetalleMatrizAlineamientoResultadosProgramaFacadeLocal {
    @PersistenceContext
    private EntityManager em;

    public void create(DetalleMatrizAlineamientoResultadosPrograma detalleMatrizAlineamientoResultadosPrograma) {
        em.persist(detalleMatrizAlineamientoResultadosPrograma);
    }

    public void edit(DetalleMatrizAlineamientoResultadosPrograma detalleMatrizAlineamientoResultadosPrograma) {
        em.merge(detalleMatrizAlineamientoResultadosPrograma);
    }

    public void remove(DetalleMatrizAlineamientoResultadosPrograma detalleMatrizAlineamientoResultadosPrograma) {
        em.remove(em.merge(detalleMatrizAlineamientoResultadosPrograma));
    }

    public DetalleMatrizAlineamientoResultadosPrograma find(Object id) {
        return em.find(DetalleMatrizAlineamientoResultadosPrograma.class, id);
    }

    public List<DetalleMatrizAlineamientoResultadosPrograma> findAll() {
        return em.createQuery("select object(o) from DetalleMatrizAlineamientoResultadosPrograma as o").getResultList();
    }

}
