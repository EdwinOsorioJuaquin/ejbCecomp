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
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
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
@Entity(name = "DrtProvincia")
@Table(name = "drt_provincia")
@NamedQueries({
    @NamedQuery(name = "DrtProvincia.findAll", query = "SELECT d FROM DrtProvincia d"),
    @NamedQuery(name = "DrtProvincia.findByIdPais", query = "SELECT d FROM DrtProvincia d WHERE d.drtProvinciaPK.idPais = :idPais"),
    @NamedQuery(name = "DrtProvincia.findByIdDpto", query = "SELECT d FROM DrtProvincia d WHERE d.drtProvinciaPK.idDpto = :idDpto"),
    @NamedQuery(name = "DrtProvincia.findByIdProv", query = "SELECT d FROM DrtProvincia d WHERE d.drtProvinciaPK.idProv = :idProv"),
    @NamedQuery(name = "DrtProvincia.findByNombreProv", query = "SELECT d FROM DrtProvincia d WHERE d.nombreProv = :nombreProv"),
    @NamedQuery(name = "DrtProvincia.findByAbreviaturaProv", query = "SELECT d FROM DrtProvincia d WHERE d.abreviaturaProv = :abreviaturaProv"),
    @NamedQuery(name = "DrtProvincia.findByCodigoProv", query = "SELECT d FROM DrtProvincia d WHERE d.codigoProv = :codigoProv"),
    @NamedQuery(name = "DrtProvincia.findByIdProvI", query = "SELECT d FROM DrtProvincia d WHERE d.idProvI = :idProvI")})
public class ejbCcoDrtProvincia implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ejbCcoDrtProvinciaPK drtProvinciaPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_prov")
    private String nombreProv;
    @Size(max = 30)
    @Column(name = "abreviatura_prov")
    private String abreviaturaProv;
    @Size(max = 4)
    @Column(name = "codigo_prov")
    private String codigoProv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_prov_i")
    private int idProvI;
    @JoinColumns({
        @JoinColumn(name = "id_pais", referencedColumnName = "id_pais", insertable = false, updatable = false),
        @JoinColumn(name = "id_dpto", referencedColumnName = "id_dpto", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private ejbCcoDrtDepartamento drtDepartamento;
    @OneToMany(mappedBy = "drtProvincia")
    private List<ejbCcoDrtDistrito> drtDistritoList;

    public ejbCcoDrtProvincia() {
    }

    public ejbCcoDrtProvincia(ejbCcoDrtProvinciaPK drtProvinciaPK) {
        this.drtProvinciaPK = drtProvinciaPK;
    }

    public ejbCcoDrtProvincia(ejbCcoDrtProvinciaPK drtProvinciaPK, String nombreProv, int idProvI) {
        this.drtProvinciaPK = drtProvinciaPK;
        this.nombreProv = nombreProv;
        this.idProvI = idProvI;
    }

    public ejbCcoDrtProvincia(int idPais, int idDpto, int idProv) {
        this.drtProvinciaPK = new ejbCcoDrtProvinciaPK(idPais, idDpto, idProv);
    }

    public ejbCcoDrtProvinciaPK getDrtProvinciaPK() {
        return drtProvinciaPK;
    }

    public void setDrtProvinciaPK(ejbCcoDrtProvinciaPK drtProvinciaPK) {
        this.drtProvinciaPK = drtProvinciaPK;
    }

    public String getNombreProv() {
        return nombreProv;
    }

    public void setNombreProv(String nombreProv) {
        this.nombreProv = nombreProv;
    }

    public String getAbreviaturaProv() {
        return abreviaturaProv;
    }

    public void setAbreviaturaProv(String abreviaturaProv) {
        this.abreviaturaProv = abreviaturaProv;
    }

    public String getCodigoProv() {
        return codigoProv;
    }

    public void setCodigoProv(String codigoProv) {
        this.codigoProv = codigoProv;
    }

    public int getIdProvI() {
        return idProvI;
    }

    public void setIdProvI(int idProvI) {
        this.idProvI = idProvI;
    }

    public ejbCcoDrtDepartamento getDrtDepartamento() {
        return drtDepartamento;
    }

    public void setDrtDepartamento(ejbCcoDrtDepartamento drtDepartamento) {
        this.drtDepartamento = drtDepartamento;
    }

    public List<ejbCcoDrtDistrito> getDrtDistritoList() {
        return drtDistritoList;
    }

    public void setDrtDistritoList(List<ejbCcoDrtDistrito> drtDistritoList) {
        this.drtDistritoList = drtDistritoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (drtProvinciaPK != null ? drtProvinciaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ejbCcoDrtProvincia)) {
            return false;
        }
        ejbCcoDrtProvincia other = (ejbCcoDrtProvincia) object;
        if ((this.drtProvinciaPK == null && other.drtProvinciaPK != null) || (this.drtProvinciaPK != null && !this.drtProvinciaPK.equals(other.drtProvinciaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbCecomp.entidades.DrtProvincia[ drtProvinciaPK=" + drtProvinciaPK + " ]";
    }
    
}
