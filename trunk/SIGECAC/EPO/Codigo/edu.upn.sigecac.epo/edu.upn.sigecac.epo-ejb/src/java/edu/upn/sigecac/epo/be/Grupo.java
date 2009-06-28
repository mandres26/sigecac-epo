/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.epo.be;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author texai
 */
@Entity
@Table(name = "EPO_GRUPO")
@NamedQueries({@NamedQuery(name = "Grupo.findAll", query = "SELECT g FROM Grupo g"), @NamedQuery(name = "Grupo.findByIdGrupo", query = "SELECT g FROM Grupo g WHERE g.idGrupo = :idGrupo"), @NamedQuery(name = "Grupo.findByNombre", query = "SELECT g FROM Grupo g WHERE g.nombre = :nombre")})
public class Grupo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_GRUPO")
    private Long idGrupo;
    @Column(name = "NOMBRE")
    private String nombre;
    @JoinTable(name = "EPO_GRUPO_ALUMNO", joinColumns = {@JoinColumn(name = "FID_GRUPO", referencedColumnName = "ID_GRUPO")}, inverseJoinColumns = {@JoinColumn(name = "FID_ALUMNO", referencedColumnName = "ID_USUARIO")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Usuario> usuarioCollection;
    @JoinColumn(name = "FID_ESQUEMA_GRUPO", referencedColumnName = "ID_ESQUEMA_GRUPO")
    @ManyToOne(fetch = FetchType.LAZY)
    private EsquemaGrupo fidEsquemaGrupo;
    @OneToMany(mappedBy = "fidGrupo", fetch = FetchType.LAZY)
    private List<Publicacion> publicacionCollection;

    public Grupo() {
    }

    public Grupo(Long idGrupo) {
        this.idGrupo = idGrupo;
    }

    public Long getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Long idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(List<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    public EsquemaGrupo getFidEsquemaGrupo() {
        return fidEsquemaGrupo;
    }

    public void setFidEsquemaGrupo(EsquemaGrupo fidEsquemaGrupo) {
        this.fidEsquemaGrupo = fidEsquemaGrupo;
    }

    public List<Publicacion> getPublicacionCollection() {
        return publicacionCollection;
    }

    public void setPublicacionCollection(List<Publicacion> publicacionCollection) {
        this.publicacionCollection = publicacionCollection;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Grupo other = (Grupo) obj;
        if (this.idGrupo != other.idGrupo && (this.idGrupo == null || !this.idGrupo.equals(other.idGrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.idGrupo != null ? this.idGrupo.hashCode() : 0);
        return hash;
    }


    @Override
    public String toString() {
        return "edu.upn.sigecac.epo.be.Grupo[idGrupo=" + idGrupo + "]";
    }

}
