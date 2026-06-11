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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jael
 */
@Entity(name="CepPersonal")
@Table(name = "cep_personal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CepPersonal.findAll", query = "SELECT c FROM CepPersonal c"),
    @NamedQuery(name = "CepPersonal.findByIdPersonal", query = "SELECT c FROM CepPersonal c WHERE c.idPersonal = :idPersonal"),
    @NamedQuery(name = "CepPersonal.findByFechaIng", query = "SELECT c FROM CepPersonal c WHERE c.fechaIng = :fechaIng"),
    @NamedQuery(name = "CepPersonal.findByFechaFin", query = "SELECT c FROM CepPersonal c WHERE c.fechaFin = :fechaFin"),
    @NamedQuery(name = "CepPersonal.findByIdDep", query = "SELECT c FROM CepPersonal c WHERE c.idDep = :idDep"),
    @NamedQuery(name = "CepPersonal.findByBandera", query = "SELECT c FROM CepPersonal c WHERE c.bandera = :bandera")})
public class ejbCcoCepPersonal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_personal")
    private Integer idPersonal;
    @Column(name = "fecha_ing")
    @Temporal(TemporalType.DATE)
    private Date fechaIng;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Column(name = "id_dep")
    private Integer idDep;
    @Column(name = "bandera")
    private Boolean bandera;
    @OneToMany(mappedBy = "cepPersonal")
    private List<ejbCcoCepCursoDocente> cepCursoDocenteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cepPersonal")
    private List<ejbCcoCepAulaCursoDocente> cepAulaCursoDocenteList;
    @JoinColumn(name = "id_tipo_cecomp", referencedColumnName = "id_tipo_cecomp")
    @ManyToOne(optional = false)
    private ejbCcoCepTipoPersonal cepTipoPersonal;
    @JoinColumn(name = "id_esc", referencedColumnName = "id_esc")
    @ManyToOne
    private ejbCcoEscPersonal escPersonal;
    @OneToMany(mappedBy = "cepPersonal")
    private List<ejbCcoCepDocenteAsistencia> cepDocenteAsistenciaList;

    public ejbCcoCepPersonal() {
    }

    public ejbCcoCepPersonal(Integer idPersonal) {
        this.idPersonal = idPersonal;
    }

    public Integer getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(Integer idPersonal) {
        this.idPersonal = idPersonal;
    }

    public Date getFechaIng() {
        return fechaIng;
    }

    public void setFechaIng(Date fechaIng) {
        this.fechaIng = fechaIng;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getIdDep() {
        return idDep;
    }

    public void setIdDep(Integer idDep) {
        this.idDep = idDep;
    }

    public Boolean getBandera() {
        return bandera;
    }

    public void setBandera(Boolean bandera) {
        this.bandera = bandera;
    }

    @XmlTransient
    public List<ejbCcoCepCursoDocente> getCepCursoDocenteList() {
        return cepCursoDocenteList;
    }

    public void setCepCursoDocenteList(List<ejbCcoCepCursoDocente> cepCursoDocenteList) {
        this.cepCursoDocenteList = cepCursoDocenteList;
    }

    @XmlTransient
    public List<ejbCcoCepAulaCursoDocente> getCepAulaCursoDocenteList() {
        return cepAulaCursoDocenteList;
    }

    public void setCepAulaCursoDocenteList(List<ejbCcoCepAulaCursoDocente> cepAulaCursoDocenteList) {
        this.cepAulaCursoDocenteList = cepAulaCursoDocenteList;
    }

    public ejbCcoCepTipoPersonal getCepTipoPersonal() {
        return cepTipoPersonal;
    }

    public void setCepTipoPersonal(ejbCcoCepTipoPersonal cepTipoPersonal) {
        this.cepTipoPersonal = cepTipoPersonal;
    }

    public ejbCcoEscPersonal getEscPersonal() {
        return escPersonal;
    }

    public void setEscPersonal(ejbCcoEscPersonal escPersonal) {
        this.escPersonal = escPersonal;
    }

    @XmlTransient
    public List<ejbCcoCepDocenteAsistencia> getCepDocenteAsistenciaList() {
        return cepDocenteAsistenciaList;
    }

    public void setCepDocenteAsistenciaList(List<ejbCcoCepDocenteAsistencia> cepDocenteAsistenciaList) {
        this.cepDocenteAsistenciaList = cepDocenteAsistenciaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersonal != null ? idPersonal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ejbCcoCepPersonal)) {
            return false;
        }
        ejbCcoCepPersonal other = (ejbCcoCepPersonal) object;
        if ((this.idPersonal == null && other.idPersonal != null) || (this.idPersonal != null && !this.idPersonal.equals(other.idPersonal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbCecomp.entidades.CepPersonal[ idPersonal=" + idPersonal + " ]";
    }
    
}
