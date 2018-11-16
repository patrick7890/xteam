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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "codigo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Codigo.findAll", query = "SELECT c FROM Codigo c")
    , @NamedQuery(name = "Codigo.findByIdCodigo", query = "SELECT c FROM Codigo c WHERE c.codigoPK.idCodigo = :idCodigo")
    , @NamedQuery(name = "Codigo.findByCodigo", query = "SELECT c FROM Codigo c WHERE c.codigo = :codigo")
    , @NamedQuery(name = "Codigo.findByActivo", query = "SELECT c FROM Codigo c WHERE c.activo = :activo")
    , @NamedQuery(name = "Codigo.findByJuegoidJuego", query = "SELECT c FROM Codigo c WHERE c.codigoPK.juegoidJuego = :juegoidJuego")})
public class Codigo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CodigoPK codigoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Activo")
    private short activo;
    @JoinColumn(name = "Juego_idJuego", referencedColumnName = "idJuego", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Juego juego;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigo")
    private List<CodigoCompra> codigoCompraList;

    public Codigo() {
    }

    public Codigo(CodigoPK codigoPK) {
        this.codigoPK = codigoPK;
    }

    public Codigo(CodigoPK codigoPK, String codigo, short activo) {
        this.codigoPK = codigoPK;
        this.codigo = codigo;
        this.activo = activo;
    }

    public Codigo(int idCodigo, int juegoidJuego) {
        this.codigoPK = new CodigoPK(idCodigo, juegoidJuego);
    }

    public CodigoPK getCodigoPK() {
        return codigoPK;
    }

    public void setCodigoPK(CodigoPK codigoPK) {
        this.codigoPK = codigoPK;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public short getActivo() {
        return activo;
    }

    public void setActivo(short activo) {
        this.activo = activo;
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    @XmlTransient
    public List<CodigoCompra> getCodigoCompraList() {
        return codigoCompraList;
    }

    public void setCodigoCompraList(List<CodigoCompra> codigoCompraList) {
        this.codigoCompraList = codigoCompraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoPK != null ? codigoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Codigo)) {
            return false;
        }
        Codigo other = (Codigo) object;
        if ((this.codigoPK == null && other.codigoPK != null) || (this.codigoPK != null && !this.codigoPK.equals(other.codigoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.entidad.Codigo[ codigoPK=" + codigoPK + " ]";
    }
    
}
