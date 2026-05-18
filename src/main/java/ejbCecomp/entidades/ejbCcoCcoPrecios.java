/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejbCecomp.entidades;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author Jael
 */
@Entity(name = "CcoPrecios")
@Table(name = "cco_precios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CcoPrecios.findAll", query = "SELECT c FROM CcoPrecios c"),
    @NamedQuery(name = "CcoPrecios.findByIdPrecio", query = "SELECT c FROM CcoPrecios c WHERE c.idPrecio = :idPrecio"),
    @NamedQuery(name = "CcoPrecios.findByConcepto", query = "SELECT c FROM CcoPrecios c WHERE c.concepto = :concepto"),
    @NamedQuery(name = "CcoPrecios.findByTipoPrecio", query = "SELECT c FROM CcoPrecios c WHERE c.tipoPrecio = :tipoPrecio"),
    @NamedQuery(name = "CcoPrecios.findByMonto", query = "SELECT c FROM CcoPrecios c WHERE c.monto = :monto"),
    @NamedQuery(name = "CcoPrecios.findByActivo", query = "SELECT c FROM CcoPrecios c WHERE c.activo = :activo")})
public class ejbCcoCcoPrecios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_precio")
    private Integer idPrecio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "concepto")
    private String concepto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tipo_precio")
    private String tipoPrecio;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto")
    private BigDecimal monto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private short activo;

    public ejbCcoCcoPrecios() {
    }

    public ejbCcoCcoPrecios(Integer idPrecio) {
        this.idPrecio = idPrecio;
    }

    public ejbCcoCcoPrecios(Integer idPrecio, String concepto, String tipoPrecio, BigDecimal monto, short activo) {
        this.idPrecio = idPrecio;
        this.concepto = concepto;
        this.tipoPrecio = tipoPrecio;
        this.monto = monto;
        this.activo = activo;
    }

    public Integer getIdPrecio() {
        return idPrecio;
    }

    public void setIdPrecio(Integer idPrecio) {
        this.idPrecio = idPrecio;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getTipoPrecio() {
        return tipoPrecio;
    }

    public void setTipoPrecio(String tipoPrecio) {
        this.tipoPrecio = tipoPrecio;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public short getActivo() {
        return activo;
    }

    public void setActivo(short activo) {
        this.activo = activo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrecio != null ? idPrecio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ejbCcoCcoPrecios)) {
            return false;
        }
        ejbCcoCcoPrecios other = (ejbCcoCcoPrecios) object;
        if ((this.idPrecio == null && other.idPrecio != null) || (this.idPrecio != null && !this.idPrecio.equals(other.idPrecio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbCecomp.entidades.CcoPrecios[ idPrecio=" + idPrecio + " ]";
    }
    
}
