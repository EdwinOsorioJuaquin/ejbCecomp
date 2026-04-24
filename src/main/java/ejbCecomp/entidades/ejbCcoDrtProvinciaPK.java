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
public class ejbCcoDrtProvinciaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pais")
    private int idPais;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_dpto")
    private int idDpto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_prov")
    private int idProv;

    public ejbCcoDrtProvinciaPK() {
    }

    public ejbCcoDrtProvinciaPK(int idPais, int idDpto, int idProv) {
        this.idPais = idPais;
        this.idDpto = idDpto;
        this.idProv = idProv;
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

    public int getIdProv() {
        return idProv;
    }

    public void setIdProv(int idProv) {
        this.idProv = idProv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPais;
        hash += (int) idDpto;
        hash += (int) idProv;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ejbCcoDrtProvinciaPK)) {
            return false;
        }
        ejbCcoDrtProvinciaPK other = (ejbCcoDrtProvinciaPK) object;
        if (this.idPais != other.idPais) {
            return false;
        }
        if (this.idDpto != other.idDpto) {
            return false;
        }
        if (this.idProv != other.idProv) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbCecomp.entidades.DrtProvinciaPK[ idPais=" + idPais + ", idDpto=" + idDpto + ", idProv=" + idProv + " ]";
    }
    
}
