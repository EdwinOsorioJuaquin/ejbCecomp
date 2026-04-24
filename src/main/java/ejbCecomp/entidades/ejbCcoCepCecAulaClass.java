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
@Entity(name = "CepCecAulaClass")
@Table(name = "cep_cec_aula_class")
@NamedQueries({
    @NamedQuery(name = "CepCecAulaClass.findAll", query = "SELECT c FROM CepCecAulaClass c"),
    @NamedQuery(name = "CepCecAulaClass.findByIdAulClass", query = "SELECT c FROM CepCecAulaClass c WHERE c.idAulClass = :idAulClass"),
    @NamedQuery(name = "CepCecAulaClass.findByPiso", query = "SELECT c FROM CepCecAulaClass c WHERE c.piso = :piso"),
    @NamedQuery(name = "CepCecAulaClass.findByLugar", query = "SELECT c FROM CepCecAulaClass c WHERE c.lugar = :lugar"),
    @NamedQuery(name = "CepCecAulaClass.findByNomAula", query = "SELECT c FROM CepCecAulaClass c WHERE c.nomAula = :nomAula"),
    @NamedQuery(name = "CepCecAulaClass.findByCondicion", query = "SELECT c FROM CepCecAulaClass c WHERE c.condicion = :condicion"),
    @NamedQuery(name = "CepCecAulaClass.findByIdDep", query = "SELECT c FROM CepCecAulaClass c WHERE c.idDep = :idDep"),
    @NamedQuery(name = "CepCecAulaClass.findByNumAula", query = "SELECT c FROM CepCecAulaClass c WHERE c.numAula = :numAula")})
public class ejbCcoCepCecAulaClass implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_aul_class")
    private Integer idAulClass;
    @Basic(optional = false)
    @NotNull
    @Column(name = "piso")
    private int piso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "lugar")
    private String lugar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nom_aula")
    private String nomAula;
    @Basic(optional = false)
    @NotNull
    @Column(name = "condicion")
    private Character condicion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_dep")
    private int idDep;
    @Column(name = "num_aula")
    private Integer numAula;
    @OneToMany(mappedBy = "cepCecAulaClass")
    private List<ejbCcoCepHorarioDia> cepHorarioDiaList;
    @OneToMany(mappedBy = "cepCecAulaClass")
    private List<ejbCcoCepAulaCursoDocente> cepAulaCursoDocenteList;

    public ejbCcoCepCecAulaClass() {
    }

    public ejbCcoCepCecAulaClass(Integer idAulClass) {
        this.idAulClass = idAulClass;
    }

    public ejbCcoCepCecAulaClass(Integer idAulClass, int piso, String lugar, String nomAula, Character condicion, int idDep) {
        this.idAulClass = idAulClass;
        this.piso = piso;
        this.lugar = lugar;
        this.nomAula = nomAula;
        this.condicion = condicion;
        this.idDep = idDep;
    }

    public Integer getIdAulClass() {
        return idAulClass;
    }

    public void setIdAulClass(Integer idAulClass) {
        this.idAulClass = idAulClass;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getNomAula() {
        return nomAula;
    }

    public void setNomAula(String nomAula) {
        this.nomAula = nomAula;
    }

    public Character getCondicion() {
        return condicion;
    }

    public void setCondicion(Character condicion) {
        this.condicion = condicion;
    }

    public int getIdDep() {
        return idDep;
    }

    public void setIdDep(int idDep) {
        this.idDep = idDep;
    }

    public Integer getNumAula() {
        return numAula;
    }

    public void setNumAula(Integer numAula) {
        this.numAula = numAula;
    }

    public List<ejbCcoCepHorarioDia> getCepHorarioDiaList() {
        return cepHorarioDiaList;
    }

    public void setCepHorarioDiaList(List<ejbCcoCepHorarioDia> cepHorarioDiaList) {
        this.cepHorarioDiaList = cepHorarioDiaList;
    }

    public List<ejbCcoCepAulaCursoDocente> getCepAulaCursoDocenteList() {
        return cepAulaCursoDocenteList;
    }

    public void setCepAulaCursoDocenteList(List<ejbCcoCepAulaCursoDocente> cepAulaCursoDocenteList) {
        this.cepAulaCursoDocenteList = cepAulaCursoDocenteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAulClass != null ? idAulClass.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ejbCcoCepCecAulaClass)) {
            return false;
        }
        ejbCcoCepCecAulaClass other = (ejbCcoCepCecAulaClass) object;
        if ((this.idAulClass == null && other.idAulClass != null) || (this.idAulClass != null && !this.idAulClass.equals(other.idAulClass))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbCecomp.entidades.CepCecAulaClass[ idAulClass=" + idAulClass + " ]";
    }
    
}
