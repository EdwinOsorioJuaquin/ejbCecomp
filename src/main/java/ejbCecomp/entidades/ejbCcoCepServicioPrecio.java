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
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Jael
 */
@Entity(name="CepServicioPrecio")
@Table(name = "cep_servicio_precio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CepServicioPrecio.findAll", query = "SELECT c FROM CepServicioPrecio c"),
    @NamedQuery(name = "CepServicioPrecio.findByIdServicioPrecio", query = "SELECT c FROM CepServicioPrecio c WHERE c.idServicioPrecio = :idServicioPrecio"),
    @NamedQuery(name = "CepServicioPrecio.findByTipoServicio", query = "SELECT c FROM CepServicioPrecio c WHERE c.tipoServicio = :tipoServicio"),
    @NamedQuery(name = "CepServicioPrecio.findByTipoAlumno", query = "SELECT c FROM CepServicioPrecio c WHERE c.tipoAlumno = :tipoAlumno"),
    @NamedQuery(name = "CepServicioPrecio.findByMonto", query = "SELECT c FROM CepServicioPrecio c WHERE c.monto = :monto"),
    @NamedQuery(name = "CepServicioPrecio.findByCodigoPago", query = "SELECT c FROM CepServicioPrecio c WHERE c.codigoPago = :codigoPago"),
    @NamedQuery(name = "CepServicioPrecio.findByFechaRegistro", query = "SELECT c FROM CepServicioPrecio c WHERE c.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "CepServicioPrecio.findByActivo", query = "SELECT c FROM CepServicioPrecio c WHERE c.activo = :activo")})
public class ejbCcoCepServicioPrecio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_servicio_precio")
    private Integer idServicioPrecio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tipo_servicio")
    private String tipoServicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "tipo_alumno")
    private String tipoAlumno;
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
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo")
    private boolean activo;

    public ejbCcoCepServicioPrecio() {
    }

    public ejbCcoCepServicioPrecio(Integer idServicioPrecio) {
        this.idServicioPrecio = idServicioPrecio;
    }

    public ejbCcoCepServicioPrecio(Integer idServicioPrecio, String tipoServicio, String tipoAlumno, BigDecimal monto, String codigoPago, boolean activo) {
        this.idServicioPrecio = idServicioPrecio;
        this.tipoServicio = tipoServicio;
        this.tipoAlumno = tipoAlumno;
        this.monto = monto;
        this.codigoPago = codigoPago;
        this.activo = activo;
    }

    public Integer getIdServicioPrecio() {
        return idServicioPrecio;
    }

    public void setIdServicioPrecio(Integer idServicioPrecio) {
        this.idServicioPrecio = idServicioPrecio;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getTipoAlumno() {
        return tipoAlumno;
    }

    public void setTipoAlumno(String tipoAlumno) {
        this.tipoAlumno = tipoAlumno;
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

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idServicioPrecio != null ? idServicioPrecio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ejbCcoCepServicioPrecio)) {
            return false;
        }
        ejbCcoCepServicioPrecio other = (ejbCcoCepServicioPrecio) object;
        if ((this.idServicioPrecio == null && other.idServicioPrecio != null) || (this.idServicioPrecio != null && !this.idServicioPrecio.equals(other.idServicioPrecio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbCecomp.entidades.CepServicioPrecio[ idServicioPrecio=" + idServicioPrecio + " ]";
    }
    
}
