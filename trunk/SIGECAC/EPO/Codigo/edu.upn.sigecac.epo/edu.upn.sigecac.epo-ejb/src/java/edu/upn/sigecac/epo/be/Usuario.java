/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.epo.be;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author texai
 */
@Entity
@Table(name = "EPO_USUARIO")
@NamedQueries({@NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"), @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario"), @NamedQuery(name = "Usuario.findByNombres", query = "SELECT u FROM Usuario u WHERE u.nombres = :nombres"), @NamedQuery(name = "Usuario.findByApellidop", query = "SELECT u FROM Usuario u WHERE u.apellidop = :apellidop"), @NamedQuery(name = "Usuario.findByApellidom", query = "SELECT u FROM Usuario u WHERE u.apellidom = :apellidom"), @NamedQuery(name = "Usuario.findByTipo", query = "SELECT u FROM Usuario u WHERE u.tipo = :tipo"), @NamedQuery(name = "Usuario.findByUltimoLogin", query = "SELECT u FROM Usuario u WHERE u.ultimoLogin = :ultimoLogin"), @NamedQuery(name = "Usuario.findByLogin", query = "SELECT u FROM Usuario u WHERE u.login = :login"), @NamedQuery(name = "Usuario.findByPassword", query = "SELECT u FROM Usuario u WHERE u.password = :password")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_USUARIO")
    private Long idUsuario;
    @Column(name = "NOMBRES")
    private String nombres;
    @Column(name = "APELLIDOP")
    private String apellidop;
    @Column(name = "APELLIDOM")
    private String apellidom;
    @Basic(optional = false)
    @Column(name = "TIPO")
    private short tipo;
    @Basic(optional = false)
    @Column(name = "ULTIMO_LOGIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimoLogin;
    @Basic(optional = false)
    @Column(name = "LOGIN")
    private String login;
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String password;
    @ManyToMany(mappedBy = "usuarioCollection", fetch = FetchType.LAZY)
    private List<Grupo> grupoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fidUsuario", fetch = FetchType.LAZY)
    private List<Alarma> alarmaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fidUsuario", fetch = FetchType.LAZY)
    private List<Visita> visitaCollection;
    @OneToMany(mappedBy = "fidAlumno", fetch = FetchType.LAZY)
    private List<Publicacion> publicacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fidUsuario", fetch = FetchType.LAZY)
    private List<Comentario> comentarioCollection;

    public Usuario() {
    }

    public Usuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Long idUsuario, short tipo, Date ultimoLogin, String login, String password) {
        this.idUsuario = idUsuario;
        this.tipo = tipo;
        this.ultimoLogin = ultimoLogin;
        this.login = login;
        this.password = password;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidop() {
        return apellidop;
    }

    public void setApellidop(String apellidop) {
        this.apellidop = apellidop;
    }

    public String getApellidom() {
        return apellidom;
    }

    public void setApellidom(String apellidom) {
        this.apellidom = apellidom;
    }

    public short getTipo() {
        return tipo;
    }

    public void setTipo(short tipo) {
        this.tipo = tipo;
    }

    public Date getUltimoLogin() {
        return ultimoLogin;
    }

    public void setUltimoLogin(Date ultimoLogin) {
        this.ultimoLogin = ultimoLogin;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Grupo> getGrupoCollection() {
        return grupoCollection;
    }

    public void setGrupoCollection(List<Grupo> grupoCollection) {
        this.grupoCollection = grupoCollection;
    }

    public List<Alarma> getAlarmaCollection() {
        return alarmaCollection;
    }

    public void setAlarmaCollection(List<Alarma> alarmaCollection) {
        this.alarmaCollection = alarmaCollection;
    }

    public List<Visita> getVisitaCollection() {
        return visitaCollection;
    }

    public void setVisitaCollection(List<Visita> visitaCollection) {
        this.visitaCollection = visitaCollection;
    }

    public List<Publicacion> getPublicacionCollection() {
        return publicacionCollection;
    }

    public void setPublicacionCollection(List<Publicacion> publicacionCollection) {
        this.publicacionCollection = publicacionCollection;
    }

    public List<Comentario> getComentarioCollection() {
        return comentarioCollection;
    }

    public void setComentarioCollection(List<Comentario> comentarioCollection) {
        this.comentarioCollection = comentarioCollection;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (this.idUsuario != other.idUsuario && (this.idUsuario == null || !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (this.idUsuario != null ? this.idUsuario.hashCode() : 0);
        return hash;
    }


    @Override
    public String toString() {
        return "edu.upn.sigecac.epo.be.Usuario[idUsuario=" + idUsuario + "]";
    }

}
