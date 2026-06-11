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
import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Jael
 */
@Entity(name="CepCcoMatriculaCab")
@Table(name = "cep_cco_matricula_cab")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CepCcoMatriculaCab.findAll", query = "SELECT c FROM CepCcoMatriculaCab c"),
    @NamedQuery(name = "CepCcoMatriculaCab.findByIdMtaAlu", query = "SELECT c FROM CepCcoMatriculaCab c WHERE c.idMtaAlu = :idMtaAlu"),
    @NamedQuery(name = "CepCcoMatriculaCab.findByNotaFinal", query = "SELECT c FROM CepCcoMatriculaCab c WHERE c.notaFinal = :notaFinal")})
public class ejbCcoCepCcoMatriculaCab implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_mta_alu")
    private Integer idMtaAlu;
    @Column(name = "nota_final")
    private Integer notaFinal;
    @OneToMany(mappedBy = "cepCcoMatriculaCab")
    private List<ejbCcoCepCecCert> cepCecCertList;
    @OneToMany(mappedBy = "cepCcoMatriculaCab")
    private List<ejbCcoCepCecNotas> cepCecNotasList;
    @OneToMany(mappedBy = "cepCcoMatriculaCab")
    private List<ejbCcoCepPagos> cepPagosList;
    @JoinColumn(name = "id_ad", referencedColumnName = "id_ad")
    @ManyToOne
    private ejbCcoCepCursoDocente cepCursoDocente;
    @JoinColumn(name = "id_dir", referencedColumnName = "id_dir")
    @ManyToOne(optional = false)
    private ejbCcoDrtPersonanatural drtPersonanatural;

    public ejbCcoCepCcoMatriculaCab() {
    }

    public ejbCcoCepCcoMatriculaCab(Integer idMtaAlu) {
        this.idMtaAlu = idMtaAlu;
    }

    public Integer getIdMtaAlu() {
        return idMtaAlu;
    }

    public void setIdMtaAlu(Integer idMtaAlu) {
        this.idMtaAlu = idMtaAlu;
    }

    public Integer getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(Integer notaFinal) {
        this.notaFinal = notaFinal;
    }

    @XmlTransient
    public List<ejbCcoCepCecCert> getCepCecCertList() {
        return cepCecCertList;
    }

    public void setCepCecCertList(List<ejbCcoCepCecCert> cepCecCertList) {
        this.cepCecCertList = cepCecCertList;
    }

    @XmlTransient
    public List<ejbCcoCepCecNotas> getCepCecNotasList() {
        return cepCecNotasList;
    }

    public void setCepCecNotasList(List<ejbCcoCepCecNotas> cepCecNotasList) {
        this.cepCecNotasList = cepCecNotasList;
    }

    @XmlTransient
    public List<ejbCcoCepPagos> getCepPagosList() {
        return cepPagosList;
    }

    public void setCepPagosList(List<ejbCcoCepPagos> cepPagosList) {
        this.cepPagosList = cepPagosList;
    }

    public ejbCcoCepCursoDocente getCepCursoDocente() {
        return cepCursoDocente;
    }

    public void setCepCursoDocente(ejbCcoCepCursoDocente cepCursoDocente) {
        this.cepCursoDocente = cepCursoDocente;
    }

    public ejbCcoDrtPersonanatural getDrtPersonanatural() {
        return drtPersonanatural;
    }

    public void setDrtPersonanatural(ejbCcoDrtPersonanatural drtPersonanatural) {
        this.drtPersonanatural = drtPersonanatural;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMtaAlu != null ? idMtaAlu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ejbCcoCepCcoMatriculaCab)) {
            return false;
        }
        ejbCcoCepCcoMatriculaCab other = (ejbCcoCepCcoMatriculaCab) object;
        if ((this.idMtaAlu == null && other.idMtaAlu != null) || (this.idMtaAlu != null && !this.idMtaAlu.equals(other.idMtaAlu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbCecomp.entidades.CepCcoMatriculaCab[ idMtaAlu=" + idMtaAlu + " ]";
    }
    
}
