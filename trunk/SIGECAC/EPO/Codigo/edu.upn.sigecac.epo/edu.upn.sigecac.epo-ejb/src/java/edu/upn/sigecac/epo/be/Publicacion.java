/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upn.sigecac.epo.be;

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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author texai
 */
@Entity
@Table(name = "EPO_PUBLICACION")
@NamedQueries({@NamedQuery(name = "Publicacion.findAll", query = "SELECT p FROM Publicacion p"), @NamedQuery(name = "Publicacion.findByIdPublicacion", query = "SELECT p FROM Publicacion p WHERE p.idPublicacion = :idPublicacion"), @NamedQuery(name = "Publicacion.findByRecibirComentaios", query = "SELECT p FROM Publicacion p WHERE p.recibirComentaios = :recibirComentaios")})
public class Publicacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PUBLICACION", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPublicacion;
    @Basic(optional = false)
    @Lob
    @Column(name = "KEYWORDS")
    private String keywords;
    @Basic(optional = false)
    @Lob
    @Column(name = "RESUMEN")
    private String resumen;
    @Lob
    @Column(name = "COMENTARIO_AL_DOCENTE")
    private String comentarioAlDocente;
    @Basic(optional = false)
    @Column(name = "RECIBIR_COMENTAIOS")
    private boolean recibirComentaios;
    @Basic(optional = false)
    @Lob
    @Column(name = "TITULO")
    private String titulo;
    @Lob
    @Column(name = "ARCHIVO")
    private byte[] archivo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fidPublicacion", fetch = FetchType.LAZY)
    private List<Visita> visitaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fidPublicacionTrabajo", fetch = FetchType.LAZY)
    private List<EvaluacionPublicacion> evaluacionPublicacionCollection;
    @JoinColumn(name = "FID_GRUPO", referencedColumnName = "ID_GRUPO")
    @ManyToOne(fetch = FetchType.LAZY)
    private Grupo fidGrupo;
    @JoinColumn(name = "FID_PETICION", referencedColumnName = "ID_PETICION")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Peticion fidPeticion;
    @JoinColumn(name = "FID_ALUMNO", referencedColumnName = "ID_USUARIO")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario fidAlumno;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fidPublicacion", fetch = FetchType.LAZY)
    private List<Comentario> comentarioCollection;

    public Publicacion() {
    }

    public Publicacion(Long idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public Publicacion(Long idPublicacion, String keywords, String resumen, boolean recibirComentaios, String titulo) {
        this.idPublicacion = idPublicacion;
        this.keywords = keywords;
        this.resumen = resumen;
        this.recibirComentaios = recibirComentaios;
        this.titulo = titulo;
    }

    public Long getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(Long idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getComentarioAlDocente() {
        return comentarioAlDocente;
    }

    public void setComentarioAlDocente(String comentarioAlDocente) {
        this.comentarioAlDocente = comentarioAlDocente;
    }

    public boolean getRecibirComentaios() {
        return recibirComentaios;
    }

    public void setRecibirComentaios(boolean recibirComentaios) {
        this.recibirComentaios = recibirComentaios;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public byte[] getArchivo() {
        return archivo;
    }

    public void setArchivo(byte[] archivo) {
        this.archivo = archivo;
    }

    public List<Visita> getVisitaCollection() {
        return visitaCollection;
    }

    public void setVisitaCollection(List<Visita> visitaCollection) {
        this.visitaCollection = visitaCollection;
    }

    public List<EvaluacionPublicacion> getEvaluacionPublicacionCollection() {
        return evaluacionPublicacionCollection;
    }

    public void setEvaluacionPublicacionCollection(List<EvaluacionPublicacion> evaluacionPublicacionCollection) {
        this.evaluacionPublicacionCollection = evaluacionPublicacionCollection;
    }

    public Grupo getFidGrupo() {
        return fidGrupo;
    }

    public void setFidGrupo(Grupo fidGrupo) {
        this.fidGrupo = fidGrupo;
    }

    public Peticion getFidPeticion() {
        return fidPeticion;
    }

    public void setFidPeticion(Peticion fidPeticion) {
        this.fidPeticion = fidPeticion;
    }

    public Usuario getFidAlumno() {
        return fidAlumno;
    }

    public void setFidAlumno(Usuario fidAlumno) {
        this.fidAlumno = fidAlumno;
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
        final Publicacion other = (Publicacion) obj;
        if (this.idPublicacion != other.idPublicacion && (this.idPublicacion == null || !this.idPublicacion.equals(other.idPublicacion))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + (this.idPublicacion != null ? this.idPublicacion.hashCode() : 0);
        return hash;
    }


    @Override
    public String toString() {
        return "edu.upn.sigecac.epo.be.Publicacion[idPublicacion=" + idPublicacion + "]";
    }

}
