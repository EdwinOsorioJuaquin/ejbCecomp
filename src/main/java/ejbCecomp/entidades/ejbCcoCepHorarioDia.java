/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejbCecomp.entidades;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Entity(name="CepHorarioDia")
@Table(name = "cep_horario_dia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CepHorarioDia.findAll", query = "SELECT c FROM CepHorarioDia c"),
    @NamedQuery(name = "CepHorarioDia.findByIdHorario", query = "SELECT c FROM CepHorarioDia c WHERE c.idHorario = :idHorario"),
    @NamedQuery(name = "CepHorarioDia.findByDia", query = "SELECT c FROM CepHorarioDia c WHERE c.dia = :dia")})
public class ejbCcoCepHorarioDia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_horario")
    private Integer idHorario;
    @Column(name = "dia")
    private Short dia;
    @JoinColumn(name = "id_aul_class", referencedColumnName = "id_aul_class")
    @ManyToOne
    private ejbCcoCepCecAulaClass cepCecAulaClass;
    @JoinColumn(name = "id_ad", referencedColumnName = "id_ad")
    @ManyToOne
    private ejbCcoCepCursoDocente cepCursoDocente;
    @JoinColumn(name = "id_hora", referencedColumnName = "id_hora")
    @ManyToOne
    private ejbCcoCepHorarioHora cepHorarioHora;

    public ejbCcoCepHorarioDia() {
    }

    public ejbCcoCepHorarioDia(Integer idHorario) {
        this.idHorario = idHorario;
    }

    public Integer getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Integer idHorario) {
        this.idHorario = idHorario;
    }

    public Short getDia() {
        return dia;
    }

    public void setDia(Short dia) {
        this.dia = dia;
    }

    public ejbCcoCepCecAulaClass getCepCecAulaClass() {
        return cepCecAulaClass;
    }

    public void setCepCecAulaClass(ejbCcoCepCecAulaClass cepCecAulaClass) {
        this.cepCecAulaClass = cepCecAulaClass;
    }

    public ejbCcoCepCursoDocente getCepCursoDocente() {
        return cepCursoDocente;
    }

    public void setCepCursoDocente(ejbCcoCepCursoDocente cepCursoDocente) {
        this.cepCursoDocente = cepCursoDocente;
    }

    public ejbCcoCepHorarioHora getCepHorarioHora() {
        return cepHorarioHora;
    }

    public void setCepHorarioHora(ejbCcoCepHorarioHora cepHorarioHora) {
        this.cepHorarioHora = cepHorarioHora;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHorario != null ? idHorario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ejbCcoCepHorarioDia)) {
            return false;
        }
        ejbCcoCepHorarioDia other = (ejbCcoCepHorarioDia) object;
        if ((this.idHorario == null && other.idHorario != null) || (this.idHorario != null && !this.idHorario.equals(other.idHorario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbCecomp.entidades.CepHorarioDia[ idHorario=" + idHorario + " ]";
    }
    
}
