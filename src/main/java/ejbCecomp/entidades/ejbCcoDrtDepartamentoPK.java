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
public class ejbCcoDrtDepartamentoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pais")
    private int idPais;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_dpto")
    private int idDpto;

    public ejbCcoDrtDepartamentoPK() {
    }

    public ejbCcoDrtDepartamentoPK(int idPais, int idDpto) {
        this.idPais = idPais;
        this.idDpto = idDpto;
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public int getIdDpto() {
        return idDpto;
    }

    public void setIdDpto(int idDpto) {
        this.idDpto = idDpto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPais;
        hash += (int) idDpto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ejbCcoDrtDepartamentoPK)) {
            return false;
        }
        ejbCcoDrtDepartamentoPK other = (ejbCcoDrtDepartamentoPK) object;
        if (this.idPais != other.idPais) {
            return false;
        }
        if (this.idDpto != other.idDpto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbCecomp.entidades.DrtDepartamentoPK[ idPais=" + idPais + ", idDpto=" + idDpto + " ]";
    }
    
}
