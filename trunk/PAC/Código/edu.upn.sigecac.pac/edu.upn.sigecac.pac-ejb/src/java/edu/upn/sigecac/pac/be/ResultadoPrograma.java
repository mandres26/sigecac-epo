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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PAC_RESULTADO_PROGRAMA")
@NamedQueries({@NamedQuery(name = "ResultadoPrograma.findAll", query = "SELECT r FROM ResultadoPrograma r"), @NamedQuery(name = "ResultadoPrograma.findByIdResultadoPrograma", query = "SELECT r FROM ResultadoPrograma r WHERE r.idResultadoPrograma = :idResultadoPrograma"), @NamedQuery(name = "ResultadoPrograma.findByNombre", query = "SELECT r FROM ResultadoPrograma r WHERE r.nombre = :nombre"), @NamedQuery(name = "ResultadoPrograma.findByDescripcion", query = "SELECT r FROM ResultadoPrograma r WHERE r.descripcion = :descripcion"), @NamedQuery(name = "ResultadoPrograma.findByEstado", query = "SELECT r FROM ResultadoPrograma r WHERE r.estado = :estado")})
public class ResultadoPrograma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_RESULTADO_PROGRAMA", nullable = false)
    private Long idResultadoPrograma = 0L;
    @Column(name = "NOMBRE", length = 100)
    private String nombre;
    @Column(name = "DESCRIPCION", length = 255)
    private String descripcion;
    @Column(name = "ESTADO")
    private Boolean estado;
    @OneToMany(mappedBy = "fidResultadoPrograma", fetch = FetchType.LAZY)
    private List<CapacidadMedible> capacidadMedibleCollection;
    @Column(name = "FID_CARRERA")
    private Long fid_Carrera;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fidResultadoPrograma", fetch = FetchType.LAZY)
    private List<DetalleMatrizAlineamientoObjetivosEducacionales> detalleMatrizAlineamientoObjetivosEducacionalesCollection;

    public ResultadoPrograma() {
    }

    public ResultadoPrograma(Long idResultadoPrograma) {
        this.idResultadoPrograma = idResultadoPrograma;
    }

    public Long getIdResultadoPrograma() {
        return idResultadoPrograma;
    }

    public void setIdResultadoPrograma(Long idResultadoPrograma) {
        this.idResultadoPrograma = idResultadoPrograma;
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

    public List<CapacidadMedible> getCapacidadMedibleCollection() {
        return capacidadMedibleCollection;
    }

    public void setCapacidadMedibleCollection(List<CapacidadMedible> capacidadMedibleCollection) {
        this.capacidadMedibleCollection = capacidadMedibleCollection;
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
        hash += (idResultadoPrograma != null ? idResultadoPrograma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResultadoPrograma)) {
            return false;
        }
        ResultadoPrograma other = (ResultadoPrograma) object;
        if ((this.idResultadoPrograma == null && other.idResultadoPrograma != null) || (this.idResultadoPrograma != null && !this.idResultadoPrograma.equals(other.idResultadoPrograma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idResultadoPrograma.toString();
    }

    public Long getFid_Carrera() {
        return fid_Carrera;
    }

    public void setFid_Carrera(Long fid_Carrera) {
        this.fid_Carrera = fid_Carrera;
    }
}
