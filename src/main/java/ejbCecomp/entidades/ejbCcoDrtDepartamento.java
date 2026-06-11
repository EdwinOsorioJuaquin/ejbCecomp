/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejbCecomp.entidades;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Entity(name="DrtDepartamento")
@Table(name = "drt_departamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DrtDepartamento.findAll", query = "SELECT d FROM DrtDepartamento d"),
    @NamedQuery(name = "DrtDepartamento.findByIdPais", query = "SELECT d FROM DrtDepartamento d WHERE d.drtDepartamentoPK.idPais = :idPais"),
    @NamedQuery(name = "DrtDepartamento.findByIdDpto", query = "SELECT d FROM DrtDepartamento d WHERE d.drtDepartamentoPK.idDpto = :idDpto"),
    @NamedQuery(name = "DrtDepartamento.findByNombreDpto", query = "SELECT d FROM DrtDepartamento d WHERE d.nombreDpto = :nombreDpto"),
    @NamedQuery(name = "DrtDepartamento.findByAbreviaturaDpto", query = "SELECT d FROM DrtDepartamento d WHERE d.abreviaturaDpto = :abreviaturaDpto"),
    @NamedQuery(name = "DrtDepartamento.findByCodigoDpto", query = "SELECT d FROM DrtDepartamento d WHERE d.codigoDpto = :codigoDpto")})
public class ejbCcoDrtDepartamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ejbCcoDrtDepartamentoPK drtDepartamentoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_dpto")
    private String nombreDpto;
    @Size(max = 20)
    @Column(name = "abreviatura_dpto")
    private String abreviaturaDpto;
    @Size(max = 2)
    @Column(name = "codigo_dpto")
    private String codigoDpto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "drtDepartamento")
    private List<ejbCcoDrtProvincia> drtProvinciaList;
    @JoinColumn(name = "id_pais", referencedColumnName = "id_pais", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ejbCcoDrtPais drtPais;

    public ejbCcoDrtDepartamento() {
    }

    public ejbCcoDrtDepartamento(ejbCcoDrtDepartamentoPK drtDepartamentoPK) {
        this.drtDepartamentoPK = drtDepartamentoPK;
    }

    public ejbCcoDrtDepartamento(ejbCcoDrtDepartamentoPK drtDepartamentoPK, String nombreDpto) {
        this.drtDepartamentoPK = drtDepartamentoPK;
        this.nombreDpto = nombreDpto;
    }

    public ejbCcoDrtDepartamento(int idPais, int idDpto) {
        this.drtDepartamentoPK = new ejbCcoDrtDepartamentoPK(idPais, idDpto);
    }

    public ejbCcoDrtDepartamentoPK getDrtDepartamentoPK() {
        return drtDepartamentoPK;
    }

    public void setDrtDepartamentoPK(ejbCcoDrtDepartamentoPK drtDepartamentoPK) {
        this.drtDepartamentoPK = drtDepartamentoPK;
    }

    public String getNombreDpto() {
        return nombreDpto;
    }

    public void setNombreDpto(String nombreDpto) {
        this.nombreDpto = nombreDpto;
    }

    public String getAbreviaturaDpto() {
        return abreviaturaDpto;
    }

    public void setAbreviaturaDpto(String abreviaturaDpto) {
        this.abreviaturaDpto = abreviaturaDpto;
    }

    public String getCodigoDpto() {
        return codigoDpto;
    }

    public void setCodigoDpto(String codigoDpto) {
        this.codigoDpto = codigoDpto;
    }

    @XmlTransient
    public List<ejbCcoDrtProvincia> getDrtProvinciaList() {
        return drtProvinciaList;
    }

    public void setDrtProvinciaList(List<ejbCcoDrtProvincia> drtProvinciaList) {
        this.drtProvinciaList = drtProvinciaList;
    }

    public ejbCcoDrtPais getDrtPais() {
        return drtPais;
    }

    public void setDrtPais(ejbCcoDrtPais drtPais) {
        this.drtPais = drtPais;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (drtDepartamentoPK != null ? drtDepartamentoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ejbCcoDrtDepartamento)) {
            return false;
        }
        ejbCcoDrtDepartamento other = (ejbCcoDrtDepartamento) object;
        if ((this.drtDepartamentoPK == null && other.drtDepartamentoPK != null) || (this.drtDepartamentoPK != null && !this.drtDepartamentoPK.equals(other.drtDepartamentoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbCecomp.entidades.DrtDepartamento[ drtDepartamentoPK=" + drtDepartamentoPK + " ]";
    }
    
}
