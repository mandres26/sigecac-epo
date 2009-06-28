/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.sigecac.gen.be;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "GEN_DOCENTE")
@NamedQueries({
    @NamedQuery(name = "Docente.findAll", query = "SELECT d FROM Docente d")
})
@PrimaryKeyJoinColumn(name = "ID_DOCENTE", referencedColumnName = "ID_PERSONA")
@DiscriminatorValue(value = "DO")
public class Docente extends Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "TIPO", nullable = false)
    private TipoDocente tipo;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "GEN_CLASE_DOCENTE", joinColumns = {
        @JoinColumn(name = "FID_DOCENTE", referencedColumnName = "ID_DOCENTE")
    }, inverseJoinColumns = {
        @JoinColumn(name = "FID_CLASE", referencedColumnName = "ID_CLASE")
    })
    private List<Clase> clases;

    public Docente() {
    }

    public Docente(Long idPersona) {
        super(idPersona);
    }

    public TipoDocente getTipo() {
        return tipo;
    }

    public void setTipo(TipoDocente tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersona != null ? idPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.idPersona == null && other.idPersona != null) || (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idPersona.toString();
    }
}
