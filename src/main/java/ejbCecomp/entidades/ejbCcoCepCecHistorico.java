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
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author Jael
 */
@Entity(name="CepCecHistorico")
@Table(name = "cep_cec_historico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CepCecHistorico.findAll", query = "SELECT c FROM CepCecHistorico c"),
    @NamedQuery(name = "CepCecHistorico.findByIdHistorico", query = "SELECT c FROM CepCecHistorico c WHERE c.idHistorico = :idHistorico"),
    @NamedQuery(name = "CepCecHistorico.findByIdDir", query = "SELECT c FROM CepCecHistorico c WHERE c.idDir = :idDir"),
    @NamedQuery(name = "CepCecHistorico.findByApPaternoHis", query = "SELECT c FROM CepCecHistorico c WHERE c.apPaternoHis = :apPaternoHis"),
    @NamedQuery(name = "CepCecHistorico.findByApMaternoHis", query = "SELECT c FROM CepCecHistorico c WHERE c.apMaternoHis = :apMaternoHis"),
    @NamedQuery(name = "CepCecHistorico.findByNombreCompletoHis", query = "SELECT c FROM CepCecHistorico c WHERE c.nombreCompletoHis = :nombreCompletoHis"),
    @NamedQuery(name = "CepCecHistorico.findByIdCurHis", query = "SELECT c FROM CepCecHistorico c WHERE c.idCurHis = :idCurHis"),
    @NamedQuery(name = "CepCecHistorico.findByNomCurHis", query = "SELECT c FROM CepCecHistorico c WHERE c.nomCurHis = :nomCurHis"),
    @NamedQuery(name = "CepCecHistorico.findByIdMatHis", query = "SELECT c FROM CepCecHistorico c WHERE c.idMatHis = :idMatHis"),
    @NamedQuery(name = "CepCecHistorico.findByNotaMatHis", query = "SELECT c FROM CepCecHistorico c WHERE c.notaMatHis = :notaMatHis"),
    @NamedQuery(name = "CepCecHistorico.findByIdCertHis", query = "SELECT c FROM CepCecHistorico c WHERE c.idCertHis = :idCertHis"),
    @NamedQuery(name = "CepCecHistorico.findByResolHis", query = "SELECT c FROM CepCecHistorico c WHERE c.resolHis = :resolHis"),
    @NamedQuery(name = "CepCecHistorico.findByFechaCertHis", query = "SELECT c FROM CepCecHistorico c WHERE c.fechaCertHis = :fechaCertHis"),
    @NamedQuery(name = "CepCecHistorico.findByIdDocenteHis", query = "SELECT c FROM CepCecHistorico c WHERE c.idDocenteHis = :idDocenteHis"),
    @NamedQuery(name = "CepCecHistorico.findByNombreCompletoDoc", query = "SELECT c FROM CepCecHistorico c WHERE c.nombreCompletoDoc = :nombreCompletoDoc")})
public class ejbCcoCepCecHistorico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_historico")
    private Integer idHistorico;
    @Column(name = "id_dir")
    private Integer idDir;
    @Size(max = 50)
    @Column(name = "ap_paterno_his")
    private String apPaternoHis;
    @Size(max = 50)
    @Column(name = "ap_materno_his")
    private String apMaternoHis;
    @Size(max = 100)
    @Column(name = "nombre_completo_his")
    private String nombreCompletoHis;
    @Column(name = "id_cur_his")
    private Integer idCurHis;
    @Size(max = 100)
    @Column(name = "nom_cur_his")
    private String nomCurHis;
    @Column(name = "id_mat_his")
    private Integer idMatHis;
    @Column(name = "nota_mat_his")
    private Integer notaMatHis;
    @Column(name = "id_cert_his")
    private Integer idCertHis;
    @Column(name = "resol_his")
    private Integer resolHis;
    @Column(name = "fecha_cert_his")
    private Integer fechaCertHis;
    @Column(name = "id_docente_his")
    private Integer idDocenteHis;
    @Size(max = 100)
    @Column(name = "nombre_completo_doc")
    private String nombreCompletoDoc;
    @JoinColumn(name = "id_cert", referencedColumnName = "id_cert")
    @ManyToOne
    private ejbCcoCepCecCert cepCecCert;

    public ejbCcoCepCecHistorico() {
    }

    public ejbCcoCepCecHistorico(Integer idHistorico) {
        this.idHistorico = idHistorico;
    }

    public Integer getIdHistorico() {
        return idHistorico;
    }

    public void setIdHistorico(Integer idHistorico) {
        this.idHistorico = idHistorico;
    }

    public Integer getIdDir() {
        return idDir;
    }

    public void setIdDir(Integer idDir) {
        this.idDir = idDir;
    }

    public String getApPaternoHis() {
        return apPaternoHis;
    }

    public void setApPaternoHis(String apPaternoHis) {
        this.apPaternoHis = apPaternoHis;
    }

    public String getApMaternoHis() {
        return apMaternoHis;
    }

    public void setApMaternoHis(String apMaternoHis) {
        this.apMaternoHis = apMaternoHis;
    }

    public String getNombreCompletoHis() {
        return nombreCompletoHis;
    }

    public void setNombreCompletoHis(String nombreCompletoHis) {
        this.nombreCompletoHis = nombreCompletoHis;
    }

    public Integer getIdCurHis() {
        return idCurHis;
    }

    public void setIdCurHis(Integer idCurHis) {
        this.idCurHis = idCurHis;
    }

    public String getNomCurHis() {
        return nomCurHis;
    }

    public void setNomCurHis(String nomCurHis) {
        this.nomCurHis = nomCurHis;
    }

    public Integer getIdMatHis() {
        return idMatHis;
    }

    public void setIdMatHis(Integer idMatHis) {
        this.idMatHis = idMatHis;
    }

    public Integer getNotaMatHis() {
        return notaMatHis;
    }

    public void setNotaMatHis(Integer notaMatHis) {
        this.notaMatHis = notaMatHis;
    }

    public Integer getIdCertHis() {
        return idCertHis;
    }

    public void setIdCertHis(Integer idCertHis) {
        this.idCertHis = idCertHis;
    }

    public Integer getResolHis() {
        return resolHis;
    }

    public void setResolHis(Integer resolHis) {
        this.resolHis = resolHis;
    }

    public Integer getFechaCertHis() {
        return fechaCertHis;
    }

    public void setFechaCertHis(Integer fechaCertHis) {
        this.fechaCertHis = fechaCertHis;
    }

    public Integer getIdDocenteHis() {
        return idDocenteHis;
    }

    public void setIdDocenteHis(Integer idDocenteHis) {
        this.idDocenteHis = idDocenteHis;
    }

    public String getNombreCompletoDoc() {
        return nombreCompletoDoc;
    }

    public void setNombreCompletoDoc(String nombreCompletoDoc) {
        this.nombreCompletoDoc = nombreCompletoDoc;
    }

    public ejbCcoCepCecCert getCepCecCert() {
        return cepCecCert;
    }

    public void setCepCecCert(ejbCcoCepCecCert cepCecCert) {
        this.cepCecCert = cepCecCert;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHistorico != null ? idHistorico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ejbCcoCepCecHistorico)) {
            return false;
        }
        ejbCcoCepCecHistorico other = (ejbCcoCepCecHistorico) object;
        if ((this.idHistorico == null && other.idHistorico != null) || (this.idHistorico != null && !this.idHistorico.equals(other.idHistorico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbCecomp.entidades.CepCecHistorico[ idHistorico=" + idHistorico + " ]";
    }
    
}
