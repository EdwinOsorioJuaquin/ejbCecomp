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
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jael
 */
@Entity(name = "CepCcoAluIns")
@Table(name = "cep_cco_alu_ins")
@NamedQueries({
    @NamedQuery(name = "CepCcoAluIns.findAll", query = "SELECT c FROM CepCcoAluIns c"),
    @NamedQuery(name = "CepCcoAluIns.findByIdMatriAlu", query = "SELECT c FROM CepCcoAluIns c WHERE c.idMatriAlu = :idMatriAlu"),
    @NamedQuery(name = "CepCcoAluIns.findByFecha", query = "SELECT c FROM CepCcoAluIns c WHERE c.fecha = :fecha"),
    @NamedQuery(name = "CepCcoAluIns.findByBandera", query = "SELECT c FROM CepCcoAluIns c WHERE c.bandera = :bandera"),
    @NamedQuery(name = "CepCcoAluIns.findByIduser", query = "SELECT c FROM CepCcoAluIns c WHERE c.iduser = :iduser"),
    @NamedQuery(name = "CepCcoAluIns.findByHistorialFecha", query = "SELECT c FROM CepCcoAluIns c WHERE c.historialFecha = :historialFecha")})
public class ejbCcoCepCcoAluIns implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_matri_alu")
    private Integer idMatriAlu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bandera")
    private Character bandera;
    @Column(name = "iduser")
    private Integer iduser;
    @Column(name = "historial_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date historialFecha;
    @OneToMany(mappedBy = "cepCcoAluIns")
    private List<ejbCcoCepCecCert> cepCecCertList;
    @JoinColumn(name = "id_ad", referencedColumnName = "id_ad")
    @ManyToOne
    private ejbCcoCepCursoDocente cepCursoDocente;
    @JoinColumn(name = "id_dir", referencedColumnName = "id_dir")
    @ManyToOne(optional = false)
    private ejbCcoDrtPersonanatural drtPersonanatural;

    public ejbCcoCepCcoAluIns() {
    }

    public ejbCcoCepCcoAluIns(Integer idMatriAlu) {
        this.idMatriAlu = idMatriAlu;
    }

    public ejbCcoCepCcoAluIns(Integer idMatriAlu, Date fecha, Character bandera) {
        this.idMatriAlu = idMatriAlu;
        this.fecha = fecha;
        this.bandera = bandera;
    }

    public Integer getIdMatriAlu() {
        return idMatriAlu;
    }

    public void setIdMatriAlu(Integer idMatriAlu) {
        this.idMatriAlu = idMatriAlu;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Character getBandera() {
        return bandera;
    }

    public void setBandera(Character bandera) {
        this.bandera = bandera;
    }

    public Integer getIduser() {
        return iduser;
    }

    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }

    public Date getHistorialFecha() {
        return historialFecha;
    }

    public void setHistorialFecha(Date historialFecha) {
        this.historialFecha = historialFecha;
    }

    public List<ejbCcoCepCecCert> getCepCecCertList() {
        return cepCecCertList;
    }

    public void setCepCecCertList(List<ejbCcoCepCecCert> cepCecCertList) {
        this.cepCecCertList = cepCecCertList;
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
        hash += (idMatriAlu != null ? idMatriAlu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ejbCcoCepCcoAluIns)) {
            return false;
        }
        ejbCcoCepCcoAluIns other = (ejbCcoCepCcoAluIns) object;
        if ((this.idMatriAlu == null && other.idMatriAlu != null) || (this.idMatriAlu != null && !this.idMatriAlu.equals(other.idMatriAlu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbCecomp.entidades.CepCcoAluIns[ idMatriAlu=" + idMatriAlu + " ]";
    }
    
}
