package edu.upn.sigecac.pac.be;

import java.io.Serializable;
import java.util.List;
import javax.faces.model.SelectItem;
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

@Entity
@Table(name = "PAC_CRITERIO")
@NamedQueries({@NamedQuery(name = "Criterio.findAll", query = "SELECT c FROM Criterio c"), @NamedQuery(name = "Criterio.findByIdCriterio", query = "SELECT c FROM Criterio c WHERE c.idCriterio = :idCriterio"), @NamedQuery(name = "Criterio.findByNombre", query = "SELECT c FROM Criterio c WHERE c.nombre = :nombre"), @NamedQuery(name = "Criterio.findByDescripcion", query = "SELECT c FROM Criterio c WHERE c.descripcion = :descripcion")})
public class Criterio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CRITERIO", nullable = false)
    private Long idCriterio = 0L;
    @Column(name = "NOMBRE", length = 100)
    private String nombre;
    @Column(name = "DESCRIPCION", length = 255)
    private String descripcion;
    @JoinColumn(name = "FID_CAPACIDAD_MEDIBLE", referencedColumnName = "ID_CAPACIDAD_MEDIBLE")
    @ManyToOne(fetch = FetchType.LAZY)
    private CapacidadMedible fidCapacidadMedible;
    @OneToMany(mappedBy = "fidCriterio", fetch = FetchType.LAZY)
    private List<Nivel> nivelCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fidCriterio", fetch = FetchType.LAZY)
    private List<DetalleMatrizAlineamientoResultadosPrograma> detalleMatrizAlineamientoResultadosProgramaCollection;

    public Criterio() {
    }

    public Criterio(Long idCriterio) {
        this.idCriterio = idCriterio;
    }

    public Criterio(Long idCriterio, String nombre) {
        this.idCriterio = idCriterio;
        this.nombre = nombre;
    }

    public Long getIdCriterio() {
        return idCriterio;
    }

    public void setIdCriterio(Long idCriterio) {
        this.idCriterio = idCriterio;
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

    public CapacidadMedible getFidCapacidadMedible() {
        return fidCapacidadMedible;
    }

    public void setFidCapacidadMedible(CapacidadMedible fidCapacidadMedible) {
        this.fidCapacidadMedible = fidCapacidadMedible;
    }

    public List<Nivel> getNivelCollection() {
        return nivelCollection;
    }

    public void setNivelCollection(List<Nivel> nivelCollection) {
        this.nivelCollection = nivelCollection;
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
        hash += (idCriterio != null ? idCriterio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Criterio)) {
            return false;
        }
        Criterio other = (Criterio) object;
        if ((this.idCriterio == null && other.idCriterio != null) || (this.idCriterio != null && !this.idCriterio.equals(other.idCriterio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return idCriterio.toString();
        return "edu.upn.sigecac.pac.be.Criterio[idCriterio=" + idCriterio + "]";
    }

    public SelectItem[] getNivelCollectionAsItems() {
        List<Nivel> lista = getNivelCollection();
        SelectItem[] select = new SelectItem[lista.size()];
        int i = 0;
        for (Nivel x : lista) {
            select[i++] = new SelectItem(x, x.getNombre());
        }
        return select;
    }
}
