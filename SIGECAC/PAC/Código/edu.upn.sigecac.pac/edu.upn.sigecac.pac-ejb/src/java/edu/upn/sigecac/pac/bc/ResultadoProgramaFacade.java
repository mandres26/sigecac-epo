/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.sigecac.pac.bc;

import edu.upn.sigecac.pac.be.ObjetivoEducacional;
import edu.upn.sigecac.pac.be.ResultadoPrograma;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ResultadoProgramaFacade implements ResultadoProgramaFacadeLocal {

    @PersistenceContext
    private EntityManager em;

    public void create(ResultadoPrograma resultadoPrograma) {
        em.persist(resultadoPrograma);
    }

    public void edit(ResultadoPrograma resultadoPrograma) {
        em.merge(resultadoPrograma);
    }

    public void remove(ResultadoPrograma resultadoPrograma) {
        em.remove(em.merge(resultadoPrograma));
    }

    public ResultadoPrograma find(Object id) {
        return em.find(ResultadoPrograma.class, id);
    }

    public List<ResultadoPrograma> findAll() {
        return em.createQuery("select object(o) from ResultadoPrograma as o").getResultList();
    }

    public List<ResultadoPrograma> listarxEstado(boolean var) {
        return em.createQuery("select object(o) from ResultadoPrograma as o where o.estado=?1").setParameter(1, var).getResultList();

    }

    @Override
    public List<ResultadoPrograma> listarxCarrera(Long idCarrera) {
        return em.createQuery("select object(o) from ResultadoPrograma as o where o.fid_Carrera=?1").setParameter(1, idCarrera).getResultList();
    }
}
