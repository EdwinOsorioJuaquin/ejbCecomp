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
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Jael
 */
@Entity(name="CepCecCert")
@Table(name = "cep_cec_cert")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CepCecCert.findAll", query = "SELECT c FROM CepCecCert c"),
    @NamedQuery(name = "CepCecCert.findByIdCert", query = "SELECT c FROM CepCecCert c WHERE c.idCert = :idCert"),
    @NamedQuery(name = "CepCecCert.findByFechaCert", query = "SELECT c FROM CepCecCert c WHERE c.fechaCert = :fechaCert"),
    @NamedQuery(name = "CepCecCert.findByEstadoCert", query = "SELECT c FROM CepCecCert c WHERE c.estadoCert = :estadoCert"),
    @NamedQuery(name = "CepCecCert.findByResol", query = "SELECT c FROM CepCecCert c WHERE c.resol = :resol")})
public class ejbCcoCepCecCert implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cert")
    private Integer idCert;
    @Column(name = "fecha_cert")
    @Temporal(TemporalType.DATE)
    private Date fechaCert;
    @Column(name = "estado_cert")
    private Boolean estadoCert;
    @Column(name = "resol")
    private Integer resol;
    @JoinColumn(name = "id_mta_alu", referencedColumnName = "id_mta_alu")
    @ManyToOne(optional = false)
    private ejbCcoCepCcoMatriculaCab idMtaAlu;

    public ejbCcoCepCecCert() {
    }

    public ejbCcoCepCecCert(Integer idCert) {
        this.idCert = idCert;
    }

    public Integer getIdCert() {
        return idCert;
    }

    public void setIdCert(Integer idCert) {
        this.idCert = idCert;
    }

    public Date getFechaCert() {
        return fechaCert;
    }

    public void setFechaCert(Date fechaCert) {
        this.fechaCert = fechaCert;
    }

    public Boolean getEstadoCert() {
        return estadoCert;
    }

    public void setEstadoCert(Boolean estadoCert) {
        this.estadoCert = estadoCert;
    }

    public Integer getResol() {
        return resol;
    }

    public void setResol(Integer resol) {
        this.resol = resol;
    }

    public ejbCcoCepCcoMatriculaCab getIdMtaAlu() {
        return idMtaAlu;
    }

    public void setIdMtaAlu(ejbCcoCepCcoMatriculaCab idMtaAlu) {
        this.idMtaAlu = idMtaAlu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCert != null ? idCert.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ejbCcoCepCecCert)) {
            return false;
        }
        ejbCcoCepCecCert other = (ejbCcoCepCecCert) object;
        if ((this.idCert == null && other.idCert != null) || (this.idCert != null && !this.idCert.equals(other.idCert))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbCecomp.entidades.CepCecCert[ idCert=" + idCert + " ]";
    }
    
}
