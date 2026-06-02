/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejbCecomp.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author Jael
 */
@Entity(name="CepCecSesion")
@Table(name = "cep_cec_sesion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CepCecSesion.findAll", query = "SELECT s FROM CepCecSesion s"),
    @NamedQuery(name = "CepCecSesion.findByIdSesio", query = "SELECT s FROM CepCecSesion s WHERE s.ejbCcoCepCecSesionPK.idSesio = :idSesio"),
    @NamedQuery(name = "CepCecSesion.findByIdPland", query = "SELECT s FROM CepCecSesion s WHERE s.ejbCcoCepCecSesionPK.idPland = :idPland"),
    @NamedQuery(name = "CepCecSesion.findByEstadoSesion", query = "SELECT s FROM CepCecSesion s WHERE s.estadoSesion = :estadoSesion"),
    @NamedQuery(name = "CepCecSesion.findByNombreSesion", query = "SELECT s FROM CepCecSesion s WHERE s.nombreSesion = :nombreSesion")
})
public class ejbCcoCepCecSesion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ejbCcoCepCecSesionPK ejbCcoCepCecSesionPK;
    @Column(name = "estado_sesion")
    private Boolean estadoSesion;
    @Size(max = 100)
    @Column(name = "nombre_sesion")
    private String nombreSesion;

    public ejbCcoCepCecSesion() {
    }

    public ejbCcoCepCecSesion(ejbCcoCepCecSesionPK ejbCcoCepCecSesionPK) {
        this.ejbCcoCepCecSesionPK = ejbCcoCepCecSesionPK;
    }

    public ejbCcoCepCecSesion(int idSesio, int idPland) {
        this.ejbCcoCepCecSesionPK = new ejbCcoCepCecSesionPK(idSesio, idPland);
    }

    public ejbCcoCepCecSesionPK getEjbCcoCepCecSesionPK() {
        return ejbCcoCepCecSesionPK;
    }

    public void setEjbCcoCepCecSesionPK(ejbCcoCepCecSesionPK ejbCcoCepCecSesionPK) {
        this.ejbCcoCepCecSesionPK = ejbCcoCepCecSesionPK;
    }

    public Boolean getEstadoSesion() {
        return estadoSesion;
    }

    public void setEstadoSesion(Boolean estadoSesion) {
        this.estadoSesion = estadoSesion;
    }

    public String getNombreSesion() {
        return nombreSesion;
    }

    public void setNombreSesion(String nombreSesion) {
        this.nombreSesion = nombreSesion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ejbCcoCepCecSesionPK != null ? ejbCcoCepCecSesionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ejbCcoCepCecSesion)) {
            return false;
        }
        ejbCcoCepCecSesion other = (ejbCcoCepCecSesion) object;
        if ((this.ejbCcoCepCecSesionPK == null && other.ejbCcoCepCecSesionPK != null) || (this.ejbCcoCepCecSesionPK != null && !this.ejbCcoCepCecSesionPK.equals(other.ejbCcoCepCecSesionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbCecomp.entidades.ejbCcoCepCecSesion[ ejbCcoCepCecSesionPK=" + ejbCcoCepCecSesionPK + " ]";
    }
    
}
