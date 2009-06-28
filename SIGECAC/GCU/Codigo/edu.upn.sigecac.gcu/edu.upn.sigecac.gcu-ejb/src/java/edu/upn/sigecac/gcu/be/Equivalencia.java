/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.gcu.be;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Programador
 */
@Entity
@Table(name = "GCU_EQUIVALENCIA")
@NamedQueries({@NamedQuery(name = "Equivalencia.findAll", query = "SELECT e FROM Equivalencia e"), @NamedQuery(name = "Equivalencia.findByFxIdEquivalencia", query = "SELECT e FROM Equivalencia e WHERE e.fxIdEquivalencia = :fxIdEquivalencia"), @NamedQuery(name = "Equivalencia.findByAbreviatura", query = "SELECT e FROM Equivalencia e WHERE e.abreviatura = :abreviatura"), @NamedQuery(name = "Equivalencia.findByNombre", query = "SELECT e FROM Equivalencia e WHERE e.nombre = :nombre")})
public class Equivalencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FX_ID_EQUIVALENCIA")
    private Long fxIdEquivalencia;
    @Column(name = "ABREVIATURA")
    private String abreviatura;
    @Column(name = "NOMBRE")
    private String nombre;
    @JoinColumn(name = "FX_ID_CURSO", referencedColumnName = "ID_CURSO")
    @ManyToOne(fetch = FetchType.LAZY)
    private Curso fxIdCurso;

    public Equivalencia() {
    }

    public Equivalencia(Long fxIdEquivalencia) {
        this.fxIdEquivalencia = fxIdEquivalencia;
    }

    public Long getFxIdEquivalencia() {
        return fxIdEquivalencia;
    }

    public void setFxIdEquivalencia(Long fxIdEquivalencia) {
        this.fxIdEquivalencia = fxIdEquivalencia;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Curso getFxIdCurso() {
        return fxIdCurso;
    }

    public void setFxIdCurso(Curso fxIdCurso) {
        this.fxIdCurso = fxIdCurso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fxIdEquivalencia != null ? fxIdEquivalencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equivalencia)) {
            return false;
        }
        Equivalencia other = (Equivalencia) object;
        if ((this.fxIdEquivalencia == null && other.fxIdEquivalencia != null) || (this.fxIdEquivalencia != null && !this.fxIdEquivalencia.equals(other.fxIdEquivalencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.upn.sigecac.gcu.be.Equivalencia[fxIdEquivalencia=" + fxIdEquivalencia + "]";
    }

}
