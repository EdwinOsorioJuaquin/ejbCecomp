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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jael
 */
@Entity(name = "CepCursoDocente")
@Table(name = "cep_curso_docente")
@NamedQueries({
    @NamedQuery(name = "CepCursoDocente.findAll", query = "SELECT c FROM CepCursoDocente c"),
    @NamedQuery(name = "CepCursoDocente.findByIdAd", query = "SELECT c FROM CepCursoDocente c WHERE c.idAd = :idAd"),
    @NamedQuery(name = "CepCursoDocente.findByIdDep", query = "SELECT c FROM CepCursoDocente c WHERE c.idDep = :idDep"),
    @NamedQuery(name = "CepCursoDocente.findByEstado", query = "SELECT c FROM CepCursoDocente c WHERE c.estado = :estado"),
    @NamedQuery(name = "CepCursoDocente.findByFecha", query = "SELECT c FROM CepCursoDocente c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "CepCursoDocente.findByFechaFin", query = "SELECT c FROM CepCursoDocente c WHERE c.fechaFin = :fechaFin"),
    @NamedQuery(name = "CepCursoDocente.findByCerraAper", query = "SELECT c FROM CepCursoDocente c WHERE c.cerraAper = :cerraAper")})
public class ejbCcoCepCursoDocente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ad")
    private Integer idAd;
    @Column(name = "id_dep")
    private Integer idDep;
    @Column(name = "estado")
    private Boolean estado;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Column(name = "cerra_aper")
    private Boolean cerraAper;
    @JoinColumn(name = "id_ciclo", referencedColumnName = "id_ciclo")
    @ManyToOne
    private ejbCcoCepCecCiclo cepCecCiclo;
    @JoinColumn(name = "id_grupo", referencedColumnName = "id_grupo")
    @ManyToOne
    private ejbCcoCepCecGrupoCurso cepCecGrupoCurso;
    @JoinColumn(name = "id_nivel", referencedColumnName = "id_nivel")
    @ManyToOne
    private ejbCcoCepCecNivel cepCecNivel;
    @JoinColumn(name = "id_curso", referencedColumnName = "id_curso")
    @ManyToOne
    private ejbCcoCepCurso cepCurso;
    @JoinColumn(name = "id_personal", referencedColumnName = "id_personal")
    @ManyToOne
    private ejbCcoCepPersonal cepPersonal;
    @OneToMany(mappedBy = "cepCursoDocente")
    private List<ejbCcoCepHorarioDia> cepHorarioDiaList;
    @OneToMany(mappedBy = "cepCursoDocente")
    private List<ejbCcoCepCcoAluIns> cepCcoAluInsList;
    @OneToMany(mappedBy = "cepCursoDocente")
    private List<ejbCcoCepCcoMatriculaCab> cepCcoMatriculaCabList;

    public ejbCcoCepCursoDocente() {
    }

    public ejbCcoCepCursoDocente(Integer idAd) {
        this.idAd = idAd;
    }

    public Integer getIdAd() {
        return idAd;
    }

    public void setIdAd(Integer idAd) {
        this.idAd = idAd;
    }

    public Integer getIdDep() {
        return idDep;
    }

    public void setIdDep(Integer idDep) {
        this.idDep = idDep;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Boolean getCerraAper() {
        return cerraAper;
    }

    public void setCerraAper(Boolean cerraAper) {
        this.cerraAper = cerraAper;
    }

    public ejbCcoCepCecCiclo getCepCecCiclo() {
        return cepCecCiclo;
    }

    public void setCepCecCiclo(ejbCcoCepCecCiclo cepCecCiclo) {
        this.cepCecCiclo = cepCecCiclo;
    }

    public ejbCcoCepCecGrupoCurso getCepCecGrupoCurso() {
        return cepCecGrupoCurso;
    }

    public void setCepCecGrupoCurso(ejbCcoCepCecGrupoCurso cepCecGrupoCurso) {
        this.cepCecGrupoCurso = cepCecGrupoCurso;
    }

    public ejbCcoCepCecNivel getCepCecNivel() {
        return cepCecNivel;
    }

    public void setCepCecNivel(ejbCcoCepCecNivel cepCecNivel) {
        this.cepCecNivel = cepCecNivel;
    }

    public ejbCcoCepCurso getCepCurso() {
        return cepCurso;
    }

    public void setCepCurso(ejbCcoCepCurso cepCurso) {
        this.cepCurso = cepCurso;
    }

    public ejbCcoCepPersonal getCepPersonal() {
        return cepPersonal;
    }

    public void setCepPersonal(ejbCcoCepPersonal cepPersonal) {
        this.cepPersonal = cepPersonal;
    }

    public List<ejbCcoCepHorarioDia> getCepHorarioDiaList() {
        return cepHorarioDiaList;
    }

    public void setCepHorarioDiaList(List<ejbCcoCepHorarioDia> cepHorarioDiaList) {
        this.cepHorarioDiaList = cepHorarioDiaList;
    }

    public List<ejbCcoCepCcoAluIns> getCepCcoAluInsList() {
        return cepCcoAluInsList;
    }

    public void setCepCcoAluInsList(List<ejbCcoCepCcoAluIns> cepCcoAluInsList) {
        this.cepCcoAluInsList = cepCcoAluInsList;
    }

    public List<ejbCcoCepCcoMatriculaCab> getCepCcoMatriculaCabList() {
        return cepCcoMatriculaCabList;
    }

    public void setCepCcoMatriculaCabList(List<ejbCcoCepCcoMatriculaCab> cepCcoMatriculaCabList) {
        this.cepCcoMatriculaCabList = cepCcoMatriculaCabList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAd != null ? idAd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ejbCcoCepCursoDocente)) {
            return false;
        }
        ejbCcoCepCursoDocente other = (ejbCcoCepCursoDocente) object;
        if ((this.idAd == null && other.idAd != null) || (this.idAd != null && !this.idAd.equals(other.idAd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbCecomp.entidades.CepCursoDocente[ idAd=" + idAd + " ]";
    }
    
}
