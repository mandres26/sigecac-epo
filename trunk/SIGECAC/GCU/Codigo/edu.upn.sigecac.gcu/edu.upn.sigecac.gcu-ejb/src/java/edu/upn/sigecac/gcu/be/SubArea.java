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
@Table(name = "GCU_SUB_AREA")
@NamedQueries({@NamedQuery(name = "SubArea.findAll", query = "SELECT s FROM SubArea s"), @NamedQuery(name = "SubArea.findByIdSubArea", query = "SELECT s FROM SubArea s WHERE s.idSubArea = :idSubArea"), @NamedQuery(name = "SubArea.findByNombre", query = "SELECT s FROM SubArea s WHERE s.nombre = :nombre")})
public class SubArea implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_SUB_AREA")
    private Integer idSubArea;
    @Column(name = "NOMBRE")
    private String nombre;
    @OneToMany(mappedBy = "fxSubarea", fetch = FetchType.LAZY)
    private Collection<Curso> cursoCollection;
    @JoinColumn(name = "FX_IDAREA", referencedColumnName = "ID_AREA")
    @ManyToOne(fetch = FetchType.LAZY)
    private Area fxIdarea;

    public SubArea() {
    }

    public SubArea(Integer idSubArea) {
        this.idSubArea = idSubArea;
    }

    public Integer getIdSubArea() {
        return idSubArea;
    }

    public void setIdSubArea(Integer idSubArea) {
        this.idSubArea = idSubArea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<Curso> getCursoCollection() {
        return cursoCollection;
    }

    public void setCursoCollection(Collection<Curso> cursoCollection) {
        this.cursoCollection = cursoCollection;
    }

    public Area getFxIdarea() {
        return fxIdarea;
    }

    public void setFxIdarea(Area fxIdarea) {
        this.fxIdarea = fxIdarea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSubArea != null ? idSubArea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubArea)) {
            return false;
        }
        SubArea other = (SubArea) object;
        if ((this.idSubArea == null && other.idSubArea != null) || (this.idSubArea != null && !this.idSubArea.equals(other.idSubArea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.upn.sigecac.gcu.be.SubArea[idSubArea=" + idSubArea + "]";
    }

}
