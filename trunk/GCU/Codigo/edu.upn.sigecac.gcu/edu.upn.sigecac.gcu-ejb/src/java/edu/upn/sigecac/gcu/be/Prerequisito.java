/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.gcu.be;

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

/**
 *
 * @author Programador
 */
@Entity
@Table(name = "GCU_PREREQUISITO")
@NamedQueries({@NamedQuery(name = "Prerequisito.findAll", query = "SELECT p FROM Prerequisito p"), @NamedQuery(name = "Prerequisito.findByIdPrerequisito", query = "SELECT p FROM Prerequisito p WHERE p.idPrerequisito = :idPrerequisito"), @NamedQuery(name = "Prerequisito.findByAbreviatura", query = "SELECT p FROM Prerequisito p WHERE p.abreviatura = :abreviatura"), @NamedQuery(name = "Prerequisito.findByNombre", query = "SELECT p FROM Prerequisito p WHERE p.nombre = :nombre")})
public class Prerequisito implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PREREQUISITO")
    private Long idPrerequisito;
    @Column(name = "ABREVIATURA")
    private String abreviatura;
    @Column(name = "NOMBRE")
    private String nombre;
    @JoinColumn(name = "FX_IDCURSO", referencedColumnName = "ID_CURSO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Curso fxIdcurso;

    public Prerequisito() {
    }

    public Prerequisito(Long idPrerequisito) {
        this.idPrerequisito = idPrerequisito;
    }

    public Long getIdPrerequisito() {
        return idPrerequisito;
    }

    public void setIdPrerequisito(Long idPrerequisito) {
        this.idPrerequisito = idPrerequisito;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Curso getFxIdcurso() {
        return fxIdcurso;
    }

    public void setFxIdcurso(Curso fxIdcurso) {
        this.fxIdcurso = fxIdcurso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrerequisito != null ? idPrerequisito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prerequisito)) {
            return false;
        }
        Prerequisito other = (Prerequisito) object;
        if ((this.idPrerequisito == null && other.idPrerequisito != null) || (this.idPrerequisito != null && !this.idPrerequisito.equals(other.idPrerequisito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.upn.sigecac.gcu.be.Prerequisito[idPrerequisito=" + idPrerequisito + "]";
    }

}
