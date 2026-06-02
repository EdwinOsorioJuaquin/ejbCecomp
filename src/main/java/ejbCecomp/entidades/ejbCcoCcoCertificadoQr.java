/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejbCecomp.entidades;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Edwin
 */
@Entity(name = "CcoCertificadoQr")
@Table(name = "cco_certificado_qr")
@NamedQueries({
    @NamedQuery(name = "CcoCertificadoQr.findAll", query = "SELECT c FROM CcoCertificadoQr c"),
    @NamedQuery(name = "CcoCertificadoQr.findByIdQr", query = "SELECT c FROM CcoCertificadoQr c WHERE c.idQr = :idQr"),
    @NamedQuery(name = "CcoCertificadoQr.findByCodigoQr", query = "SELECT c FROM CcoCertificadoQr c WHERE c.codigoQr = :codigoQr"),
    @NamedQuery(name = "CcoCertificadoQr.findByFechaGeneracion", query = "SELECT c FROM CcoCertificadoQr c WHERE c.fechaGeneracion = :fechaGeneracion"),
    @NamedQuery(name = "CcoCertificadoQr.findByIdCertificado", query = "SELECT c FROM CcoCertificadoQr c WHERE c.idCertificado = :idCertificado")})
public class ejbCcoCcoCertificadoQr implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_qr")
    private Integer idQr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "codigo_qr")
    private String codigoQr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "url_validacion")
    private String urlValidacion;
    @Column(name = "fecha_generacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaGeneracion;
    @Size(max = 20)
    @Column(name = "estado")
    private String estado;

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "qr_imagen")
    private byte[] qrImagen;
    
    @JoinColumn(name = "id_certificado", referencedColumnName = "id_cert")
    @ManyToOne(optional = false)
    private ejbCcoCepCecCert idCertificado;

    public ejbCcoCcoCertificadoQr() {
    }

    public ejbCcoCcoCertificadoQr(Integer idQr) {
        this.idQr = idQr;
    }

    public ejbCcoCcoCertificadoQr(Integer idQr, String codigoQr, String urlValidacion) {
        this.idQr = idQr;
        this.codigoQr = codigoQr;
        this.urlValidacion = urlValidacion;
    }

    public Integer getIdQr() {
        return idQr;
    }

    public void setIdQr(Integer idQr) {
        this.idQr = idQr;
    }

    public String getCodigoQr() {
        return codigoQr;
    }

    public void setCodigoQr(String codigoQr) {
        this.codigoQr = codigoQr;
    }

    public String getUrlValidacion() {
        return urlValidacion;
    }

    public void setUrlValidacion(String urlValidacion) {
        this.urlValidacion = urlValidacion;
    }

    public Date getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(Date fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public byte[] getQrImagen() {
        return qrImagen;
    }

    public void setQrImagen(byte[] qrImagen) {
        this.qrImagen = qrImagen;
    }

    public ejbCcoCepCecCert getIdCertificado() {
        return idCertificado;
    }

    public void setIdCertificado(ejbCcoCepCecCert idCertificado) {
        this.idCertificado = idCertificado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idQr != null ? idQr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ejbCcoCcoCertificadoQr)) {
            return false;
        }
        ejbCcoCcoCertificadoQr other = (ejbCcoCcoCertificadoQr) object;
        if ((this.idQr == null && other.idQr != null) || (this.idQr != null && !this.idQr.equals(other.idQr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbCecomp.entidades.ejbCcoCcoCertificadoQr[ idQr=" + idQr + " ]";
    }

    
}
