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
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Jael
 */
@Entity(name = "CepNivelModalidad")
@Table(name = "cep_nivel_modalidad")
@NamedQueries({
    @NamedQuery(name = "CepNivelModalidad.findAll", query = "SELECT c FROM CepNivelModalidad c"),
    @NamedQuery(name = "CepNivelModalidad.findByIdNivMod", query = "SELECT c FROM CepNivelModalidad c WHERE c.idNivMod = :idNivMod"),
    @NamedQuery(name = "CepNivelModalidad.findByNomNivMod", query = "SELECT c FROM CepNivelModalidad c WHERE c.nomNivMod = :nomNivMod"),
    @NamedQuery(name = "CepNivelModalidad.findByHabilitado", query = "SELECT c FROM CepNivelModalidad c WHERE c.habilitado = :habilitado")})
public class ejbCcoCepNivelModalidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "id_niv_mod")
    private String idNivMod;
    @Column(name = "nom_niv_mod")
    private Character nomNivMod;
    @Column(name = "habilitado")
    private Character habilitado;
    @OneToMany(mappedBy = "cepNivelModalidad")
    private List<ejbCcoCepCurso> cepCursoList;

    public ejbCcoCepNivelModalidad() {
    }

    public ejbCcoCepNivelModalidad(String idNivMod) {
        this.idNivMod = idNivMod;
    }

    public String getIdNivMod() {
        return idNivMod;
    }

    public void setIdNivMod(String idNivMod) {
        this.idNivMod = idNivMod;
    }

    public Character getNomNivMod() {
        return nomNivMod;
    }

    public void setNomNivMod(Character nomNivMod) {
        this.nomNivMod = nomNivMod;
    }

    public Character getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Character habilitado) {
        this.habilitado = habilitado;
    }

    public List<ejbCcoCepCurso> getCepCursoList() {
        return cepCursoList;
    }

    public void setCepCursoList(List<ejbCcoCepCurso> cepCursoList) {
        this.cepCursoList = cepCursoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNivMod != null ? idNivMod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ejbCcoCepNivelModalidad)) {
            return false;
        }
        ejbCcoCepNivelModalidad other = (ejbCcoCepNivelModalidad) object;
        if ((this.idNivMod == null && other.idNivMod != null) || (this.idNivMod != null && !this.idNivMod.equals(other.idNivMod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbCecomp.entidades.CepNivelModalidad[ idNivMod=" + idNivMod + " ]";
    }
    
}
