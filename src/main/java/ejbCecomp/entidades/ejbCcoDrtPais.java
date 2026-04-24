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
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Jael
 */
@Entity(name = "DrtPais")
@Table(name = "drt_pais")
@NamedQueries({
    @NamedQuery(name = "DrtPais.findAll", query = "SELECT d FROM DrtPais d"),
    @NamedQuery(name = "DrtPais.findByIdPais", query = "SELECT d FROM DrtPais d WHERE d.idPais = :idPais"),
    @NamedQuery(name = "DrtPais.findByNombrePais", query = "SELECT d FROM DrtPais d WHERE d.nombrePais = :nombrePais"),
    @NamedQuery(name = "DrtPais.findByAbreviaturaPais", query = "SELECT d FROM DrtPais d WHERE d.abreviaturaPais = :abreviaturaPais"),
    @NamedQuery(name = "DrtPais.findByCodigoPostal", query = "SELECT d FROM DrtPais d WHERE d.codigoPostal = :codigoPostal")})
public class ejbCcoDrtPais implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pais")
    private Integer idPais;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_pais")
    private String nombrePais;
    @Size(max = 10)
    @Column(name = "abreviatura_pais")
    private String abreviaturaPais;
    @Size(max = 10)
    @Column(name = "codigo_postal")
    private String codigoPostal;
    @OneToMany(mappedBy = "drtPais")
    private List<ejbCcoDrtDepartamento> drtDepartamentoList;

    public ejbCcoDrtPais() {
    }

    public ejbCcoDrtPais(Integer idPais) {
        this.idPais = idPais;
    }

    public ejbCcoDrtPais(Integer idPais, String nombrePais) {
        this.idPais = idPais;
        this.nombrePais = nombrePais;
    }

    public Integer getIdPais() {
        return idPais;
    }

    public void setIdPais(Integer idPais) {
        this.idPais = idPais;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public String getAbreviaturaPais() {
        return abreviaturaPais;
    }

    public void setAbreviaturaPais(String abreviaturaPais) {
        this.abreviaturaPais = abreviaturaPais;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public List<ejbCcoDrtDepartamento> getDrtDepartamentoList() {
        return drtDepartamentoList;
    }

    public void setDrtDepartamentoList(List<ejbCcoDrtDepartamento> drtDepartamentoList) {
        this.drtDepartamentoList = drtDepartamentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPais != null ? idPais.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ejbCcoDrtPais)) {
            return false;
        }
        ejbCcoDrtPais other = (ejbCcoDrtPais) object;
        if ((this.idPais == null && other.idPais != null) || (this.idPais != null && !this.idPais.equals(other.idPais))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbCecomp.entidades.DrtPais[ idPais=" + idPais + " ]";
    }
    
}
