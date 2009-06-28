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
@Table(name = "GCU_OBJETIVO_CURSO")
@NamedQueries({@NamedQuery(name = "ObjetivoCurso.findAll", query = "SELECT o FROM ObjetivoCurso o"), @NamedQuery(name = "ObjetivoCurso.findByIdObjetivocurso", query = "SELECT o FROM ObjetivoCurso o WHERE o.idObjetivocurso = :idObjetivocurso"), @NamedQuery(name = "ObjetivoCurso.findByDescripcion", query = "SELECT o FROM ObjetivoCurso o WHERE o.descripcion = :descripcion")})
public class ObjetivoCurso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_OBJETIVOCURSO")
    private Long idObjetivocurso;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @JoinColumn(name = "FX_IDEDICION", referencedColumnName = "ID_EDICION_CURSO")
    @ManyToOne(fetch = FetchType.LAZY)
    private EdicionCurso fxIdedicion;

    public ObjetivoCurso() {
    }

    public ObjetivoCurso(Long idObjetivocurso) {
        this.idObjetivocurso = idObjetivocurso;
    }

    public ObjetivoCurso(Long idObjetivocurso, String descripcion) {
        this.idObjetivocurso = idObjetivocurso;
        this.descripcion = descripcion;
    }

    public Long getIdObjetivocurso() {
        return idObjetivocurso;
    }

    public void setIdObjetivocurso(Long idObjetivocurso) {
        this.idObjetivocurso = idObjetivocurso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EdicionCurso getFxIdedicion() {
        return fxIdedicion;
    }

    public void setFxIdedicion(EdicionCurso fxIdedicion) {
        this.fxIdedicion = fxIdedicion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idObjetivocurso != null ? idObjetivocurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ObjetivoCurso)) {
            return false;
        }
        ObjetivoCurso other = (ObjetivoCurso) object;
        if ((this.idObjetivocurso == null && other.idObjetivocurso != null) || (this.idObjetivocurso != null && !this.idObjetivocurso.equals(other.idObjetivocurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.upn.sigecac.gcu.be.ObjetivoCurso[idObjetivocurso=" + idObjetivocurso + "]";
    }

}
