/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.gcu.bc;

import javax.ejb.Stateless;
import edu.upn.sigecac.gcu.be.Area;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 *
 * @author XTUDiO
 */
@Stateless
public class AreaFacadeBean implements AreaFacadeLocal {

    @PersistenceContext(name="edu.upn.sigecac.gcu-ejbPU")
    private EntityManager em;

    public AreaFacadeBean() {
    }

    

    @Override
    public void crear(Area objArea) throws Exception {
        try{
            em.persist(objArea);
        }catch(Exception e){
             throw e;
        }
    }

    @Override
    public List<Area> listar() throws Exception {
        List<Area> lista = null;
        try {lista = (List<Area>) em.createNamedQuery("Area.findAll").getResultList();}
        catch (Exception e) {throw e;}
        return lista;
    }

    @Override
    public Area buscar(long id) throws Exception {
       try{
            return em.find(Area.class, id);
         } catch (Exception e){throw e;}
    }

    @Override
    public void eliminar(Area objArea) throws Exception {
        try{
           em.remove(em.merge(objArea));
        }catch (Exception e){throw e;}
    }

    @Override
    public void actualizar(Area objArea) throws Exception {
         try{
           em.merge(objArea);
        } catch (Exception e){throw e;}
    }

    @Override
    public List<Area> filtrar(String criterio, String valor) throws Exception {
        List<Area> lista = null;
        try {
            if (valor.trim().equals("")) {
                lista = listar();
            } else {
                lista = (List<Area>) em.createQuery("Select object(o) from Area o Where o.nombre LIKE ?1 ").setParameter(1, "%" + valor + "%").getResultList();
            }
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }
 
}
