/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.sigecac.gen.bc;

import edu.upn.sigecac.gen.be.Clase;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Administrador
 */
@Stateless
public class ClaseFacadeBean implements ClaseFacadeLocal {

    @PersistenceContext(name = "edu.upn.sigecac.gen-ejbPU")
    private EntityManager em;

    public ClaseFacadeBean() {
    }

    @Override
    public Clase porId(String id) throws Exception {
        Clase x = null;
        try {
            if (id.trim().equals("")) {
                return null;
            } else {
                x = (Clase) em.createQuery("Select object(o) from Clase o Where o.idClase = ?1 ").setParameter(1, Long.parseLong(id)).getSingleResult();
            }
        } catch (Exception e) {
            throw e;
        }
        return x;
    }

    @Override
    public List<Clase> listar() throws Exception {
        try {
            return (List<Clase>) em.createQuery("SELECT a FROM Clase a ").getResultList();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public List<Clase> listarPorCurso(String idCurso) throws Exception {
        try {
            return (List<Clase>) em.createQuery("SELECT a FROM Clase a ").getResultList();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }
}
