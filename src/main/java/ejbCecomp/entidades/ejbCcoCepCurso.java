/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejbCecomp.entidades;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Entity(name = "CepCurso")
@Table(name = "cep_curso")
@NamedQueries({
    @NamedQuery(name = "CepCurso.findAll", query = "SELECT c FROM CepCurso c"),
    @NamedQuery(name = "CepCurso.findByIdCurso", query = "SELECT c FROM CepCurso c WHERE c.idCurso = :idCurso"),
    @NamedQuery(name = "CepCurso.findByNomCurso", query = "SELECT c FROM CepCurso c WHERE c.nomCurso = :nomCurso"),
    @NamedQuery(name = "CepCurso.findByBandera", query = "SELECT c FROM CepCurso c WHERE c.bandera = :bandera"),
    @NamedQuery(name = "CepCurso.findByIdDep", query = "SELECT c FROM CepCurso c WHERE c.idDep = :idDep"),
    @NamedQuery(name = "CepCurso.findByAbreviatura", query = "SELECT c FROM CepCurso c WHERE c.abreviatura = :abreviatura")})
public class ejbCcoCepCurso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_curso")
    private Integer idCurso;
    @Size(max = 90)
    @Column(name = "nom_curso")
    private String nomCurso;
    @Column(name = "bandera")
    private Boolean bandera;
    @Column(name = "id_dep")
    private Integer idDep;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "abreviatura")
    private String abreviatura;
    @Column(name = "duracion")
    private String duracion;
    @OneToMany(mappedBy = "cepCurso")
    private List<ejbCcoCepCursoDocente> cepCursoDocenteList;
    @OneToMany(mappedBy = "cepCurso")
    private List<ejbCcoCepAulaCursoDocente> cepAulaCursoDocenteList;
    @JoinColumn(name = "id_pland", referencedColumnName = "id_pland")
    @ManyToOne
    private ejbCcoCepCecPlan cepCecPlan;
    @JoinColumn(name = "id_niv_mod", referencedColumnName = "id_niv_mod")
    @ManyToOne(optional = false)
    private ejbCcoCepNivelModalidad cepNivelModalidad;

    public ejbCcoCepCurso() {
    }

    public ejbCcoCepCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public ejbCcoCepCurso(Integer idCurso, String abreviatura) {
        this.idCurso = idCurso;
        this.abreviatura = abreviatura;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public String getNomCurso() {
        return nomCurso;
    }

    public void setNomCurso(String nomCurso) {
        this.nomCurso = nomCurso;
    }

    public Boolean getBandera() {
        return bandera;
    }

    public void setBandera(Boolean bandera) {
        this.bandera = bandera;
    }

    public Integer getIdDep() {
        return idDep;
    }

    public void setIdDep(Integer idDep) {
        this.idDep = idDep;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }
    
    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public List<ejbCcoCepCursoDocente> getCepCursoDocenteList() {
        return cepCursoDocenteList;
    }

    public void setCepCursoDocenteList(List<ejbCcoCepCursoDocente> cepCursoDocenteList) {
        this.cepCursoDocenteList = cepCursoDocenteList;
    }

    public List<ejbCcoCepAulaCursoDocente> getCepAulaCursoDocenteList() {
        return cepAulaCursoDocenteList;
    }

    public void setCepAulaCursoDocenteList(List<ejbCcoCepAulaCursoDocente> cepAulaCursoDocenteList) {
        this.cepAulaCursoDocenteList = cepAulaCursoDocenteList;
    }

    public ejbCcoCepCecPlan getCepCecPlan() {
        return cepCecPlan;
    }

    public void setCepCecPlan(ejbCcoCepCecPlan cepCecPlan) {
        this.cepCecPlan = cepCecPlan;
    }

    public ejbCcoCepNivelModalidad getCepNivelModalidad() {
        return cepNivelModalidad;
    }

    public void setCepNivelModalidad(ejbCcoCepNivelModalidad cepNivelModalidad) {
        this.cepNivelModalidad = cepNivelModalidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCurso != null ? idCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ejbCcoCepCurso)) {
            return false;
        }
        ejbCcoCepCurso other = (ejbCcoCepCurso) object;
        if ((this.idCurso == null && other.idCurso != null) || (this.idCurso != null && !this.idCurso.equals(other.idCurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbCecomp.entidades.CepCurso[ idCurso=" + idCurso + " ]";
    }
    
}
