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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;

/**
 *
 * @author Jael
 */
@Entity(name = "CepCecTema")
@Table(name = "cep_cec_tema")
@NamedQueries({
    @NamedQuery(name = "CepCecTema.findAll", query = "SELECT c FROM CepCecTema c"),
    @NamedQuery(name = "CepCecTema.findByIdTem", query = "SELECT c FROM CepCecTema c WHERE c.idTem = :idTem"),
    @NamedQuery(name = "CepCecTema.findByNomTem", query = "SELECT c FROM CepCecTema c WHERE c.nomTem = :nomTem"),
    @NamedQuery(name = "CepCecTema.findByEstadoTem", query = "SELECT c FROM CepCecTema c WHERE c.estadoTem = :estadoTem")})
public class ejbCcoCepCecTema implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tem")
    private Integer idTem;
    @Size(max = 100)
    @Column(name = "nom_tem")
    private String nomTem;
    @Column(name = "estado_tem")
    private Boolean estadoTem;
    @JoinColumn(name = "id_sesio", referencedColumnName = "id_sesio")
    @ManyToOne(optional = false)
    private ejbCcoCepCecSesion cepCecSesion;

    public ejbCcoCepCecTema() {
    }

    public ejbCcoCepCecTema(Integer idTem) {
        this.idTem = idTem;
    }

    public Integer getIdTem() {
        return idTem;
    }

    public void setIdTem(Integer idTem) {
        this.idTem = idTem;
    }

    public String getNomTem() {
        return nomTem;
    }

    public void setNomTem(String nomTem) {
        this.nomTem = nomTem;
    }

    public Boolean getEstadoTem() {
        return estadoTem;
    }

    public void setEstadoTem(Boolean estadoTem) {
        this.estadoTem = estadoTem;
    }

    public ejbCcoCepCecSesion getCepCecSesion() {
        return cepCecSesion;
    }

    public void setCepCecSesion(ejbCcoCepCecSesion cepCecSesion) {
        this.cepCecSesion = cepCecSesion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTem != null ? idTem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ejbCcoCepCecTema)) {
            return false;
        }
        ejbCcoCepCecTema other = (ejbCcoCepCecTema) object;
        if ((this.idTem == null && other.idTem != null) || (this.idTem != null && !this.idTem.equals(other.idTem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbCecomp.entidades.CepCecTema[ idTem=" + idTem + " ]";
    }
    
}
