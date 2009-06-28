/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upn.sigecac.gen.be;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "GEN_CLASE")
@NamedQueries({@NamedQuery(name = "Clase.findAll", query = "SELECT c FROM Clase c"), @NamedQuery(name = "Clase.findByIdClase", query = "SELECT c FROM Clase c WHERE c.idClase = :idClase"), @NamedQuery(name = "Clase.findByCodigo", query = "SELECT c FROM Clase c WHERE c.codigo = :codigo")})
public class Clase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_CLASE", nullable = false)
    private Long idClase;
    @Basic(optional = false)
    @Column(name = "CODIGO", nullable = false, length = 50)
    private String codigo;
    @ManyToMany(mappedBy = "clases", fetch = FetchType.LAZY)
    private List<Docente> docentes;

    public Clase() {
    }

    public Clase(Long idClase) {
        this.idClase = idClase;
    }

    public Clase(Long idClase, String codigo) {
        this.idClase = idClase;
        this.codigo = codigo;
    }

    public Long getIdClase() {
        return idClase;
    }

    public void setIdClase(Long idClase) {
        this.idClase = idClase;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<Docente> getDocentes() {
        return docentes;
    }

    public void setDocentes(List<Docente> docentes) {
        this.docentes = docentes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClase != null ? idClase.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clase)) {
            return false;
        }
        Clase other = (Clase) object;
        if ((this.idClase == null && other.idClase != null) || (this.idClase != null && !this.idClase.equals(other.idClase))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.upn.sigecac.gen.be.Clase[idClase=" + idClase + "]";
    }
}
