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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "EPO_VISITA")
@NamedQueries({@NamedQuery(name = "Visita.findAll", query = "SELECT v FROM Visita v"), @NamedQuery(name = "Visita.findByIdVisita", query = "SELECT v FROM Visita v WHERE v.idVisita = :idVisita"), @NamedQuery(name = "Visita.findByFecha", query = "SELECT v FROM Visita v WHERE v.fecha = :fecha")})
public class Visita implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_VISITA")
    private Long idVisita;
    @Basic(optional = false)
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "FID_PUBLICACION", referencedColumnName = "ID_PUBLICACION")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Publicacion fidPublicacion;
    @JoinColumn(name = "FID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario fidUsuario;

    public Visita() {
    }

    public Visita(Long idVisita) {
        this.idVisita = idVisita;
    }

    public Visita(Long idVisita, Date fecha) {
        this.idVisita = idVisita;
        this.fecha = fecha;
    }

    public Long getIdVisita() {
        return idVisita;
    }

    public void setIdVisita(Long idVisita) {
        this.idVisita = idVisita;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Publicacion getFidPublicacion() {
        return fidPublicacion;
    }

    public void setFidPublicacion(Publicacion fidPublicacion) {
        this.fidPublicacion = fidPublicacion;
    }

    public Usuario getFidUsuario() {
        return fidUsuario;
    }

    public void setFidUsuario(Usuario fidUsuario) {
        this.fidUsuario = fidUsuario;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Visita other = (Visita) obj;
        if (this.idVisita != other.idVisita && (this.idVisita == null || !this.idVisita.equals(other.idVisita))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (this.idVisita != null ? this.idVisita.hashCode() : 0);
        return hash;
    }


    @Override
    public String toString() {
        return "edu.upn.sigecac.epo.be.Visita[idVisita=" + idVisita + "]";
    }

}
