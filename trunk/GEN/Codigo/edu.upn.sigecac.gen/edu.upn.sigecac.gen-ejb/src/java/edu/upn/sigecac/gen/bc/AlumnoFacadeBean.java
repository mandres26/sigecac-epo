/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.sigecac.gen.bc;

import edu.upn.sigecac.gen.be.Alumno;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Administrador
 */
@Stateless
public class AlumnoFacadeBean implements AlumnoFacadeLocal {

    @PersistenceContext(name = "edu.upn.sigecac.gen-ejbPU")
    private EntityManager em;

    public AlumnoFacadeBean() {
    }

    @Override
    public void registrar(Alumno a) throws Exception {
        try {
            em.persist(a);
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public void editar(Alumno a) throws Exception {
        try {
            em.merge(a);
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(Alumno a) throws Exception {
        try {
            em.remove(em.merge(a));
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public Alumno buscarPorId(Long idAlumno) throws Exception {
        try {
            return (Alumno) em.createQuery("SELECT a FROM Alumno a WHERE a.idPersona = :idPersona").setParameter("idPersona", idAlumno).getSingleResult();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public List<Alumno> listar() throws Exception {
        try {
            return (List<Alumno>) em.createQuery("SELECT a FROM Alumno a ").getResultList();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public List<Alumno> buscarXSegmento(String cicloVida, String perfil, int notaMin, int notaMax) throws Exception {
        try {
            return (List<Alumno>) em.createQuery("SELECT a FROM Alumno a where a.cicloVida=?1 and a.perfil=?2 and a.promPonderado>= ?3  and a.promPonderado<= ?4 ").setParameter(1, cicloVida).setParameter(2, perfil).setParameter(3, notaMin).setParameter(4, notaMax).getResultList();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public List<Alumno> buscarXPerfil(String perfilSeleccionado, int notaMin, int notaMax) throws Exception {
        try {
            return (List<Alumno>) em.createQuery("SELECT a FROM Alumno a where a.perfil=?1 and a.promPonderado>= ?3  and a.promPonderado<= ?4").setParameter(1, perfilSeleccionado).setParameter(3, notaMin).setParameter(4, notaMax).getResultList();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public List<Alumno> buscarXCicloVida(String cicloVidaSeleccionado, int notaMin, int notaMax) throws Exception {
        try {
            return (List<Alumno>) em.createQuery("SELECT a FROM Alumno a where a.cicloVida=?1 and a.promPonderado>= ?3  and a.promPonderado<= ?4").setParameter(1, cicloVidaSeleccionado).setParameter(3, notaMin).setParameter(4, notaMax).getResultList();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public List<Alumno> buscarXCiclo(String cicloSeleccionada, int notaMin, int notaMax) throws Exception {
        try {
            return (List<Alumno>) em.createQuery("SELECT a FROM Alumno a where a.ciclo=?1 and a.promPonderado>= ?3  and a.promPonderado<= ?4").setParameter(1, cicloSeleccionada).setParameter(3, notaMin).setParameter(4, notaMax).getResultList();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public List<Alumno> buscarXCicloPerfilNotas(String cicloSeleccionada, String perfilSeleccionado, int notaMin, int notaMax) throws Exception {
        try {
            return (List<Alumno>) em.createQuery("SELECT a FROM Alumno a where a.ciclo=?1 and a.perfil=?2 and a.promPonderado>= ?3  and a.promPonderado<= ?4 ").setParameter(1, cicloSeleccionada).setParameter(2, perfilSeleccionado).setParameter(3, notaMin).setParameter(4, notaMax).getResultList();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public List<Alumno> buscarCicloxCVida(String cicloSeleccionada, String carreraVidaSeleccionada, int notaMin, int notaMax) throws Exception {
        try {
            return (List<Alumno>) em.createQuery("SELECT a FROM Alumno a where a.ciclo=?1 and a.cicloVida=?2 and a.promPonderado>= ?3  and a.promPonderado<= ?4 ").setParameter(1, cicloSeleccionada).setParameter(2, carreraVidaSeleccionada).setParameter(3, notaMin).setParameter(4, notaMax).getResultList();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public List<Alumno> buscarCicloxCVidaxPerfil(String cicloSeleccionada, String carreraVidaSeleccionada, int notaMin, int notaMax, String perfilSeleccionado) throws Exception {
        try {
            return (List<Alumno>) em.createQuery("SELECT a FROM Alumno a where a.ciclo=?1 and a.cicloVida=?2 and a.promPonderado>= ?3  and a.promPonderado<= ?4 and a.perfil=?5 ").setParameter(1, cicloSeleccionada).setParameter(2, carreraVidaSeleccionada).setParameter(3, notaMin).setParameter(4, notaMax).setParameter(5, perfilSeleccionado).getResultList();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }

    @Override
    public List<Alumno> listarxNotas(int notaMin, int notaMax) throws Exception {
        try {
            return (List<Alumno>) em.createQuery("SELECT a FROM Alumno a where  a.promPonderado>= ?3  and a.promPonderado<= ?4").setParameter(3, notaMin).setParameter(4, notaMax).getResultList();
        } catch (Exception e) {
            throw new Exception("Error: " + e.getMessage());
        }
    }
}
