/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejbCecomp.entidades;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Entity(name="RcdVoucher")
@Table(name = "rcd_voucher")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RcdVoucher.findAll", query = "SELECT r FROM RcdVoucher r"),
    @NamedQuery(name = "RcdVoucher.findByIdVoucher", query = "SELECT r FROM RcdVoucher r WHERE r.idVoucher = :idVoucher"),
    @NamedQuery(name = "RcdVoucher.findByCodUnidadRecaudadora", query = "SELECT r FROM RcdVoucher r WHERE r.codUnidadRecaudadora = :codUnidadRecaudadora"),
    @NamedQuery(name = "RcdVoucher.findByCodAlumno", query = "SELECT r FROM RcdVoucher r WHERE r.codAlumno = :codAlumno"),
    @NamedQuery(name = "RcdVoucher.findBySecuencia", query = "SELECT r FROM RcdVoucher r WHERE r.secuencia = :secuencia"),
    @NamedQuery(name = "RcdVoucher.findByTipoDocumento", query = "SELECT r FROM RcdVoucher r WHERE r.tipoDocumento = :tipoDocumento"),
    @NamedQuery(name = "RcdVoucher.findBySituacion", query = "SELECT r FROM RcdVoucher r WHERE r.situacion = :situacion"),
    @NamedQuery(name = "RcdVoucher.findByConcepto", query = "SELECT r FROM RcdVoucher r WHERE r.concepto = :concepto"),
    @NamedQuery(name = "RcdVoucher.findByTipoPersona", query = "SELECT r FROM RcdVoucher r WHERE r.tipoPersona = :tipoPersona"),
    @NamedQuery(name = "RcdVoucher.findBySede", query = "SELECT r FROM RcdVoucher r WHERE r.sede = :sede"),
    @NamedQuery(name = "RcdVoucher.findByNumDocumento", query = "SELECT r FROM RcdVoucher r WHERE r.numDocumento = :numDocumento"),
    @NamedQuery(name = "RcdVoucher.findByImportePagado", query = "SELECT r FROM RcdVoucher r WHERE r.importePagado = :importePagado"),
    @NamedQuery(name = "RcdVoucher.findByTipoPago", query = "SELECT r FROM RcdVoucher r WHERE r.tipoPago = :tipoPago"),
    @NamedQuery(name = "RcdVoucher.findByFormaPago", query = "SELECT r FROM RcdVoucher r WHERE r.formaPago = :formaPago"),
    @NamedQuery(name = "RcdVoucher.findByFechaPago", query = "SELECT r FROM RcdVoucher r WHERE r.fechaPago = :fechaPago"),
    @NamedQuery(name = "RcdVoucher.findByHoraPago", query = "SELECT r FROM RcdVoucher r WHERE r.horaPago = :horaPago"),
    @NamedQuery(name = "RcdVoucher.findByCodCajero", query = "SELECT r FROM RcdVoucher r WHERE r.codCajero = :codCajero"),
    @NamedQuery(name = "RcdVoucher.findByCodAgencia", query = "SELECT r FROM RcdVoucher r WHERE r.codAgencia = :codAgencia"),
    @NamedQuery(name = "RcdVoucher.findByNumCheque", query = "SELECT r FROM RcdVoucher r WHERE r.numCheque = :numCheque"),
    @NamedQuery(name = "RcdVoucher.findByCodBanco", query = "SELECT r FROM RcdVoucher r WHERE r.codBanco = :codBanco"),
    @NamedQuery(name = "RcdVoucher.findByCondicion", query = "SELECT r FROM RcdVoucher r WHERE r.condicion = :condicion"),
    @NamedQuery(name = "RcdVoucher.findByFechaEnvio", query = "SELECT r FROM RcdVoucher r WHERE r.fechaEnvio = :fechaEnvio"),
    @NamedQuery(name = "RcdVoucher.findByNombre", query = "SELECT r FROM RcdVoucher r WHERE r.nombre = :nombre"),
    @NamedQuery(name = "RcdVoucher.findByCuenta", query = "SELECT r FROM RcdVoucher r WHERE r.cuenta = :cuenta"),
    @NamedQuery(name = "RcdVoucher.findByEstado", query = "SELECT r FROM RcdVoucher r WHERE r.estado = :estado"),
    @NamedQuery(name = "RcdVoucher.findByFechaUso", query = "SELECT r FROM RcdVoucher r WHERE r.fechaUso = :fechaUso"),
    @NamedQuery(name = "RcdVoucher.findByIdAcper", query = "SELECT r FROM RcdVoucher r WHERE r.idAcper = :idAcper"),
    @NamedQuery(name = "RcdVoucher.findByIdActiva", query = "SELECT r FROM RcdVoucher r WHERE r.idActiva = :idActiva"),
    @NamedQuery(name = "RcdVoucher.findByFechaActivacion", query = "SELECT r FROM RcdVoucher r WHERE r.fechaActivacion = :fechaActivacion")})
