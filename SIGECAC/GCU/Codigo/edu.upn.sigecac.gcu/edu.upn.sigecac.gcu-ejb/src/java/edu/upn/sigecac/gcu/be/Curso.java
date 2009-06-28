/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.gcu.be;

import java.io.Serializable;
import java.util.Collection;
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

/**
 *
 * @author Programador
 */
@Entity
@Table(name = "GCU_CURSO")
@NamedQueries({@NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c"), @NamedQuery(name = "Curso.findByIdCurso", query = "SELECT c FROM Curso c WHERE c.idCurso = :idCurso"), @NamedQuery(name = "Curso.findByCodigo", query = "SELECT c FROM Curso c WHERE c.codigo = :codigo"), @NamedQuery(name = "Curso.findByNombre", query = "SELECT c FROM Curso c WHERE c.nombre = :nombre"), @NamedQuery(name = "Curso.findByAbreviatura", query = "SELECT c FROM Curso c WHERE c.abreviatura = :abreviatura"), @NamedQuery(name = "Curso.findByDescripcion", query = "SELECT c FROM Curso c WHERE c.descripcion = :descripcion"), @NamedQuery(name = "Curso.findByNrocreditos", query = "SELECT c FROM Curso c WHERE c.nrocreditos = :nrocreditos"), @NamedQuery(name = "Curso.findByHorastecnicas", query = "SELECT c FROM Curso c WHERE c.horastecnicas = :horastecnicas"), @NamedQuery(name = "Curso.findByHoraspracticas", query = "SELECT c FROM Curso c WHERE c.horaspracticas = :horaspracticas"), @NamedQuery(name = "Curso.findByHoraslaboratorio", query = "SELECT c FROM Curso c WHERE c.horaslaboratorio = :horaslaboratorio")})
public class Curso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CURSO")
    private Long idCurso;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "ABREVIATURA")
    private String abreviatura;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "NROCREDITOS")
    private int nrocreditos;
    @Column(name = "HORASTECNICAS")
    private Integer horastecnicas;
    @Basic(optional = false)
    @Column(name = "HORASPRACTICAS")
    private int horaspracticas;
    @Basic(optional = false)
    @Column(name = "HORASLABORATORIO")
    private int horaslaboratorio;
    @OneToMany(mappedBy = "fkCurso", fetch = FetchType.LAZY)
    private Collection<Ciclo> cicloCollection;
    @OneToMany(mappedBy = "idCurso", fetch = FetchType.LAZY)
    private Collection<EspecializacionCurso> especializacionCursoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fxIdcurso", fetch = FetchType.LAZY)
    private Collection<Prerequisito> prerequisitoCollection;
    @JoinColumn(name = "FX_SUBAREA", referencedColumnName = "ID_SUB_AREA")
    @ManyToOne(fetch = FetchType.LAZY)
    private SubArea fxSubarea;
    @OneToMany(mappedBy = "fxIdCurso", fetch = FetchType.LAZY)
    private Collection<Equivalencia> equivalenciaCollection;
    @OneToMany(mappedBy = "fxIdcurso", fetch = FetchType.LAZY)
    private Collection<EdicionCurso> edicionCursoCollection;

    public Curso() {
    }

    public Curso(Long idCurso) {
        this.idCurso = idCurso;
    }

    public Curso(Long idCurso, String codigo, String nombre, String abreviatura, int nrocreditos, int horaspracticas, int horaslaboratorio) {
        this.idCurso = idCurso;
        this.codigo = codigo;
        this.nombre = nombre;
        this.abreviatura = abreviatura;
        this.nrocreditos = nrocreditos;
        this.horaspracticas = horaspracticas;
        this.horaslaboratorio = horaslaboratorio;
    }

    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNrocreditos() {
        return nrocreditos;
    }

    public void setNrocreditos(int nrocreditos) {
        this.nrocreditos = nrocreditos;
    }

    public Integer getHorastecnicas() {
        return horastecnicas;
    }

    public void setHorastecnicas(Integer horastecnicas) {
        this.horastecnicas = horastecnicas;
    }

    public int getHoraspracticas() {
        return horaspracticas;
    }

    public void setHoraspracticas(int horaspracticas) {
        this.horaspracticas = horaspracticas;
    }

    public int getHoraslaboratorio() {
        return horaslaboratorio;
    }

    public void setHoraslaboratorio(int horaslaboratorio) {
        this.horaslaboratorio = horaslaboratorio;
    }

    public Collection<Ciclo> getCicloCollection() {
        return cicloCollection;
    }

    public void setCicloCollection(Collection<Ciclo> cicloCollection) {
        this.cicloCollection = cicloCollection;
    }

    public Collection<EspecializacionCurso> getEspecializacionCursoCollection() {
        return especializacionCursoCollection;
    }

    public void setEspecializacionCursoCollection(Collection<EspecializacionCurso> especializacionCursoCollection) {
        this.especializacionCursoCollection = especializacionCursoCollection;
    }

    public Collection<Prerequisito> getPrerequisitoCollection() {
        return prerequisitoCollection;
    }

    public void setPrerequisitoCollection(Collection<Prerequisito> prerequisitoCollection) {
        this.prerequisitoCollection = prerequisitoCollection;
    }

    public SubArea getFxSubarea() {
        return fxSubarea;
    }

    public void setFxSubarea(SubArea fxSubarea) {
        this.fxSubarea = fxSubarea;
    }

    public Collection<Equivalencia> getEquivalenciaCollection() {
        return equivalenciaCollection;
    }

    public void setEquivalenciaCollection(Collection<Equivalencia> equivalenciaCollection) {
        this.equivalenciaCollection = equivalenciaCollection;
    }

    public Collection<EdicionCurso> getEdicionCursoCollection() {
        return edicionCursoCollection;
    }

    public void setEdicionCursoCollection(Collection<EdicionCurso> edicionCursoCollection) {
        this.edicionCursoCollection = edicionCursoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCurso != null ? idCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.idCurso == null && other.idCurso != null) || (this.idCurso != null && !this.idCurso.equals(other.idCurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.upn.sigecac.gcu.be.Curso[idCurso=" + idCurso + "]";
    }

}
