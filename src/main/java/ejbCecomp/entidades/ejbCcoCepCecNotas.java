/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejbCecomp.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author Jael
 */
@Entity(name="CepCecNotas")
@Table(name = "cep_cec_notas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CepCecNotas.findAll", query = "SELECT c FROM CepCecNotas c"),
    @NamedQuery(name = "CepCecNotas.findByIdMtaAlu", query = "SELECT c FROM CepCecNotas c WHERE c.cepCecNotasPK.idMtaAlu = :idMtaAlu"),
    @NamedQuery(name = "CepCecNotas.findByIdSesio", query = "SELECT c FROM CepCecNotas c WHERE c.cepCecNotasPK.idSesio = :idSesio"),
    @NamedQuery(name = "CepCecNotas.findByNota", query = "SELECT c FROM CepCecNotas c WHERE c.nota = :nota")})
public class ejbCcoCepCecNotas implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ejbCcoCepCecNotasPK cepCecNotasPK;
    @Column(name = "nota")
    private Integer nota;
    @JoinColumn(name = "id_mta_alu", referencedColumnName = "id_mta_alu", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ejbCcoCepCcoMatriculaCab cepCcoMatriculaCab;

    public ejbCcoCepCecNotas() {
    }

    public ejbCcoCepCecNotas(ejbCcoCepCecNotasPK cepCecNotasPK) {
        this.cepCecNotasPK = cepCecNotasPK;
    }

    public ejbCcoCepCecNotas(int idMtaAlu, int idSesio) {
        this.cepCecNotasPK = new ejbCcoCepCecNotasPK(idMtaAlu, idSesio);
    }

    public ejbCcoCepCecNotasPK getCepCecNotasPK() {
        return cepCecNotasPK;
    }

    public void setCepCecNotasPK(ejbCcoCepCecNotasPK cepCecNotasPK) {
        this.cepCecNotasPK = cepCecNotasPK;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public ejbCcoCepCcoMatriculaCab getCepCcoMatriculaCab() {
        return cepCcoMatriculaCab;
    }

    public void setCepCcoMatriculaCab(ejbCcoCepCcoMatriculaCab cepCcoMatriculaCab) {
        this.cepCcoMatriculaCab = cepCcoMatriculaCab;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cepCecNotasPK != null ? cepCecNotasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ejbCcoCepCecNotas)) {
            return false;
        }
        ejbCcoCepCecNotas other = (ejbCcoCepCecNotas) object;
        if ((this.cepCecNotasPK == null && other.cepCecNotasPK != null) || (this.cepCecNotasPK != null && !this.cepCecNotasPK.equals(other.cepCecNotasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbCecomp.entidades.CepCecNotas[ cepCecNotasPK=" + cepCecNotasPK + " ]";
    }
    
}
