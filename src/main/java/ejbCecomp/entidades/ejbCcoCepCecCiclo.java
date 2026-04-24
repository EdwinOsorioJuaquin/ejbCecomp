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
@Entity(name = "CepCecCiclo")
@Table(name = "cep_cec_ciclo")
@NamedQueries({
    @NamedQuery(name = "CepCecCiclo.findAll", query = "SELECT c FROM CepCecCiclo c"),
    @NamedQuery(name = "CepCecCiclo.findByIdCiclo", query = "SELECT c FROM CepCecCiclo c WHERE c.idCiclo = :idCiclo"),
    @NamedQuery(name = "CepCecCiclo.findByNomCiclo", query = "SELECT c FROM CepCecCiclo c WHERE c.nomCiclo = :nomCiclo")})
public class ejbCcoCepCecCiclo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ciclo")
    private Integer idCiclo;
    @Size(max = 20)
    @Column(name = "nom_ciclo")
    private String nomCiclo;
    @OneToMany(mappedBy = "cepCecCiclo")
    private List<ejbCcoCepCursoDocente> cepCursoDocenteList;

    public ejbCcoCepCecCiclo() {
    }

    public ejbCcoCepCecCiclo(Integer idCiclo) {
        this.idCiclo = idCiclo;
    }

    public Integer getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(Integer idCiclo) {
        this.idCiclo = idCiclo;
    }

    public String getNomCiclo() {
        return nomCiclo;
    }

    public void setNomCiclo(String nomCiclo) {
        this.nomCiclo = nomCiclo;
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
        hash += (idCiclo != null ? idCiclo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ejbCcoCepCecCiclo)) {
            return false;
        }
        ejbCcoCepCecCiclo other = (ejbCcoCepCecCiclo) object;
        if ((this.idCiclo == null && other.idCiclo != null) || (this.idCiclo != null && !this.idCiclo.equals(other.idCiclo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbCecomp.entidades.CepCecCiclo[ idCiclo=" + idCiclo + " ]";
    }
    
}
