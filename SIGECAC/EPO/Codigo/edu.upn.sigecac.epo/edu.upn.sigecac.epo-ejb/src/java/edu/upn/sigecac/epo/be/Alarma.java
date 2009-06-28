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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author texai
 */
@Entity
@Table(name = "EPO_ALARMA")
@NamedQueries({@NamedQuery(name = "Alarma.findAll", query = "SELECT a FROM Alarma a"), @NamedQuery(name = "Alarma.findByIdAlarma", query = "SELECT a FROM Alarma a WHERE a.idAlarma = :idAlarma"), @NamedQuery(name = "Alarma.findByPalabra", query = "SELECT a FROM Alarma a WHERE a.palabra = :palabra")})
public class Alarma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_ALARMA")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idAlarma;
    @Basic(optional = false)
    @Column(name = "PALABRA")
    private String palabra;
    @JoinColumn(name = "FID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario fidUsuario;

    public Alarma() {
    }

    public Alarma(Long idAlarma) {
        this.idAlarma = idAlarma;
    }

    public Alarma(Long idAlarma, String palabra) {
        this.idAlarma = idAlarma;
        this.palabra = palabra;
    }

    public Long getIdAlarma() {
        return idAlarma;
    }

    public void setIdAlarma(Long idAlarma) {
        this.idAlarma = idAlarma;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public Usuario getFidUsuario() {
        return fidUsuario;
    }

    public void setFidUsuario(Usuario fidUsuario) {
        this.fidUsuario = fidUsuario;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Alarma other = (Alarma) obj;
        if (this.idAlarma != other.idAlarma && (this.idAlarma == null || !this.idAlarma.equals(other.idAlarma))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + (this.idAlarma != null ? this.idAlarma.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "edu.upn.sigecac.epo.be.Alarma[idAlarma=" + idAlarma + "]";
    }
}
