/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.entidad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Patricio
 */
@Entity
@Table(name = "juego_genero")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JuegoGenero.findAll", query = "SELECT j FROM JuegoGenero j")
    , @NamedQuery(name = "JuegoGenero.findByIdJuegoGenero", query = "SELECT j FROM JuegoGenero j WHERE j.idJuegoGenero = :idJuegoGenero")})
public class JuegoGenero implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idJuego_Genero")
    private Integer idJuegoGenero;
    @JoinColumn(name = "Genero_idGenero", referencedColumnName = "idGenero")
    @ManyToOne(optional = false)
    private Genero generoidGenero;
    @JoinColumn(name = "Juego_idJuego", referencedColumnName = "idJuego")
    @ManyToOne(optional = false)
    private Juego juegoidJuego;

    public JuegoGenero() {
    }

    public JuegoGenero(Integer idJuegoGenero) {
        this.idJuegoGenero = idJuegoGenero;
    }

    public Integer getIdJuegoGenero() {
        return idJuegoGenero;
    }

    public void setIdJuegoGenero(Integer idJuegoGenero) {
        this.idJuegoGenero = idJuegoGenero;
    }

    public Genero getGeneroidGenero() {
        return generoidGenero;
    }

    public void setGeneroidGenero(Genero generoidGenero) {
        this.generoidGenero = generoidGenero;
    }

    public Juego getJuegoidJuego() {
        return juegoidJuego;
    }

    public void setJuegoidJuego(Juego juegoidJuego) {
        this.juegoidJuego = juegoidJuego;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJuegoGenero != null ? idJuegoGenero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JuegoGenero)) {
            return false;
        }
        JuegoGenero other = (JuegoGenero) object;
        if ((this.idJuegoGenero == null && other.idJuegoGenero != null) || (this.idJuegoGenero != null && !this.idJuegoGenero.equals(other.idJuegoGenero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.entidad.JuegoGenero[ idJuegoGenero=" + idJuegoGenero + " ]";
    }
    
}
