/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.sigecac.gen.be;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "GEN_COMITE_EJECUTIVO")
@NamedQueries({
    @NamedQuery(name = "ComiteEjecutivo.findAll", query = "SELECT c FROM ComiteEjecutivo c")
})
public class ComiteEjecutivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_COMITE_EJECUTIVO", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComiteEjecutivo;
    @Column(name = "NOMBRE", length = 80)
    private String nombre;

    public ComiteEjecutivo() {
    }

    public ComiteEjecutivo(Long idComiteEjecutivo) {
        this.idComiteEjecutivo = idComiteEjecutivo;
    }

    public Long getIdComiteEjecutivo() {
        return idComiteEjecutivo;
    }

    public void setIdComiteEjecutivo(Long idComiteEjecutivo) {
        this.idComiteEjecutivo = idComiteEjecutivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComiteEjecutivo != null ? idComiteEjecutivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComiteEjecutivo)) {
            return false;
        }
        ComiteEjecutivo other = (ComiteEjecutivo) object;
        if ((this.idComiteEjecutivo == null && other.idComiteEjecutivo != null) || (this.idComiteEjecutivo != null && !this.idComiteEjecutivo.equals(other.idComiteEjecutivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.upn.sigecac.gen.be.ComiteEjecutivo[idComiteEjecutivo=" + idComiteEjecutivo + "]";
    }
}
