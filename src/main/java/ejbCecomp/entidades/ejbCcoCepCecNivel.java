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
@Entity(name = "CepCecNivel")
@Table(name = "cep_cec_nivel")
@NamedQueries({
    @NamedQuery(name = "CepCecNivel.findAll", query = "SELECT c FROM CepCecNivel c"),
    @NamedQuery(name = "CepCecNivel.findByIdNivel", query = "SELECT c FROM CepCecNivel c WHERE c.idNivel = :idNivel"),
    @NamedQuery(name = "CepCecNivel.findByNombreNivel", query = "SELECT c FROM CepCecNivel c WHERE c.nombreNivel = :nombreNivel")})
public class ejbCcoCepCecNivel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_nivel")
    private Integer idNivel;
    @Size(max = 20)
    @Column(name = "nombre_nivel")
    private String nombreNivel;
    @OneToMany(mappedBy = "cepCecNivel")
    private List<ejbCcoCepCursoDocente> cepCursoDocenteList;

    public ejbCcoCepCecNivel() {
    }

    public ejbCcoCepCecNivel(Integer idNivel) {
        this.idNivel = idNivel;
    }

    public Integer getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(Integer idNivel) {
        this.idNivel = idNivel;
    }

    public String getNombreNivel() {
        return nombreNivel;
    }

    public void setNombreNivel(String nombreNivel) {
        this.nombreNivel = nombreNivel;
    }

    public List<ejbCcoCepCursoDocente> getCepCursoDocenteList() {
        return cepCursoDocenteList;
    }

    public void setCepCursoDocenteList(List<ejbCcoCepCursoDocente> cepCursoDocenteList) {
        this.cepCursoDocenteList = cepCursoDocenteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNivel != null ? idNivel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ejbCcoCepCecNivel)) {
            return false;
        }
        ejbCcoCepCecNivel other = (ejbCcoCepCecNivel) object;
        if ((this.idNivel == null && other.idNivel != null) || (this.idNivel != null && !this.idNivel.equals(other.idNivel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbCecomp.entidades.CepCecNivel[ idNivel=" + idNivel + " ]";
    }
    
}
