package edu.upn.sigecac.pac.be;

import java.io.Serializable;
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
import javax.persistence.Table;

@Entity
@Table(name = "PAC_DETALLE_MATRIZ_ALINEAMIENTO_RESULTADOS_PROGRAMA")
@NamedQueries({@NamedQuery(name = "DetalleMatrizAlineamientoResultadosPrograma.findAll", query = "SELECT d FROM DetalleMatrizAlineamientoResultadosPrograma d"), @NamedQuery(name = "DetalleMatrizAlineamientoResultadosPrograma.findByIdDetalleMatrizResultadosPrograma", query = "SELECT d FROM DetalleMatrizAlineamientoResultadosPrograma d WHERE d.idDetalleMatrizResultadosPrograma = :idDetalleMatrizResultadosPrograma")})
public class DetalleMatrizAlineamientoResultadosPrograma implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID_DETALLE_MATRIZ_RESULTADOS_PROGRAMA", nullable = false)
    private Long idDetalleMatrizResultadosPrograma;
    @JoinColumn(name = "FID_CRITERIO", referencedColumnName = "ID_CRITERIO", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Criterio fidCriterio;
    @JoinColumn(name = "FID_MATRIZ_RESULTADOS_PROGRAMA", referencedColumnName = "ID_MATRIZ_RESULTADOS_PROGRAMA")
    @ManyToOne(fetch = FetchType.LAZY)
    private MatrizAlineamientoResultadosPrograma fidMatrizResultadosPrograma;
     @Column(name = "FID_CURSO")
    private Long fid_Curso;

    public DetalleMatrizAlineamientoResultadosPrograma() {
    }

    public DetalleMatrizAlineamientoResultadosPrograma(Long idDetalleMatrizResultadosPrograma) {
        this.idDetalleMatrizResultadosPrograma = idDetalleMatrizResultadosPrograma;
    }

    public Long getIdDetalleMatrizResultadosPrograma() {
        return idDetalleMatrizResultadosPrograma;
    }

    public void setIdDetalleMatrizResultadosPrograma(Long idDetalleMatrizResultadosPrograma) {
        this.idDetalleMatrizResultadosPrograma = idDetalleMatrizResultadosPrograma;
    }

    public Criterio getFidCriterio() {
        return fidCriterio;
    }

    public Long getFid_Curso() {
        return fid_Curso;
    }

    public void setFid_Curso(Long fid_Curso) {
        this.fid_Curso = fid_Curso;
    }

    public void setFidCriterio(Criterio fidCriterio) {
        this.fidCriterio = fidCriterio;
    }

    public MatrizAlineamientoResultadosPrograma getFidMatrizResultadosPrograma() {
        return fidMatrizResultadosPrograma;
    }

    public void setFidMatrizResultadosPrograma(MatrizAlineamientoResultadosPrograma fidMatrizResultadosPrograma) {
        this.fidMatrizResultadosPrograma = fidMatrizResultadosPrograma;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleMatrizResultadosPrograma != null ? idDetalleMatrizResultadosPrograma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleMatrizAlineamientoResultadosPrograma)) {
            return false;
        }
        DetalleMatrizAlineamientoResultadosPrograma other = (DetalleMatrizAlineamientoResultadosPrograma) object;
        if ((this.idDetalleMatrizResultadosPrograma == null && other.idDetalleMatrizResultadosPrograma != null) || (this.idDetalleMatrizResultadosPrograma != null && !this.idDetalleMatrizResultadosPrograma.equals(other.idDetalleMatrizResultadosPrograma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.upn.sigecac.pac.be.DetalleMatrizAlineamientoResultadosPrograma[idDetalleMatrizResultadosPrograma=" + idDetalleMatrizResultadosPrograma + "]";
    }

}
