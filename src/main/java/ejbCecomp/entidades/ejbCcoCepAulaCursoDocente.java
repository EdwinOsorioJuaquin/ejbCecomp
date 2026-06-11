/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejbCecomp.entidades;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author Jael
 */
@Entity(name="CepAulaCursoDocente")
@Table(name = "cep_aula_curso_docente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CepAulaCursoDocente.findAll", query = "SELECT c FROM CepAulaCursoDocente c"),
    @NamedQuery(name = "CepAulaCursoDocente.findByIdAulClass", query = "SELECT c FROM CepAulaCursoDocente c WHERE c.cepAulaCursoDocentePK.idAulClass = :idAulClass"),
    @NamedQuery(name = "CepAulaCursoDocente.findByIdPersonal", query = "SELECT c FROM CepAulaCursoDocente c WHERE c.cepAulaCursoDocentePK.idPersonal = :idPersonal"),
    @NamedQuery(name = "CepAulaCursoDocente.findByIdCurso", query = "SELECT c FROM CepAulaCursoDocente c WHERE c.cepAulaCursoDocentePK.idCurso = :idCurso"),
    @NamedQuery(name = "CepAulaCursoDocente.findByEstado", query = "SELECT c FROM CepAulaCursoDocente c WHERE c.estado = :estado"),
    @NamedQuery(name = "CepAulaCursoDocente.findByIdDep", query = "SELECT c FROM CepAulaCursoDocente c WHERE c.idDep = :idDep")})
public class ejbCcoCepAulaCursoDocente implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ejbCcoCepAulaCursoDocentePK cepAulaCursoDocentePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private boolean estado;
    @Column(name = "id_dep")
    private Integer idDep;
    @JoinColumn(name = "id_aul_class", referencedColumnName = "id_aul_class", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ejbCcoCepCecAulaClass cepCecAulaClass;
    @JoinColumn(name = "id_personal", referencedColumnName = "id_personal", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ejbCcoCepPersonal cepPersonal;

    public ejbCcoCepAulaCursoDocente() {
    }

    public ejbCcoCepAulaCursoDocente(ejbCcoCepAulaCursoDocentePK cepAulaCursoDocentePK) {
        this.cepAulaCursoDocentePK = cepAulaCursoDocentePK;
    }

    public ejbCcoCepAulaCursoDocente(ejbCcoCepAulaCursoDocentePK cepAulaCursoDocentePK, boolean estado) {
        this.cepAulaCursoDocentePK = cepAulaCursoDocentePK;
        this.estado = estado;
    }

    public ejbCcoCepAulaCursoDocente(int idAulClass, int idPersonal, int idCurso) {
        this.cepAulaCursoDocentePK = new ejbCcoCepAulaCursoDocentePK(idAulClass, idPersonal, idCurso);
    }

    public ejbCcoCepAulaCursoDocentePK getCepAulaCursoDocentePK() {
        return cepAulaCursoDocentePK;
    }

    public void setCepAulaCursoDocentePK(ejbCcoCepAulaCursoDocentePK cepAulaCursoDocentePK) {
        this.cepAulaCursoDocentePK = cepAulaCursoDocentePK;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Integer getIdDep() {
        return idDep;
    }

    public void setIdDep(Integer idDep) {
        this.idDep = idDep;
    }

    public ejbCcoCepCecAulaClass getCepCecAulaClass() {
        return cepCecAulaClass;
    }

    public void setCepCecAulaClass(ejbCcoCepCecAulaClass cepCecAulaClass) {
        this.cepCecAulaClass = cepCecAulaClass;
    }

    public ejbCcoCepPersonal getCepPersonal() {
        return cepPersonal;
    }

    public void setCepPersonal(ejbCcoCepPersonal cepPersonal) {
        this.cepPersonal = cepPersonal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cepAulaCursoDocentePK != null ? cepAulaCursoDocentePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ejbCcoCepAulaCursoDocente)) {
            return false;
        }
        ejbCcoCepAulaCursoDocente other = (ejbCcoCepAulaCursoDocente) object;
        if ((this.cepAulaCursoDocentePK == null && other.cepAulaCursoDocentePK != null) || (this.cepAulaCursoDocentePK != null && !this.cepAulaCursoDocentePK.equals(other.cepAulaCursoDocentePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbCecomp.entidades.CepAulaCursoDocente[ cepAulaCursoDocentePK=" + cepAulaCursoDocentePK + " ]";
    }
    
}
