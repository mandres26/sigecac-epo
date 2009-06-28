/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.gcu.bc;

import javax.ejb.Stateless;
import edu.upn.sigecac.gcu.be.SubArea;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 *
 * @author XTUDiO
 */
@Stateless
public class SubAreaFacadeBean implements SubAreaFacadeLocal {
  @PersistenceContext(name="edu.upn.sigecac.gcu-ejbPU")
    private EntityManager em;

    public SubAreaFacadeBean() {
    }



    @Override
    public void crear(SubArea objSubArea) throws Exception {
        try{
            em.persist(objSubArea);
        }catch(Exception e){
             throw e;
        }
    }

    @Override
    public List<SubArea> listar() throws Exception {
        List<SubArea> lista = null;
        try {lista = (List<SubArea>) em.createNamedQuery("SubArea.findAll").getResultList();}
        catch (Exception e) {throw e;}
        return lista;
    }

    @Override
    public SubArea buscar(long id) throws Exception {
       try{
            return em.find(SubArea.class, id);
         } catch (Exception e){throw e;}
    }

    @Override
    public void eliminar(SubArea objSubArea) throws Exception {
        try{
           em.remove(em.merge(objSubArea));
        }catch (Exception e){throw e;}
    }

    @Override
    public void actualizar(SubArea objSubArea) throws Exception {
         try{
           em.merge(objSubArea);
        } catch (Exception e){throw e;}
    }

    @Override
    public List<SubArea> filtrar(String criterio, String valor) throws Exception {
        List<SubArea> lista = null;
        try {
            if (valor.trim().equals("")) {
                lista = listar();
            } else {
                lista = (List<SubArea>) em.createQuery("Select object(o) from SubArea o Where o.nombre LIKE ?1 ").setParameter(1, "%" + valor + "%").getResultList();
            }
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

}
