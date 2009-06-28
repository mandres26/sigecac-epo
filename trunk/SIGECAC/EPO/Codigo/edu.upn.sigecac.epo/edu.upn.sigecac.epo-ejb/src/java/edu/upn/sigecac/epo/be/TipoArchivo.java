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
@Table(name = "EPO_TIPO_ARCHIVO")
@NamedQueries({@NamedQuery(name = "TipoArchivo.findAll", query = "SELECT t FROM TipoArchivo t"), @NamedQuery(name = "TipoArchivo.findByIdTipoArchivo", query = "SELECT t FROM TipoArchivo t WHERE t.idTipoArchivo = :idTipoArchivo"), @NamedQuery(name = "TipoArchivo.findByExtension", query = "SELECT t FROM TipoArchivo t WHERE t.extension = :extension"), @NamedQuery(name = "TipoArchivo.findByNombre", query = "SELECT t FROM TipoArchivo t WHERE t.nombre = :nombre"), @NamedQuery(name = "TipoArchivo.findByIcono", query = "SELECT t FROM TipoArchivo t WHERE t.icono = :icono")})
public class TipoArchivo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_TIPO_ARCHIVO")
    private Long idTipoArchivo;
    @Basic(optional = false)
    @Column(name = "EXTENSION")
    private String extension;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "ICONO")
    private String icono;
    @OneToMany(mappedBy = "fidTipoArchivo", fetch = FetchType.LAZY)
    private List<Peticion> peticionCollection;

    public TipoArchivo() {
    }

    public TipoArchivo(Long idTipoArchivo) {
        this.idTipoArchivo = idTipoArchivo;
    }

    public TipoArchivo(Long idTipoArchivo, String extension) {
        this.idTipoArchivo = idTipoArchivo;
        this.extension = extension;
    }

    public Long getIdTipoArchivo() {
        return idTipoArchivo;
    }

    public void setIdTipoArchivo(Long idTipoArchivo) {
        this.idTipoArchivo = idTipoArchivo;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
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
        final TipoArchivo other = (TipoArchivo) obj;
        if (this.idTipoArchivo != other.idTipoArchivo && (this.idTipoArchivo == null || !this.idTipoArchivo.equals(other.idTipoArchivo))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.idTipoArchivo != null ? this.idTipoArchivo.hashCode() : 0);
        return hash;
    }


    @Override
    public String toString() {
        return "edu.upn.sigecac.epo.be.TipoArchivo[idTipoArchivo=" + idTipoArchivo + "]";
    }

}
