/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.sigecac.gen.bc;

import edu.upn.sigecac.gen.be.Persona;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Administrador
 */
@Stateless
public class PersonaFacade implements PersonaFacadeLocal {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void create(Persona persona) {
        em.persist(persona);
    }

    @Override
    public void edit(Persona persona) {
        em.merge(persona);
    }

    @Override
    public void remove(Persona persona) {
        em.remove(em.merge(persona));
    }

    @Override
    public Persona find(Object id) {
        return em.find(Persona.class, id);
    }

    @Override
    public List<Persona> findAll() {
        return em.createQuery("select object(o) from Persona as o").getResultList();
    }

    @Override
    public List<Persona> buscarAlumnoLike(String buscar) {
        return em.createQuery("select object(o) from Persona as o where o.apellidoPaterno LIKE '%" + buscar + "%'").getResultList();
    }
}
