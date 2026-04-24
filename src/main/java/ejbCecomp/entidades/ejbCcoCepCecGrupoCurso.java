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
@Entity(name = "CepCecGrupoCurso")
@Table(name = "cep_cec_grupo_curso")
@NamedQueries({
    @NamedQuery(name = "CepCecGrupoCurso.findAll", query = "SELECT c FROM CepCecGrupoCurso c"),
    @NamedQuery(name = "CepCecGrupoCurso.findByIdGrupo", query = "SELECT c FROM CepCecGrupoCurso c WHERE c.idGrupo = :idGrupo"),
    @NamedQuery(name = "CepCecGrupoCurso.findByNombre", query = "SELECT c FROM CepCecGrupoCurso c WHERE c.nombre = :nombre")})
public class ejbCcoCepCecGrupoCurso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_grupo")
    private Integer idGrupo;
    @Size(max = 20)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "cepCecGrupoCurso")
    private List<ejbCcoCepCursoDocente> cepCursoDocenteList;

    public ejbCcoCepCecGrupoCurso() {
    }

    public ejbCcoCepCecGrupoCurso(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        hash += (idGrupo != null ? idGrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ejbCcoCepCecGrupoCurso)) {
            return false;
        }
        ejbCcoCepCecGrupoCurso other = (ejbCcoCepCecGrupoCurso) object;
        if ((this.idGrupo == null && other.idGrupo != null) || (this.idGrupo != null && !this.idGrupo.equals(other.idGrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbCecomp.entidades.CepCecGrupoCurso[ idGrupo=" + idGrupo + " ]";
    }
    
}
