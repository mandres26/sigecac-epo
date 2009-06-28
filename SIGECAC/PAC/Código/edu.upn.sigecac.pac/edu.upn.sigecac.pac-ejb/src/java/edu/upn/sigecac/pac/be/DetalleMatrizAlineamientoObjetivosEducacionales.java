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
@Table(name = "PAC_DETALLE_MATRIZ_ALINEAMIENTO_OBJETIVOS_EDUCACIONALES")
@NamedQueries({@NamedQuery(name = "DetalleMatrizAlineamientoObjetivosEducacionales.findAll", query = "SELECT d FROM DetalleMatrizAlineamientoObjetivosEducacionales d"), @NamedQuery(name = "DetalleMatrizAlineamientoObjetivosEducacionales.findByIdDetalleMatrizObjetivosEducacionales", query = "SELECT d FROM DetalleMatrizAlineamientoObjetivosEducacionales d WHERE d.idDetalleMatrizObjetivosEducacionales = :idDetalleMatrizObjetivosEducacionales")})
public class DetalleMatrizAlineamientoObjetivosEducacionales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DETALLE_MATRIZ_OBJETIVOS_EDUCACIONALES", nullable = false)
    private Long idDetalleMatrizObjetivosEducacionales;
    @JoinColumn(name = "FID_MATRIZ_OBJETIVOS_EDUCACIONALES", referencedColumnName = "ID_MATRIZ_ALINEAMIENTO_OBJETIVOS_EDUCACIONALES")
    @ManyToOne(fetch = FetchType.LAZY)
    private MatrizAlineamientoObjetivosEducacionales fidMatrizObjetivosEducacionales;
    @JoinColumn(name = "FID_OBJETIVO_EDUCACIONAL", referencedColumnName = "ID_OBJETIVO_EDUCACIONAL", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ObjetivoEducacional fidObjetivoEducacional;
    @JoinColumn(name = "FID_RESULTADO_PROGRAMA", referencedColumnName = "ID_RESULTADO_PROGRAMA", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ResultadoPrograma fidResultadoPrograma;

    public DetalleMatrizAlineamientoObjetivosEducacionales() {
    }

    public DetalleMatrizAlineamientoObjetivosEducacionales(Long idDetalleMatrizObjetivosEducacionales) {
        this.idDetalleMatrizObjetivosEducacionales = idDetalleMatrizObjetivosEducacionales;
    }

    public Long getIdDetalleMatrizObjetivosEducacionales() {
        return idDetalleMatrizObjetivosEducacionales;
    }

    public void setIdDetalleMatrizObjetivosEducacionales(Long idDetalleMatrizObjetivosEducacionales) {
        this.idDetalleMatrizObjetivosEducacionales = idDetalleMatrizObjetivosEducacionales;
    }

    public MatrizAlineamientoObjetivosEducacionales getFidMatrizObjetivosEducacionales() {
        return fidMatrizObjetivosEducacionales;
    }

    public void setFidMatrizObjetivosEducacionales(MatrizAlineamientoObjetivosEducacionales fidMatrizObjetivosEducacionales) {
        this.fidMatrizObjetivosEducacionales = fidMatrizObjetivosEducacionales;
    }

    public ObjetivoEducacional getFidObjetivoEducacional() {
        return fidObjetivoEducacional;
    }

    public void setFidObjetivoEducacional(ObjetivoEducacional fidObjetivoEducacional) {
        this.fidObjetivoEducacional = fidObjetivoEducacional;
    }

    public ResultadoPrograma getFidResultadoPrograma() {
        return fidResultadoPrograma;
    }

    public void setFidResultadoPrograma(ResultadoPrograma fidResultadoPrograma) {
        this.fidResultadoPrograma = fidResultadoPrograma;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleMatrizObjetivosEducacionales != null ? idDetalleMatrizObjetivosEducacionales.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleMatrizAlineamientoObjetivosEducacionales)) {
            return false;
        }
        DetalleMatrizAlineamientoObjetivosEducacionales other = (DetalleMatrizAlineamientoObjetivosEducacionales) object;
        if ((this.idDetalleMatrizObjetivosEducacionales == null && other.idDetalleMatrizObjetivosEducacionales != null) || (this.idDetalleMatrizObjetivosEducacionales != null && !this.idDetalleMatrizObjetivosEducacionales.equals(other.idDetalleMatrizObjetivosEducacionales))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.upn.sigecac.pac.be.DetalleMatrizAlineamientoObjetivosEducacionales[idDetalleMatrizObjetivosEducacionales=" + idDetalleMatrizObjetivosEducacionales + "]";
    }
}
