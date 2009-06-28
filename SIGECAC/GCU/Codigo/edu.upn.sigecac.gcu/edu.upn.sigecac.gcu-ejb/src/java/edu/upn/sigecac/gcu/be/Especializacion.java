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
@Table(name = "GCU_ESPECIALIZACION")
@NamedQueries({@NamedQuery(name = "Especializacion.findAll", query = "SELECT e FROM Especializacion e"), @NamedQuery(name = "Especializacion.findByIdEspecializacion", query = "SELECT e FROM Especializacion e WHERE e.idEspecializacion = :idEspecializacion"), @NamedQuery(name = "Especializacion.findByNombre", query = "SELECT e FROM Especializacion e WHERE e.nombre = :nombre"), @NamedQuery(name = "Especializacion.findByDescripcion", query = "SELECT e FROM Especializacion e WHERE e.descripcion = :descripcion"), @NamedQuery(name = "Especializacion.findByAbreviatura", query = "SELECT e FROM Especializacion e WHERE e.abreviatura = :abreviatura")})
public class Especializacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ESPECIALIZACION")
    private Long idEspecializacion;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "ABREVIATURA")
    private String abreviatura;
    @OneToMany(mappedBy = "idEspecializacion", fetch = FetchType.LAZY)
    private Collection<EspecializacionCurso> especializacionCursoCollection;

    public Especializacion() {
    }

    public Especializacion(Long idEspecializacion) {
        this.idEspecializacion = idEspecializacion;
    }

    public Long getIdEspecializacion() {
        return idEspecializacion;
    }

    public void setIdEspecializacion(Long idEspecializacion) {
        this.idEspecializacion = idEspecializacion;
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

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public Collection<EspecializacionCurso> getEspecializacionCursoCollection() {
        return especializacionCursoCollection;
    }

    public void setEspecializacionCursoCollection(Collection<EspecializacionCurso> especializacionCursoCollection) {
        this.especializacionCursoCollection = especializacionCursoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEspecializacion != null ? idEspecializacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Especializacion)) {
            return false;
        }
        Especializacion other = (Especializacion) object;
        if ((this.idEspecializacion == null && other.idEspecializacion != null) || (this.idEspecializacion != null && !this.idEspecializacion.equals(other.idEspecializacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.upn.sigecac.gcu.be.Especializacion[idEspecializacion=" + idEspecializacion + "]";
    }

}
