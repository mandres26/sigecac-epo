package edu.upn.sigecac.pac.be;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PAC_MATRIZ_ALINEAMIENTO_OBJETIVOS_EDUCACIONALES")
@NamedQueries({@NamedQuery(name = "MatrizAlineamientoObjetivosEducacionales.findAll", query = "SELECT m FROM MatrizAlineamientoObjetivosEducacionales m"), @NamedQuery(name = "MatrizAlineamientoObjetivosEducacionales.findByIdMatrizAlineamientoObjetivosEducacionales", query = "SELECT m FROM MatrizAlineamientoObjetivosEducacionales m WHERE m.idMatrizAlineamientoObjetivosEducacionales = :idMatrizAlineamientoObjetivosEducacionales"), @NamedQuery(name = "MatrizAlineamientoObjetivosEducacionales.findByNombre", query = "SELECT m FROM MatrizAlineamientoObjetivosEducacionales m WHERE m.nombre = :nombre"), @NamedQuery(name = "MatrizAlineamientoObjetivosEducacionales.findByDescripcion", query = "SELECT m FROM MatrizAlineamientoObjetivosEducacionales m WHERE m.descripcion = :descripcion"), @NamedQuery(name = "MatrizAlineamientoObjetivosEducacionales.findByFecha", query = "SELECT m FROM MatrizAlineamientoObjetivosEducacionales m WHERE m.fecha = :fecha")})
public class MatrizAlineamientoObjetivosEducacionales implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID_MATRIZ_ALINEAMIENTO_OBJETIVOS_EDUCACIONALES", nullable = false)
    private Long idMatrizAlineamientoObjetivosEducacionales;
    @Basic(optional = false)
    @Column(name = "NOMBRE", nullable = false, length = 100)
    private String nombre;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION", nullable = false, length = 255)
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "FECHA", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @OneToMany(mappedBy = "fidMatrizObjetivosEducacionales", fetch = FetchType.LAZY)
    private List<DetalleMatrizAlineamientoObjetivosEducacionales> detalleMatrizAlineamientoObjetivosEducacionalesCollection;

    public MatrizAlineamientoObjetivosEducacionales() {
    }

    public MatrizAlineamientoObjetivosEducacionales(Long idMatrizAlineamientoObjetivosEducacionales) {
        this.idMatrizAlineamientoObjetivosEducacionales = idMatrizAlineamientoObjetivosEducacionales;
    }

    public MatrizAlineamientoObjetivosEducacionales(Long idMatrizAlineamientoObjetivosEducacionales, String nombre, String descripcion, Date fecha) {
        this.idMatrizAlineamientoObjetivosEducacionales = idMatrizAlineamientoObjetivosEducacionales;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public Long getIdMatrizAlineamientoObjetivosEducacionales() {
        return idMatrizAlineamientoObjetivosEducacionales;
    }

    public void setIdMatrizAlineamientoObjetivosEducacionales(Long idMatrizAlineamientoObjetivosEducacionales) {
        this.idMatrizAlineamientoObjetivosEducacionales = idMatrizAlineamientoObjetivosEducacionales;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
        hash += (idMatrizAlineamientoObjetivosEducacionales != null ? idMatrizAlineamientoObjetivosEducacionales.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MatrizAlineamientoObjetivosEducacionales)) {
            return false;
        }
        MatrizAlineamientoObjetivosEducacionales other = (MatrizAlineamientoObjetivosEducacionales) object;
        if ((this.idMatrizAlineamientoObjetivosEducacionales == null && other.idMatrizAlineamientoObjetivosEducacionales != null) || (this.idMatrizAlineamientoObjetivosEducacionales != null && !this.idMatrizAlineamientoObjetivosEducacionales.equals(other.idMatrizAlineamientoObjetivosEducacionales))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.upn.sigecac.pac.be.MatrizAlineamientoObjetivosEducacionales[idMatrizAlineamientoObjetivosEducacionales=" + idMatrizAlineamientoObjetivosEducacionales + "]";
    }

}
