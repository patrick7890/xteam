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
@Table(name = "juego_plataforma")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JuegoPlataforma.findAll", query = "SELECT j FROM JuegoPlataforma j")
    , @NamedQuery(name = "JuegoPlataforma.findByIdJuegoPlataforma", query = "SELECT j FROM JuegoPlataforma j WHERE j.idJuegoPlataforma = :idJuegoPlataforma")})
public class JuegoPlataforma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idJuego_Plataforma")
    private Integer idJuegoPlataforma;
    @JoinColumn(name = "Juego_idJuego", referencedColumnName = "idJuego")
    @ManyToOne(optional = false)
    private Juego juegoidJuego;
    @JoinColumn(name = "Plataforma_idPlataforma", referencedColumnName = "idPlataforma")
    @ManyToOne(optional = false)
    private Plataforma plataformaidPlataforma;

    public JuegoPlataforma() {
    }

    public JuegoPlataforma(Integer idJuegoPlataforma) {
        this.idJuegoPlataforma = idJuegoPlataforma;
    }

    public Integer getIdJuegoPlataforma() {
        return idJuegoPlataforma;
    }

    public void setIdJuegoPlataforma(Integer idJuegoPlataforma) {
        this.idJuegoPlataforma = idJuegoPlataforma;
    }

    public Juego getJuegoidJuego() {
        return juegoidJuego;
    }

    public void setJuegoidJuego(Juego juegoidJuego) {
        this.juegoidJuego = juegoidJuego;
    }

    public Plataforma getPlataformaidPlataforma() {
        return plataformaidPlataforma;
    }

    public void setPlataformaidPlataforma(Plataforma plataformaidPlataforma) {
        this.plataformaidPlataforma = plataformaidPlataforma;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJuegoPlataforma != null ? idJuegoPlataforma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JuegoPlataforma)) {
            return false;
        }
        JuegoPlataforma other = (JuegoPlataforma) object;
        if ((this.idJuegoPlataforma == null && other.idJuegoPlataforma != null) || (this.idJuegoPlataforma != null && !this.idJuegoPlataforma.equals(other.idJuegoPlataforma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.entidad.JuegoPlataforma[ idJuegoPlataforma=" + idJuegoPlataforma + " ]";
    }
    
}
