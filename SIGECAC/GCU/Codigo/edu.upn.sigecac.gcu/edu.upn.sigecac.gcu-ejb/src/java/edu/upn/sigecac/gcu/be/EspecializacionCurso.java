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
@Table(name = "GCU_ESPECIALIZACION_CURSO")
@NamedQueries({@NamedQuery(name = "EspecializacionCurso.findAll", query = "SELECT e FROM EspecializacionCurso e"), @NamedQuery(name = "EspecializacionCurso.findByIdEspecializacionCurso", query = "SELECT e FROM EspecializacionCurso e WHERE e.idEspecializacionCurso = :idEspecializacionCurso")})
public class EspecializacionCurso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ESPECIALIZACION_CURSO")
    private Long idEspecializacionCurso;
    @JoinColumn(name = "ID_CURSO", referencedColumnName = "ID_CURSO")
    @ManyToOne(fetch = FetchType.LAZY)
    private Curso idCurso;
    @JoinColumn(name = "ID_ESPECIALIZACION", referencedColumnName = "ID_ESPECIALIZACION")
    @ManyToOne(fetch = FetchType.LAZY)
    private Especializacion idEspecializacion;

    public EspecializacionCurso() {
    }

    public EspecializacionCurso(Long idEspecializacionCurso) {
        this.idEspecializacionCurso = idEspecializacionCurso;
    }

    public Long getIdEspecializacionCurso() {
        return idEspecializacionCurso;
    }

    public void setIdEspecializacionCurso(Long idEspecializacionCurso) {
        this.idEspecializacionCurso = idEspecializacionCurso;
    }

    public Curso getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Curso idCurso) {
        this.idCurso = idCurso;
    }

    public Especializacion getIdEspecializacion() {
        return idEspecializacion;
    }

    public void setIdEspecializacion(Especializacion idEspecializacion) {
        this.idEspecializacion = idEspecializacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEspecializacionCurso != null ? idEspecializacionCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EspecializacionCurso)) {
            return false;
        }
        EspecializacionCurso other = (EspecializacionCurso) object;
        if ((this.idEspecializacionCurso == null && other.idEspecializacionCurso != null) || (this.idEspecializacionCurso != null && !this.idEspecializacionCurso.equals(other.idEspecializacionCurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.upn.sigecac.gcu.be.EspecializacionCurso[idEspecializacionCurso=" + idEspecializacionCurso + "]";
    }

}
