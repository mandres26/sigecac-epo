/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.sigecac.gen.be;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "GEN_GRUPO_OBJETIVO")
@NamedQueries({
    @NamedQuery(name = "GrupoObjetivo.findAll", query = "SELECT g FROM GrupoObjetivo g")
})
public class GrupoObjetivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_GRUPO_OBJETIVO", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGrupoObjetivo;
    @Column(name = "NOMBRE", length = 50)
    private String nombre;
    @Column(name = "DESCRIPCION", length = 250)
    private String descripcion;

    public GrupoObjetivo() {
    }

    public GrupoObjetivo(Long idGrupoObjetivo) {
        this.idGrupoObjetivo = idGrupoObjetivo;
    }

    public Long getIdGrupoObjetivo() {
        return idGrupoObjetivo;
    }

    public void setIdGrupoObjetivo(Long idGrupoObjetivo) {
        this.idGrupoObjetivo = idGrupoObjetivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGrupoObjetivo != null ? idGrupoObjetivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoObjetivo)) {
            return false;
        }
        GrupoObjetivo other = (GrupoObjetivo) object;
        if ((this.idGrupoObjetivo == null && other.idGrupoObjetivo != null) || (this.idGrupoObjetivo != null && !this.idGrupoObjetivo.equals(other.idGrupoObjetivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.upn.sigecac.gen.be.GrupoObjetivo[idGrupoObjetivo=" + idGrupoObjetivo + "]";
    }
}
