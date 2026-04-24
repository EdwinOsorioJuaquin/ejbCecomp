/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejbCecomp.entidades;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

/**
 *
 * @author Jael
 */
@Embeddable
public class ejbCcoCepAulaCursoDocentePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_aul_class")
    private int idAulClass;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_personal")
    private int idPersonal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_curso")
    private int idCurso;

    public ejbCcoCepAulaCursoDocentePK() {
    }

    public ejbCcoCepAulaCursoDocentePK(int idAulClass, int idPersonal, int idCurso) {
        this.idAulClass = idAulClass;
        this.idPersonal = idPersonal;
        this.idCurso = idCurso;
    }

    public int getIdAulClass() {
        return idAulClass;
    }

    public void setIdAulClass(int idAulClass) {
        this.idAulClass = idAulClass;
    }

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idAulClass;
        hash += (int) idPersonal;
        hash += (int) idCurso;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ejbCcoCepAulaCursoDocentePK)) {
            return false;
        }
        ejbCcoCepAulaCursoDocentePK other = (ejbCcoCepAulaCursoDocentePK) object;
        if (this.idAulClass != other.idAulClass) {
            return false;
        }
        if (this.idPersonal != other.idPersonal) {
            return false;
        }
        if (this.idCurso != other.idCurso) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbCecomp.entidades.CepAulaCursoDocentePK[ idAulClass=" + idAulClass + ", idPersonal=" + idPersonal + ", idCurso=" + idCurso + " ]";
    }
    
}
