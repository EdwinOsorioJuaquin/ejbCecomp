/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejbCecomp.entidades;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

/**
 *
 * @author Jael
 */
@Embeddable
public class ejbCcoCepCecNotasPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_mta_alu")
    private int idMtaAlu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_sesio")
    private int idSesio;

    public ejbCcoCepCecNotasPK() {
    }

    public ejbCcoCepCecNotasPK(int idMtaAlu, int idSesio) {
        this.idMtaAlu = idMtaAlu;
        this.idSesio = idSesio;
    }

    public int getIdMtaAlu() {
        return idMtaAlu;
    }

    public void setIdMtaAlu(int idMtaAlu) {
        this.idMtaAlu = idMtaAlu;
    }

    public int getIdSesio() {
        return idSesio;
    }

    public void setIdSesio(int idSesio) {
        this.idSesio = idSesio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idMtaAlu;
        hash += (int) idSesio;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ejbCcoCepCecNotasPK)) {
            return false;
        }
        ejbCcoCepCecNotasPK other = (ejbCcoCepCecNotasPK) object;
        if (this.idMtaAlu != other.idMtaAlu) {
            return false;
        }
        if (this.idSesio != other.idSesio) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbCecomp.entidades.CepCecNotasPK[ idMtaAlu=" + idMtaAlu + ", idSesio=" + idSesio + " ]";
    }
    
}
