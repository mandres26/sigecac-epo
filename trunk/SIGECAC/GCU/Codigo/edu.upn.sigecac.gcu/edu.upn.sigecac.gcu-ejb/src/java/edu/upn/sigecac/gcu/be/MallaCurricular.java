/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.gcu.be;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "GCU_MALLA_CURRICULAR")
@NamedQueries({@NamedQuery(name = "MallaCurricular.findAll", query = "SELECT m FROM MallaCurricular m"), @NamedQuery(name = "MallaCurricular.findByIdMallacurricular", query = "SELECT m FROM MallaCurricular m WHERE m.idMallacurricular = :idMallacurricular"), @NamedQuery(name = "MallaCurricular.findByNombre", query = "SELECT m FROM MallaCurricular m WHERE m.nombre = :nombre"), @NamedQuery(name = "MallaCurricular.findByDescripcion", query = "SELECT m FROM MallaCurricular m WHERE m.descripcion = :descripcion"), @NamedQuery(name = "MallaCurricular.findBySemestre", query = "SELECT m FROM MallaCurricular m WHERE m.semestre = :semestre"), @NamedQuery(name = "MallaCurricular.findByFxPlanEstudios", query = "SELECT m FROM MallaCurricular m WHERE m.fxPlanEstudios = :fxPlanEstudios"), @NamedQuery(name = "MallaCurricular.findByNrocreditos", query = "SELECT m FROM MallaCurricular m WHERE m.nrocreditos = :nrocreditos"), @NamedQuery(name = "MallaCurricular.findByNrociclos", query = "SELECT m FROM MallaCurricular m WHERE m.nrociclos = :nrociclos"), @NamedQuery(name = "MallaCurricular.findByAno", query = "SELECT m FROM MallaCurricular m WHERE m.ano = :ano")})
public class MallaCurricular implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_MALLACURRICULAR")
    private Long idMallacurricular;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "SEMESTRE")
    private Integer semestre;
    @Column(name = "FX_PLAN_ESTUDIOS")
    private BigInteger fxPlanEstudios;
    @Column(name = "NROCREDITOS")
    private Integer nrocreditos;
    @Column(name = "NROCICLOS")
    private Integer nrociclos;
    @Column(name = "ANO")
    private Integer ano;
    @OneToMany(mappedBy = "fkMallaCurricular", fetch = FetchType.LAZY)
    private Collection<Ciclo> cicloCollection;
    @JoinColumn(name = "FK_ID_CARRERA", referencedColumnName = "ID_CARRERA")
    @ManyToOne(fetch = FetchType.LAZY)
    private Carrera fkIdCarrera;
    @OneToMany(mappedBy = "fxMallacurricular", fetch = FetchType.LAZY)
    private Collection<MallaEstandares> mallaEstandaresCollection;

    public MallaCurricular() {
    }

    public MallaCurricular(Long idMallacurricular) {
        this.idMallacurricular = idMallacurricular;
    }

    public Long getIdMallacurricular() {
        return idMallacurricular;
    }

    public void setIdMallacurricular(Long idMallacurricular) {
        this.idMallacurricular = idMallacurricular;
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

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public BigInteger getFxPlanEstudios() {
        return fxPlanEstudios;
    }

    public void setFxPlanEstudios(BigInteger fxPlanEstudios) {
        this.fxPlanEstudios = fxPlanEstudios;
    }

    public Integer getNrocreditos() {
        return nrocreditos;
    }

    public void setNrocreditos(Integer nrocreditos) {
        this.nrocreditos = nrocreditos;
    }

    public Integer getNrociclos() {
        return nrociclos;
    }

    public void setNrociclos(Integer nrociclos) {
        this.nrociclos = nrociclos;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Collection<Ciclo> getCicloCollection() {
        return cicloCollection;
    }

    public void setCicloCollection(Collection<Ciclo> cicloCollection) {
        this.cicloCollection = cicloCollection;
    }

    public Carrera getFkIdCarrera() {
        return fkIdCarrera;
    }

    public void setFkIdCarrera(Carrera fkIdCarrera) {
        this.fkIdCarrera = fkIdCarrera;
    }

    public Collection<MallaEstandares> getMallaEstandaresCollection() {
        return mallaEstandaresCollection;
    }

    public void setMallaEstandaresCollection(Collection<MallaEstandares> mallaEstandaresCollection) {
        this.mallaEstandaresCollection = mallaEstandaresCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMallacurricular != null ? idMallacurricular.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MallaCurricular)) {
            return false;
        }
        MallaCurricular other = (MallaCurricular) object;
        if ((this.idMallacurricular == null && other.idMallacurricular != null) || (this.idMallacurricular != null && !this.idMallacurricular.equals(other.idMallacurricular))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.upn.sigecac.gcu.be.MallaCurricular[idMallacurricular=" + idMallacurricular + "]";
    }

}
