/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.epo.be;

import java.io.Serializable;
import javax.persistence.Basic;
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
import javax.persistence.Table;

/**
 *
 * @author texai
 */
@Entity
@Table(name = "EPO_EVALUACION_CRITERIO")
@NamedQueries({@NamedQuery(name = "EvaluacionCriterio.findAll", query = "SELECT e FROM EvaluacionCriterio e"), @NamedQuery(name = "EvaluacionCriterio.findByIdEvaluacionCriterio", query = "SELECT e FROM EvaluacionCriterio e WHERE e.idEvaluacionCriterio = :idEvaluacionCriterio")})
public class EvaluacionCriterio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_EVALUACION_CRITERIO")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idEvaluacionCriterio;
    @Basic(optional = false)
    @Lob
    @Column(name = "COMENTARIO")
    private String comentario;
    @JoinColumn(name = "FID_CRITERIO_EVALUACION", referencedColumnName = "ID_CRITERIO_EVALUACION")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CriterioEvaluacion fidCriterioEvaluacion;
    @JoinColumn(name = "FID_EVALUACION_PUBLICACION", referencedColumnName = "ID_EVALUACION_PUBLICACION")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EvaluacionPublicacion fidEvaluacionPublicacion;
    @JoinColumn(name = "FID_NIVEL", referencedColumnName = "ID_NIVEL")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private NivelEpo fidNivel;

    public EvaluacionCriterio() {
    }

    public EvaluacionCriterio(Long idEvaluacionCriterio) {
        this.idEvaluacionCriterio = idEvaluacionCriterio;
    }

    public EvaluacionCriterio(Long idEvaluacionCriterio, String comentario) {
        this.idEvaluacionCriterio = idEvaluacionCriterio;
        this.comentario = comentario;
    }

    public Long getIdEvaluacionCriterio() {
        return idEvaluacionCriterio;
    }

    public void setIdEvaluacionCriterio(Long idEvaluacionCriterio) {
        this.idEvaluacionCriterio = idEvaluacionCriterio;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public CriterioEvaluacion getFidCriterioEvaluacion() {
        return fidCriterioEvaluacion;
    }

    public void setFidCriterioEvaluacion(CriterioEvaluacion fidCriterioEvaluacion) {
        this.fidCriterioEvaluacion = fidCriterioEvaluacion;
    }

    public EvaluacionPublicacion getFidEvaluacionPublicacion() {
        return fidEvaluacionPublicacion;
    }

    public void setFidEvaluacionPublicacion(EvaluacionPublicacion fidEvaluacionPublicacion) {
        this.fidEvaluacionPublicacion = fidEvaluacionPublicacion;
    }

    public NivelEpo getFidNivel() {
        return fidNivel;
    }

    public void setFidNivel(NivelEpo fidNivel) {
        this.fidNivel = fidNivel;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EvaluacionCriterio other = (EvaluacionCriterio) obj;
        if (this.idEvaluacionCriterio != other.idEvaluacionCriterio && (this.idEvaluacionCriterio == null || !this.idEvaluacionCriterio.equals(other.idEvaluacionCriterio))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + (this.idEvaluacionCriterio != null ? this.idEvaluacionCriterio.hashCode() : 0);
        return hash;
    }



    @Override
    public String toString() {
        return "edu.upn.sigecac.epo.be.EvaluacionCriterio[idEvaluacionCriterio=" + idEvaluacionCriterio + "]";
    }

}
