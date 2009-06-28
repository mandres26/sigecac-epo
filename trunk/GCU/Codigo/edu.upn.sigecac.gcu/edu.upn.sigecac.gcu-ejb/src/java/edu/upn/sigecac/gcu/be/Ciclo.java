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
@Table(name = "GCU_CICLO")
@NamedQueries({@NamedQuery(name = "Ciclo.findAll", query = "SELECT c FROM Ciclo c"), @NamedQuery(name = "Ciclo.findByIdCiclo", query = "SELECT c FROM Ciclo c WHERE c.idCiclo = :idCiclo"), @NamedQuery(name = "Ciclo.findByCiclo", query = "SELECT c FROM Ciclo c WHERE c.ciclo = :ciclo")})
public class Ciclo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CICLO")
    private Long idCiclo;
    @Basic(optional = false)
    @Column(name = "CICLO")
    private String ciclo;
    @JoinColumn(name = "FK_CURSO", referencedColumnName = "ID_CURSO")
    @ManyToOne(fetch = FetchType.LAZY)
    private Curso fkCurso;
    @JoinColumn(name = "FK_MALLA_CURRICULAR", referencedColumnName = "ID_MALLACURRICULAR")
    @ManyToOne(fetch = FetchType.LAZY)
    private MallaCurricular fkMallaCurricular;

    public Ciclo() {
    }

    public Ciclo(Long idCiclo) {
        this.idCiclo = idCiclo;
    }

    public Ciclo(Long idCiclo, String ciclo) {
        this.idCiclo = idCiclo;
        this.ciclo = ciclo;
    }

    public Long getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(Long idCiclo) {
        this.idCiclo = idCiclo;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public Curso getFkCurso() {
        return fkCurso;
    }

    public void setFkCurso(Curso fkCurso) {
        this.fkCurso = fkCurso;
    }

    public MallaCurricular getFkMallaCurricular() {
        return fkMallaCurricular;
    }

    public void setFkMallaCurricular(MallaCurricular fkMallaCurricular) {
        this.fkMallaCurricular = fkMallaCurricular;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCiclo != null ? idCiclo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciclo)) {
            return false;
        }
        Ciclo other = (Ciclo) object;
        if ((this.idCiclo == null && other.idCiclo != null) || (this.idCiclo != null && !this.idCiclo.equals(other.idCiclo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.upn.sigecac.gcu.be.Ciclo[idCiclo=" + idCiclo + "]";
    }

}
