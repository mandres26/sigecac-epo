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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author texai
 */
@Entity
@Table(name = "EPO_ESQUEMA_GRUPO")
@NamedQueries({@NamedQuery(name = "EsquemaGrupo.findAll", query = "SELECT e FROM EsquemaGrupo e"), @NamedQuery(name = "EsquemaGrupo.findByIdEsquemaGrupo", query = "SELECT e FROM EsquemaGrupo e WHERE e.idEsquemaGrupo = :idEsquemaGrupo"), @NamedQuery(name = "EsquemaGrupo.findByFidGenClase", query = "SELECT e FROM EsquemaGrupo e WHERE e.fidGenClase = :fidGenClase"), @NamedQuery(name = "EsquemaGrupo.findByNombre", query = "SELECT e FROM EsquemaGrupo e WHERE e.nombre = :nombre")})
public class EsquemaGrupo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_ESQUEMA_GRUPO")
    private Long idEsquemaGrupo;
    @Basic(optional = false)
    @Column(name = "FID_GEN_CLASE")
    private long fidGenClase;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @OneToMany(mappedBy = "fidEsquemaGrupo", fetch = FetchType.LAZY)
    private List<Grupo> grupoCollection;
    @OneToMany(mappedBy = "fidEsquemaGrupo", fetch = FetchType.LAZY)
    private List<Peticion> peticionCollection;

    public EsquemaGrupo() {
    }

    public EsquemaGrupo(Long idEsquemaGrupo) {
        this.idEsquemaGrupo = idEsquemaGrupo;
    }

    public EsquemaGrupo(Long idEsquemaGrupo, long fidGenClase, String nombre) {
        this.idEsquemaGrupo = idEsquemaGrupo;
        this.fidGenClase = fidGenClase;
        this.nombre = nombre;
    }

    public Long getIdEsquemaGrupo() {
        return idEsquemaGrupo;
    }

    public void setIdEsquemaGrupo(Long idEsquemaGrupo) {
        this.idEsquemaGrupo = idEsquemaGrupo;
    }

    public long getFidGenClase() {
        return fidGenClase;
    }

    public void setFidGenClase(long fidGenClase) {
        this.fidGenClase = fidGenClase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Grupo> getGrupoCollection() {
        return grupoCollection;
    }

    public void setGrupoCollection(List<Grupo> grupoCollection) {
        this.grupoCollection = grupoCollection;
    }

    public List<Peticion> getPeticionCollection() {
        return peticionCollection;
    }

    public void setPeticionCollection(List<Peticion> peticionCollection) {
        this.peticionCollection = peticionCollection;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EsquemaGrupo other = (EsquemaGrupo) obj;
        if (this.idEsquemaGrupo != other.idEsquemaGrupo && (this.idEsquemaGrupo == null || !this.idEsquemaGrupo.equals(other.idEsquemaGrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + (this.idEsquemaGrupo != null ? this.idEsquemaGrupo.hashCode() : 0);
        return hash;
    }



    @Override
    public String toString() {
        return "edu.upn.sigecac.epo.be.EsquemaGrupo[idEsquemaGrupo=" + idEsquemaGrupo + "]";
    }

}
