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
@Table(name = "GEN_EMPLEADOR")
@NamedQueries({
    @NamedQuery(name = "Empleador.findAll", query = "SELECT e FROM Empleador e")
})
public class Empleador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_EMPLEADOR", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmpleador;
    @Column(name = "RAZON_SOCIAL", length = 80)
    private String razonSocial;

    public Empleador() {
    }

    public Empleador(Long idEmpleador) {
        this.idEmpleador = idEmpleador;
    }

    public Long getIdEmpleador() {
        return idEmpleador;
    }

    public void setIdEmpleador(Long idEmpleador) {
        this.idEmpleador = idEmpleador;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmpleador != null ? idEmpleador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleador)) {
            return false;
        }
        Empleador other = (Empleador) object;
        if ((this.idEmpleador == null && other.idEmpleador != null) || (this.idEmpleador != null && !this.idEmpleador.equals(other.idEmpleador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.upn.sigecac.gen.be.Empleador[idEmpleador=" + idEmpleador + "]";
    }
}
