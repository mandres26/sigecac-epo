package edu.upn.sigecac.pac.be;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "PAC_CAPACIDAD_MEDIBLE")
@NamedQueries({@NamedQuery(name = "CapacidadMedible.findAll", query = "SELECT c FROM CapacidadMedible c"), @NamedQuery(name = "CapacidadMedible.findByIdCapacidadMedible", query = "SELECT c FROM CapacidadMedible c WHERE c.idCapacidadMedible = :idCapacidadMedible"), @NamedQuery(name = "CapacidadMedible.findByNombre", query = "SELECT c FROM CapacidadMedible c WHERE c.nombre = :nombre"), @NamedQuery(name = "CapacidadMedible.findByDescripcion", query = "SELECT c FROM CapacidadMedible c WHERE c.descripcion = :descripcion")})
public class CapacidadMedible implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CAPACIDAD_MEDIBLE", nullable = false)
    private Long idCapacidadMedible = 0L;
    @Basic(optional = false)
    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;
    @Column(name = "DESCRIPCION", length = 255)
    private String descripcion;
    @OneToMany(mappedBy = "fidCapacidadMedible", fetch = FetchType.LAZY)
    private List<Criterio> criterioCollection;
    @JoinColumn(name = "FID_RESULTADO_PROGRAMA", referencedColumnName = "ID_RESULTADO_PROGRAMA")
    @ManyToOne(fetch = FetchType.LAZY)
    private ResultadoPrograma fidResultadoPrograma;

    @PrePersist
    @PreUpdate
    private void validar() {
        if (nombre.trim().equals("")) {
            nombre = "SIRVASE INGRESAR ALGO";
        }
    }

    public CapacidadMedible() {
    }

    public CapacidadMedible(Long idCapacidadMedible) {
        this.idCapacidadMedible = idCapacidadMedible;
    }

    public CapacidadMedible(Long idCapacidadMedible, String nombre) {
        this.idCapacidadMedible = idCapacidadMedible;
        this.nombre = nombre;
    }

    public Long getIdCapacidadMedible() {
        return idCapacidadMedible;
    }

    public void setIdCapacidadMedible(Long idCapacidadMedible) {
        this.idCapacidadMedible = idCapacidadMedible;
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

    public List<Criterio> getCriterioCollection() {
        return criterioCollection;
    }

    public void setCriterioCollection(List<Criterio> criterioCollection) {
        this.criterioCollection = criterioCollection;
    }

    public ResultadoPrograma getFidResultadoPrograma() {
        return fidResultadoPrograma;
    }

    public void setFidResultadoPrograma(ResultadoPrograma fidResultadoPrograma) {
        this.fidResultadoPrograma = fidResultadoPrograma;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCapacidadMedible != null ? idCapacidadMedible.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CapacidadMedible)) {
            return false;
        }
        CapacidadMedible other = (CapacidadMedible) object;
        if ((this.idCapacidadMedible == null && other.idCapacidadMedible != null) || (this.idCapacidadMedible != null && !this.idCapacidadMedible.equals(other.idCapacidadMedible))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.upn.sigecac.pac.be.CapacidadMedible[idCapacidadMedible=" + idCapacidadMedible + "]";
    }
}
