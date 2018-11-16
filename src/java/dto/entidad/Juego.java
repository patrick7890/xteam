/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Patricio
 */
@Entity
@Table(name = "juego")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Juego.findAll", query = "SELECT j FROM Juego j")
    , @NamedQuery(name = "Juego.findByIdJuego", query = "SELECT j FROM Juego j WHERE j.idJuego = :idJuego")
    , @NamedQuery(name = "Juego.findByNombreJuego", query = "SELECT j FROM Juego j WHERE j.nombreJuego = :nombreJuego")
    , @NamedQuery(name = "Juego.findByDescripcionJuego", query = "SELECT j FROM Juego j WHERE j.descripcionJuego = :descripcionJuego")
    , @NamedQuery(name = "Juego.findByPrecioJuego", query = "SELECT j FROM Juego j WHERE j.precioJuego = :precioJuego")})
public class Juego implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idJuego")
    private Integer idJuego;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombreJuego")
    private String nombreJuego;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descripcionJuego")
    private String descripcionJuego;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precioJuego")
    private int precioJuego;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "juegoidJuego")
    private List<JuegoGenero> juegoGeneroList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "juego")
    private List<Codigo> codigoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "juegoidJuego")
    private List<JuegoPlataforma> juegoPlataformaList;

    public Juego() {
    }

    public Juego(Integer idJuego) {
        this.idJuego = idJuego;
    }

    public Juego(Integer idJuego, String nombreJuego, String descripcionJuego, int precioJuego) {
        this.idJuego = idJuego;
        this.nombreJuego = nombreJuego;
        this.descripcionJuego = descripcionJuego;
        this.precioJuego = precioJuego;
    }

    public Integer getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(Integer idJuego) {
        this.idJuego = idJuego;
    }

    public String getNombreJuego() {
        return nombreJuego;
    }

    public void setNombreJuego(String nombreJuego) {
        this.nombreJuego = nombreJuego;
    }

    public String getDescripcionJuego() {
        return descripcionJuego;
    }

    public void setDescripcionJuego(String descripcionJuego) {
        this.descripcionJuego = descripcionJuego;
    }

    public int getPrecioJuego() {
        return precioJuego;
    }

    public void setPrecioJuego(int precioJuego) {
        this.precioJuego = precioJuego;
    }

    @XmlTransient
    public List<JuegoGenero> getJuegoGeneroList() {
        return juegoGeneroList;
    }

    public void setJuegoGeneroList(List<JuegoGenero> juegoGeneroList) {
        this.juegoGeneroList = juegoGeneroList;
    }

    @XmlTransient
    public List<Codigo> getCodigoList() {
        return codigoList;
    }

    public void setCodigoList(List<Codigo> codigoList) {
        this.codigoList = codigoList;
    }

    @XmlTransient
    public List<JuegoPlataforma> getJuegoPlataformaList() {
        return juegoPlataformaList;
    }

    public void setJuegoPlataformaList(List<JuegoPlataforma> juegoPlataformaList) {
        this.juegoPlataformaList = juegoPlataformaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJuego != null ? idJuego.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Juego)) {
            return false;
        }
        Juego other = (Juego) object;
        if ((this.idJuego == null && other.idJuego != null) || (this.idJuego != null && !this.idJuego.equals(other.idJuego))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.entidad.Juego[ idJuego=" + idJuego + " ]";
    }
    
}
