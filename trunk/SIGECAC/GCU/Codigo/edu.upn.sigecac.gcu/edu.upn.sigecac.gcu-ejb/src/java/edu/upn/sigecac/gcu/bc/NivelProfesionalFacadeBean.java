/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.gcu.bc;

import javax.ejb.Stateless;
import edu.upn.sigecac.gcu.be.NivelProfesional;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
/**
 *
 * @author Programador
 */
@Stateless
public class NivelProfesionalFacadeBean implements NivelProfesionalFacadeLocal {

    @PersistenceContext(name="edu.upn.sigecac.gcu-ejbPU")
    private EntityManager em;
    public NivelProfesionalFacadeBean() {
    }

    @Override
    public void crear(NivelProfesional objNivelProfesional) throws Exception {
        try{
            em.persist(objNivelProfesional);
        }catch(Exception e){
             throw e;
        }
    }

    @Override
    public List<NivelProfesional> listar() throws Exception {
        List<NivelProfesional> lista = null;
        try {lista = (List<NivelProfesional>) em.createNamedQuery("NivelProfesional.findAll").getResultList();}
        catch (Exception e) {throw e;}
        return lista;
    }

    @Override
    public NivelProfesional buscar(long id) throws Exception {
       try{
            return em.find(NivelProfesional.class, id);
         } catch (Exception e){throw e;}
    }

    @Override
    public void eliminar(NivelProfesional objNivelProfesional) throws Exception {
        try{
           em.remove(em.merge(objNivelProfesional));
        }catch (Exception e){throw e;}
    }

    @Override
    public void actualizar(NivelProfesional objNivelProfesional) throws Exception {
         try{
           em.merge(objNivelProfesional);
        } catch (Exception e){throw e;}
    }

    @Override
    public List<NivelProfesional> filtrar(String criterio, String valor) throws Exception {
        List<NivelProfesional> lista = null;
        try {
            if (valor.trim().equals("")) {
                lista = listar();
            } else {
                lista = (List<NivelProfesional>) em.createQuery("Select object(o) from NivelProfesional o Where o.nombre LIKE ?1 ").setParameter(1, "%" + valor + "%").getResultList();
            }
        } catch (Exception e) {
            throw e;
        }
        return lista;
    } 
}
