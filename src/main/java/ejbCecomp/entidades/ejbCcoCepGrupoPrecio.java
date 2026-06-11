/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejbCecomp.entidades;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Entity(name="CepGrupoPrecio")
@Table(name = "cep_grupo_precio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CepGrupoPrecio.findAll", query = "SELECT c FROM CepGrupoPrecio c"),
    @NamedQuery(name = "CepGrupoPrecio.findByIdGrupoPrecio", query = "SELECT c FROM CepGrupoPrecio c WHERE c.idGrupoPrecio = :idGrupoPrecio"),
    @NamedQuery(name = "CepGrupoPrecio.findByMonto", query = "SELECT c FROM CepGrupoPrecio c WHERE c.monto = :monto"),
    @NamedQuery(name = "CepGrupoPrecio.findByCodigoPago", query = "SELECT c FROM CepGrupoPrecio c WHERE c.codigoPago = :codigoPago")})
public class ejbCcoCepGrupoPrecio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_grupo_precio")
    private Integer idGrupoPrecio;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto")
    private BigDecimal monto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "codigo_pago")
    private String codigoPago;
    @ManyToOne
    @JoinColumn(name = "id_ad")
    private ejbCcoCepCursoDocente cepCursoDocente;

    public ejbCcoCepGrupoPrecio() {
    }

    public ejbCcoCepGrupoPrecio(Integer idGrupoPrecio) {
        this.idGrupoPrecio = idGrupoPrecio;
    }

    public ejbCcoCepGrupoPrecio(Integer idGrupoPrecio, BigDecimal monto, String codigoPago) {
        this.idGrupoPrecio = idGrupoPrecio;
        this.monto = monto;
        this.codigoPago = codigoPago;
    }

    public Integer getIdGrupoPrecio() {
        return idGrupoPrecio;
    }

    public void setIdGrupoPrecio(Integer idGrupoPrecio) {
        this.idGrupoPrecio = idGrupoPrecio;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getCodigoPago() {
        return codigoPago;
    }

    public void setCodigoPago(String codigoPago) {
        this.codigoPago = codigoPago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGrupoPrecio != null ? idGrupoPrecio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ejbCcoCepGrupoPrecio)) {
            return false;
        }
        ejbCcoCepGrupoPrecio other = (ejbCcoCepGrupoPrecio) object;
        if ((this.idGrupoPrecio == null && other.idGrupoPrecio != null) || (this.idGrupoPrecio != null && !this.idGrupoPrecio.equals(other.idGrupoPrecio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbCecomp.entidades.CepGrupoPrecio[ idGrupoPrecio=" + idGrupoPrecio + " ]";
    }
    
}
