/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.epo.be;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author texai
 */
@Entity
@Table(name = "EPO_PERIODO_ACADEMICO")
@NamedQueries({@NamedQuery(name = "PeriodoAcademico.findAll", query = "SELECT p FROM PeriodoAcademico p"), @NamedQuery(name = "PeriodoAcademico.findByIdPeriodoAcademico", query = "SELECT p FROM PeriodoAcademico p WHERE p.idPeriodoAcademico = :idPeriodoAcademico"), @NamedQuery(name = "PeriodoAcademico.findByNombre", query = "SELECT p FROM PeriodoAcademico p WHERE p.nombre = :nombre"), @NamedQuery(name = "PeriodoAcademico.findByInicio", query = "SELECT p FROM PeriodoAcademico p WHERE p.inicio = :inicio"), @NamedQuery(name = "PeriodoAcademico.findByFin", query = "SELECT p FROM PeriodoAcademico p WHERE p.fin = :fin")})
public class PeriodoAcademico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PERIODO_ACADEMICO", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPeriodoAcademico;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inicio;
    @Basic(optional = false)
    @Column(name = "FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fin;

    public PeriodoAcademico() {
    }

    public PeriodoAcademico(Long idPeriodoAcademico) {
        this.idPeriodoAcademico = idPeriodoAcademico;
    }

    public PeriodoAcademico(Long idPeriodoAcademico, String nombre, Date inicio, Date fin) {
        this.idPeriodoAcademico = idPeriodoAcademico;
        this.nombre = nombre;
        this.inicio = inicio;
        this.fin = fin;
    }

    public Long getIdPeriodoAcademico() {
        return idPeriodoAcademico;
    }

    public void setIdPeriodoAcademico(Long idPeriodoAcademico) {
        this.idPeriodoAcademico = idPeriodoAcademico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PeriodoAcademico other = (PeriodoAcademico) obj;
        if (this.idPeriodoAcademico != other.idPeriodoAcademico && (this.idPeriodoAcademico == null || !this.idPeriodoAcademico.equals(other.idPeriodoAcademico))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.idPeriodoAcademico != null ? this.idPeriodoAcademico.hashCode() : 0);
        return hash;
    }


    @Override
    public String toString() {
        return "edu.upn.sigecac.epo.be.PeriodoAcademico[idPeriodoAcademico=" + idPeriodoAcademico + "]";
    }

}
