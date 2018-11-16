/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto.entidad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Patricio
 */
@Embeddable
public class CodigoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idCodigo")
    private int idCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Juego_idJuego")
    private int juegoidJuego;

    public CodigoPK() {
    }

    public CodigoPK(int idCodigo, int juegoidJuego) {
        this.idCodigo = idCodigo;
        this.juegoidJuego = juegoidJuego;
    }

    public int getIdCodigo() {
        return idCodigo;
    }

    public void setIdCodigo(int idCodigo) {
        this.idCodigo = idCodigo;
    }

    public int getJuegoidJuego() {
        return juegoidJuego;
    }

    public void setJuegoidJuego(int juegoidJuego) {
        this.juegoidJuego = juegoidJuego;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCodigo;
        hash += (int) juegoidJuego;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CodigoPK)) {
            return false;
        }
        CodigoPK other = (CodigoPK) object;
        if (this.idCodigo != other.idCodigo) {
            return false;
        }
        if (this.juegoidJuego != other.juegoidJuego) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.entidad.CodigoPK[ idCodigo=" + idCodigo + ", juegoidJuego=" + juegoidJuego + " ]";
    }
    
}
