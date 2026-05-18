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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Jael
 */
@Entity(name="CepPersonal")
@Table(name = "cep_personal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CepPersonal.findAll", query = "SELECT e FROM CepPersonal e"),
    @NamedQuery(name = "CepPersonal.findByIdPersonal", query = "SELECT e FROM CepPersonal e WHERE e.idPersonal = :idPersonal"),
    @NamedQuery(name = "CepPersonal.findByFechaIng", query = "SELECT e FROM CepPersonal e WHERE e.fechaIng = :fechaIng"),
    @NamedQuery(name = "CepPersonal.findByFechaFin", query = "SELECT e FROM CepPersonal e WHERE e.fechaFin = :fechaFin"),
    @NamedQuery(name = "CepPersonal.findByIdDep", query = "SELECT e FROM CepPersonal e WHERE e.idDep = :idDep"),
    @NamedQuery(name = "CepPersonal.findByBandera", query = "SELECT e FROM CepPersonal e WHERE e.bandera = :bandera")})
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
    @JoinColumn(name = "id_tipo_cecomp", referencedColumnName = "id_tipo_cecomp")
    @ManyToOne(optional = false)
    private ejbCcoCepTipoPersonal idTipoCecomp;
    @JoinColumn(name = "id_esc", referencedColumnName = "id_esc")
    @ManyToOne
    private ejbCcoEscPersonal idEsc;

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

    public ejbCcoCepTipoPersonal getIdTipoCecomp() {
        return idTipoCecomp;
    }

    public void setIdTipoCecomp(ejbCcoCepTipoPersonal idTipoCecomp) {
        this.idTipoCecomp = idTipoCecomp;
    }

    public ejbCcoEscPersonal getIdEsc() {
        return idEsc;
    }

    public void setIdEsc(ejbCcoEscPersonal idEsc) {
        this.idEsc = idEsc;
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
        return "ejbCecomp.entidades.ejbCcoCepPersonal[ idPersonal=" + idPersonal + " ]";
    }
    
}
