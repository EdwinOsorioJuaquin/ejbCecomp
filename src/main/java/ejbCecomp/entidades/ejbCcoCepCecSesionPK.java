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
public class ejbCcoCepCecSesionPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_sesio")
    private int idSesio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pland")
    private int idPland;

    public ejbCcoCepCecSesionPK() {
    }

    public ejbCcoCepCecSesionPK(int idSesio, int idPland) {
        this.idSesio = idSesio;
        this.idPland = idPland;
    }

    public int getIdSesio() {
        return idSesio;
    }

    public void setIdSesio(int idSesio) {
        this.idSesio = idSesio;
    }

    public int getIdPland() {
        return idPland;
    }

    public void setIdPland(int idPland) {
        this.idPland = idPland;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idSesio;
        hash += (int) idPland;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ejbCcoCepCecSesionPK)) {
            return false;
        }
        ejbCcoCepCecSesionPK other = (ejbCcoCepCecSesionPK) object;
        if (this.idSesio != other.idSesio) {
            return false;
        }
        if (this.idPland != other.idPland) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbCecomp.entidades.CepCecSesionPK[ idSesio=" + idSesio + ", idPland=" + idPland + " ]";
    }
    
}
