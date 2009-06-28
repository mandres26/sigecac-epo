
package edu.upn.sigecac.pac.bc;



import java.util.List;
import javax.ejb.Local;


@Local
public interface ObjetivoEducacionalFacadeLocal {

    public void create(edu.upn.sigecac.pac.be.ObjetivoEducacional objetivoEducacional);

    public void edit(edu.upn.sigecac.pac.be.ObjetivoEducacional objetivoEducacional);

public List<edu.upn.sigecac.pac.be.ObjetivoEducacional> listarxCarrera(Long idCarrera);

    public void remove(edu.upn.sigecac.pac.be.ObjetivoEducacional objetivoEducacional);

    public edu.upn.sigecac.pac.be.ObjetivoEducacional find(java.lang.Object id);

    public java.util.List<edu.upn.sigecac.pac.be.ObjetivoEducacional> findAll();

    public java.util.List<edu.upn.sigecac.pac.be.ObjetivoEducacional> listarxEstado(boolean var);
    
}
