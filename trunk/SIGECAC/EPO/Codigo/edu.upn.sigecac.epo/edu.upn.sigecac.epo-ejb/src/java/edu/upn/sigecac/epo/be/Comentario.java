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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "EPO_COMENTARIO")
@NamedQueries({@NamedQuery(name = "Comentario.findAll", query = "SELECT c FROM Comentario c"), @NamedQuery(name = "Comentario.findByIdComentario", query = "SELECT c FROM Comentario c WHERE c.idComentario = :idComentario"), @NamedQuery(name = "Comentario.findByFecha", query = "SELECT c FROM Comentario c WHERE c.fecha = :fecha")})
public class Comentario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_COMENTARIO")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idComentario;
    @Basic(optional = false)
    @Lob
    @Column(name = "COMENTARIO")
    private String comentario;
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

    public Comentario() {
    }

    public Comentario(Long idComentario) {
        this.idComentario = idComentario;
    }

    public Comentario(Long idComentario, String comentario, Date fecha) {
        this.idComentario = idComentario;
        this.comentario = comentario;
        this.fecha = fecha;
    }

    public Long getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(Long idComentario) {
        this.idComentario = idComentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
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
        final Comentario other = (Comentario) obj;
        if (this.idComentario != other.idComentario && (this.idComentario == null || !this.idComentario.equals(other.idComentario))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.idComentario != null ? this.idComentario.hashCode() : 0);
        return hash;
    }



    @Override
    public String toString() {
        return "edu.upn.sigecac.epo.be.Comentario[idComentario=" + idComentario + "]";
    }

}
