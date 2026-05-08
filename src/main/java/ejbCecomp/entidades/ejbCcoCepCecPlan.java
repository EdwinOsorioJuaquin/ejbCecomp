/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejbCecomp.entidades;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Jael
 */
@Entity(name="CepCecPlan")
@Table(name = "cep_cec_plan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CepCecPlan.findAll", query = "SELECT c FROM CepCecPlan c"),
    @NamedQuery(name = "CepCecPlan.findByIdPland", query = "SELECT c FROM CepCecPlan c WHERE c.idPland = :idPland"),
    @NamedQuery(name = "CepCecPlan.findByNomPland", query = "SELECT c FROM CepCecPlan c WHERE c.nomPland = :nomPland"),
    @NamedQuery(name = "CepCecPlan.findByEstadoPland", query = "SELECT c FROM CepCecPlan c WHERE c.estadoPland = :estadoPland"),
    @NamedQuery(name = "CepCecPlan.findByFechaRegis", query = "SELECT c FROM CepCecPlan c WHERE c.fechaRegis = :fechaRegis"),
    @NamedQuery(name = "CepCecPlan.findByDesPland", query = "SELECT c FROM CepCecPlan c WHERE c.desPland = :desPland")
})
public class ejbCcoCepCecPlan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pland")
    private Integer idPland;
    @Size(max = 40)
    @Column(name = "nom_pland")
    private String nomPland;
    @Column(name = "estado_pland")
    private Boolean estadoPland;
    @Column(name = "fecha_regis")
    @Temporal(TemporalType.DATE)
    private Date fechaRegis;
    @Size(max = 100)
    @Column(name = "des_pland")
    private String desPland;

    public ejbCcoCepCecPlan() {
    }

    public ejbCcoCepCecPlan(Integer idPland) {
        this.idPland = idPland;
    }

    public Integer getIdPland() {
        return idPland;
    }

    public void setIdPland(Integer idPland) {
        this.idPland = idPland;
    }

    public String getNomPland() {
        return nomPland;
    }

    public void setNomPland(String nomPland) {
        this.nomPland = nomPland;
    }

    public Boolean getEstadoPland() {
        return estadoPland;
    }

    public void setEstadoPland(Boolean estadoPland) {
        this.estadoPland = estadoPland;
    }

    public Date getFechaRegis() {
        return fechaRegis;
    }

    public void setFechaRegis(Date fechaRegis) {
        this.fechaRegis = fechaRegis;
    }

    public String getDesPland() {
        return desPland;
    }

    public void setDesPland(String desPland) {
        this.desPland = desPland;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPland != null ? idPland.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ejbCcoCepCecPlan)) {
            return false;
        }
        ejbCcoCepCecPlan other = (ejbCcoCepCecPlan) object;
        if ((this.idPland == null && other.idPland != null) || (this.idPland != null && !this.idPland.equals(other.idPland))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbCecomp.entidades.ejbCcoCepCecPlan[ idPland=" + idPland + " ]";
    }
    
}
