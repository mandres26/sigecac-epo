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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author texai
 */
@Entity
@Table(name = "EPO_NIVEL")
@NamedQueries({@NamedQuery(name = "NivelEpo.findAll", query = "SELECT n FROM NivelEpo n"), @NamedQuery(name = "NivelEpo.findByIdNivel", query = "SELECT n FROM NivelEpo n WHERE n.idNivel = :idNivel"), @NamedQuery(name = "NivelEpo.findByNombre", query = "SELECT n FROM NivelEpo n WHERE n.nombre = :nombre"), @NamedQuery(name = "NivelEpo.findByPeso", query = "SELECT n FROM NivelEpo n WHERE n.peso = :peso")})
public class NivelEpo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_NIVEL")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idNivel;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Lob
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "PESO")
    private double peso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fidNivel", fetch = FetchType.LAZY)
    private List<EvaluacionCriterio> evaluacionCriterioCollection;
    @JoinColumn(name = "FID_CRITERIO_EVALUACION", referencedColumnName = "ID_CRITERIO_EVALUACION")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CriterioEvaluacion fidCriterioEvaluacion;

    public NivelEpo() {
    }

    public NivelEpo(Long idNivel) {
        this.idNivel = idNivel;
    }

    public NivelEpo(Long idNivel, String nombre, double peso) {
        this.idNivel = idNivel;
        this.nombre = nombre;
        this.peso = peso;
    }

    public Long getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(Long idNivel) {
        this.idNivel = idNivel;
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

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public List<EvaluacionCriterio> getEvaluacionCriterioCollection() {
        return evaluacionCriterioCollection;
    }

    public void setEvaluacionCriterioCollection(List<EvaluacionCriterio> evaluacionCriterioCollection) {
        this.evaluacionCriterioCollection = evaluacionCriterioCollection;
    }

    public CriterioEvaluacion getFidCriterioEvaluacion() {
        return fidCriterioEvaluacion;
    }

    public void setFidCriterioEvaluacion(CriterioEvaluacion fidCriterioEvaluacion) {
        this.fidCriterioEvaluacion = fidCriterioEvaluacion;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NivelEpo other = (NivelEpo) obj;
        if (this.idNivel != other.idNivel && (this.idNivel == null || !this.idNivel.equals(other.idNivel))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + (this.idNivel != null ? this.idNivel.hashCode() : 0);
        return hash;
    }


    @Override
    public String toString() {
        return "edu.upn.sigecac.epo.be.NivelEpo[idNivel=" + idNivel + "]";
    }

}
