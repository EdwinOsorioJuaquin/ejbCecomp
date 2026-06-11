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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Jael
 */
@Entity(name="VtCecompPagos")
@Table(name = "vt_cecomp_pagos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VtCecompPagos.findAll", query = "SELECT v FROM VtCecompPagos v"),
    @NamedQuery(name = "VtCecompPagos.findByIdVoucher", query = "SELECT v FROM VtCecompPagos v WHERE v.idVoucher = :idVoucher"),
    @NamedQuery(name = "VtCecompPagos.findByNumDocumento", query = "SELECT v FROM VtCecompPagos v WHERE v.numDocumento = :numDocumento"),
    @NamedQuery(name = "VtCecompPagos.findByImportePagado", query = "SELECT v FROM VtCecompPagos v WHERE v.importePagado = :importePagado"),
    @NamedQuery(name = "VtCecompPagos.findByFechaPago", query = "SELECT v FROM VtCecompPagos v WHERE v.fechaPago = :fechaPago"),
    @NamedQuery(name = "VtCecompPagos.findByHoraPago", query = "SELECT v FROM VtCecompPagos v WHERE v.horaPago = :horaPago"),
    @NamedQuery(name = "VtCecompPagos.findByTipoPago", query = "SELECT v FROM VtCecompPagos v WHERE v.tipoPago = :tipoPago"),
    @NamedQuery(name = "VtCecompPagos.findByFormaPago", query = "SELECT v FROM VtCecompPagos v WHERE v.formaPago = :formaPago"),
    @NamedQuery(name = "VtCecompPagos.findByNombrePagador", query = "SELECT v FROM VtCecompPagos v WHERE v.nombrePagador = :nombrePagador"),
    @NamedQuery(name = "VtCecompPagos.findByNumCheque", query = "SELECT v FROM VtCecompPagos v WHERE v.numCheque = :numCheque"),
    @NamedQuery(name = "VtCecompPagos.findByCodBanco", query = "SELECT v FROM VtCecompPagos v WHERE v.codBanco = :codBanco"),
    @NamedQuery(name = "VtCecompPagos.findByEstadoVoucher", query = "SELECT v FROM VtCecompPagos v WHERE v.estadoVoucher = :estadoVoucher"),
    @NamedQuery(name = "VtCecompPagos.findByCodAgencia", query = "SELECT v FROM VtCecompPagos v WHERE v.codAgencia = :codAgencia"),
    @NamedQuery(name = "VtCecompPagos.findByTipoDocumento", query = "SELECT v FROM VtCecompPagos v WHERE v.tipoDocumento = :tipoDocumento"),
    @NamedQuery(name = "VtCecompPagos.findByCodAlumno", query = "SELECT v FROM VtCecompPagos v WHERE v.codAlumno = :codAlumno"),
    @NamedQuery(name = "VtCecompPagos.findByIdNumPago", query = "SELECT v FROM VtCecompPagos v WHERE v.idNumPago = :idNumPago"),
    @NamedQuery(name = "VtCecompPagos.findByFechaPagoCecomp", query = "SELECT v FROM VtCecompPagos v WHERE v.fechaPagoCecomp = :fechaPagoCecomp"),
    @NamedQuery(name = "VtCecompPagos.findByMonto", query = "SELECT v FROM VtCecompPagos v WHERE v.monto = :monto"),
    @NamedQuery(name = "VtCecompPagos.findBySaldo", query = "SELECT v FROM VtCecompPagos v WHERE v.saldo = :saldo"),
    @NamedQuery(name = "VtCecompPagos.findByObservacion", query = "SELECT v FROM VtCecompPagos v WHERE v.observacion = :observacion"),
    @NamedQuery(name = "VtCecompPagos.findByIdConcepto", query = "SELECT v FROM VtCecompPagos v WHERE v.idConcepto = :idConcepto"),
    @NamedQuery(name = "VtCecompPagos.findByNombreConcepto", query = "SELECT v FROM VtCecompPagos v WHERE v.nombreConcepto = :nombreConcepto"),
    @NamedQuery(name = "VtCecompPagos.findByTipoConcepto", query = "SELECT v FROM VtCecompPagos v WHERE v.tipoConcepto = :tipoConcepto"),
    @NamedQuery(name = "VtCecompPagos.findByApPaterno", query = "SELECT v FROM VtCecompPagos v WHERE v.apPaterno = :apPaterno"),
    @NamedQuery(name = "VtCecompPagos.findByApMaterno", query = "SELECT v FROM VtCecompPagos v WHERE v.apMaterno = :apMaterno"),
    @NamedQuery(name = "VtCecompPagos.findByNombrePersona", query = "SELECT v FROM VtCecompPagos v WHERE v.nombrePersona = :nombrePersona"),
    @NamedQuery(name = "VtCecompPagos.findByDni", query = "SELECT v FROM VtCecompPagos v WHERE v.dni = :dni"),
    @NamedQuery(name = "VtCecompPagos.findByDocumentoUtilizado", query = "SELECT v FROM VtCecompPagos v WHERE v.documentoUtilizado = :documentoUtilizado"),
    @NamedQuery(name = "VtCecompPagos.findByTipoDocumentoUtilizado", query = "SELECT v FROM VtCecompPagos v WHERE v.tipoDocumentoUtilizado = :tipoDocumentoUtilizado"),
    @NamedQuery(name = "VtCecompPagos.findByEstudiante", query = "SELECT v FROM VtCecompPagos v WHERE v.estudiante = :estudiante"),
    @NamedQuery(name = "VtCecompPagos.findByTipoAlumno", query = "SELECT v FROM VtCecompPagos v WHERE v.tipoAlumno = :tipoAlumno")})
