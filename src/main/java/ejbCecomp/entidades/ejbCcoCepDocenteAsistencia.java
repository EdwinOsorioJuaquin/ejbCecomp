/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejbCecomp.entidades;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Jael
 */
@Entity(name="CepDocenteAsistencia")
@Table(name = "cep_docente_asistencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CepDocenteAsistencia.findAll", query = "SELECT c FROM CepDocenteAsistencia c"),
    @NamedQuery(name = "CepDocenteAsistencia.findByIdHora", query = "SELECT c FROM CepDocenteAsistencia c WHERE c.cepDocenteAsistenciaPK.idHora = :idHora"),
    @NamedQuery(name = "CepDocenteAsistencia.findByIdFecha", query = "SELECT c FROM CepDocenteAsistencia c WHERE c.cepDocenteAsistenciaPK.idFecha = :idFecha"),
    @NamedQuery(name = "CepDocenteAsistencia.findByIdPersonal", query = "SELECT c FROM CepDocenteAsistencia c WHERE c.cepDocenteAsistenciaPK.idPersonal = :idPersonal")})
public class ejbCcoCepDocenteAsistencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ejbCcoCepDocenteAsistenciaPK cepDocenteAsistenciaPK;
    @JoinColumn(name = "id_personal", referencedColumnName = "id_personal", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ejbCcoCepPersonal cepPersonal;

    public ejbCcoCepDocenteAsistencia() {
    }

    public ejbCcoCepDocenteAsistencia(ejbCcoCepDocenteAsistenciaPK cepDocenteAsistenciaPK) {
        this.cepDocenteAsistenciaPK = cepDocenteAsistenciaPK;
    }

    public ejbCcoCepDocenteAsistencia(Date idHora, Date idFecha, int idPersonal) {
        this.cepDocenteAsistenciaPK = new ejbCcoCepDocenteAsistenciaPK(idHora, idFecha, idPersonal);
    }

    public ejbCcoCepDocenteAsistenciaPK getCepDocenteAsistenciaPK() {
        return cepDocenteAsistenciaPK;
    }

    public void setCepDocenteAsistenciaPK(ejbCcoCepDocenteAsistenciaPK cepDocenteAsistenciaPK) {
        this.cepDocenteAsistenciaPK = cepDocenteAsistenciaPK;
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
        hash += (cepDocenteAsistenciaPK != null ? cepDocenteAsistenciaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ejbCcoCepDocenteAsistencia)) {
            return false;
        }
        ejbCcoCepDocenteAsistencia other = (ejbCcoCepDocenteAsistencia) object;
        if ((this.cepDocenteAsistenciaPK == null && other.cepDocenteAsistenciaPK != null) || (this.cepDocenteAsistenciaPK != null && !this.cepDocenteAsistenciaPK.equals(other.cepDocenteAsistenciaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbCecomp.entidades.CepDocenteAsistencia[ cepDocenteAsistenciaPK=" + cepDocenteAsistenciaPK + " ]";
    }
    
}
