/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
@Table(name = "PAC_MATRIZ_ALINEAMIENTO_RESULTADOS_PROGRAMA")
@NamedQueries({@NamedQuery(name = "MatrizAlineamientoResultadosPrograma.findAll", query = "SELECT m FROM MatrizAlineamientoResultadosPrograma m"), @NamedQuery(name = "MatrizAlineamientoResultadosPrograma.findByIdMatrizResultadosPrograma", query = "SELECT m FROM MatrizAlineamientoResultadosPrograma m WHERE m.idMatrizResultadosPrograma = :idMatrizResultadosPrograma"), @NamedQuery(name = "MatrizAlineamientoResultadosPrograma.findByNombre", query = "SELECT m FROM MatrizAlineamientoResultadosPrograma m WHERE m.nombre = :nombre"), @NamedQuery(name = "MatrizAlineamientoResultadosPrograma.findByDescripcion", query = "SELECT m FROM MatrizAlineamientoResultadosPrograma m WHERE m.descripcion = :descripcion"), @NamedQuery(name = "MatrizAlineamientoResultadosPrograma.findByFecha", query = "SELECT m FROM MatrizAlineamientoResultadosPrograma m WHERE m.fecha = :fecha")})
public class MatrizAlineamientoResultadosPrograma implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID_MATRIZ_RESULTADOS_PROGRAMA", nullable = false)
    private Long idMatrizResultadosPrograma;
    @Basic(optional = false)
    @Column(name = "NOMBRE", nullable = false, length = 50)
    private String nombre;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION", nullable = false, length = 255)
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "FECHA", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @OneToMany(mappedBy = "fidMatrizResultadosPrograma", fetch = FetchType.LAZY)
    private List<DetalleMatrizAlineamientoResultadosPrograma> detalleMatrizAlineamientoResultadosProgramaCollection;

    public MatrizAlineamientoResultadosPrograma() {
    }

    public MatrizAlineamientoResultadosPrograma(Long idMatrizResultadosPrograma) {
        this.idMatrizResultadosPrograma = idMatrizResultadosPrograma;
    }

    public MatrizAlineamientoResultadosPrograma(Long idMatrizResultadosPrograma, String nombre, String descripcion, Date fecha) {
        this.idMatrizResultadosPrograma = idMatrizResultadosPrograma;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public Long getIdMatrizResultadosPrograma() {
        return idMatrizResultadosPrograma;
    }

    public void setIdMatrizResultadosPrograma(Long idMatrizResultadosPrograma) {
        this.idMatrizResultadosPrograma = idMatrizResultadosPrograma;
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

    public List<DetalleMatrizAlineamientoResultadosPrograma> getDetalleMatrizAlineamientoResultadosProgramaCollection() {
        return detalleMatrizAlineamientoResultadosProgramaCollection;
    }

    public void setDetalleMatrizAlineamientoResultadosProgramaCollection(List<DetalleMatrizAlineamientoResultadosPrograma> detalleMatrizAlineamientoResultadosProgramaCollection) {
        this.detalleMatrizAlineamientoResultadosProgramaCollection = detalleMatrizAlineamientoResultadosProgramaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMatrizResultadosPrograma != null ? idMatrizResultadosPrograma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MatrizAlineamientoResultadosPrograma)) {
            return false;
        }
        MatrizAlineamientoResultadosPrograma other = (MatrizAlineamientoResultadosPrograma) object;
        if ((this.idMatrizResultadosPrograma == null && other.idMatrizResultadosPrograma != null) || (this.idMatrizResultadosPrograma != null && !this.idMatrizResultadosPrograma.equals(other.idMatrizResultadosPrograma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.upn.sigecac.pac.be.MatrizAlineamientoResultadosPrograma[idMatrizResultadosPrograma=" + idMatrizResultadosPrograma + "]";
    }

}
