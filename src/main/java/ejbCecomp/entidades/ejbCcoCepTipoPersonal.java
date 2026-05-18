/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejbCecomp.entidades;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Jael
 */
@Entity(name="CepTipoPersonal")
@Table(name = "cep_tipo_personal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CepTipoPersonal.findAll", query = "SELECT c FROM CepTipoPersonal c"),
    @NamedQuery(name = "CepTipoPersonal.findByIdTipoCecomp", query = "SELECT c FROM CepTipoPersonal c WHERE c.idTipoCecomp = :idTipoCecomp"),
    @NamedQuery(name = "CepTipoPersonal.findByNombre", query = "SELECT c FROM CepTipoPersonal c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "CepTipoPersonal.findByDescripcion", query = "SELECT c FROM CepTipoPersonal c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "CepTipoPersonal.findByAbreviatura", query = "SELECT c FROM CepTipoPersonal c WHERE c.abreviatura = :abreviatura"),
    @NamedQuery(name = "CepTipoPersonal.findByActivo", query = "SELECT c FROM CepTipoPersonal c WHERE c.activo = :activo")})
public class ejbCcoCepTipoPersonal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tipo_cecomp")
    private Short idTipoCecomp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 10)
    @Column(name = "abreviatura")
    private String abreviatura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoCecomp")
    private List<ejbCcoCepPersonal> ejbCcoCepPersonalList;

    public ejbCcoCepTipoPersonal() {
    }

    public ejbCcoCepTipoPersonal(Short idTipoCecomp) {
        this.idTipoCecomp = idTipoCecomp;
    }

    public ejbCcoCepTipoPersonal(Short idTipoCecomp, String nombre, boolean activo) {
        this.idTipoCecomp = idTipoCecomp;
        this.nombre = nombre;
        this.activo = activo;
    }

    public Short getIdTipoCecomp() {
        return idTipoCecomp;
    }

    public void setIdTipoCecomp(Short idTipoCecomp) {
        this.idTipoCecomp = idTipoCecomp;
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

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @XmlTransient
    public List<ejbCcoCepPersonal> getEjbCcoCepPersonalList() {
        return ejbCcoCepPersonalList;
    }

    public void setEjbCcoCepPersonalList(List<ejbCcoCepPersonal> ejbCcoCepPersonalList) {
        this.ejbCcoCepPersonalList = ejbCcoCepPersonalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoCecomp != null ? idTipoCecomp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ejbCcoCepTipoPersonal)) {
            return false;
        }
        ejbCcoCepTipoPersonal other = (ejbCcoCepTipoPersonal) object;
        if ((this.idTipoCecomp == null && other.idTipoCecomp != null) || (this.idTipoCecomp != null && !this.idTipoCecomp.equals(other.idTipoCecomp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbCecomp.entidades.CepTipoPersonal[ idTipoCecomp=" + idTipoCecomp + " ]";
    }
    
}
