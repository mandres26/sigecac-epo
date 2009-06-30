/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.epo.bc;

import edu.upn.sigecac.epo.be.Rubrica;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author texai
 */
@Stateless
public class RubricaBean implements RubricaLocal {

    @PersistenceContext(name = "edu.upn.sigecac.epo-ejbPU")
    private EntityManager em;

    public RubricaBean() {
    }

    @Override
    public void registrar(Rubrica x) throws Exception {
        try {
            em.persist(x);
        } catch (Exception e) {
            throw e;
        }
    }


    @Override
    public List<Rubrica> listar() throws Exception {
        List<Rubrica> lista = null;
        try {
            lista = (List<Rubrica>) em.createQuery("SELECT r FROM Rubrica r").getResultList();
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

    @Override
    public Rubrica porId(String id) throws Exception {
        Rubrica x = null;
        try {
            if (id.trim().equals("")) {
                return null;
            } else {
                x = (Rubrica) em.createQuery("Select object(o) from Rubrica o Where o.idRubrica = ?1 ").setParameter(1,  Long.parseLong(id) ).getSingleResult();
            }
        } catch (Exception e) {
            throw e;
        }
        return x;
    }


 
}
