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
@Table(name = "GCU_ESTANDARES_CUANTIFICADORES")
@NamedQueries({@NamedQuery(name = "EstandaresCuantificadores.findAll", query = "SELECT e FROM EstandaresCuantificadores e"), @NamedQuery(name = "EstandaresCuantificadores.findByIdEstandares", query = "SELECT e FROM EstandaresCuantificadores e WHERE e.idEstandares = :idEstandares"), @NamedQuery(name = "EstandaresCuantificadores.findByDescripcion", query = "SELECT e FROM EstandaresCuantificadores e WHERE e.descripcion = :descripcion"), @NamedQuery(name = "EstandaresCuantificadores.findByValoracion", query = "SELECT e FROM EstandaresCuantificadores e WHERE e.valoracion = :valoracion"), @NamedQuery(name = "EstandaresCuantificadores.findByTipoestandar", query = "SELECT e FROM EstandaresCuantificadores e WHERE e.tipoestandar = :tipoestandar")})
public class EstandaresCuantificadores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ESTANDARES")
    private Long idEstandares;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "VALORACION")
    private String valoracion;
    @Column(name = "TIPOESTANDAR")
    private String tipoestandar;
    @JoinColumn(name = "FX_MALLA_ESTANDARES", referencedColumnName = "ID_MALLA_ESTANDARES")
    @ManyToOne(fetch = FetchType.LAZY)
    private MallaEstandares fxMallaEstandares;

    public EstandaresCuantificadores() {
    }

    public EstandaresCuantificadores(Long idEstandares) {
        this.idEstandares = idEstandares;
    }

    public Long getIdEstandares() {
        return idEstandares;
    }

    public void setIdEstandares(Long idEstandares) {
        this.idEstandares = idEstandares;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getValoracion() {
        return valoracion;
    }

    public void setValoracion(String valoracion) {
        this.valoracion = valoracion;
    }

    public String getTipoestandar() {
        return tipoestandar;
    }

    public void setTipoestandar(String tipoestandar) {
        this.tipoestandar = tipoestandar;
    }

    public MallaEstandares getFxMallaEstandares() {
        return fxMallaEstandares;
    }

    public void setFxMallaEstandares(MallaEstandares fxMallaEstandares) {
        this.fxMallaEstandares = fxMallaEstandares;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstandares != null ? idEstandares.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstandaresCuantificadores)) {
            return false;
        }
        EstandaresCuantificadores other = (EstandaresCuantificadores) object;
        if ((this.idEstandares == null && other.idEstandares != null) || (this.idEstandares != null && !this.idEstandares.equals(other.idEstandares))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.upn.sigecac.gcu.be.EstandaresCuantificadores[idEstandares=" + idEstandares + "]";
    }

}
