package edu.upn.sigecac.pac.beans;

import edu.upn.sigecac.pac.be.ObjetivoEducacional;
import edu.upn.sigecac.pac.be.ResultadoPrograma;

public class MatrizObjetivoAdapter {
    ResultadoPrograma resultadoPrograma;
    ObjetivoEducacional objetivoEducacional;

    public ObjetivoEducacional getObjetivoEducacional() {
        return objetivoEducacional;
    }

    public void setObjetivoEducacional(ObjetivoEducacional objetivoEducacional) {
        this.objetivoEducacional = objetivoEducacional;
    }

    public ResultadoPrograma getResultadoPrograma() {
        return resultadoPrograma;
    }

    public void setResultadoPrograma(ResultadoPrograma resultadoPrograma) {
        this.resultadoPrograma = resultadoPrograma;
    }
}
