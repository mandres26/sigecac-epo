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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "SEG_GRUPO")
@NamedQueries({@NamedQuery(name = "Grupo.findAll", query = "SELECT g FROM Grupo g"),
@NamedQuery(name = "Grupo.findByIdGrupo", query = "SELECT g FROM Grupo g WHERE g.idGrupo = :idGrupo"),
@NamedQuery(name = "Grupo.findByNombre", query = "SELECT g FROM Grupo g WHERE g.nombre = :nombre"),
@NamedQuery(name = "Grupo.findByDescripcion", query = "SELECT g FROM Grupo g WHERE g.descripcion = :descripcion"),
@NamedQuery(name = "Grupo.findByEstado", query = "SELECT g FROM Grupo g WHERE g.estado = :estado")})
public class Grupo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_GRUPO", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idGrupo;
    @Column(name = "NOMBRE", length = 150)
    private String nombre;
    @Column(name = "DESCRIPCION", length = 200)
    private String descripcion;
    @Column(name = "ESTADO")
    private Boolean estado;
    
    @JoinTable(name = "SEG_ROL_GRUPO",
    joinColumns = {
        @JoinColumn(name = "FID_GRUPO", referencedColumnName = "ID_GRUPO", nullable = false)},
    inverseJoinColumns = {
        @JoinColumn(name = "FID_ROL", referencedColumnName = "ID_ROL", nullable = false)})
    @ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Rol> rolCollection;

    @JoinTable(name = "SEG_GRUPO_USUARIO",
    joinColumns = {
        @JoinColumn(name = "FID_GRUPO", referencedColumnName = "ID_GRUPO", nullable = false)},
    inverseJoinColumns = {
        @JoinColumn(name = "FID_USUARIO", referencedColumnName = "ID_USUARIO", nullable = false)})
    @ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Usuario> usuarioCollection;

    public Grupo() {
    }

    public Grupo(Long idGrupo) {
        this.idGrupo = idGrupo;
    }

    public Long getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Long idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public List<Rol> getRolCollection() {
        return rolCollection;
    }

    public void setRolCollection(List<Rol> rolCollection) {
        this.rolCollection = rolCollection;
    }

    public List<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(List<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGrupo != null ? idGrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupo)) {
            return false;
        }
        Grupo other = (Grupo) object;
        if ((this.idGrupo == null && other.idGrupo != null) || (this.idGrupo != null && !this.idGrupo.equals(other.idGrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.upn.sigecac.seg.be.Grupo[idGrupo=" + idGrupo + "]";
    }

}
