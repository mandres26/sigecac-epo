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
@Table(name = "GCU_EDICION_CURSO")
@NamedQueries({@NamedQuery(name = "EdicionCurso.findAll", query = "SELECT e FROM EdicionCurso e"), @NamedQuery(name = "EdicionCurso.findByIdEdicionCurso", query = "SELECT e FROM EdicionCurso e WHERE e.idEdicionCurso = :idEdicionCurso"), @NamedQuery(name = "EdicionCurso.findByEdicion", query = "SELECT e FROM EdicionCurso e WHERE e.edicion = :edicion"), @NamedQuery(name = "EdicionCurso.findByDescripcion", query = "SELECT e FROM EdicionCurso e WHERE e.descripcion = :descripcion"), @NamedQuery(name = "EdicionCurso.findByAno", query = "SELECT e FROM EdicionCurso e WHERE e.ano = :ano"), @NamedQuery(name = "EdicionCurso.findBySemestre", query = "SELECT e FROM EdicionCurso e WHERE e.semestre = :semestre"), @NamedQuery(name = "EdicionCurso.findByCarerra", query = "SELECT e FROM EdicionCurso e WHERE e.carerra = :carerra")})
public class EdicionCurso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_EDICION_CURSO")
    private Long idEdicionCurso;
    @Column(name = "EDICION")
    private String edicion;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "ANO")
    private Integer ano;
    @Column(name = "SEMESTRE")
    private Integer semestre;
    @Column(name = "CARERRA")
    private Integer carerra;
    @OneToMany(mappedBy = "fxIdedicion", fetch = FetchType.LAZY)
    private Collection<ObjetivoCurso> objetivoCursoCollection;
    @JoinColumn(name = "FX_IDCURSO", referencedColumnName = "ID_CURSO")
    @ManyToOne(fetch = FetchType.LAZY)
    private Curso fxIdcurso;

    public EdicionCurso() {
    }

    public EdicionCurso(Long idEdicionCurso) {
        this.idEdicionCurso = idEdicionCurso;
    }

    public Long getIdEdicionCurso() {
        return idEdicionCurso;
    }

    public void setIdEdicionCurso(Long idEdicionCurso) {
        this.idEdicionCurso = idEdicionCurso;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public Integer getCarerra() {
        return carerra;
    }

    public void setCarerra(Integer carerra) {
        this.carerra = carerra;
    }

    public Collection<ObjetivoCurso> getObjetivoCursoCollection() {
        return objetivoCursoCollection;
    }

    public void setObjetivoCursoCollection(Collection<ObjetivoCurso> objetivoCursoCollection) {
        this.objetivoCursoCollection = objetivoCursoCollection;
    }

    public Curso getFxIdcurso() {
        return fxIdcurso;
    }

    public void setFxIdcurso(Curso fxIdcurso) {
        this.fxIdcurso = fxIdcurso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEdicionCurso != null ? idEdicionCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EdicionCurso)) {
            return false;
        }
        EdicionCurso other = (EdicionCurso) object;
        if ((this.idEdicionCurso == null && other.idEdicionCurso != null) || (this.idEdicionCurso != null && !this.idEdicionCurso.equals(other.idEdicionCurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.upn.sigecac.gcu.be.EdicionCurso[idEdicionCurso=" + idEdicionCurso + "]";
    }

}
