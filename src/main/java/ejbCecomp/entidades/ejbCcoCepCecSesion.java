/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejbCecomp.entidades;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Jael
 */
@Entity(name = "CepCecSesion")
@Table(name = "cep_cec_sesion")
@NamedQueries({
    @NamedQuery(name = "CepCecSesion.findAll", query = "SELECT c FROM CepCecSesion c"),
    @NamedQuery(name = "CepCecSesion.findByIdSesio", query = "SELECT c FROM CepCecSesion c WHERE c.idSesio = :idSesio"),
    @NamedQuery(name = "CepCecSesion.findByEstadoSesion", query = "SELECT c FROM CepCecSesion c WHERE c.estadoSesion = :estadoSesion")})
public class ejbCcoCepCecSesion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_sesio")
    private Integer idSesio;
    @Column(name = "estado_sesion")
    private Boolean estadoSesion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cepCecSesion")
    private List<ejbCcoCepCecNotas> cepCecNotasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cepCecSesion")
    private List<ejbCcoCepCecTema> cepCecTemaList;
    @JoinColumn(name = "id_pland", referencedColumnName = "id_pland")
    @ManyToOne(optional = false)
    private ejbCcoCepCecPlan cepCecPlan;

    public ejbCcoCepCecSesion() {
    }

    public ejbCcoCepCecSesion(Integer idSesio) {
        this.idSesio = idSesio;
    }

    public Integer getIdSesio() {
        return idSesio;
    }

    public void setIdSesio(Integer idSesio) {
        this.idSesio = idSesio;
    }

    public Boolean getEstadoSesion() {
        return estadoSesion;
    }

    public void setEstadoSesion(Boolean estadoSesion) {
        this.estadoSesion = estadoSesion;
    }

    public List<ejbCcoCepCecNotas> getCepCecNotasList() {
        return cepCecNotasList;
    }

    public void setCepCecNotasList(List<ejbCcoCepCecNotas> cepCecNotasList) {
        this.cepCecNotasList = cepCecNotasList;
    }

    public List<ejbCcoCepCecTema> getCepCecTemaList() {
        return cepCecTemaList;
    }

    public void setCepCecTemaList(List<ejbCcoCepCecTema> cepCecTemaList) {
        this.cepCecTemaList = cepCecTemaList;
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
        hash += (idSesio != null ? idSesio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ejbCcoCepCecSesion)) {
            return false;
        }
        ejbCcoCepCecSesion other = (ejbCcoCepCecSesion) object;
        if ((this.idSesio == null && other.idSesio != null) || (this.idSesio != null && !this.idSesio.equals(other.idSesio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbCecomp.entidades.CepCecSesion[ idSesio=" + idSesio + " ]";
    }
    
}
