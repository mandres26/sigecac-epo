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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Programador
 */
@Entity
@Table(name = "GCU_NIVEL_PROFESIONAL")
@NamedQueries({@NamedQuery(name = "NivelProfesional.findAll", query = "SELECT n FROM NivelProfesional n"), @NamedQuery(name = "NivelProfesional.findByIdNivelProfesional", query = "SELECT n FROM NivelProfesional n WHERE n.idNivelProfesional = :idNivelProfesional"), @NamedQuery(name = "NivelProfesional.findByNivelProfesional", query = "SELECT n FROM NivelProfesional n WHERE n.nivelProfesional = :nivelProfesional"), @NamedQuery(name = "NivelProfesional.findByDescripcion", query = "SELECT n FROM NivelProfesional n WHERE n.descripcion = :descripcion")})
public class NivelProfesional implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_NIVEL_PROFESIONAL")
    private Long idNivelProfesional;
    @Column(name = "NIVEL_PROFESIONAL")
    private String nivelProfesional;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(mappedBy = "fxNivelProfesional", fetch = FetchType.LAZY)
    private Collection<Area> areaCollection;

    public NivelProfesional() {
    }

    public NivelProfesional(Long idNivelProfesional) {
        this.idNivelProfesional = idNivelProfesional;
    }

    public Long getIdNivelProfesional() {
        return idNivelProfesional;
    }

    public void setIdNivelProfesional(Long idNivelProfesional) {
        this.idNivelProfesional = idNivelProfesional;
    }

    public String getNivelProfesional() {
        return nivelProfesional;
    }

    public void setNivelProfesional(String nivelProfesional) {
        this.nivelProfesional = nivelProfesional;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Collection<Area> getAreaCollection() {
        return areaCollection;
    }

    public void setAreaCollection(Collection<Area> areaCollection) {
        this.areaCollection = areaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNivelProfesional != null ? idNivelProfesional.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NivelProfesional)) {
            return false;
        }
        NivelProfesional other = (NivelProfesional) object;
        if ((this.idNivelProfesional == null && other.idNivelProfesional != null) || (this.idNivelProfesional != null && !this.idNivelProfesional.equals(other.idNivelProfesional))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.upn.sigecac.gcu.be.NivelProfesional[idNivelProfesional=" + idNivelProfesional + "]";
    }

}
