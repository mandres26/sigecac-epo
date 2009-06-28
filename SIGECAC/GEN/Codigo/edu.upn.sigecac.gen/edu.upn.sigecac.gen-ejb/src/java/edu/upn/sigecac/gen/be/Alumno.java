/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.sigecac.gen.be;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "GEN_ALUMNO")
@NamedQueries({
    @NamedQuery(name = "Alumno.findAll", query = "SELECT a FROM Alumno a")
})
@PrimaryKeyJoinColumn(name = "ID_ALUMNO", referencedColumnName = "ID_PERSONA")
@DiscriminatorValue(value = "AL")
public class Alumno extends Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "PROM_PONDERADO", precision = 18, scale = 2)
    private BigDecimal promPonderado;
    @Column(name = "CICLO_VIDA", length = 50)
    private String cicloVida;
    @Column(name = "SEM_INGRESO", length = 50)
    private String semIngreso;
    @Column(name = "PERFIL", length = 50)
    private String perfil;
    @Column(name = "NRO_HIJOS", length = 50)
    private String nroHijos;
    @Column(name = "NOM_EMPRESA", length = 50)
    private String nomEmpresa;
    @Column(name = "DIR_TRABAJO", length = 70)
    private String dirTrabajo;
    @Column(name = "TEL_TRABAJO", length = 20)
    private String telTrabajo;
    @Column(name = "VIV_HABITADA", length = 50)
    private String vivHabitada;
    @Column(name = "NRO_PERSONAS_HABITAN")
    private Integer nroPersonasHabitan;
    @Column(name = "COL_PROCEDENCIA", length = 50)
    private String colProcedencia;
    @Column(name = "LUG_PROCEDENCIA", length = 50)
    private String lugProcedencia;
    @Column(name = "DES_ESCOLAR", length = 50)
    private String desEscolar;
    @Column(name = "PROM_SEM_ANTERIOR", precision = 18, scale = 2)
    private BigDecimal promSemAnterior;
    @Column(name = "DES_ACTUAL", length = 50)
    private String desActual;
    @Column(name = "AST_CLASE", length = 50)
    private String astClase;
    @Column(name = "PRO_FISICOS")
    private Boolean proFisicos;
    @Column(name = "DET_PRO_FISICOS", length = 50)
    private String detProFisicos;
    @Column(name = "DIF_CONDUCTA")
    private Boolean difConducta;
    @Column(name = "DET_CONDUCTA", length = 50)
    private String detConducta;
    @Column(name = "CICLO", length = 50)
    private String ciclo;

    public Alumno() {
    }

    public Alumno(Long idPersona) {
        super(idPersona);
    }

    public String getAstClase() {
        return astClase;
    }

    public void setAstClase(String astClase) {
        this.astClase = astClase;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getCicloVida() {
        return cicloVida;
    }

    public void setCicloVida(String cicloVida) {
        this.cicloVida = cicloVida;
    }

    public String getColProcedencia() {
        return colProcedencia;
    }

    public void setColProcedencia(String colProcedencia) {
        this.colProcedencia = colProcedencia;
    }

    public String getDesActual() {
        return desActual;
    }

    public void setDesActual(String desActual) {
        this.desActual = desActual;
    }

    public String getDesEscolar() {
        return desEscolar;
    }

    public void setDesEscolar(String desEscolar) {
        this.desEscolar = desEscolar;
    }

    public String getDetConducta() {
        return detConducta;
    }

    public void setDetConducta(String detConducta) {
        this.detConducta = detConducta;
    }

    public String getDetProFisicos() {
        return detProFisicos;
    }

    public void setDetProFisicos(String detProFisicos) {
        this.detProFisicos = detProFisicos;
    }

    public Boolean getDifConducta() {
        return difConducta;
    }

    public void setDifConducta(Boolean difConducta) {
        this.difConducta = difConducta;
    }

    public String getDirTrabajo() {
        return dirTrabajo;
    }

    public void setDirTrabajo(String dirTrabajo) {
        this.dirTrabajo = dirTrabajo;
    }

    public String getLugProcedencia() {
        return lugProcedencia;
    }

    public void setLugProcedencia(String lugProcedencia) {
        this.lugProcedencia = lugProcedencia;
    }

    public String getNomEmpresa() {
        return nomEmpresa;
    }

    public void setNomEmpresa(String nomEmpresa) {
        this.nomEmpresa = nomEmpresa;
    }

    public String getNroHijos() {
        return nroHijos;
    }

    public void setNroHijos(String nroHijos) {
        this.nroHijos = nroHijos;
    }

    public Integer getNroPersonasHabitan() {
        return nroPersonasHabitan;
    }

    public void setNroPersonasHabitan(Integer nroPersonasHabitan) {
        this.nroPersonasHabitan = nroPersonasHabitan;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public Boolean getProFisicos() {
        return proFisicos;
    }

    public void setProFisicos(Boolean proFisicos) {
        this.proFisicos = proFisicos;
    }

    public BigDecimal getPromPonderado() {
        return promPonderado;
    }

    public void setPromPonderado(BigDecimal promPonderado) {
        this.promPonderado = promPonderado;
    }

    public BigDecimal getPromSemAnterior() {
        return promSemAnterior;
    }

    public void setPromSemAnterior(BigDecimal promSemAnterior) {
        this.promSemAnterior = promSemAnterior;
    }

    public String getSemIngreso() {
        return semIngreso;
    }

    public void setSemIngreso(String semIngreso) {
        this.semIngreso = semIngreso;
    }

    public String getTelTrabajo() {
        return telTrabajo;
    }

    public void setTelTrabajo(String telTrabajo) {
        this.telTrabajo = telTrabajo;
    }

    public String getVivHabitada() {
        return vivHabitada;
    }

    public void setVivHabitada(String vivHabitada) {
        this.vivHabitada = vivHabitada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersona != null ? idPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.idPersona == null && other.idPersona != null) || (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idPersona.toString();
    }
}
