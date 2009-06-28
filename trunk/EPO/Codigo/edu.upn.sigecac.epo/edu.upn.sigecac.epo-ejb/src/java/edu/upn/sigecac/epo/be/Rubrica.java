/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.epo.be;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author texai
 */
@Entity
@Table(name = "EPO_RUBRICA")
@NamedQueries({@NamedQuery(name = "Rubrica.findAll", query = "SELECT r FROM Rubrica r"), @NamedQuery(name = "Rubrica.findByIdRubrica", query = "SELECT r FROM Rubrica r WHERE r.idRubrica = :idRubrica"), @NamedQuery(name = "Rubrica.findByCodigo", query = "SELECT r FROM Rubrica r WHERE r.codigo = :codigo")})
public class Rubrica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_RUBRICA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRubrica;
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private String codigo;
    @Basic(optional = false)
    @Lob
    @Column(name = "NOMBRE")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fidRubrica", fetch = FetchType.LAZY)
    private List<CriterioEvaluacion> criterioEvaluacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fidRubrica", fetch = FetchType.LAZY)
    private List<Peticion> peticionCollection;

    public Rubrica() {
    }

    public Rubrica(Long idRubrica) {
        this.idRubrica = idRubrica;
    }

    public Rubrica(Long idRubrica, String codigo, String nombre) {
        this.idRubrica = idRubrica;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Long getIdRubrica() {
        return idRubrica;
    }

    public void setIdRubrica(Long idRubrica) {
        this.idRubrica = idRubrica;
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

    public List<CriterioEvaluacion> getCriterioEvaluacionCollection() {
        return criterioEvaluacionCollection;
    }

    public void setCriterioEvaluacionCollection(List<CriterioEvaluacion> criterioEvaluacionCollection) {
        this.criterioEvaluacionCollection = criterioEvaluacionCollection;
    }

    public List<Peticion> getPeticionCollection() {
        return peticionCollection;
    }

    public void setPeticionCollection(List<Peticion> peticionCollection) {
        this.peticionCollection = peticionCollection;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Rubrica other = (Rubrica) obj;
        if (this.idRubrica != other.idRubrica && (this.idRubrica == null || !this.idRubrica.equals(other.idRubrica))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + (this.idRubrica != null ? this.idRubrica.hashCode() : 0);
        return hash;
    }


    @Override
    public String toString() {
        return "edu.upn.sigecac.epo.be.Rubrica[idRubrica=" + idRubrica + "]";
    }

}
