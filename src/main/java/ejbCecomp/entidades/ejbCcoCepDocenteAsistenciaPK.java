/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejbCecomp.entidades;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Jael
 */
@Embeddable
public class ejbCcoCepDocenteAsistenciaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_hora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date idHora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date idFecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_personal")
    private int idPersonal;

    public ejbCcoCepDocenteAsistenciaPK() {
    }

    public ejbCcoCepDocenteAsistenciaPK(Date idHora, Date idFecha, int idPersonal) {
        this.idHora = idHora;
        this.idFecha = idFecha;
        this.idPersonal = idPersonal;
    }

    public Date getIdHora() {
        return idHora;
    }

    public void setIdHora(Date idHora) {
        this.idHora = idHora;
    }

    public Date getIdFecha() {
        return idFecha;
    }

    public void setIdFecha(Date idFecha) {
        this.idFecha = idFecha;
    }

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHora != null ? idHora.hashCode() : 0);
        hash += (idFecha != null ? idFecha.hashCode() : 0);
        hash += (int) idPersonal;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ejbCcoCepDocenteAsistenciaPK)) {
            return false;
        }
        ejbCcoCepDocenteAsistenciaPK other = (ejbCcoCepDocenteAsistenciaPK) object;
        if ((this.idHora == null && other.idHora != null) || (this.idHora != null && !this.idHora.equals(other.idHora))) {
            return false;
        }
        if ((this.idFecha == null && other.idFecha != null) || (this.idFecha != null && !this.idFecha.equals(other.idFecha))) {
            return false;
        }
        if (this.idPersonal != other.idPersonal) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbCecomp.entidades.CepDocenteAsistenciaPK[ idHora=" + idHora + ", idFecha=" + idFecha + ", idPersonal=" + idPersonal + " ]";
    }
    
}
