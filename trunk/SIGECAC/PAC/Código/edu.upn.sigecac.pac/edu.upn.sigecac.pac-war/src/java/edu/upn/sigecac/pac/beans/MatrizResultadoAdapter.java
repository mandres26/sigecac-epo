package edu.upn.sigecac.pac.beans;

import edu.upn.sigecac.gcu.be.Curso;
import edu.upn.sigecac.pac.be.Criterio;
import edu.upn.sigecac.pac.be.ObjetivoEducacional;

public class MatrizResultadoAdapter {

    Curso curso;
    Criterio criterio;
    ObjetivoEducacional objetivoEducacional;

    public Criterio getCriterio() {
        return criterio;
    }

    public void setCriterio(Criterio criterio) {
        this.criterio = criterio;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public ObjetivoEducacional getObjetivoEducacional() {
        return objetivoEducacional;
    }

    public void setObjetivoEducacional(ObjetivoEducacional objetivoEducacional) {
        this.objetivoEducacional = objetivoEducacional;
    }
}
