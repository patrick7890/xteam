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
@Table(name = "tipousuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipousuario.findAll", query = "SELECT t FROM Tipousuario t")
    , @NamedQuery(name = "Tipousuario.findByIdTipoUsuario", query = "SELECT t FROM Tipousuario t WHERE t.idTipoUsuario = :idTipoUsuario")
    , @NamedQuery(name = "Tipousuario.findByDescripcionTipoUsuario", query = "SELECT t FROM Tipousuario t WHERE t.descripcionTipoUsuario = :descripcionTipoUsuario")})
public class Tipousuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTipoUsuario")
    private Integer idTipoUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descripcionTipoUsuario")
    private String descripcionTipoUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoUsuarioidTipoUsuario")
    private List<Usuario> usuarioList;

    public Tipousuario() {
    }

    public Tipousuario(Integer idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public Tipousuario(Integer idTipoUsuario, String descripcionTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
        this.descripcionTipoUsuario = descripcionTipoUsuario;
    }

    public Integer getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(Integer idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getDescripcionTipoUsuario() {
        return descripcionTipoUsuario;
    }

    public void setDescripcionTipoUsuario(String descripcionTipoUsuario) {
        this.descripcionTipoUsuario = descripcionTipoUsuario;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoUsuario != null ? idTipoUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipousuario)) {
            return false;
        }
        Tipousuario other = (Tipousuario) object;
        if ((this.idTipoUsuario == null && other.idTipoUsuario != null) || (this.idTipoUsuario != null && !this.idTipoUsuario.equals(other.idTipoUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.entidad.Tipousuario[ idTipoUsuario=" + idTipoUsuario + " ]";
    }
    
}
