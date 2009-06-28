/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.gcu.bc;

import javax.ejb.Stateless;
import edu.upn.sigecac.gcu.be.Equivalencia;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 *
 * @author XTUDiO
 */
@Stateless
public class EquivalenciaFacadeBean implements EquivalenciaFacadeLocal {

    @PersistenceContext(name="edu.upn.sigecac.gcu-ejbPU")
    private EntityManager em;

    public EquivalenciaFacadeBean() {
    }


   @Override
    public void crear(Equivalencia objEquivalencia) throws Exception {
        try{
            em.persist(objEquivalencia);
        }catch(Exception e){
             throw e;
        }
    }

    @Override
    public List<Equivalencia> listar() throws Exception {
        List<Equivalencia> lista = null;
        try {lista = (List<Equivalencia>) em.createNamedQuery("Equivalencia.findAll").getResultList();}
        catch (Exception e) {throw e;}
        return lista;
    }

    @Override
    public Equivalencia buscar(long id) throws Exception {
       try{
            return em.find(Equivalencia.class, id);
         } catch (Exception e){throw e;}
    }

    @Override
    public void eliminar(Equivalencia objEquivalencia) throws Exception {
        try{
           em.remove(em.merge(objEquivalencia));
        }catch (Exception e){throw e;}
    }

    @Override
    public void actualizar(Equivalencia objEquivalencia) throws Exception {
         try{
           em.merge(objEquivalencia);
        } catch (Exception e){throw e;}
    }

    @Override
    public List<Equivalencia> EquivalenciaxCurso(long valor) throws Exception {
        List<Equivalencia> lista = null;
        try {
                lista = (List<Equivalencia>) em.createQuery("Select object(o) from Equivalencia o Where o.fxIdCurso.idCurso = ?1 ").setParameter(1, valor).getResultList();
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

}
