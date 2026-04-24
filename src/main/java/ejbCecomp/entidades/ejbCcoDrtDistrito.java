/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejbCecomp.entidades;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;

/**
 *
 * @author Jael
 */
@Entity(name = "DrtDistrito")
@Table(name = "drt_distrito")
@NamedQueries({
    @NamedQuery(name = "DrtDistrito.findAll", query = "SELECT d FROM DrtDistrito d"),
    @NamedQuery(name = "DrtDistrito.findByIdPais", query = "SELECT d FROM DrtDistrito d WHERE d.drtDistritoPK.idPais = :idPais"),
    @NamedQuery(name = "DrtDistrito.findByIdDpto", query = "SELECT d FROM DrtDistrito d WHERE d.drtDistritoPK.idDpto = :idDpto"),
    @NamedQuery(name = "DrtDistrito.findByIdProv", query = "SELECT d FROM DrtDistrito d WHERE d.drtDistritoPK.idProv = :idProv"),
    @NamedQuery(name = "DrtDistrito.findByIdDistrito", query = "SELECT d FROM DrtDistrito d WHERE d.drtDistritoPK.idDistrito = :idDistrito"),
    @NamedQuery(name = "DrtDistrito.findByNombreDist", query = "SELECT d FROM DrtDistrito d WHERE d.nombreDist = :nombreDist"),
    @NamedQuery(name = "DrtDistrito.findByAbreviaturaDist", query = "SELECT d FROM DrtDistrito d WHERE d.abreviaturaDist = :abreviaturaDist"),
    @NamedQuery(name = "DrtDistrito.findByIdUbg", query = "SELECT d FROM DrtDistrito d WHERE d.idUbg = :idUbg"),
    @NamedQuery(name = "DrtDistrito.findByCodigoDist", query = "SELECT d FROM DrtDistrito d WHERE d.codigoDist = :codigoDist"),
    @NamedQuery(name = "DrtDistrito.findByUbigeoActualizado", query = "SELECT d FROM DrtDistrito d WHERE d.ubigeoActualizado = :ubigeoActualizado")})
public class ejbCcoDrtDistrito implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ejbCcoDrtDistritoPK drtDistritoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre_dist")
    private String nombreDist;
    @Size(max = 50)
    @Column(name = "abreviatura_dist")
    private String abreviaturaDist;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ubg")
    private int idUbg;
    @Size(max = 6)
    @Column(name = "codigo_dist")
    private String codigoDist;
    @Size(max = 6)
    @Column(name = "ubigeo_actualizado")
    private String ubigeoActualizado;
    @JoinColumns({
        @JoinColumn(name = "id_pais", referencedColumnName = "id_pais", insertable = false, updatable = false),
        @JoinColumn(name = "id_dpto", referencedColumnName = "id_dpto", insertable = false, updatable = false),
        @JoinColumn(name = "id_prov", referencedColumnName = "id_prov", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private ejbCcoDrtProvincia drtProvincia;

    public ejbCcoDrtDistrito() {
    }

    public ejbCcoDrtDistrito(ejbCcoDrtDistritoPK drtDistritoPK) {
        this.drtDistritoPK = drtDistritoPK;
    }

    public ejbCcoDrtDistrito(ejbCcoDrtDistritoPK drtDistritoPK, String nombreDist, int idUbg) {
        this.drtDistritoPK = drtDistritoPK;
        this.nombreDist = nombreDist;
        this.idUbg = idUbg;
    }

    public ejbCcoDrtDistrito(int idPais, int idDpto, int idProv, int idDistrito) {
        this.drtDistritoPK = new ejbCcoDrtDistritoPK(idPais, idDpto, idProv, idDistrito);
    }

    public ejbCcoDrtDistritoPK getDrtDistritoPK() {
        return drtDistritoPK;
    }

    public void setDrtDistritoPK(ejbCcoDrtDistritoPK drtDistritoPK) {
        this.drtDistritoPK = drtDistritoPK;
    }

    public String getNombreDist() {
        return nombreDist;
    }

    public void setNombreDist(String nombreDist) {
        this.nombreDist = nombreDist;
    }

    public String getAbreviaturaDist() {
        return abreviaturaDist;
    }

    public void setAbreviaturaDist(String abreviaturaDist) {
        this.abreviaturaDist = abreviaturaDist;
    }

    public int getIdUbg() {
        return idUbg;
    }

    public void setIdUbg(int idUbg) {
        this.idUbg = idUbg;
    }

    public String getCodigoDist() {
        return codigoDist;
    }

    public void setCodigoDist(String codigoDist) {
        this.codigoDist = codigoDist;
    }

    public String getUbigeoActualizado() {
        return ubigeoActualizado;
    }

    public void setUbigeoActualizado(String ubigeoActualizado) {
        this.ubigeoActualizado = ubigeoActualizado;
    }

    public ejbCcoDrtProvincia getDrtProvincia() {
        return drtProvincia;
    }

    public void setDrtProvincia(ejbCcoDrtProvincia drtProvincia) {
        this.drtProvincia = drtProvincia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (drtDistritoPK != null ? drtDistritoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ejbCcoDrtDistrito)) {
            return false;
        }
        ejbCcoDrtDistrito other = (ejbCcoDrtDistrito) object;
        if ((this.drtDistritoPK == null && other.drtDistritoPK != null) || (this.drtDistritoPK != null && !this.drtDistritoPK.equals(other.drtDistritoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbCecomp.entidades.DrtDistrito[ drtDistritoPK=" + drtDistritoPK + " ]";
    }
    
}