public class ejbCcoVtCecompPagos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_voucher")
    private int idVoucher;
    @Size(max = 20)
    @Column(name = "num_documento")
    private String numDocumento;
    @Size(max = 20)
    @Column(name = "importe_pagado")
    private String importePagado;
    @Size(max = 20)
    @Column(name = "fecha_pago")
    private String fechaPago;
    @Size(max = 20)
    @Column(name = "hora_pago")
    private String horaPago;
    @Size(max = 20)
    @Column(name = "tipo_pago")
    private String tipoPago;
    @Size(max = 20)
    @Column(name = "forma_pago")
    private String formaPago;
    @Size(max = 50)
    @Column(name = "nombre_pagador")
    private String nombrePagador;
    @Size(max = 20)
    @Column(name = "num_cheque")
    private String numCheque;
    @Size(max = 20)
    @Column(name = "cod_banco")
    private String codBanco;
    @Size(max = 20)
    @Column(name = "estado_voucher")
    private String estadoVoucher;
    @Size(max = 20)
    @Column(name = "cod_agencia")
    private String codAgencia;
    @Size(max = 20)
    @Column(name = "tipo_documento")
    private String tipoDocumento;
    @Size(max = 20)
    @Column(name = "cod_alumno")
    private String codAlumno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_num_pago")
    private int idNumPago;
    @Column(name = "fecha_pago_cecomp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPagoCecomp;
    @Column(name = "monto")
    private Integer monto;
    @Column(name = "saldo")
    private Integer saldo;
    @Size(max = 200)
    @Column(name = "observacion")
    private String observacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_concepto")
    private int idConcepto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "nombre_concepto")
    private String nombreConcepto;
    @Size(max = 250)
    @Column(name = "tipo_concepto")
    private String tipoConcepto;
    @Size(max = 50)
    @Column(name = "ap_paterno")
    private String apPaterno;
    @Size(max = 50)
    @Column(name = "ap_materno")
    private String apMaterno;
    @Size(max = 80)
    @Column(name = "nombre_persona")
    private String nombrePersona;
    @Size(max = 250)
    @Column(name = "dni")
    private String dni;
    @Size(max = 20)
    @Column(name = "documento_utilizado")
    private String documentoUtilizado;
    @Size(max = 19)
    @Column(name = "tipo_documento_utilizado")
    private String tipoDocumentoUtilizado;
    @Size(max = 182)
    @Column(name = "estudiante")
    private String estudiante;
    @Size(max = 7)
    @Column(name = "tipo_alumno")
    private String tipoAlumno;
    @Size(max = 20)
    @Column(name = "concepto")
    private String concepto;

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public ejbCcoVtCecompPagos() {
    }

    public int getIdVoucher() {
        return idVoucher;
    }

    public void setIdVoucher(int idVoucher) {
        this.idVoucher = idVoucher;
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

    public String getNombrePagador() {
        return nombrePagador;
    }

    public void setNombrePagador(String nombrePagador) {
        this.nombrePagador = nombrePagador;
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

    public String getEstadoVoucher() {
        return estadoVoucher;
    }

    public void setEstadoVoucher(String estadoVoucher) {
        this.estadoVoucher = estadoVoucher;
    }

    public String getCodAgencia() {
        return codAgencia;
    }

    public void setCodAgencia(String codAgencia) {
        this.codAgencia = codAgencia;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getCodAlumno() {
        return codAlumno;
    }

    public void setCodAlumno(String codAlumno) {
        this.codAlumno = codAlumno;
    }

    public int getIdNumPago() {
        return idNumPago;
    }

    public void setIdNumPago(int idNumPago) {
        this.idNumPago = idNumPago;
    }

    public Date getFechaPagoCecomp() {
        return fechaPagoCecomp;
    }

    public void setFechaPagoCecomp(Date fechaPagoCecomp) {
        this.fechaPagoCecomp = fechaPagoCecomp;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getIdConcepto() {
        return idConcepto;
    }

    public void setIdConcepto(int idConcepto) {
        this.idConcepto = idConcepto;
    }

    public String getNombreConcepto() {
        return nombreConcepto;
    }

    public void setNombreConcepto(String nombreConcepto) {
        this.nombreConcepto = nombreConcepto;
    }

    public String getTipoConcepto() {
        return tipoConcepto;
    }

    public void setTipoConcepto(String tipoConcepto) {
        this.tipoConcepto = tipoConcepto;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDocumentoUtilizado() {
        return documentoUtilizado;
    }

    public void setDocumentoUtilizado(String documentoUtilizado) {
        this.documentoUtilizado = documentoUtilizado;
    }

    public String getTipoDocumentoUtilizado() {
        return tipoDocumentoUtilizado;
    }

    public void setTipoDocumentoUtilizado(String tipoDocumentoUtilizado) {
        this.tipoDocumentoUtilizado = tipoDocumentoUtilizado;
    }

    public String getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(String estudiante) {
        this.estudiante = estudiante;
    }

    public String getTipoAlumno() {
        return tipoAlumno;
    }

    public void setTipoAlumno(String tipoAlumno) {
        this.tipoAlumno = tipoAlumno;
    }
    
}