public class ejbCcoRcdVoucher implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_voucher")
    private Integer idVoucher;
    @Size(max = 20)
    @Column(name = "cod_unidad_recaudadora")
    private String codUnidadRecaudadora;
    @Size(max = 20)
    @Column(name = "cod_alumno")
    private String codAlumno;
    @Size(max = 20)
    @Column(name = "secuencia")
    private String secuencia;
    @Size(max = 20)
    @Column(name = "tipo_documento")
    private String tipoDocumento;
    @Size(max = 20)
    @Column(name = "situacion")
    private String situacion;
    @Size(max = 20)
    @Column(name = "concepto")
    private String concepto;
    @Size(max = 20)
    @Column(name = "tipo_persona")
    private String tipoPersona;
    @Size(max = 20)
    @Column(name = "sede")
    private String sede;
    @Size(max = 20)
    @Column(name = "num_documento")
    private String numDocumento;
    @Size(max = 20)
    @Column(name = "importe_pagado")
    private String importePagado;
    @Size(max = 20)
    @Column(name = "tipo_pago")
    private String tipoPago;
    @Size(max = 20)
    @Column(name = "forma_pago")
    private String formaPago;
    @Size(max = 20)
    @Column(name = "fecha_pago")
    private String fechaPago;
    @Size(max = 20)
    @Column(name = "hora_pago")
    private String horaPago;
    @Size(max = 20)
    @Column(name = "cod_cajero")
    private String codCajero;
    @Size(max = 20)
    @Column(name = "cod_agencia")
    private String codAgencia;
    @Size(max = 20)
    @Column(name = "num_cheque")
    private String numCheque;
    @Size(max = 20)
    @Column(name = "cod_banco")
    private String codBanco;
    @Size(max = 20)
    @Column(name = "condicion")
    private String condicion;
    @Size(max = 20)
    @Column(name = "fecha_envio")
    private String fechaEnvio;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 20)
    @Column(name = "cuenta")
    private String cuenta;
    @Size(max = 20)
    @Column(name = "estado")
    private String estado;
    @Size(max = 20)
    @Column(name = "fecha_uso")
    private String fechaUso;
    @Size(max = 20)
    @Column(name = "id_acper")
    private String idAcper;
    @Size(max = 20)
    @Column(name = "id_activa")
    private String idActiva;
    @Size(max = 20)
    @Column(name = "fecha_activacion")
    private String fechaActivacion;
    @OneToMany(mappedBy = "rcdVoucher")
    private List<ejbCcoCepPagos> cepPagosList;
    @JoinColumn(name = "id_concepto", referencedColumnName = "id_concepto")
    @ManyToOne
    private ejbCcoRcdConcepto rcdConcepto;

    public ejbCcoRcdVoucher() {
    }

    public ejbCcoRcdVoucher(Integer idVoucher) {
        this.idVoucher = idVoucher;
    }

    public Integer getIdVoucher() {
        return idVoucher;
    }

    public void setIdVoucher(Integer idVoucher) {
        this.idVoucher = idVoucher;
    }

    public String getCodUnidadRecaudadora() {
        return codUnidadRecaudadora;
    }

    public void setCodUnidadRecaudadora(String codUnidadRecaudadora) {
        this.codUnidadRecaudadora = codUnidadRecaudadora;
    }

    public String getCodAlumno() {
        return codAlumno;
    }

    public void setCodAlumno(String codAlumno) {
        this.codAlumno = codAlumno;
    }

    public String getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(String secuencia) {
        this.secuencia = secuencia;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getImportePagado() {
        return importePagado;
    }

    public void setImportePagado(String importePagado) {
        this.importePagado = importePagado;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getHoraPago() {
        return horaPago;
    }

    public void setHoraPago(String horaPago) {
        this.horaPago = horaPago;
    }

    public String getCodCajero() {
        return codCajero;
    }

    public void setCodCajero(String codCajero) {
        this.codCajero = codCajero;
    }

    public String getCodAgencia() {
        return codAgencia;
    }

    public void setCodAgencia(String codAgencia) {
        this.codAgencia = codAgencia;
    }

    public String getNumCheque() {
        return numCheque;
    }

    public void setNumCheque(String numCheque) {
        this.numCheque = numCheque;
    }

    public String getCodBanco() {
        return codBanco;
    }

    public void setCodBanco(String codBanco) {
        this.codBanco = codBanco;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public String getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(String fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaUso() {
        return fechaUso;
    }

    public void setFechaUso(String fechaUso) {
        this.fechaUso = fechaUso;
    }

    public String getIdAcper() {
        return idAcper;
    }

    public void setIdAcper(String idAcper) {
        this.idAcper = idAcper;
    }

    public String getIdActiva() {
        return idActiva;
    }

    public void setIdActiva(String idActiva) {
        this.idActiva = idActiva;
    }

    public String getFechaActivacion() {
        return fechaActivacion;
    }

    public void setFechaActivacion(String fechaActivacion) {
        this.fechaActivacion = fechaActivacion;
    }

    @XmlTransient
    public List<ejbCcoCepPagos> getCepPagosList() {
        return cepPagosList;
    }

    public void setCepPagosList(List<ejbCcoCepPagos> cepPagosList) {
        this.cepPagosList = cepPagosList;
    }

    public ejbCcoRcdConcepto getRcdConcepto() {
        return rcdConcepto;
    }

    public void setRcdConcepto(ejbCcoRcdConcepto rcdConcepto) {
        this.rcdConcepto = rcdConcepto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVoucher != null ? idVoucher.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ejbCcoRcdVoucher)) {
            return false;
        }
        ejbCcoRcdVoucher other = (ejbCcoRcdVoucher) object;
        if ((this.idVoucher == null && other.idVoucher != null) || (this.idVoucher != null && !this.idVoucher.equals(other.idVoucher))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbCecomp.entidades.RcdVoucher[ idVoucher=" + idVoucher + " ]";
    }
    
}
