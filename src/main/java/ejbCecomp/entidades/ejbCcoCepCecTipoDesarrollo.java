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
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Jael
 */
@Entity(name="CepCecTipoDesarrollo")
@Table(name = "cep_cec_tipo_desarrollo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CepCecTipoDesarrollo.findAll", query = "SELECT c FROM CepCecTipoDesarrollo c"),
    @NamedQuery(name = "CepCecTipoDesarrollo.findByIdCiclo", query = "SELECT c FROM CepCecTipoDesarrollo c WHERE c.idCiclo = :idCiclo"),
    @NamedQuery(name = "CepCecTipoDesarrollo.findByNombreDesarrollo", query = "SELECT c FROM CepCecTipoDesarrollo c WHERE c.nombreDesarrollo = :nombreDesarrollo")})
public class ejbCcoCepCecTipoDesarrollo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ciclo")
    private Integer idCiclo;
    @Size(max = 20)
    @Column(name = "nombre_desarrollo")
    private String nombreDesarrollo;
    @OneToMany(mappedBy = "cepCecTipoDesarrollo")
    private List<ejbCcoCepCursoDocente> cepCursoDocenteList;

    public ejbCcoCepCecTipoDesarrollo() {
    }

    public ejbCcoCepCecTipoDesarrollo(Integer idCiclo) {
        this.idCiclo = idCiclo;
    }

    public Integer getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(Integer idCiclo) {
        this.idCiclo = idCiclo;
    }

    public String getNombreDesarrollo() {
        return nombreDesarrollo;
    }

    public void setNombreDesarrollo(String nombreDesarrollo) {
        this.nombreDesarrollo = nombreDesarrollo;
    }

    @XmlTransient
    public List<ejbCcoCepCursoDocente> getCepCursoDocenteList() {
        return cepCursoDocenteList;
    }

    public void setCepCursoDocenteList(List<ejbCcoCepCursoDocente> cepCursoDocenteList) {
        this.cepCursoDocenteList = cepCursoDocenteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCiclo != null ? idCiclo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ejbCcoCepCecTipoDesarrollo)) {
            return false;
        }
        ejbCcoCepCecTipoDesarrollo other = (ejbCcoCepCecTipoDesarrollo) object;
        if ((this.idCiclo == null && other.idCiclo != null) || (this.idCiclo != null && !this.idCiclo.equals(other.idCiclo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejbCecomp.entidades.CepCecTipoDesarrollo[ idCiclo=" + idCiclo + " ]";
    }
    
}
