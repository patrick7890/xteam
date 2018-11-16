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
@Table(name = "plataforma")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plataforma.findAll", query = "SELECT p FROM Plataforma p")
    , @NamedQuery(name = "Plataforma.findByIdPlataforma", query = "SELECT p FROM Plataforma p WHERE p.idPlataforma = :idPlataforma")
    , @NamedQuery(name = "Plataforma.findByPlataforma", query = "SELECT p FROM Plataforma p WHERE p.plataforma = :plataforma")})
public class Plataforma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPlataforma")
    private Integer idPlataforma;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "plataforma")
    private String plataforma;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plataformaidPlataforma")
    private List<JuegoPlataforma> juegoPlataformaList;

    public Plataforma() {
    }

    public Plataforma(Integer idPlataforma) {
        this.idPlataforma = idPlataforma;
    }

    public Plataforma(Integer idPlataforma, String plataforma) {
        this.idPlataforma = idPlataforma;
        this.plataforma = plataforma;
    }

    public Integer getIdPlataforma() {
        return idPlataforma;
    }

    public void setIdPlataforma(Integer idPlataforma) {
        this.idPlataforma = idPlataforma;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
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
        hash += (idPlataforma != null ? idPlataforma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plataforma)) {
            return false;
        }
        Plataforma other = (Plataforma) object;
        if ((this.idPlataforma == null && other.idPlataforma != null) || (this.idPlataforma != null && !this.idPlataforma.equals(other.idPlataforma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.entidad.Plataforma[ idPlataforma=" + idPlataforma + " ]";
    }
    
}
