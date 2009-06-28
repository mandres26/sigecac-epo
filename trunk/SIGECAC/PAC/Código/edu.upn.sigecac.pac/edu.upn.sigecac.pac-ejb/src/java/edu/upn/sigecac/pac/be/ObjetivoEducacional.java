/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.pac.be;


import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "PAC_OBJETIVO_EDUCACIONAL")
@NamedQueries({@NamedQuery(name = "ObjetivoEducacional.findAll", query = "SELECT o FROM ObjetivoEducacional o"), @NamedQuery(name = "ObjetivoEducacional.findByIdObjetivoEducacional", query = "SELECT o FROM ObjetivoEducacional o WHERE o.idObjetivoEducacional = :idObjetivoEducacional"), @NamedQuery(name = "ObjetivoEducacional.findByNombre", query = "SELECT o FROM ObjetivoEducacional o WHERE o.nombre = :nombre"), @NamedQuery(name = "ObjetivoEducacional.findByDescripcion", query = "SELECT o FROM ObjetivoEducacional o WHERE o.descripcion = :descripcion"), @NamedQuery(name = "ObjetivoEducacional.findByEstado", query = "SELECT o FROM ObjetivoEducacional o WHERE o.estado = :estado")})
public class ObjetivoEducacional implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID_OBJETIVO_EDUCACIONAL", nullable = false)
    private Long idObjetivoEducacional;
    @Column(name = "NOMBRE", length = 100)
    private String nombre;
    @Column(name = "DESCRIPCION", length = 255)
    private String descripcion;
    @Column(name = "ESTADO")
    private Boolean estado;
    @Column(name = "FID_CARRERA")
    private Long fid_Carrera;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fidObjetivoEducacional", fetch = FetchType.LAZY)
    private List<DetalleMatrizAlineamientoObjetivosEducacionales> detalleMatrizAlineamientoObjetivosEducacionalesCollection;

    public ObjetivoEducacional() {
    }

    public ObjetivoEducacional(Long idObjetivoEducacional) {
        this.idObjetivoEducacional = idObjetivoEducacional;
    }

    public Long getIdObjetivoEducacional() {
        return idObjetivoEducacional;
    }

    public void setIdObjetivoEducacional(Long idObjetivoEducacional) {
        this.idObjetivoEducacional = idObjetivoEducacional;
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

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Long getFid_Carrera() {
        return fid_Carrera;
    }

    public void setFid_Carrera(Long fid_Carrera) {
        this.fid_Carrera = fid_Carrera;
    }

  

    public List<DetalleMatrizAlineamientoObjetivosEducacionales> getDetalleMatrizAlineamientoObjetivosEducacionalesCollection() {
        return detalleMatrizAlineamientoObjetivosEducacionalesCollection;
    }

    public void setDetalleMatrizAlineamientoObjetivosEducacionalesCollection(List<DetalleMatrizAlineamientoObjetivosEducacionales> detalleMatrizAlineamientoObjetivosEducacionalesCollection) {
        this.detalleMatrizAlineamientoObjetivosEducacionalesCollection = detalleMatrizAlineamientoObjetivosEducacionalesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idObjetivoEducacional != null ? idObjetivoEducacional.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ObjetivoEducacional)) {
            return false;
        }
        ObjetivoEducacional other = (ObjetivoEducacional) object;
        if ((this.idObjetivoEducacional == null && other.idObjetivoEducacional != null) || (this.idObjetivoEducacional != null && !this.idObjetivoEducacional.equals(other.idObjetivoEducacional))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.upn.sigecac.pac.be.ObjetivoEducacional[idObjetivoEducacional=" + idObjetivoEducacional + "]";
    }

}
