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
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Jael
 */
@Entity(name = "CepPagos")
@Table(name = "cep_pagos")
@NamedQueries({
    @NamedQuery(name = "CepPagos.findAll", query = "SELECT c FROM CepPagos c"),
    @NamedQuery(name = "CepPagos.findByIdNumPago", query = "SELECT c FROM CepPagos c WHERE c.idNumPago = :idNumPago"),
    @NamedQuery(name = "CepPagos.findByCodigoAlu", query = "SELECT c FROM CepPagos c WHERE c.codigoAlu = :codigoAlu"),
    @NamedQuery(name = "CepPagos.findByIdDep", query = "SELECT c FROM CepPagos c WHERE c.idDep = :idDep"),
    @NamedQuery(name = "CepPagos.findByFecha", query = "SELECT c FROM CepPagos c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "CepPagos.findByMonto", query = "SELECT c FROM CepPagos c WHERE c.monto = :monto"),
    @NamedQuery(name = "CepPagos.findBySaldo", query = "SELECT c FROM CepPagos c WHERE c.saldo = :saldo"),
    @NamedQuery(name = "CepPagos.findByAnio", query = "SELECT c FROM CepPagos c WHERE c.anio = :anio"),
    @NamedQuery(name = "CepPagos.findByObservacion", query = "SELECT c FROM CepPagos c WHERE c.observacion = :observacion"),
    @NamedQuery(name = "CepPagos.findByFechaHist", query = "SELECT c FROM CepPagos c WHERE c.fechaHist = :fechaHist")})
public class ejbCcoCepPagos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_num_pago")
    private Integer idNumPago;
    @Column(name = "codigo_alu")
    private Integer codigoAlu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_dep")
    private int idDep;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "monto")
    private Integer monto;
    @Column(name = "saldo")
    private Integer saldo;
    @Column(name = "anio")
    private Short anio;
    @Size(max = 200)
    @Column(name = "observacion")
    private String observacion;
    @Column(name = "fecha_hist")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHist;
    @JoinColumn(name = "id_mta_alu", referencedColumnName = "id_mta_alu")
    @ManyToOne
    private ejbCcoCepCcoMatriculaCab cepCcoMatriculaCab;
//    @JoinColumn(name = "id_cert", referencedColumnName = "id_cert")
//    @ManyToOne
//    private ejbCcoCepCecCert cepCecCert;
    @JoinColumn(name = "id_dir", referencedColumnName = "id_dir")
    @ManyToOne(optional = false)
    private ejbCcoDrtPersonanatural drtPersonanatural;
    @JoinColumn(name = "id_voucher", referencedColumnName = "id_voucher")
    @ManyToOne
    private ejbCcoRcdVoucher rcdVoucher;

    public ejbCcoCepPagos() {
    }

    public ejbCcoCepPagos(Integer idNumPago) {
        this.idNumPago = idNumPago;
    }

    public ejbCcoCepPagos(Integer idNumPago, int idDep) {
        this.idNumPago = idNumPago;
        this.idDep = idDep;
    }

    public Integer getIdNumPago() {
        return idNumPago;
    }

    public void setIdNumPago(Integer idNumPago) {
        this.idNumPago = idNumPago;
    }

    public Integer getCodigoAlu() {
        return codigoAlu;
    }

    public void setCodigoAlu(Integer codigoAlu) {
        this.codigoAlu = codigoAlu;
    }

    public int getIdDep() {
        return idDep;
    }

    public void setIdDep(int idDep) {
        this.idDep = idDep;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

    public Short getAnio() {
        return anio;
    }

    public void setAnio(Short anio) {
        this.anio = anio;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Date getFechaHist() {
        return fechaHist;
    }

    public void setFechaHist(Date fechaHist) {
        this.fechaHist = fechaHist;
    }

    public ejbCcoCepCcoMatriculaCab getCepCcoMatriculaCab() {
        return cepCcoMatriculaCab;
    }

    public void setCepCcoMatriculaCab(ejbCcoCepCcoMatriculaCab cepCcoMatriculaCab) {
        this.cepCcoMatriculaCab = cepCcoMatriculaCab;
    }

//    public ejbCcoCepCecCert getCepCecCert() {
//        return cepCecCert;
//    }
//
//    public void setCepCecCert(ejbCcoCepCecCert cepCecCert) {
//        this.cepCecCert = cepCecCert;
//    }

    public ejbCcoDrtPersonanatural getDrtPersonanatural() {
        return drtPersonanatural;
    }

    public void setDrtPersonanatural(ejbCcoDrtPersonanatural drtPersonanatural) {
        this.drtPersonanatural = drtPersonanatural;
    }

    public ejbCcoRcdVoucher getRcdVoucher() {
        return rcdVoucher;
    }

    public void setRcdVoucher(ejbCcoRcdVoucher rcdVoucher) {
        this.rcdVoucher = rcdVoucher;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNumPago != null ? idNumPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ejbCcoCepPagos)) {
            return false;
        }
        ejbCcoCepPagos other = (ejbCcoCepPagos) object;
        if ((this.idNumPago == null && other.idNumPago != null) || (this.idNumPago != null && !this.idNumPago.equals(other.idNumPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbCecomp.entidades.CepPagos[ idNumPago=" + idNumPago + " ]";
    }
    
}
