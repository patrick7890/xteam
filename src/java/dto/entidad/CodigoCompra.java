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
import javax.persistence.JoinColumns;
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
@Table(name = "codigo_compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CodigoCompra.findAll", query = "SELECT c FROM CodigoCompra c")
    , @NamedQuery(name = "CodigoCompra.findByIdCodigoCompra", query = "SELECT c FROM CodigoCompra c WHERE c.idCodigoCompra = :idCodigoCompra")})
public class CodigoCompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCodigo_Compra")
    private Integer idCodigoCompra;
    @JoinColumns({
        @JoinColumn(name = "Codigo_idCodigo", referencedColumnName = "idCodigo")
        , @JoinColumn(name = "Codigo_Juego_idJuego", referencedColumnName = "Juego_idJuego")})
    @ManyToOne(optional = false)
    private Codigo codigo;
    @JoinColumn(name = "Compra_idCompra", referencedColumnName = "idCompra")
    @ManyToOne(optional = false)
    private Compra compraidCompra;

    public CodigoCompra() {
    }

    public CodigoCompra(Integer idCodigoCompra) {
        this.idCodigoCompra = idCodigoCompra;
    }

    public Integer getIdCodigoCompra() {
        return idCodigoCompra;
    }

    public void setIdCodigoCompra(Integer idCodigoCompra) {
        this.idCodigoCompra = idCodigoCompra;
    }

    public Codigo getCodigo() {
        return codigo;
    }

    public void setCodigo(Codigo codigo) {
        this.codigo = codigo;
    }

    public Compra getCompraidCompra() {
        return compraidCompra;
    }

    public void setCompraidCompra(Compra compraidCompra) {
        this.compraidCompra = compraidCompra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCodigoCompra != null ? idCodigoCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CodigoCompra)) {
            return false;
        }
        CodigoCompra other = (CodigoCompra) object;
        if ((this.idCodigoCompra == null && other.idCodigoCompra != null) || (this.idCodigoCompra != null && !this.idCodigoCompra.equals(other.idCodigoCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.entidad.CodigoCompra[ idCodigoCompra=" + idCodigoCompra + " ]";
    }
    
}
