/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejbCecomp.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    @NamedQuery(name = "CepCecSesion.findAll", query = "SELECT c FROM CepCecSesion c"),
    @NamedQuery(name = "CepCecSesion.findByIdSesio", query = "SELECT c FROM CepCecSesion c WHERE c.cepCecSesionPK.idSesio = :idSesio"),
    @NamedQuery(name = "CepCecSesion.findByIdPland", query = "SELECT c FROM CepCecSesion c WHERE c.cepCecSesionPK.idPland = :idPland"),
    @NamedQuery(name = "CepCecSesion.findByEstadoSesion", query = "SELECT c FROM CepCecSesion c WHERE c.estadoSesion = :estadoSesion"),
    @NamedQuery(name = "CepCecSesion.findByNombreSesion", query = "SELECT c FROM CepCecSesion c WHERE c.nombreSesion = :nombreSesion")})
public class ejbCcoCepCecSesion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ejbCcoCepCecSesionPK cepCecSesionPK;
    @Column(name = "estado_sesion")
    private Boolean estadoSesion;
    @Size(max = 100)
    @Column(name = "nombre_sesion")
    private String nombreSesion;
    @JoinColumn(name = "id_pland", referencedColumnName = "id_pland", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ejbCcoCepCecPlan cepCecPlan;

    public ejbCcoCepCecSesion() {
    }

    public ejbCcoCepCecSesion(ejbCcoCepCecSesionPK cepCecSesionPK) {
        this.cepCecSesionPK = cepCecSesionPK;
    }

    public ejbCcoCepCecSesion(int idSesio, int idPland) {
        this.cepCecSesionPK = new ejbCcoCepCecSesionPK(idSesio, idPland);
    }

    public ejbCcoCepCecSesionPK getCepCecSesionPK() {
        return cepCecSesionPK;
    }

    public void setCepCecSesionPK(ejbCcoCepCecSesionPK cepCecSesionPK) {
        this.cepCecSesionPK = cepCecSesionPK;
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

    public ejbCcoCepCecPlan getCepCecPlan() {
        return cepCecPlan;
    }

    public void setCepCecPlan(ejbCcoCepCecPlan cepCecPlan) {
        this.cepCecPlan = cepCecPlan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cepCecSesionPK != null ? cepCecSesionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ejbCcoCepCecSesion)) {
            return false;
        }
        ejbCcoCepCecSesion other = (ejbCcoCepCecSesion) object;
        if ((this.cepCecSesionPK == null && other.cepCecSesionPK != null) || (this.cepCecSesionPK != null && !this.cepCecSesionPK.equals(other.cepCecSesionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbCecomp.entidades.CepCecSesion[ cepCecSesionPK=" + cepCecSesionPK + " ]";
    }
    
}
