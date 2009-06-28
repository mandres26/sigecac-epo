/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.gcu.be;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.Table;

/**
 *
 * @author Programador
 */
@Entity
@Table(name = "GCU_AREA")
@NamedQueries({@NamedQuery(name = "Area.findAll", query = "SELECT a FROM Area a"), @NamedQuery(name = "Area.findByIdArea", query = "SELECT a FROM Area a WHERE a.idArea = :idArea"), @NamedQuery(name = "Area.findByDescripcion", query = "SELECT a FROM Area a WHERE a.descripcion = :descripcion"), @NamedQuery(name = "Area.findByArea", query = "SELECT a FROM Area a WHERE a.area = :area")})
public class Area implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_AREA")
    private Long idArea;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "AREA")
    private String area;
    @OneToMany(mappedBy = "fxIdarea", fetch = FetchType.LAZY)
    private Collection<SubArea> subAreaCollection;
    @JoinColumn(name = "FX_NIVEL_PROFESIONAL", referencedColumnName = "ID_NIVEL_PROFESIONAL")
    @ManyToOne(fetch = FetchType.LAZY)
    private NivelProfesional fxNivelProfesional;

    public Area() {
    }

    public Area(Long idArea) {
        this.idArea = idArea;
    }

    public Long getIdArea() {
        return idArea;
    }

    public void setIdArea(Long idArea) {
        this.idArea = idArea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Collection<SubArea> getSubAreaCollection() {
        return subAreaCollection;
    }

    public void setSubAreaCollection(Collection<SubArea> subAreaCollection) {
        this.subAreaCollection = subAreaCollection;
    }

    public NivelProfesional getFxNivelProfesional() {
        return fxNivelProfesional;
    }

    public void setFxNivelProfesional(NivelProfesional fxNivelProfesional) {
        this.fxNivelProfesional = fxNivelProfesional;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArea != null ? idArea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Area)) {
            return false;
        }
        Area other = (Area) object;
        if ((this.idArea == null && other.idArea != null) || (this.idArea != null && !this.idArea.equals(other.idArea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.upn.sigecac.gcu.be.Area[idArea=" + idArea + "]";
    }

}
