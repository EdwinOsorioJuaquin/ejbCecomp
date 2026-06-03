package ejbCecomp.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "VwCecompPagos")
@Table(name = "VW_CECOMP_PAGOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VwCecompPagos.findAll", query = "SELECT v FROM VwCecompPagos v"),
    @NamedQuery(name = "VwCecompPagos.findByIdNumPago", query = "SELECT v FROM VwCecompPagos v WHERE v.idNumPago = :idNumPago"),
})
public class ejbCcoVwCecompPagos implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_num_pago")
    private Integer idNumPago;
    
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
    
    @Column(name = "codigo_alu")
    private Integer codigoAlu;
    
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
    
    @Size(max = 182)
    @Column(name = "estudiante")
    private String estudiante;

    public ejbCcoVwCecompPagos() {
    }

    public ejbCcoVwCecompPagos(Integer idNumPago) {
        this.idNumPago = idNumPago;
    }

    // Getters y Setters
    public Integer getIdNumPago() {
        return idNumPago;
    }

    public void setIdNumPago(Integer idNumPago) {
        this.idNumPago = idNumPago;
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

    public Integer getCodigoAlu() {
        return codigoAlu;
    }

    public void setCodigoAlu(Integer codigoAlu) {
        this.codigoAlu = codigoAlu;
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

    public String getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(String estudiante) {
        this.estudiante = estudiante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNumPago != null ? idNumPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof ejbCcoVwCecompPagos)) {
            return false;
        }
        ejbCcoVwCecompPagos other = (ejbCcoVwCecompPagos) object;
        if ((this.idNumPago == null && other.idNumPago != null) || 
            (this.idNumPago != null && !this.idNumPago.equals(other.idNumPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbCecomp.entidades.VwCecompPagos[ idNumPago=" + idNumPago + " ]";
    }
}