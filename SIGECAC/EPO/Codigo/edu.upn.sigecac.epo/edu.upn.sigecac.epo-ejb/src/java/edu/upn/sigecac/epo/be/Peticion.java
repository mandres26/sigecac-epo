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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author texai
 */
@Entity
@Table(name = "EPO_PETICION")
@NamedQueries({@NamedQuery(name = "Peticion.findAll", query = "SELECT p FROM Peticion p"), @NamedQuery(name = "Peticion.findByIdPeticion", query = "SELECT p FROM Peticion p WHERE p.idPeticion = :idPeticion"), @NamedQuery(name = "Peticion.findByInicio", query = "SELECT p FROM Peticion p WHERE p.inicio = :inicio"), @NamedQuery(name = "Peticion.findByFin", query = "SELECT p FROM Peticion p WHERE p.fin = :fin"), @NamedQuery(name = "Peticion.findByGrupal", query = "SELECT p FROM Peticion p WHERE p.grupal = :grupal"), @NamedQuery(name = "Peticion.findByMultitema", query = "SELECT p FROM Peticion p WHERE p.multitema = :multitema"), @NamedQuery(name = "Peticion.findByNombre", query = "SELECT p FROM Peticion p WHERE p.nombre = :nombre")})
public class Peticion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PETICION")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idPeticion;
    @Column(name = "INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inicio;
    @Basic(optional = false)
    @Column(name = "FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fin;
    @Lob
    @Column(name = "REFERENCIA")
    private byte[] referencia;
    @Basic(optional = false)
    @Column(name = "GRUPAL")
    private boolean grupal;
    @Basic(optional = false)
    @Column(name = "MULTITEMA")
    private boolean multitema;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Lob
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @JoinColumn(name = "FID_ESQUEMA_GRUPO", referencedColumnName = "ID_ESQUEMA_GRUPO")
    @ManyToOne(fetch = FetchType.LAZY)
    private EsquemaGrupo fidEsquemaGrupo;
    @JoinColumn(name = "FID_RUBRICA", referencedColumnName = "ID_RUBRICA")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Rubrica fidRubrica;
    @JoinColumn(name = "FID_TIPO_ARCHIVO", referencedColumnName = "ID_TIPO_ARCHIVO")
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoArchivo fidTipoArchivo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fidPeticion", fetch = FetchType.LAZY)
    private List<Publicacion> publicacionCollection;

    public Peticion() {
    }

    public Peticion(Long idPeticion) {
        this.idPeticion = idPeticion;
    }

    public Peticion(Long idPeticion, Date fin, boolean grupal, boolean multitema, String nombre) {
        this.idPeticion = idPeticion;
        this.fin = fin;
        this.grupal = grupal;
        this.multitema = multitema;
        this.nombre = nombre;
    }

    public Long getIdPeticion() {
        return idPeticion;
    }

    public void setIdPeticion(Long idPeticion) {
        this.idPeticion = idPeticion;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public byte[] getReferencia() {
        return referencia;
    }

    public void setReferencia(byte[] referencia) {
        this.referencia = referencia;
    }

    public boolean getGrupal() {
        return grupal;
    }

    public void setGrupal(boolean grupal) {
        this.grupal = grupal;
    }

    public boolean getMultitema() {
        return multitema;
    }

    public void setMultitema(boolean multitema) {
        this.multitema = multitema;
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

    public EsquemaGrupo getFidEsquemaGrupo() {
        return fidEsquemaGrupo;
    }

    public void setFidEsquemaGrupo(EsquemaGrupo fidEsquemaGrupo) {
        this.fidEsquemaGrupo = fidEsquemaGrupo;
    }

    public Rubrica getFidRubrica() {
        return fidRubrica;
    }

    public void setFidRubrica(Rubrica fidRubrica) {
        this.fidRubrica = fidRubrica;
    }

    public TipoArchivo getFidTipoArchivo() {
        return fidTipoArchivo;
    }

    public void setFidTipoArchivo(TipoArchivo fidTipoArchivo) {
        this.fidTipoArchivo = fidTipoArchivo;
    }

    public List<Publicacion> getPublicacionCollection() {
        return publicacionCollection;
    }

    public void setPublicacionCollection(List<Publicacion> publicacionCollection) {
        this.publicacionCollection = publicacionCollection;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Peticion other = (Peticion) obj;
        if (this.idPeticion != other.idPeticion && (this.idPeticion == null || !this.idPeticion.equals(other.idPeticion))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + (this.idPeticion != null ? this.idPeticion.hashCode() : 0);
        return hash;
    }



    @Override
    public String toString() {
        return "edu.upn.sigecac.epo.be.Peticion[idPeticion=" + idPeticion + "]";
    }

}
