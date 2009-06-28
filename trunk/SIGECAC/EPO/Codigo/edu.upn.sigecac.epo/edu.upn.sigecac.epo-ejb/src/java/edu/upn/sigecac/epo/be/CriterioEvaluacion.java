/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.epo.be;

import edu.upn.sigecac.pac.be.Criterio;
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
@Table(name = "EPO_CRITERIO_EVALUACION")
@NamedQueries({@NamedQuery(name = "CriterioEvaluacion.findAll", query = "SELECT c FROM CriterioEvaluacion c"), @NamedQuery(name = "CriterioEvaluacion.findByIdCriterioEvaluacion", query = "SELECT c FROM CriterioEvaluacion c WHERE c.idCriterioEvaluacion = :idCriterioEvaluacion"), @NamedQuery(name = "CriterioEvaluacion.findByPeso", query = "SELECT c FROM CriterioEvaluacion c WHERE c.peso = :peso")})
public class CriterioEvaluacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_CRITERIO_EVALUACION")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCriterioEvaluacion;
    @Basic(optional = false)
    @Column(name = "PESO")
    private short peso;
    @Lob
    @Column(name = "COMENTARIO")
    private String comentario;
    @JoinColumn(name = "FID_RUBRICA", referencedColumnName = "ID_RUBRICA")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Rubrica fidRubrica;

    @JoinColumn(name = "FID_PAC_CRITERIO_EVALUACION", referencedColumnName = "ID_CRITERIO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Criterio fidPACCriterio;

    public Criterio getFidPACCriterio() {
        return fidPACCriterio;
    }

    public void setFidPACCriterio(Criterio fidPACCriterio) {
        this.fidPACCriterio = fidPACCriterio;
    }


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fidCriterioEvaluacion", fetch = FetchType.LAZY)
    private List<EvaluacionCriterio> evaluacionCriterioCollection;

    public CriterioEvaluacion() {
    }

    public CriterioEvaluacion(Long idCriterioEvaluacion) {
        this.idCriterioEvaluacion = idCriterioEvaluacion;
    }

    public CriterioEvaluacion(Long idCriterioEvaluacion, short peso) {
        this.idCriterioEvaluacion = idCriterioEvaluacion;
        this.peso = peso;
    }

    public Long getIdCriterioEvaluacion() {
        return idCriterioEvaluacion;
    }

    public void setIdCriterioEvaluacion(Long idCriterioEvaluacion) {
        this.idCriterioEvaluacion = idCriterioEvaluacion;
    }

    public short getPeso() {
        return peso;
    }

    public void setPeso(short peso) {
        this.peso = peso;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Rubrica getFidRubrica() {
        return fidRubrica;
    }

    public void setFidRubrica(Rubrica fidRubrica) {
        this.fidRubrica = fidRubrica;
    }

    public List<EvaluacionCriterio> getEvaluacionCriterioCollection() {
        return evaluacionCriterioCollection;
    }

    public void setEvaluacionCriterioCollection(List<EvaluacionCriterio> evaluacionCriterioCollection) {
        this.evaluacionCriterioCollection = evaluacionCriterioCollection;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CriterioEvaluacion other = (CriterioEvaluacion) obj;
        if (this.idCriterioEvaluacion != other.idCriterioEvaluacion && (this.idCriterioEvaluacion == null || !this.idCriterioEvaluacion.equals(other.idCriterioEvaluacion))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + (this.idCriterioEvaluacion != null ? this.idCriterioEvaluacion.hashCode() : 0);
        return hash;
    }



    @Override
    public String toString() {
        return "edu.upn.sigecac.epo.be.CriterioEvaluacion[idCriterioEvaluacion=" + idCriterioEvaluacion + "]";
    }

}
