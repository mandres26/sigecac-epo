package edu.upn.sigecac.pac.be;

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
@Entity
@Table(name = "PAC_NIVEL")
@NamedQueries({@NamedQuery(name = "Nivel.findAll", query = "SELECT n FROM Nivel n"), @NamedQuery(name = "Nivel.findByIdNivel", query = "SELECT n FROM Nivel n WHERE n.idNivel = :idNivel"), @NamedQuery(name = "Nivel.findByNombre", query = "SELECT n FROM Nivel n WHERE n.nombre = :nombre"), @NamedQuery(name = "Nivel.findByDescripcion", query = "SELECT n FROM Nivel n WHERE n.descripcion = :descripcion")})
public class Nivel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    @Basic(optional = false)
    @Column(name = "ID_NIVEL", nullable = false)
    private Long idNivel = 0L;
    @Column(name = "NOMBRE", length = 100)
    private String nombre;
    @Column(name = "DESCRIPCION", length = 255)
    private String descripcion;
    @JoinColumn(name = "FID_CRITERIO", referencedColumnName = "ID_CRITERIO")
    @ManyToOne(fetch = FetchType.LAZY)
    private Criterio fidCriterio;
  

    public Nivel() {
    }

    public Nivel(Long idNivel) {
        this.idNivel = idNivel;
    }

    public Long getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(Long idNivel) {
        this.idNivel = idNivel;
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

    public Criterio getFidCriterio() {
        return fidCriterio;
    }

    public void setFidCriterio(Criterio fidCriterio) {
        this.fidCriterio = fidCriterio;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNivel != null ? idNivel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nivel)) {
            return false;
        }
        Nivel other = (Nivel) object;
        if ((this.idNivel == null && other.idNivel != null) || (this.idNivel != null && !this.idNivel.equals(other.idNivel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
         return "edu.upn.sigecac.pac.be.Nivel[idNivel=" + idNivel + "]";
        //return idNivel.toString();
    }

}
