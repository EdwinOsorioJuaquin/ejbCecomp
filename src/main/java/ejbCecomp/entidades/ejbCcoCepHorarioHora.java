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
@Entity(name = "CepHorarioHora")
@Table(name = "cep_horario_hora")
@NamedQueries({
    @NamedQuery(name = "CepHorarioHora.findAll", query = "SELECT c FROM CepHorarioHora c"),
    @NamedQuery(name = "CepHorarioHora.findByIdHora", query = "SELECT c FROM CepHorarioHora c WHERE c.idHora = :idHora"),
    @NamedQuery(name = "CepHorarioHora.findByIdDep", query = "SELECT c FROM CepHorarioHora c WHERE c.idDep = :idDep"),
    @NamedQuery(name = "CepHorarioHora.findByNomHora", query = "SELECT c FROM CepHorarioHora c WHERE c.nomHora = :nomHora"),
    @NamedQuery(name = "CepHorarioHora.findByEstado", query = "SELECT c FROM CepHorarioHora c WHERE c.estado = :estado"),
    @NamedQuery(name = "CepHorarioHora.findByTurno", query = "SELECT c FROM CepHorarioHora c WHERE c.turno = :turno"),
    @NamedQuery(name = "CepHorarioHora.findByOrden", query = "SELECT c FROM CepHorarioHora c WHERE c.orden = :orden")})
public class ejbCcoCepHorarioHora implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_hora")
    private Integer idHora;
    @Column(name = "id_dep")
    private Integer idDep;
    @Size(max = 25)
    @Column(name = "nom_hora")
    private String nomHora;
    @Column(name = "estado")
    private Boolean estado;
    @Column(name = "turno")
    private Character turno;
    @Column(name = "orden")
    private Short orden;
    @OneToMany(mappedBy = "cepHorarioHora")
    private List<ejbCcoCepHorarioDia> cepHorarioDiaList;

    public ejbCcoCepHorarioHora() {
    }

    public ejbCcoCepHorarioHora(Integer idHora) {
        this.idHora = idHora;
    }

    public Integer getIdHora() {
        return idHora;
    }

    public void setIdHora(Integer idHora) {
        this.idHora = idHora;
    }

    public Integer getIdDep() {
        return idDep;
    }

    public void setIdDep(Integer idDep) {
        this.idDep = idDep;
    }

    public String getNomHora() {
        return nomHora;
    }

    public void setNomHora(String nomHora) {
        this.nomHora = nomHora;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Character getTurno() {
        return turno;
    }

    public void setTurno(Character turno) {
        this.turno = turno;
    }

    public Short getOrden() {
        return orden;
    }

    public void setOrden(Short orden) {
        this.orden = orden;
    }

    public List<ejbCcoCepHorarioDia> getCepHorarioDiaList() {
        return cepHorarioDiaList;
    }

    public void setCepHorarioDiaList(List<ejbCcoCepHorarioDia> cepHorarioDiaList) {
        this.cepHorarioDiaList = cepHorarioDiaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHora != null ? idHora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ejbCcoCepHorarioHora)) {
            return false;
        }
        ejbCcoCepHorarioHora other = (ejbCcoCepHorarioHora) object;
        if ((this.idHora == null && other.idHora != null) || (this.idHora != null && !this.idHora.equals(other.idHora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbCecomp.entidades.CepHorarioHora[ idHora=" + idHora + " ]";
    }
    
}
