package edu.upn.sigecac.seg.be;

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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "SEG_ROL")
@NamedQueries({@NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r"),
@NamedQuery(name = "Rol.findByIdRol", query = "SELECT r FROM Rol r WHERE r.idRol = :idRol"),
@NamedQuery(name = "Rol.findByNombre", query = "SELECT r FROM Rol r WHERE r.nombre = :nombre"),
@NamedQuery(name = "Rol.findByEstado", query = "SELECT r FROM Rol r WHERE r.estado = :estado")})
public class Rol implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_ROL", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idRol;
    @Basic(optional = false)
    @Column(name = "NOMBRE", nullable = false, length = 50)
    private String nombre;
    @Column(name = "ESTADO")
    private Boolean estado;
    @ManyToMany(mappedBy="rolCollection",fetch=FetchType.LAZY)
    private List<Grupo> grupoCollection;

    public Rol() {
    }

    public Rol(Long idRol) {
        this.idRol = idRol;
    }

    public Rol(Long idRol, String nombre) {
        this.idRol = idRol;
        this.nombre = nombre;
    }

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public List<Grupo> getGrupoCollection() {
        return grupoCollection;
    }

    public void setGrupoCollection(List<Grupo> grupoCollection) {
        this.grupoCollection = grupoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRol != null ? idRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rol)) {
            return false;
        }
        Rol other = (Rol) object;
        if ((this.idRol == null && other.idRol != null) || (this.idRol != null && !this.idRol.equals(other.idRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.upn.sigecac.seg.be.Rol[idRol=" + idRol + "]";
    }
}