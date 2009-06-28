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
@Table(name = "EPO_EVALUACION_PUBLICACION")
@NamedQueries({@NamedQuery(name = "EvaluacionPublicacion.findAll", query = "SELECT e FROM EvaluacionPublicacion e"), @NamedQuery(name = "EvaluacionPublicacion.findByIdEvaluacionPublicacion", query = "SELECT e FROM EvaluacionPublicacion e WHERE e.idEvaluacionPublicacion = :idEvaluacionPublicacion")})
public class EvaluacionPublicacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_EVALUACION_PUBLICACION")
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private Long idEvaluacionPublicacion;
    @Basic(optional = false)
    @Lob
    @Column(name = "COMENTARIO")
    private String comentario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fidEvaluacionPublicacion", fetch = FetchType.LAZY)
    private List<EvaluacionCriterio> evaluacionCriterioCollection;
    @JoinColumn(name = "FID_PUBLICACION_TRABAJO", referencedColumnName = "ID_PUBLICACION")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Publicacion fidPublicacionTrabajo;

    public EvaluacionPublicacion() {
    }

    public EvaluacionPublicacion(Long idEvaluacionPublicacion) {
        this.idEvaluacionPublicacion = idEvaluacionPublicacion;
    }

    public EvaluacionPublicacion(Long idEvaluacionPublicacion, String comentario) {
        this.idEvaluacionPublicacion = idEvaluacionPublicacion;
        this.comentario = comentario;
    }

    public Long getIdEvaluacionPublicacion() {
        return idEvaluacionPublicacion;
    }

    public void setIdEvaluacionPublicacion(Long idEvaluacionPublicacion) {
        this.idEvaluacionPublicacion = idEvaluacionPublicacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public List<EvaluacionCriterio> getEvaluacionCriterioCollection() {
        return evaluacionCriterioCollection;
    }

    public void setEvaluacionCriterioCollection(List<EvaluacionCriterio> evaluacionCriterioCollection) {
        this.evaluacionCriterioCollection = evaluacionCriterioCollection;
    }

    public Publicacion getFidPublicacionTrabajo() {
        return fidPublicacionTrabajo;
    }

    public void setFidPublicacionTrabajo(Publicacion fidPublicacionTrabajo) {
        this.fidPublicacionTrabajo = fidPublicacionTrabajo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EvaluacionPublicacion other = (EvaluacionPublicacion) obj;
        if (this.idEvaluacionPublicacion != other.idEvaluacionPublicacion && (this.idEvaluacionPublicacion == null || !this.idEvaluacionPublicacion.equals(other.idEvaluacionPublicacion))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + (this.idEvaluacionPublicacion != null ? this.idEvaluacionPublicacion.hashCode() : 0);
        return hash;
    }



    @Override
    public String toString() {
        return "edu.upn.sigecac.epo.be.EvaluacionPublicacion[idEvaluacionPublicacion=" + idEvaluacionPublicacion + "]";
    }

}
