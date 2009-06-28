/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.gcu.bc;

import edu.upn.sigecac.gcu.be.EstandaresCuantificadores;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author XTUDiO
 */
@Stateless
public class EstandaresCuantificadoresFacadeBean implements EstandaresCuantificadoresFacadeLocal {
    
    @PersistenceContext(name="edu.upn.sigecac.gcu-ejbPU")
    private EntityManager em;

    public EstandaresCuantificadoresFacadeBean() {
    }

    @Override
    public void crear(EstandaresCuantificadores objEstandaresCuantificadores) throws Exception {
        try{
            em.persist(objEstandaresCuantificadores);
        }catch(Exception e){
             throw e;
        }
    }

    @Override
    public List<EstandaresCuantificadores> listar() throws Exception {
        List<EstandaresCuantificadores> lista = null;
        try {lista = (List<EstandaresCuantificadores>) em.createNamedQuery("EstandaresCuantificadores.findAll").getResultList();}
        catch (Exception e) {throw e;}
        return lista;
    }

    @Override
    public EstandaresCuantificadores buscar(long id) throws Exception {
       try{
            return em.find(EstandaresCuantificadores.class, id);
         } catch (Exception e){throw e;}
    }

    @Override
    public void eliminar(EstandaresCuantificadores objEstandaresCuantificadores) throws Exception {
        try{
           em.remove(em.merge(objEstandaresCuantificadores));
        }catch (Exception e){throw e;}
    }

    @Override
    public void actualizar(EstandaresCuantificadores objEstandaresCuantificadores) throws Exception {
         try{
           em.merge(objEstandaresCuantificadores);
        } catch (Exception e){throw e;}
    }

    @Override
    public List<EstandaresCuantificadores> filtrar(String criterio, String valor) throws Exception {
        List<EstandaresCuantificadores> lista = null;
        try {
            if (valor.trim().equals("")) {
                lista = listar();
            } else {
                lista = (List<EstandaresCuantificadores>) em.createQuery("Select object(o) from EstandaresCuantificadores o Where o.nombre LIKE ?1 ").setParameter(1, "%" + valor + "%").getResultList();
            }
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }
 
}
