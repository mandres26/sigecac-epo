/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.sigecac.epo.bc;

import edu.upn.sigecac.epo.be.Peticion;
import edu.upn.sigecac.gen.be.Clase;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author texai
 */
@Stateless
public class PeticionBean implements PeticionLocal {

    @PersistenceContext(name = "edu.upn.sigecac.epo-ejbPU")
    private EntityManager em;

    public PeticionBean() {
    }

    @Override
    public void registrar(Peticion x) throws Exception {
        try {
            em.persist(x);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Peticion> listar() throws Exception {
        List<Peticion> lista = null;
        try {
            lista = (List<Peticion>) em.createNamedQuery("Peticion.findAll").getResultList();
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

    @Override
    // aun no usada
    public List<Clase> listarClasesPorCurso(String idCurso) throws Exception {
        List<Clase> lista = null;
        try {
            lista = (List<Clase>) em.createNativeQuery("Select c.claseId, c.claseNombnre from Clase as c where c.curso = ?1", Clase.class).setParameter(1, idCurso).getResultList();
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }


}