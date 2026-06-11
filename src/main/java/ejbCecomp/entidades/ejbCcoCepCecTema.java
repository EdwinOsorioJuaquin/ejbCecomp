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
@Entity(name="CepCecTema")
@Table(name = "cep_cec_tema")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CepCecTema.findAll", query = "SELECT c FROM CepCecTema c"),
    @NamedQuery(name = "CepCecTema.findByIdTem", query = "SELECT c FROM CepCecTema c WHERE c.cepCecTemaPK.idTem = :idTem"),
    @NamedQuery(name = "CepCecTema.findByIdSesio", query = "SELECT c FROM CepCecTema c WHERE c.cepCecTemaPK.idSesio = :idSesio"),
    @NamedQuery(name = "CepCecTema.findByNomTem", query = "SELECT c FROM CepCecTema c WHERE c.nomTem = :nomTem"),
    @NamedQuery(name = "CepCecTema.findByEstadoTem", query = "SELECT c FROM CepCecTema c WHERE c.estadoTem = :estadoTem"),
    @NamedQuery(name = "CepCecTema.findByIdPland", query = "SELECT c FROM CepCecTema c WHERE c.cepCecTemaPK.idPland = :idPland")})
public class ejbCcoCepCecTema implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ejbCcoCepCecTemaPK cepCecTemaPK;
    @Size(max = 100)
    @Column(name = "nom_tem")
    private String nomTem;
    @Column(name = "estado_tem")
    private Boolean estadoTem;

    public ejbCcoCepCecTema() {
    }

    public ejbCcoCepCecTema(ejbCcoCepCecTemaPK cepCecTemaPK) {
        this.cepCecTemaPK = cepCecTemaPK;
    }

    public ejbCcoCepCecTema(int idTem, int idSesio, int idPland) {
        this.cepCecTemaPK = new ejbCcoCepCecTemaPK(idTem, idSesio, idPland);
    }

    public ejbCcoCepCecTemaPK getCepCecTemaPK() {
        return cepCecTemaPK;
    }

    public void setCepCecTemaPK(ejbCcoCepCecTemaPK cepCecTemaPK) {
        this.cepCecTemaPK = cepCecTemaPK;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cepCecTemaPK != null ? cepCecTemaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ejbCcoCepCecTema)) {
            return false;
        }
        ejbCcoCepCecTema other = (ejbCcoCepCecTema) object;
        if ((this.cepCecTemaPK == null && other.cepCecTemaPK != null) || (this.cepCecTemaPK != null && !this.cepCecTemaPK.equals(other.cepCecTemaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbCecomp.entidades.CepCecTema[ cepCecTemaPK=" + cepCecTemaPK + " ]";
    }
    
}
