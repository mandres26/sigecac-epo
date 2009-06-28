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
@Table(name = "GCU_MALLA_ESTANDARES")
@NamedQueries({@NamedQuery(name = "MallaEstandares.findAll", query = "SELECT m FROM MallaEstandares m"), @NamedQuery(name = "MallaEstandares.findByIdMallaEstandares", query = "SELECT m FROM MallaEstandares m WHERE m.idMallaEstandares = :idMallaEstandares"), @NamedQuery(name = "MallaEstandares.findByAno", query = "SELECT m FROM MallaEstandares m WHERE m.ano = :ano")})
public class MallaEstandares implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_MALLA_ESTANDARES")
    private Long idMallaEstandares;
    @Column(name = "ANO")
    private Integer ano;
    @OneToMany(mappedBy = "fxMallaEstandares", fetch = FetchType.LAZY)
    private Collection<EstandaresCuantificadores> estandaresCuantificadoresCollection;
    @JoinColumn(name = "FX_MALLACURRICULAR", referencedColumnName = "ID_MALLACURRICULAR")
    @ManyToOne(fetch = FetchType.LAZY)
    private MallaCurricular fxMallacurricular;

    public MallaEstandares() {
    }

    public MallaEstandares(Long idMallaEstandares) {
        this.idMallaEstandares = idMallaEstandares;
    }

    public Long getIdMallaEstandares() {
        return idMallaEstandares;
    }

    public void setIdMallaEstandares(Long idMallaEstandares) {
        this.idMallaEstandares = idMallaEstandares;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Collection<EstandaresCuantificadores> getEstandaresCuantificadoresCollection() {
        return estandaresCuantificadoresCollection;
    }

    public void setEstandaresCuantificadoresCollection(Collection<EstandaresCuantificadores> estandaresCuantificadoresCollection) {
        this.estandaresCuantificadoresCollection = estandaresCuantificadoresCollection;
    }

    public MallaCurricular getFxMallacurricular() {
        return fxMallacurricular;
    }

    public void setFxMallacurricular(MallaCurricular fxMallacurricular) {
        this.fxMallacurricular = fxMallacurricular;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMallaEstandares != null ? idMallaEstandares.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MallaEstandares)) {
            return false;
        }
        MallaEstandares other = (MallaEstandares) object;
        if ((this.idMallaEstandares == null && other.idMallaEstandares != null) || (this.idMallaEstandares != null && !this.idMallaEstandares.equals(other.idMallaEstandares))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.upn.sigecac.gcu.be.MallaEstandares[idMallaEstandares=" + idMallaEstandares + "]";
    }

}
